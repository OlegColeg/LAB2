package usarb.lab3;

public class Area {
    private CandyBag bag;
    private int number;
    private String street;

    public Area() {
        this.bag = new CandyBag();
        this.number = 0;
        this.street = "unknown";
    }

    public Area(CandyBag bag, int number, String street) {
        this.bag = bag;
        this.number = number;
        this.street = street;
    }

    public void getBirthdayCard() {
        System.out.println("Sending gift to: " + street + " nr. " + number);
        System.out.println("La mulți ani, mămico! 🥳🎁🍬");

        for (CandyBox candy : bag.getCandyList()) {
            System.out.println(candy.toString());
        }

        System.out.println("\nDimensiuni:");
        for (CandyBox candy : bag.getCandyList()) {
            candy.printDim();
        }
    }
}
