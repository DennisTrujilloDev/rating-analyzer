package com.djt;

import static org.junit.jupiter.api.Assertions.*;

import java.util.List;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import org.stats.AnalyzerConfigurationException;
import org.stats.RatingAnalyzer;

public class AnalyzerTest {

  public static List<Arguments> modeSource() {
    return List.of(Arguments.of(new int[]{2, 5, 2, 3, 1, 5, 5, 2}, new int[]{2, 5}),
        Arguments.of(new int[]{2, 5, 2, 3, 1, 5, 5}, new int[]{5}),
        Arguments.of(new int[]{3, 8, 2}, new int[]{2, 3, 8}),
        Arguments.of(new int[]{3}, new int[]{3}),
        Arguments.of(new int[]{-13, -10, -8, 19, 19, 35}, new int[]{19}),
        Arguments.of(new int[]{2147483647, 2147483646}, new int[]{2147483646, 2147483647}));
  }

  public static List<Arguments> medianSource() {
    return List.of(Arguments.of(new int[]{2, 5, 2, 3, 1, 5, 5, 2}, 2.5),
        Arguments.of(new int[]{2, 5, 2, 3, 1, 5, 5}, 3), Arguments.of(new int[]{3, 8, 2}, 3),
        Arguments.of(new int[]{3}, 3),
        Arguments.of(new int[]{-13, -10, -8, 19, 19, 35}, 5.5),
        Arguments.of(new int[]{2147483647, 2147483646}, 2147483646.5));
  }

  public static List<Arguments> meanSource() {
    return List.of(Arguments.of(new int[]{1, 3, 5, 7, 9}, 5),
        Arguments.of(new int[]{2, 5, 2, 3, 1, 5, 5, 2}, 3.125),
        Arguments.of(new int[]{-13, -10, -8, 19, 19, 35}, 7),
        Arguments.of(new int[]{2147483647, 2147483646}, 2147483646.5));
  }

  @Test
  void newInstanceTest() {
    try {
      RatingAnalyzer.newInstance(null);
      fail("The array cannot be null.");
    } catch (AnalyzerConfigurationException e) {
      assertInstanceOf(IllegalArgumentException.class, e.getCause());
    }
    try {
      RatingAnalyzer.newInstance(new int[]{});
      fail("The array cannot be empty.");
    } catch (AnalyzerConfigurationException e) {
      assertInstanceOf(IllegalArgumentException.class, e.getCause());
    }
  }

  @ParameterizedTest
  @MethodSource("modeSource")
  void modeTest(int[] ratings, int[] expectedModes) {
    RatingAnalyzer analyzer = RatingAnalyzer.newInstance(ratings);
    assertArrayEquals(expectedModes, analyzer.mode());
  }

  @ParameterizedTest
  @MethodSource("medianSource")
  void medianTest(int[] ratings, double expectedMedian) {
    RatingAnalyzer analyzer = RatingAnalyzer.newInstance(ratings);
    assertEquals(expectedMedian, analyzer.median());
  }

  @ParameterizedTest
  @MethodSource("meanSource")
  void meanTest(int[] ratings, double expectedMean) {
    RatingAnalyzer analyzer = RatingAnalyzer.newInstance(ratings);
    assertEquals(expectedMean, analyzer.mean(), expectedMean * 0.000001);
  }

}
