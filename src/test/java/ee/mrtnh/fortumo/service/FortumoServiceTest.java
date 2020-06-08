package ee.mrtnh.fortumo.service;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.concurrent.ExecutionException;

@SpringBootTest
class FortumoServiceTest {

    @Autowired
    FortumoService fortumoService;

    @Test
    void processMessage_test() throws ExecutionException, InterruptedException {
     /*   CompletableFuture<Long> returnMessage1 = fortumoService.processMessage("1");
        CompletableFuture<Long> returnMessage2 = fortumoService.processMessage("2");
        CompletableFuture<Long> returnMessageInvalidInput= fortumoService.processMessage("invalid_input");
        CompletableFuture<Long> returnMessage3 = fortumoService.processMessage("3");
        CompletableFuture<Long> returnMessage4 =  fortumoService.processMessage("end");

*//*        Long join1 = returnMessage1.join();
        Long join2 = returnMessage2.join();
        Long join3 = returnMessage3.join();
        Long join4 = returnMessage4.join();

        assertEquals(join1,join2);
        assertEquals(join2,join3);
        assertEquals(join3,join4);*//*

        assertEquals(returnMessage1.get(),returnMessage4.get());*/
    }
}