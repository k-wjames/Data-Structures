package ke.co.ideagalore.datastructures;

import static java.util.Arrays.sort;

import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;

import java.util.Arrays;

public class MainActivity extends AppCompatActivity {

    TextView textView;

    @RequiresApi(api = Build.VERSION_CODES.N)
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        textView=findViewById(R.id.tv_array);

        int[] array = {4, 1, 10, -3, 12};

        int[] newArray = {4, 1, 10, 19, 12};

        int [] labels={0,0,0,1,1};
        int [] values={9,8,8,7,6};

        int num_wanted=3;
        int use_limit=2;

        LargestValueFromLabels largestValueFromLabels=new LargestValueFromLabels();
        int answer=largestValueFromLabels.largestValuesFromLabels(values, labels,num_wanted,use_limit);

        textView.setText(String.valueOf(answer));

        Button sort = findViewById(R.id.btn_sort);
        sort.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //selectionSort(array);
                //insertionSort(array);
                //bubbleSort(array);
                //quickSort(newArray, 0, newArray.length - 1);
                mergeSort(newArray, 0, newArray.length-1);

            }
        });

        Button clear=findViewById(R.id.btn_clear);
        clear.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                textView.setText("");
            }
        });

    }

    private void mergeSort(int[] array, int left, int right) {

        if (left < right) {
            int m = (left + right) / 2;
            sort(array, left, m);
            sort(array, m+1, right);
            merge(array, left, m, right);

            setView(array);
        }
    }

    private void merge(int[] array, int left, int middle, int right) {
        int s1 = middle - left + 1;
        int s2 = right - middle;

        int[] leftArray = new int[s1];
        int[] rightArray = new int[s2];

        for (int i = 0; i < s1; i++)
            leftArray[i] = array[left + 1];

        for (int j = 0; j < s2; j++)
            rightArray[j] = array[middle + 1 + j];

        int i = 0;
        int j = 0;

        int k = left;
        while (i < s1 && j < s2) {

            if (leftArray[i] <= rightArray[j]) {

                array[k] = leftArray[i];
                i++;
            } else {

                array[k] = rightArray[j];
                j++;
            }

            k++;

        }

        while (i < s1) {
            array[k] = leftArray[i];
            i++;
            k++;
        }
        while (j < s2) {

            array[k] = rightArray[j];
            j++;
            k++;
        }
    }

    private void setView(int[] newArray) {
        String str = Arrays.toString(newArray);
        textView = findViewById(R.id.tv_array);
        textView.setText(str);
    }

    private void quickSort(int[] array, int low, int high) {

        if (low < high) {

            int pi = quickSortPartition(array, low, high);
            sort(array, low, pi - 1);
            sort(array, pi + 1, high);
        }

        setView(array);

    }

    private int quickSortPartition(int[] array, int low, int high) {

        int pivot = array[high];
        int i = (low - 1);
        for (int j = low; j < high; j++) {

            if (array[j] <= pivot) {
                i++;
                int temp = array[i];
                array[i] = array[j];
                array[j] = temp;
            }
        }

        int temp = array[i + 1];
        array[i + 1] = array[high];
        array[high] = temp;

        return i + 1;

    }


    private void insertionSort(int[] array) {

        int length = array.length;
        for (int i = 0; i < length; i++) {

            int key = array[i];
            int j = i - 1;

            while (j >= 0 && array[j] > key) {

                array[j + 1] = array[j];
                j = j - 1;

            }

            array[j + 1] = key;
        }

        setView(array);

    }

    private void selectionSort(int[] array) {

        int length = array.length;

        for (int i = 0; i < length - 1; i++) {

            /*Assuming the minimum element is at index i of the array*/
            int minimum = i;

            for (int j = i + 1; j < length; j++) {
                if (array[j] < array[minimum]) {
                    minimum = j;
                }
            }

            /*Now swap the elements*/

            int temp = array[minimum];
            array[minimum] = array[i];
            array[i] = temp;
        }

        setView(array);
    }

    private void bubbleSort(int[] array) {
        int length = array.length;
        for (int i = 0; i < length - 1; i++) {

            for (int j = 0; j < length - i - 1; j++) {

                if (array[j] > array[j + 1]) {
                    int temp = array[j];
                    array[j] = array[j + 1];
                    array[j + 1] = temp;

                }
            }
        }

        setView(array);
    }


}