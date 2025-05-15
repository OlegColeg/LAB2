package usarb.lab3;

public class ChocAmor extends CandyBox {
    private float length;

    public ChocAmor() {
        super();
        this.length = 0;
    }

    public ChocAmor(String flavor, String origin, float length) {
        super(flavor, origin);
        this.length = length;
    }

    @Override
    public float getVolume() {
        return length * length * length;
    }

    public void printChocAmorDim() {
        System.out.println("ChocAmor cube: " + length + " x " + length + " x " + length);
    }

    @Override
    public void printDim() {
        printChocAmorDim();
    }

    @Override
    public String toString() {
        return "The " + super.toString() + " has volume " + getVolume();
    }
}
