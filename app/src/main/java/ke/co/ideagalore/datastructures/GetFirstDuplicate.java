package ke.co.ideagalore.datastructures;

import java.util.HashSet;

public class GetFirstDuplicate {

    int usingHashSet(int[] array) {
        int value;
        HashSet<Integer> set = new HashSet<>();
        for (int i = 0; i < array.length; i++) {

            if (set.contains(array[i])) {
                value = array[i];
                return value;
            } else {
                set.add(array[i]);
            }

        }
        value = -1;
        return value;

        //Note that this solution gives us a time complexity of O(n) which is pretty fast but its very efficient memory wise;
    }
}
