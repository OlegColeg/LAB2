package usarb.lab3;

public class Baravelli extends CandyBox {
    private float radius, height;

    public Baravelli() {
        super();
        this.radius = this.height = 0;
    }

    public Baravelli(String flavor, String origin, float radius, float height) {
        super(flavor, origin);
        this.radius = radius;
        this.height = height;
    }

    @Override
    public float getVolume() {
        return (float) (Math.PI * radius * radius * height);
    }

    public void printBaravelliDim() {
        System.out.println("Baravelli cylinder: radius = " + radius + ", height = " + height);
    }

    @Override
    public void printDim() {
        printBaravelliDim();
    }

    @Override
    public String toString() {
        return "The " + super.toString() + " has volume " + getVolume();
    }
}
