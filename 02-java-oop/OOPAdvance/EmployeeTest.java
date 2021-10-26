public class EmployeeTest {
    public static void main(String[] args) {
       Employee cole=new Employee("Cole@chimp.com",300000);
       cole.empDetails();
       Engg juan=new Engg("Juan@chimp.com",450000, "Make smoothies");
       juan.addSkill("Peel Bananas");
       juan.addSkill("Put Banana in blender");
       juan.enggDetails();
       Rabbit rabbit=new Rabbit();
       rabbit.eat();
       rabbit.sleep();
       rabbit.age();
       rabbit.breath();
       
    }
 }