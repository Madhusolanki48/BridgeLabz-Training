package AIDrivenResumeScreeningSystem;

//abstract job role
public abstract class JobRole {
	//attribute
    String roleName;
    //constructor
    JobRole(String roleName) {
        this.roleName = roleName;
    }

    public String getRoleName() {
        return roleName;
    }
}
