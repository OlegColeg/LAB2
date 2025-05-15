package usarb.lab3;

public class CandyBox {
    private String flavor;
    private String origin;

    public CandyBox() {
        this.flavor = "unknown";
        this.origin = "unknown";
    }

    public CandyBox(String flavor, String origin) {
        this.flavor = flavor;
        this.origin = origin;
    }

    public float getVolume() {
        return 0;
    }

    @Override
    public String toString() {
        return flavor + " from " + origin;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;
        CandyBox other = (CandyBox) obj;
        return flavor.equals(other.flavor) && origin.equals(other.origin);
    }

    public void printDim() {
        // se suprascrie în clasele derivate
    }
}
