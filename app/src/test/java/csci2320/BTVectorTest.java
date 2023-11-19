package csci2320;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;

public class BTVectorTest {
  @Test
  void emptyIsSizeZero() {
    var nil = BTVector.<Integer>empty();
    assertEquals(0, nil.size());
  }

  // TODO: Add your tests here.
}
