import java.util.ArrayList;

/**
 * Employee
 */
public class Employee {
    // Access modifiers
    // Attributes
    private String email;
    private float pay;
    private ArrayList<String> projects=new ArrayList<String>();
    private Employee manager;
    // Static member 
    private static int noOfEmps=0;
    // Constructor
    public Employee(){
        noOfEmps++;

    }
    public Employee(String email, float pay){
        this.email=email;
        this.pay=pay;
        noOfEmps++;
    }
    // Accessors/getters & Mutators/setters
    public String getEmail() {
        return email;
    }
    public void setEmail(String email) {
        this.email = email;
    }
    public float getPay() {
        return pay;
    }
    public void setPay(float pay) {
        this.pay = pay;
    }

    // Class methods
    public void display() {
        System.out.printf("\nEmail: %s , Pay: %.2f",this.email,this.pay);
        for (String project : projects) {
            System.out.println("\nproject:" + project);
            
        }
    }
    public void addProject(String project) {
        this.projects.add(project);
        
    }
    //Static methods
    public static int getNoOfEmps() {
        return noOfEmps;
    }
    // Method Overloading - polymorphism
    public void getBonus() {
        System.out.println("\nAfter Bonus********");
        this.pay+=1000;
    }
    public void getBonus(float bonus) {
        this.pay+=bonus;
        
    }

    // How objects talk to each other 
    public void setManager(Employee manager) {
        this.manager=manager;
        
    }
    public Employee getManager() {
        return manager;
    }

}