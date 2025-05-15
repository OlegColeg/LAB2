package usarb;
// TASK 2
public class Student {
    private String name;
    private int averageGrade;

    public Student(String name, int averageGrade) {
        this.name = name;
        this.averageGrade = averageGrade;
    }

    @Override
    public String toString() {
        return "Nume Student:" + name + "\nMedia Studentului:" + averageGrade;
    }

    public static void main(String[] args) {
        Student st1 = new Student("Oala Oleg", 6);
        System.out.println(st1);
    }
}