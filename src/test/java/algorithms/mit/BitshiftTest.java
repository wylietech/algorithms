package algorithms.mit;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.Test;

//Test the bitshift operators in Java
public class BitshiftTest {

  @Test
  public void canShiftBits() {

    int x = 1;

    assertThat(x << 1).isEqualTo(2);
    assertThat(x << 2).isEqualTo(4);
    assertThat(x << 3).isEqualTo(8);

    //By using the double operator we leave the sign intact (so negatives stay negative
    int y = -1;

    assertThat(y << 1).isEqualTo(-2);
    assertThat(y << 2).isEqualTo(-4);
    assertThat(y << 3).isEqualTo(-8);
  }

  @Test
  public void canFlipBits() {

    String binary = "00000000000000000000000010011001";

    //Parse binary in base 2
    Integer i = Integer.parseInt(binary, 2);

    Integer flipped = ~i;
    String flippedBinary = Integer.toBinaryString(flipped);
    assertThat(flippedBinary).isEqualTo("11111111111111111111111101100110");
  }

}
