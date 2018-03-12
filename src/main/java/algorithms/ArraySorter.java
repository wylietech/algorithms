package algorithms;

import java.util.ArrayList;
import java.util.List;

public class ArraySorter {

  //Bubble sort the supplied array
  static int[] sortArray(int[] data) {
    List<Integer> outputData = new ArrayList<>(data.length);

    for (int i = 0; i < data.length; i++) {
      outputData.add(i);
    }

    return new int[0];
    /*
    //If less than two then nothing to do
      if (outputData.size() < 2) {
        return outputData.toArray();
      }

    for (int i=0; i< outputData.size() - 1;i++) {
      if (items(i) > items)
    }
    */

  }
}
