//even just one test (except ctor) is basic requirement

//work on numeric value types
//use fixture?

//include good comments
//organization
package com.djt;

import static org.junit.jupiter.api.Assertions.*;

import java.util.List;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import org.stats.AnalyzerConfigurationException;
import org.stats.RatingAnalyzer;

class AnalyzerTest {

  public static List<Arguments> modeSource() {
    return List.of(
        Arguments.of(new int[]{2, 5, 2, 3, 1, 5, 5, 2}, new int[]{2, 5}),
        Arguments.of(new int[]{2, 5, 2, 3, 1, 5, 5}, new int[]{5}),
        Arguments.of(new int[]{3, 8, 2}, new int[]{2, 3, 8}),
        Arguments.of(new int[]{3}, new int[]{3}),
        Arguments.of(new int[]{2147483647, 2147483646}, new int[]{2147483646, 2147483647})
    );
  }

  public static List<Arguments> medianSource() {
    return List.of(
        Arguments.of(new int[]{2, 5, 2, 3, 1, 5, 5, 2}, 2.5),
        Arguments.of(new int[]{2, 5, 2, 3, 1, 5, 5}, 3),
        Arguments.of(new int[]{3, 8, 2}, 3),
        Arguments.of(new int[]{3}, 3),
        Arguments.of(new int[]{2147483647, 2147483646}, 2147483646.5)
    );
  }

  public static List<Arguments> meanSource() {
    return List.of(
        Arguments.of(new int[]{1, 3, 5, 7, 9}, 5),
        Arguments.of(new int[]{2, 5, 2, 3, 1, 5, 5, 2}, 3.125),
        Arguments.of(new int[]{2147483647, 2147483646}, 2147483646.5)
    );
  }

  @Test
  void newInstance() {
    try {
      RatingAnalyzer.newInstance(null);
      fail();
    } catch (AnalyzerConfigurationException e) {
      assertInstanceOf(IllegalArgumentException.class, e.getCause());
    }
    try {
      RatingAnalyzer.newInstance(new int[]{});
      fail();
    } catch (AnalyzerConfigurationException e) {
      assertInstanceOf(IllegalArgumentException.class, e.getCause());
    }
  }

  @ParameterizedTest
  @MethodSource("meanSource")
  void mean(int[] ratings, double expectedMean) {
    RatingAnalyzer analyzer = RatingAnalyzer.newInstance(ratings);
    assertEquals(expectedMean, analyzer.mean(), expectedMean * 0.000001);
  }

  @ParameterizedTest
  @MethodSource("medianSource")
  void median(int[] ratings, double expectedMedian) {
    RatingAnalyzer analyzer = RatingAnalyzer.newInstance(ratings);
    assertEquals(expectedMedian, analyzer.median());
    //do not invoke ctor, use newInstance (done through .properties file)
  }

  @ParameterizedTest
  @MethodSource("modeSource")
  void mode(int[] ratings, int[] expectedModes) {
    RatingAnalyzer analyzer = RatingAnalyzer.newInstance(ratings);
    assertArrayEquals(expectedModes, analyzer.mode());
  }

  //use (double)
}
