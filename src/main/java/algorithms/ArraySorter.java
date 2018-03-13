package algorithms;

public class ArraySorter {

  static int[] insertSortArray(int[] data) {
    if (data.length < 2) {
      return data;
    }

    //Insert sort runs 'in-place' - modifying the original array
    for (int i = 1; i < data.length; i++) {
      //We need to move item i into the correct place in the sorted list
      //Work backwards from the current position to allow for the case of a nearly sorted list
      //We may move the item back several steps if appropriate
      for (int j = i; j > 0; j--) {
        if (data[j] < data[j - 1]) {
          swapArrayItems(data, j, j - 1);
        }
      }
    }
    return data;
  }

  //Bubble sort the supplied array
  static int[] bubbleSortArray(int[] data) {
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
