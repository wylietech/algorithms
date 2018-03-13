package algorithms;

public class ArraySorter {

  //Bubble sort the supplied array
  static int[] sortArray(int[] data) {
    if (data.length < 2) {
      return data;
    }

    //Bubble sort runs 'in-place' - modifying the original array
    boolean modified;

    do {
      modified = false;
      for (int i = 1; i < data.length; i++) {
        if (data[i - 1] > data[i]) {
          swapArrayItems(data, i - 1, i);
          modified = true;
        }
      }
    }
    while (modified);

    return data;
  }

  private static void swapArrayItems(int[] data, int position1, int position2) {
    int valueAtPosition2 = data[position2];
    data[position2] = data[position1];
    data[position1] = valueAtPosition2;
  }
}
