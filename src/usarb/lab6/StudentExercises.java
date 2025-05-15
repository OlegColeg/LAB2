package usarb.lab6;

import java.util.*;

class Student implements Comparable<Student> {
    String name;      // prenume
    String surname;   // nume de familie
    long id;
    double averageGrade;

    public Student(String name, String surname, long id, double averageGrade) {
        this.name = name;
        this.surname = surname;
        this.id = id;
        this.averageGrade = averageGrade;
    }

    // Implementarea compareTo
    @Override
    public int compareTo(Student other) {
        // Comparăm mai întâi după medie (descrescător)
        int result = Double.compare(other.averageGrade, this.averageGrade);

        // Dacă mediile sunt egale, comparăm după numele de familie
        if (result == 0) {
            result = this.surname.compareTo(other.surname);

            // Dacă numele de familie sunt egale, comparăm după prenume
            if (result == 0) {
                result = this.name.compareTo(other.name);
            }
        }

        return result;
    }

    // Suprascrierea metodelor equals și hashCode
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Student student = (Student) o;
        return id == student.id &&
                Double.compare(student.averageGrade, averageGrade) == 0 &&
                Objects.equals(name, student.name) &&
                Objects.equals(surname, student.surname);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, surname, id, averageGrade);
    }

    // Suprascrierea toString pentru afisarea datelor
    @Override
    public String toString() {
        return "[" + name + " " + surname + ", ID: " + id + ", Media: " + averageGrade + "]";
    }
}

// Clasă care extinde LinkedHashSet pentru a accepta doar numere pare
class EvenNumbersSet extends LinkedHashSet<Integer> {

    @Override
    public boolean add(Integer e) {
        if (e % 2 == 0) {
            return super.add(e);
        }
        return false;
    }

    @Override
    public boolean addAll(Collection<? extends Integer> c) {
        boolean modified = false;
        for (Integer element : c) {
            if (element % 2 == 0) {
                if (super.add(element)) {
                    modified = true;
                }
            }
        }
        return modified;
    }
}

public class StudentExercises {
    public static void main(String[] args) {
        // Crearea și sortarea unui ArrayList de studenți
        System.out.println("======= ArrayList și sortare =======");
        ArrayList<Student> studentList = new ArrayList<>();
        studentList.add(new Student("Ana", "Popescu", 1001, 8.5));
        studentList.add(new Student("Mihai", "Ionescu", 1002, 9.7));
        studentList.add(new Student("Elena", "Vasilescu", 1003, 7.8));
        studentList.add(new Student("Alexandru", "Marin", 1004, 9.7));
        studentList.add(new Student("Cristina", "Popescu", 1005, 8.5));

        System.out.println("Lista de studenți nesortată:");
        for (Student s : studentList) {
            System.out.println(s);
        }

        Collections.sort(studentList);

        System.out.println("\nLista de studenți sortată după medie (descrescător), nume de familie și prenume:");
        for (Student s : studentList) {
            System.out.println(s);
        }

        // Adăugarea în PriorityQueue cu Comparator pentru sortare după ID
        System.out.println("\n======= Exercițiul 3: PriorityQueue cu Comparator =======");
        PriorityQueue<Student> priorityQueue = new PriorityQueue<>(
                (s1, s2) -> Long.compare(s1.id, s2.id) // Comparator pentru sortare crescătoare după ID
        );
        priorityQueue.addAll(studentList);

        System.out.println("PriorityQueue cu studenți sortați după ID (crescător):");
        while (!priorityQueue.isEmpty()) {
            System.out.println(priorityQueue.poll());
        }

        // Recreăm lista pentru exercițiile următoare
        studentList = new ArrayList<>();
        studentList.add(new Student("Ana", "Popescu", 1001, 8.5));
        studentList.add(new Student("Mihai", "Ionescu", 1002, 9.7));
        studentList.add(new Student("Elena", "Vasilescu", 1003, 7.8));

        //  Folosirea unui HashMap<Student, LinkedList<String>>
        System.out.println("\n======= Exercițiul 5: HashMap cu lista de materii =======");
        HashMap<Student, LinkedList<String>> studentCourses = new HashMap<>();

        // Adăugăm materii pentru fiecare student
        LinkedList<String> courses1 = new LinkedList<>();
        courses1.add("Matematică");
        courses1.add("Fizică");
        courses1.add("Informatică");
        studentCourses.put(studentList.get(0), courses1);

        LinkedList<String> courses2 = new LinkedList<>();
        courses2.add("Programare Java");
        courses2.add("Algoritmi");
        courses2.add("Baze de date");
        studentCourses.put(studentList.get(1), courses2);

        LinkedList<String> courses3 = new LinkedList<>();
        courses3.add("Rețele");
        courses3.add("Sisteme de operare");
        studentCourses.put(studentList.get(2), courses3);

        System.out.println("Conținutul HashMap-ului (Student -> Lista de materii):");
        for (Map.Entry<Student, LinkedList<String>> entry : studentCourses.entrySet()) {
            System.out.println(entry.getKey() + " -> " + entry.getValue());
        }

        // Testarea clasei EvenNumbersSet
        System.out.println("\n======= Exercițiul 6: EvenNumbersSet (LinkedHashSet) =======");
        EvenNumbersSet evenSet = new EvenNumbersSet();

        // Adăugăm numere pare și impare
        evenSet.add(2);
        evenSet.add(4);
        evenSet.add(5); // Număr impar, nu ar trebui adăugat
        evenSet.add(6);
        evenSet.add(7); // Număr impar, nu ar trebui adăugat
        evenSet.add(8);

        System.out.println("Conținutul EvenNumbersSet (LinkedHashSet):");
        for (Integer num : evenSet) {
            System.out.print(num + " ");
        }
        System.out.println();

        // Testăm și cu metoda addAll
        List<Integer> numbers = Arrays.asList(10, 11, 12, 13, 14);
        evenSet.addAll(numbers);

        System.out.println("Conținutul după addAll (doar numerele pare ar trebui adăugate):");
        for (Integer num : evenSet) {
            System.out.print(num + " ");
        }
        System.out.println();

        // Test cu HashSet
        System.out.println("\n======= Test cu HashSet =======");
        EvenNumbersSet evenHashSet = new EvenNumbersSet() {
            // Anulăm comportamentul LinkedHashSet pentru a vedea efectele HashSet
        };

        evenHashSet.add(2);
        evenHashSet.add(4);
        evenHashSet.add(6);
        evenHashSet.add(8);
        evenHashSet.add(10);

        System.out.println("Conținutul HashSet (ordinea poate fi diferită):");
        for (Integer num : evenHashSet) {
            System.out.print(num + " ");
        }
        System.out.println();

        // Test cu TreeSet 
        System.out.println("\n======= Test cu un TreeSet (care ar sorta elementele) =======");
        TreeSet<Integer> evenTreeSet = new TreeSet<>();
        evenTreeSet.add(10);
        evenTreeSet.add(2);
        evenTreeSet.add(8);
        evenTreeSet.add(4);
        evenTreeSet.add(6);

        System.out.println("Conținutul TreeSet (elementele sunt sortate):");
        for (Integer num : evenTreeSet) {
            System.out.print(num + " ");
        }
        System.out.println();

        System.out.println("\nObservații:");
        System.out.println("1. LinkedHashSet păstrează ordinea de inserare a elementelor.");
        System.out.println("2. HashSet nu garantează ordinea elementelor (depinde de codul hash).");
        System.out.println("3. TreeSet sortează elementele conform ordinii naturale (crescător).");
    }
}