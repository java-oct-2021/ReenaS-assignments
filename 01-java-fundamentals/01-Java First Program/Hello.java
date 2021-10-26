/**
 * Hello - This is my first Java Program
 */
public class Hello {
   public static void main(String[] args) {
       System.out.println("Hello Java!");
    //    primitive Types 
    byte myByte=20;
    int myInt=874634875;
    float myFloat=34.56f;
    double myDouble=54.738858748;
    char myChar='b';
    boolean myBool=true;
    // Non primitive Types 
    String myName=new String("Scott");
    String firstName="Reena";
    System.out.println(myName.toUpperCase());
    greet();
    greet("Cole");
    System.out.println(add(14,16));
    OneTo255();
    
   }
   public static void ()greet {
       System.out.println("Welcome Student!");
       
   }
   public static void greet(String student) {
    System.out.printf("Welcome %s", student);
}
public static int add(int i, int j) {
    return i+j;
}
public static void OneTo255() {
    for(int i=1;i<=20;i++){
        if(i==10){
            System.out.println("Hey this is 10");
        }
        else if(i%2==0){
                System.out.println("This is " + i);
        }
       else{
            System.out.println("This is Odd");
        }
    }
    
}
   
}