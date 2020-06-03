package ee.mrtnh.fortumo.service;

import ee.mrtnh.fortumo.util.NumberHolderUtil;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Service
@Slf4j
public class FortumoService {

    public Long processMessage(String message) {
        message = removeCurlEqualsSignFromMessageEnd(message);
        if (isMessageNumber(message)) {
            NumberHolderUtil.addNumberToList(Long.parseLong(message));
            return null;
        } else if (isMessageEnd(message)) {
            Long sum = NumberHolderUtil.getSumOfNumbersInList();
            NumberHolderUtil.clearList();
            return sum;
        }
        log.debug("Message is not number or \"end\". Message is " + message);
        return null;
    }

    private String removeCurlEqualsSignFromMessageEnd(String message) {
        // TODO: curl messages (as in assignment examples) all end with =
        if (message != null && message.length() > 0) {
            return message.substring(0, message.length() - 1);
        }
        return message;
    }

    public boolean isMessageNumber(String message) {
        try {
            Long.parseLong(message);
            log.debug("Message is of type Long. Message is " + message);
            return true;
        } catch (NumberFormatException e) {
            log.debug("Message is not of type Long. Message is " + message);
            return false;
        }
    }

    public boolean isMessageEnd(String message) {
        if (message.equalsIgnoreCase("end")) {
            log.debug("Message is \"end\"");
            return true;
        } else {
            log.debug("Message is not \"end\"");
            return false;
        }
    }
}
