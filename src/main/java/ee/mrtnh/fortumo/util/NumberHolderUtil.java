package ee.mrtnh.fortumo.util;

import lombok.extern.slf4j.Slf4j;

import java.util.ArrayList;
import java.util.List;

@Slf4j
public class NumberHolderUtil {

    static List<Long> numbersList = new ArrayList<>();
    static boolean isEnd = false;

    static final int SLEEP_TIME_MS = 1000;
    static final int MAX_CYCLES = 100;

    public static void addNumberToList(Long number) {
        log.debug("Adding number " + number + " to list");
        numbersList.add(number);
        log.debug("Added number " + number + " to list");
    }

    public static Long getSumOfNumbersInList() {
        log.debug("Getting sum of numbers in list");

        try {
            stallForEndMessage();
        } catch (InterruptedException e) {
            log.error("Could not calculate sum. Thread interrupted", e);
            return null;
        }

        log.debug("Calculating sum of numbers in list");
        if (numbersList.isEmpty()) return null;

        Long sum = 0L;
        for (Long number : numbersList) {
            sum += number;
        }
        log.debug("Calculated sum of numbers in list. Sum is " + sum);
        return sum;
    }

    private static void stallForEndMessage() throws InterruptedException {
        int counter = 0;
        while (!isEnd) {
            log.debug("\"End\" request has not arrived. Thread has slept for " + counter + " cycles. Thread will sleep for " + SLEEP_TIME_MS + "ms");
            Thread.sleep(SLEEP_TIME_MS);
            counter++;
            log.debug("Sleep counter is " + counter + " on thread " + Thread.currentThread());
            if (counter == MAX_CYCLES) {
                String message = "Could not calculate sum. Maximum number of thread sleep cycles reached";
                log.debug(message);
                throw new InterruptedException(message);
            }
        }
    }

    public static void endMessageArrived() {
        isEnd = true;
    }

    public static void clearList() {
        if (isEnd) {
            log.debug("Clearing list of numbers");
            numbersList.clear();
            isEnd = false;
            log.debug("Cleared list of numbers");
        }
    }
}
