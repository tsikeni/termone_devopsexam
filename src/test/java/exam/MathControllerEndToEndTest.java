package exam;

import io.restassured.RestAssured;
import jdk.jfr.ContentType;
import org.junit.jupiter.api.Test;

public class MathControllerEndToEndTest {



        private static final String BASE_URL = "http://localhost:8080/api/math/doMath";

        @Test
        public void testDoMath_Addition() {
            RestAssured.given()
                    .contentType(ContentType.JSON)
                    .body("{\"operand1\": 2, \"operand2\": 3, \"operation\": \"+\"}")
                    .when()
                    .post(BASE_URL)
                    .then()
                    .statusCode(200)
                    .body("calcResponse", equalTo(5.0));
        }

        // Add similar tests for subtraction, multiplication, and division


}
