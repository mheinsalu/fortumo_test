package ee.mrtnh.fortumo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;

/**
 * @author Märten Heinsalu
 * date: 06.2020
 */
@SpringBootApplication
public class FortumoTestApplication extends SpringBootServletInitializer {

    public static void main(String[] args) {
        SpringApplication.run(FortumoTestApplication.class, args);
    }

    @Override
    protected SpringApplicationBuilder configure(SpringApplicationBuilder application) {
        return application.sources(FortumoTestApplication.class);
    }

}
