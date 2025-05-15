package usarb.lab3;

public class Main {
    public static void main(String[] args) {
        CandyBag bag = new CandyBag();

        Lindt l1 = new Lindt("cherry", "Switzerland", 2, 3, 4);
        Lindt l2 = new Lindt("cherry", "Switzerland", 2, 3, 4);
        Baravelli b1 = new Baravelli("vanilla", "Italy", 2, 5);
        ChocAmor c1 = new ChocAmor("strawberry", "France", 3);

        bag.addCandy(l1);
        bag.addCandy(b1);
        bag.addCandy(c1);

        System.out.println("Lindt equals? " + l1.equals(l2));

        Area area = new Area(bag, 42, "Strada Cadourilor");
        area.getBirthdayCard();
    }
}
