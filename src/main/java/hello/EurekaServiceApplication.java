package hello;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@SpringBootApplication
public class EurekaServiceApplication {
    
    public static void main(String[] args) {
        SpringApplication.run(EurekaServiceApplication.class, args);
    }
}


@RestController
class ServiceInstanceRestController {

    @RequestMapping(value = "/hello", method = RequestMethod.GET)
    public String hello() {
        return "hello";
    }
}
