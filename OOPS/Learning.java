package OOPS;

public class Learning {
    public static void main(String[] args) {
        StudentDetails stu1 = new StudentDetails(12, "Mayank T", true);
        System.out.println(stu1.name);
        System.out.println(stu1.roll);
        System.out.println(stu1.placed);

        StudentDetails stu2 = new StudentDetails();
        System.out.println(stu2.name);

        stu1.greet("hello");//will not work because we use this keyword in the greet method and that points to the
        //instance variable name.
    }
}
class StudentDetails {
    int roll;
    String name;
    Boolean placed;

    StudentDetails(int roll, String name, Boolean placed){
        this.roll = roll;
        this.name = name;
        this.placed = placed;
    }
    StudentDetails() {
        roll = 0;
        name = null;
        placed = null;
    }

    public void greet(String name) {
        System.out.println("GOOOOD DAY " + this.name); //even if I write name, it works.
    }

}