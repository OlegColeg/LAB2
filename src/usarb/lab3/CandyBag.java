package usarb.lab3;

import java.util.ArrayList;

public class CandyBag {
    private ArrayList<CandyBox> candyList;

    public CandyBag() {
        candyList = new ArrayList<>();
    }

    public void addCandy(CandyBox candy) {
        candyList.add(candy);
    }

    public ArrayList<CandyBox> getCandyList() {
        return candyList;
    }
}

