package beats.sample;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@SpringBootApplication
@RestController
public class Application {

    @RequestMapping(value = "/", produces = "text/html")
    public String home() {
        RestTemplate restTemplate = new RestTemplate();
        HttpHeaders httpHeaders = new HttpHeaders();
        httpHeaders.setContentType(MediaType.TEXT_HTML);
        HttpEntity<String> httpEntity = new HttpEntity<>("<html><body><span>Test page</span></body></html>", httpHeaders);
        return restTemplate.postForEntity("http://httpbin.org/post", httpEntity, String.class).getBody();
    }

    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }

}
