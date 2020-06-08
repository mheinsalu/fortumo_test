package ee.mrtnh.fortumo.util;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

class MessageParserUtilTest {

    @Test
    void isMessageNumber_true() {
        String message = "1";
        assertTrue(MessageParserUtil.isMessageNumber(message));
    }

    @Test
    void isMessageNumber_false_number() {
        String message = "1.0";
        assertFalse(MessageParserUtil.isMessageNumber(message));
    }

    @Test
    void isMessageNumber_false_letter() {
        String message = "A";
        assertFalse(MessageParserUtil.isMessageNumber(message));
    }

    @Test
    void isMessageEnd_true() {
        String message = "end";
        assertTrue(MessageParserUtil.isMessageEnd(message));
    }

    @Test
    void isMessageEnd_false() {
        String message = "notEnd";
        assertFalse(MessageParserUtil.isMessageEnd(message));
    }
}