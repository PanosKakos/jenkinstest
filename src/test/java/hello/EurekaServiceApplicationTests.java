package hello;

import static org.assertj.core.api.BDDAssertions.*;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.web.server.LocalServerPort;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class EurekaServiceApplicationTests {


    @Autowired
    TestRestTemplate testRestTemplate;

    @Test
    public void shouldpass() {
        String entity = this.testRestTemplate.getForEntity(
                "http://localhost:8761" + "/hello", String.class);

        then(entity.getStatusCode()).isEqualTo(HttpStatus.OK);
    }
}
