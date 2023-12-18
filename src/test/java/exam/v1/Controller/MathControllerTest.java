package exam.v1.Controller;

import exam.v1.DTO.DoMathRequestDto;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import java.util.Map;

import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class MathControllerTest {

    @Autowired
    private TestRestTemplate restTemplate;

    @Test
    public void testDoMath_Addition() {
        DoMathRequestDto request = new DoMathRequestDto(2, 3, "+");
        ResponseEntity<Map> responseEntity = restTemplate.postForEntity("/api/math/doMath", request, Map.class);
        assertEquals(HttpStatus.OK, responseEntity.getStatusCode());
        assertEquals(5.0, responseEntity.getBody().get("calcResponse"));
    }

    @Test
    public void testDoMath_Subtraction() {
        DoMathRequestDto request = new DoMathRequestDto(5, 3, "-");
        ResponseEntity<Map> responseEntity = restTemplate.postForEntity("/api/math/doMath", request, Map.class);
        assertEquals(HttpStatus.OK, responseEntity.getStatusCode());
        assertEquals(2.0, responseEntity.getBody().get("calcResponse"));
    }

    @Test
    public void testDoMath_Multiplication() {
        DoMathRequestDto request = new DoMathRequestDto(2, 3, "*");
        ResponseEntity<Map> responseEntity = restTemplate.postForEntity("/api/math/doMath", request, Map.class);
        assertEquals(HttpStatus.OK, responseEntity.getStatusCode());
        assertEquals(6.0, responseEntity.getBody().get("calcResponse"));
    }

    @Test
    public void testDoMath_Division() {
        DoMathRequestDto request = new DoMathRequestDto(6, 3, "/");
        ResponseEntity<Map> responseEntity = restTemplate.postForEntity("/api/math/doMath", request, Map.class);
        assertEquals(HttpStatus.OK, responseEntity.getStatusCode());
        assertEquals(2.0, responseEntity.getBody().get("calcResponse"));
    }

    // Add more tests as needed
}
