package algorithms;

import java.util.regex.Matcher;
import java.util.regex.Pattern;
import org.junit.jupiter.api.Test;

class StringTokenizerTest {

  @Test
  void dateTest() {

    Pattern pattern = Pattern.compile("^(..):(..):(..)(..)$");
    Matcher matcher = pattern.matcher("07:54:34AM");

    while (matcher.find()) {
      int i = matcher.groupCount();
      String a = matcher.group(0);
      String b = matcher.group(1);
      String c = matcher.group(2);
      String d = matcher.group(3);
      String e = matcher.group(4);

      System.out.println(i);
    }

  }
}
