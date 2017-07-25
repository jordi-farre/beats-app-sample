package beats.sample;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
@RestController
public class Application {

    @RequestMapping(value = "/", produces = "text/html")
    public String home() {
        return "<html><body><span>Test page</span></body></html>";
    }

    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }

}
