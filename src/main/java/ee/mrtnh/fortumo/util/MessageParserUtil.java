package ee.mrtnh.fortumo.util;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class MessageParserUtil {

    public static boolean isMessageNumber(String message) {
        try {
            Long.parseLong(message);
            log.debug("Message is a number. Message is " + message);
            return true;
        } catch (NumberFormatException e) {
            log.debug("Message is not a number. Message is " + message);
            return false;
        }
    }

    public static boolean isMessageEnd(String message) {
        if (message.equals("end")) {
            log.debug("Message is \"end\"");
            return true;
        } else {
            log.debug("Message is not \"end\"");
            return false;
        }
    }
}
