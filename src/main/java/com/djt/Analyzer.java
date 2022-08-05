package com.djt;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import org.stats.AnalyzerConfigurationException;
import org.stats.RatingAnalyzer;

public class Analyzer implements RatingAnalyzer {

  private final int[] ratings;

  public Analyzer(int[] ratingsArray) throws AnalyzerConfigurationException {
    this.ratings = ratingsArray;
    if (ratingsArray == null || ratingsArray.length == 0) {
      throw new IllegalArgumentException("The array cannot be null or empty. Please try again!");
    }
  }

  @Override
  public double mean() {
    double sum = 0;
    for (int elementInRatings : ratings) {
      sum += elementInRatings;
    }
    return sum / ratings.length;

  }

  @Override
  public double median() throws ArrayIndexOutOfBoundsException {
    Arrays.sort(ratings);
    double answer;
    int arrayLength = ratings.length;
    int halfArrayLength = arrayLength / 2;
    long elementAtHalfArrayLength = ratings[halfArrayLength];
    if (arrayLength % 2 != 0) {
      answer = ratings[arrayLength / 2];
    } else {
      answer = (double) (elementAtHalfArrayLength + ratings[halfArrayLength - 1]) / 2;
    }
    return answer;
  }

  @Override
  public int[] mode() {
    int maxNumVal;
    int maxNumItself;
    Map<Integer, Integer> mapHere = new HashMap<>();
    List<Integer> modeVals = new ArrayList<>();

    for (int value : ratings) {
      Integer keysValue = mapHere.get(value);
      if (keysValue == null) {
        mapHere.put(value, 0);
      } else {
        mapHere.put(value, keysValue + 1);
      }
    }

    int maxValueInMap = Collections.max(mapHere.values());
    for (Entry<Integer, Integer> pair : mapHere.entrySet()) {
      maxNumVal = pair.getValue();
      maxNumItself = pair.getKey();
      if (maxNumVal == maxValueInMap) {
        modeVals.add(maxNumItself);
      }
    }

    return modeVals.stream().mapToInt(Integer::intValue)
        .sorted().toArray();

  }

}

