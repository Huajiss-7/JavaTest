package CSC3101.网工.lab9;

import java.util.ArrayList;

public class q1b {

    // Generics part

    public static class TestClass {

        // Part (b): Define the min method
        public static <E extends Comparable<E>> E min(ArrayList<E> list) {
            if (list == null || list.isEmpty()) {
                return null;
            }

            E minElement = list.get(0);
            for (int i = 1; i < list.size(); i++) {
                E currentElement = list.get(i);
                if (currentElement.compareTo(minElement) < 0) {
                    minElement = currentElement;
                }
            }

            return minElement;
        }
    }
}
