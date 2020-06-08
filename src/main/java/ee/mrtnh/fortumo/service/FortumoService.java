package ee.mrtnh.fortumo.service;

import ee.mrtnh.fortumo.util.MessageParserUtil;
import ee.mrtnh.fortumo.util.NumberHolderUtil;
import lombok.extern.slf4j.Slf4j;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;

import java.util.concurrent.CompletableFuture;

@Service
@Slf4j
public class FortumoService {

    @Async("asyncExecutor")
    public CompletableFuture<Long> processMessage(String message) {
        NumberHolderUtil.clearList();

        if (MessageParserUtil.isMessageNumber(message)) {
            NumberHolderUtil.addNumberToList(Long.valueOf(message));

            Long sum = NumberHolderUtil.getSumOfNumbersInList();
            return CompletableFuture.completedFuture(sum);
        } else if (MessageParserUtil.isMessageEnd(message)) {
            NumberHolderUtil.endMessageArrived();

            Long sum = NumberHolderUtil.getSumOfNumbersInList();
            return CompletableFuture.completedFuture(sum);
        }
        log.debug("Message is not a number or \"end\". Message is " + message);
        return null;
    }

}
