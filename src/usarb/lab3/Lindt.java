package usarb.lab3;

public class Lindt extends CandyBox {
    private float length, width, height;

    public Lindt() {
        super();
        this.length = this.width = this.height = 0;
    }

    public Lindt(String flavor, String origin, float length, float width, float height) {
        super(flavor, origin);
        this.length = length;
        this.width = width;
        this.height = height;
    }

    @Override
    public float getVolume() {
        return length * width * height;
    }

    public void printLindtDim() {
        System.out.println("Lindt box: " + length + " x " + width + " x " + height);
    }

    @Override
    public void printDim() {
        printLindtDim();
    }

    @Override
    public String toString() {
        return "The " + super.toString() + " has volume " + getVolume();
    }
}
