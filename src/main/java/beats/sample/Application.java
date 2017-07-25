package beats.sample;

import org.apache.commons.logging.Log;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.util.logging.Logger;

@SpringBootApplication
@RestController
public class Application {

    private Logger LOGGER = Logger.getLogger(Application.class.getName());

    @RequestMapping(value = "/", produces = "text/html")
    public String home() {
        RestTemplate restTemplate = new RestTemplate();
        HttpHeaders httpHeaders = new HttpHeaders();
        httpHeaders.setContentType(MediaType.TEXT_PLAIN);
        HttpEntity<String> httpEntity = new HttpEntity<>("testing", httpHeaders);
        String result = restTemplate.postForEntity("http://httpbin.org/post", httpEntity, String.class).getBody();
        LOGGER.info("Result to log: " + result);
        return "<html><body><span>Test page</span></body></html>";
    }

    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }

}
