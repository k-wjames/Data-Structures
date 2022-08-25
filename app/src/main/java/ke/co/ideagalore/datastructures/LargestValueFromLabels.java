package ke.co.ideagalore.datastructures;

import android.os.Build;
import android.widget.Toast;


import androidx.annotation.RequiresApi;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.PriorityQueue;

public class LargestValueFromLabels {
    @RequiresApi(api = Build.VERSION_CODES.N)
    public int largestValuesFromLabels(int[] values, int[] labels, int num_wanted, int use_limit) {

        List<Item> items=new ArrayList<>();
        for (int i=0;i<labels.length; i++){
            items.add(new Item(values[i],labels[i]));
        }

        PriorityQueue<Item> maxHeap=new PriorityQueue<>((Item a, Item b)->b.value-a.value);
        maxHeap.addAll(items);

        Map<Integer, Integer>counts=new HashMap<>();
        int value=0;
        while(!maxHeap.isEmpty() && num_wanted>0){

            Item current=maxHeap.remove();
            counts.put(current.label, counts.getOrDefault(current.label,0)+1);
            if (counts.get(current.label)<=use_limit){
                value+= current.value;
                num_wanted--;
            }

        }
        return value;
    }

    public class Item {

        int value, label;

        public Item(int value, int label) {
            this.value = value;
            this.label = label;
        }
    }
}
