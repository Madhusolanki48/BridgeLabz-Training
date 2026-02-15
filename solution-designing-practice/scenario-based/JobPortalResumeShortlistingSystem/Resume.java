package JobPortalResumeShortlistingSystem;
import java.util.Set;

//represents a candidate resume
public class Resume {
    //attributes
    private String name;
    private Set<String> skills;
    //constructor
    public Resume(String name, Set<String> skills) {
        this.name = name;
        this.skills = skills;
    }
    //getter method
    public String getName() {
        return name;
    }

    public Set<String> getSkills() {
        return skills;
    }
}
