package shuffer;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Test {
    public static void main(String args[]) {
        // create array list object
        List arrlist = new ArrayList();

        // populate the list
        arrlist.add("A");
        arrlist.add("B");
        arrlist.add("C");

        System.out.println("Initial collection: " + arrlist);

        // shuffle the list
        Collections.shuffle(arrlist);

        System.out.println("Final collection after shuffle: " + arrlist);
        Collections.shuffle(arrlist);

        System.out.println("Final collection after shuffle: " + arrlist);
        Collections.shuffle(arrlist);

        System.out.println("Final collection after shuffle: " + arrlist);
    }

}
