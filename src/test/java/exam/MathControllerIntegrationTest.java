package exam;


import exam.v1.DTO.DoMathRequestDto;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit4.SpringRunner;
import static org.junit.Assert.assertEquals;


import java.util.Map;

@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class MathControllerIntegrationTest {




        @Autowired
        private TestRestTemplate restTemplate;

        @Test
        public void testDoMath_Addition() {
            DoMathRequestDto request = new DoMathRequestDto(2, 3, "+");
            ResponseEntity<Map> responseEntity = restTemplate.postForEntity("/api/math/doMath", request, Map.class);
            assertEquals(HttpStatus.OK, responseEntity.getStatusCode());
            assertEquals(5.0, responseEntity.getBody().get("calcResponse"));
        }

        // Add similar tests for subtraction, multiplication, and division
    }


