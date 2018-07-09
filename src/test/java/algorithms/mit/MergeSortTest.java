package algorithms.mit;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.Test;

public class MergeSortTest {

  @Test
  public void canSortEvenList() {

    int[] data = new int[]{9, 3, 4, 2};
    MergeSort.mergeSort(data);

    assertThat(data).isSorted();
  }

  @Test
  public void canSortOddList() {

    int[] data = new int[]{9, 3, 4, 2, 8};
    MergeSort.mergeSort(data);

    assertThat(data).isSorted();
  }

  @Test
  public void canSortWithNegatives() {

    int[] data = new int[]{7, -2, 0, 0, -6, 11, 0};
    MergeSort.mergeSort(data);

    assertThat(data).isSorted();
  }

  @Test
  public void canSortAlreadySorted() {
    int[] data = new int[]{1, 2, 3, 4, 5};
    MergeSort.mergeSort(data);

    assertThat(data).isSorted();
  }

  @Test
  public void canSortSingleItem() {
    int[] data = new int[]{1};
    MergeSort.mergeSort(data);

    assertThat(data).isSorted();
  }

  @Test
  public void canSortEmptyArray() {
    int[] data = new int[0];
    MergeSort.mergeSort(data);

    assertThat(data).isSorted();
  }

}
