package com.example.fundoonotes.specification;

import com.example.fundoonotes.entity.Note;
import jakarta.persistence.criteria.JoinType;
import jakarta.persistence.criteria.Join;
import jakarta.persistence.criteria.Predicate;
import org.springframework.data.jpa.domain.Specification;

import java.util.ArrayList;
import java.util.List;

public class NoteSpecification {
    public static Specification<Note> search(String email, String title, String state, String label) {
        return (root, query, criteriaBuilder) -> {
            List<Predicate> predicates = new ArrayList<>();
            predicates.add(criteriaBuilder.equal(root.get("user").get("email"), email));

            if (state == null || state.isBlank()) {
                predicates.add(criteriaBuilder.isFalse(root.get("trashed")));
            }

            if (title != null && !title.isBlank()) {
                predicates.add(criteriaBuilder.like(
                        criteriaBuilder.lower(root.get("title")),
                        "%" + title.toLowerCase() + "%"
                ));
            }

            if (state != null && !state.isBlank()) {
                addStatePredicate(state, root.get("pined"), root.get("archived"),
                        root.get("trashed"), criteriaBuilder, predicates);
            }

            if (label != null && !label.isBlank()) {
                Join<Object, Object> labelJoin = root.join("labels", JoinType.INNER);
                predicates.add(criteriaBuilder.equal(
                        criteriaBuilder.lower(labelJoin.get("label")),
                        label.toLowerCase()
                ));
                predicates.add(criteriaBuilder.isFalse(labelJoin.get("deleted")));
            }

            query.distinct(true);
            return criteriaBuilder.and(predicates.toArray(new Predicate[0]));
        };
    }

    private static void addStatePredicate(String state, jakarta.persistence.criteria.Path<Boolean> pined,
                                          jakarta.persistence.criteria.Path<Boolean> archived,
                                          jakarta.persistence.criteria.Path<Boolean> trashed,
                                          jakarta.persistence.criteria.CriteriaBuilder criteriaBuilder,
                                          List<Predicate> predicates) {
        switch (state.toLowerCase()) {
            case "pined" -> predicates.add(criteriaBuilder.isTrue(pined));
            case "archived" -> predicates.add(criteriaBuilder.isTrue(archived));
            case "trashed" -> predicates.add(criteriaBuilder.isTrue(trashed));
            case "active" -> predicates.add(criteriaBuilder.isFalse(trashed));
            default -> predicates.add(criteriaBuilder.isFalse(trashed));
        }
    }
}
