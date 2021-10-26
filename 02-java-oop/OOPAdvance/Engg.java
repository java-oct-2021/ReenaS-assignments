import java.util.ArrayList;

public class Engg extends Employee {

    private String project;
    public ArrayList<String> skills=new ArrayList<String>();
    public Engg(String email, double pay, String project) {
        super(email, pay);
        this.project=project;
    }
    public void setProject(String project) {
        this.project = project;
    }
    public String getProject() {
        return project;
    }
    public void enggDetails() {
        this.empDetails();
        System.out.printf("Project: %s Skills: %s", this.project, this.skills);
    }
    public void addSkill(String skill) {
        skills.add(skill);
        
    }


}
