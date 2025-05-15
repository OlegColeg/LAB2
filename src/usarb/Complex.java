package usarb;
// TASK 1
public class Complex {
    // Membrii privați
    private int real;
    private int imaginary;

    // Constructorul principal (cu doi parametri)
    public Complex(int real, int imaginary) {
        this.real = real;
        this.imaginary = imaginary;
    }

    // Constructorul fără parametri (inițializează cu 0, 0)
    public Complex() {
        this(0, 0); // Apelează constructorul principal
    }

    // Constructor de copiere
    public Complex(Complex other) {
        this.real = other.real;
        this.imaginary = other.imaginary;
    }

    // Getters
    public int getReal() {
        return real;
    }

    public int getImaginary() {
        return imaginary;
    }

    // Setters
    public void setReal(int real) {
        this.real = real;
    }

    public void setImaginary(int imaginary) {
        this.imaginary = imaginary;
    }

    // Adună un alt număr complex la acest obiect
    public void addWithComplex(Complex other) {
        this.real += other.real;
        this.imaginary += other.imaginary;
    }

    // Afișează numărul complex
    public void showNumber() {
        System.out.println(real + " + " + imaginary + "i");
    }

    // Pentru testare
    public static void main(String[] args) {
        Complex c1 = new Complex(3, 4);
        Complex c2 = new Complex(1, 2);
        c1.addWithComplex(c2);
        c1.showNumber(); // Va afișa: 4 + 6i

        Complex c3 = new Complex(c1);
        c3.showNumber(); // Va afișa: 4 + 6i
    }
}
