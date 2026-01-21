package AIDrivenResumeScreeningSystem;

//generic resume class
public class Resume<T extends JobRole> {
    int candidateId;
    String candidateName;
    int experienceYears;
    String skills;
    T role;

    Resume(int candidateId, String candidateName, int experienceYears, String skills, T role) {
        this.candidateId = candidateId;
        this.candidateName = candidateName;
        this.experienceYears = experienceYears;
        this.skills = skills;
        this.role = role;
    }

    public void displayResume() {
        System.out.println("Candidate ID   : " + candidateId);
        System.out.println("Candidate Name : " + candidateName);
        System.out.println("Experience     : " + experienceYears + " years");
        System.out.println("Skills         : " + skills);
        System.out.println("Job Role       : " + role.getRoleName());
        System.out.println("--------------------------------------------");
    }
}
