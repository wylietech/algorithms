package algorithms;

import java.util.List;

public class ListSorter {

  public static List<Integer> sort(List<Integer> data) {
    if (data.size() < 2) {
      return data;
    }

    boolean madeChangesDuringSearch;

    do {
      madeChangesDuringSearch = false;
      for (int position = 0; position < data.size() - 1; position++) {
        Integer item = data.get(position);
        Integer nextItem = data.get(position + 1);
        if (nextItem < item) {
          //Swap items around
          data.set(position, nextItem);
          data.set(position + 1, item);
          madeChangesDuringSearch = true;
        }
      }
    } while (madeChangesDuringSearch);

    return data;
  }
}
