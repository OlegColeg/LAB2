package usarb.lab4;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class MyImmutableArray {
    private final List<Integer> immutableArray;

    public MyImmutableArray(ArrayList<Integer> originalArray) {
        this.immutableArray = Collections.unmodifiableList(new ArrayList<>(originalArray));
    }

    public List<Integer> getArray() {
        return immutableArray;
    }
}
