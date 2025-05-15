package usarb.lab4;

import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {

        PasswordMaker maker1 = PasswordMaker.getInstance("Daniel");
        System.out.println("Parola generată: " + maker1.getPassword());

        PasswordMaker maker2 = PasswordMaker.getInstance("AltNume");
        System.out.println("Parola nouă: " + maker2.getPassword());

        System.out.println("De câte ori a fost apelat getInstance(): " + PasswordMaker.getInstanceAccessCount());


        ArrayList<Integer> listaOriginala = new ArrayList<>();
        listaOriginala.add(10);
        listaOriginala.add(20);
        listaOriginala.add(30);

        MyImmutableArray immutable = new MyImmutableArray(listaOriginala);
        System.out.println("Array imutabil original: " + immutable.getArray());

        try {
            immutable.getArray().add(40);  // trebuie să arunce excepție
        } catch (UnsupportedOperationException e) {
            System.out.println("Modificarea a fost blocată: obiectul este imutabil.");
        }

        System.out.println("Array după încercare de modificare: " + immutable.getArray());
    }
}
