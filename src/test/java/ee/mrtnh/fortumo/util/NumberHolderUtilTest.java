package ee.mrtnh.fortumo.util;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

class NumberHolderUtilTest {

    @BeforeAll
    static void addNumbersToList() {
        NumberHolderUtil.addNumberToList(1L);
        NumberHolderUtil.addNumberToList(2L);
        NumberHolderUtil.addNumberToList(3L);
    }

    @Test
    void addNumberToList_true() {
        int listSize = NumberHolderUtil.numbersList.size();
        NumberHolderUtil.addNumberToList(4L);
        assertEquals(listSize + 1, NumberHolderUtil.numbersList.size());
    }

    @Test
    void getSumOfNumbersInList_true() {
        NumberHolderUtil.isEnd = true;
        assertEquals(10, NumberHolderUtil.getSumOfNumbersInList());
    }

    @Test
    void endMessageArrived_true() {
        NumberHolderUtil.isEnd = false;
        NumberHolderUtil.endMessageArrived();
        assertTrue(NumberHolderUtil.isEnd);
    }

    @Test
    void clearList_true() {
        NumberHolderUtil.isEnd = true;
        NumberHolderUtil.clearList();
        assertEquals(0, NumberHolderUtil.numbersList.size());
    }
}