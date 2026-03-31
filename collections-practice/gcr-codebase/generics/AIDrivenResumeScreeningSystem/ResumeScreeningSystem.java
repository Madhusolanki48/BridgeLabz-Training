package AIDrivenResumeScreeningSystem;
import java.util.*;

public class ResumeScreeningSystem {

    //wildcard pipeline for all job roles
    public static void screeningPipeline(List<? extends JobRole> roles) {
        System.out.println("\nScreening Pipeline Started...\n");
        System.out.println("Roles accepted in pipeline:");
        System.out.println("--------------------------------------------");
        for (JobRole role : roles) {
            System.out.println("- " + role.getRoleName());
        }
        System.out.println("--------------------------------------------");
    }

    //generic method: process resume safely
    public static <T extends JobRole> void processResume(Resume<T> resume) {
        System.out.println("\nResume Processing:");
        System.out.println("--------------------------------------------");
        resume.displayResume();
    }

    public static void main(String[] args) {
        System.out.println("-----  Welcome to AI Resume Screening System  -----");
        System.out.println("---------------------------------------------------");
        Resume<SoftwareEngineer> r1 =
                new Resume<>(101, "Maxwell", 2, "Java, DSA, Git", new SoftwareEngineer());

        Resume<DataScientist> r2 =
                new Resume<>(102, "Radrin", 2, "Python, ML, SQL", new DataScientist());

        Resume<ProductManager> r3 =
                new Resume<>(103, "Sacred", 3, "Agile, Roadmaps, Analytics", new ProductManager());
        //method calling
        processResume(r1);
        processResume(r2);
        processResume(r3);

        List<JobRole> roles = new ArrayList<>();
        roles.add(new SoftwareEngineer());
        roles.add(new DataScientist());
        roles.add(new ProductManager());

        screeningPipeline(roles);
    }
}
