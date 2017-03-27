package com.software.forecasting.model;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

/**
 * Created by odyssefs on 19.03.17.
 */
public class ForecastingSimulation {

  public static List<Integer> simulate(List<FutureTaskBean> futureTasksList) {
    List<Integer> efforts = new ArrayList<>();

    IntStream
        .range(0, 20)
        .forEach(
            i -> {
              final Integer[] sum = {0};
              Random randomGenerator = new Random();
              futureTasksList.forEach(
                  (futureTask) -> IntStream.range(0, futureTask.getEffort()).forEach(j -> {
                        Set<Integer> integers = futureTask.getCategoryEfforts();
                        int randomIndex = randomGenerator.nextInt(integers.size());
                        sum[0] += (Integer) integers.toArray()[randomIndex];
                      }
                  )
              );
              efforts.add(sum[0]);
            }
        );
    Collections.sort(efforts);
    return efforts;
  }
}
