package reflection;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;
import java.lang.annotation.ElementType;

//custom Annotation
@Retention(RetentionPolicy.RUNTIME)   //available at runtime
@Target(ElementType.TYPE)              //can be applied to classes
@interface Author {
    String name();
}

//class using the annotation
@Author(name = "Author Name")
class Book {
    public void display() {
        System.out.println("Book class");
    }
}

public class RetriveAnnotationsAtRuntime {
    public static void main(String[] args) {

        //get Class object
        Class<Book> clazz = Book.class;

        //check if annotation is present
        if (clazz.isAnnotationPresent(Author.class)) {

            //retrieve annotation
            Author author = clazz.getAnnotation(Author.class);

            //display annotation value
            System.out.println("Author Name: " + author.name());
        }
    }
}
