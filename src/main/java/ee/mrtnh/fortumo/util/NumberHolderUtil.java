package ee.mrtnh.fortumo.util;

import lombok.extern.slf4j.Slf4j;

import java.util.ArrayList;
import java.util.List;

@Slf4j
public class NumberHolderUtil {

    static List<Long> numbersList = new ArrayList<>();

    public static void addNumberToList(Long number) {
        log.debug("Adding number " + number + " to list");
        numbersList.add(number);
        log.debug("Added number " + number + " to list");
    }

    public static Long getSumOfNumbersInList() {
        log.debug("Getting sum of numbers in list");
        if (numbersList.size() == 0) return null;
        Long sum = 0L;
        for (Long number : numbersList) {
            sum += number;
        }
        log.debug("Got sum of numbers in list. Sum is " + sum);
        return sum;
    }

    public static void clearList() {
        log.debug("Clearing list of numbers");
        numbersList.clear();
        log.debug("Cleared list of numbers");
    }
}
