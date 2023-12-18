package exam;


import exam.v1.DTO.DoMathRequestDto;
import io.restassured.http.ContentType;
import org.junit.jupiter.api.Test;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;

public class MathControllerEndToEndTest {

    @Test
    public void testDoMath_Addition() {
        DoMathRequestDto request = new DoMathRequestDto(2, 3, "+");

        given()
                .contentType(ContentType.JSON)
                .body(request)
                .when()
                .post("http://localhost:8080/api/math/doMath")
                .then()
                .statusCode(200)
                .body("calcResponse", equalTo(5.0));
    }

    @Test
    public void testDoMath_Subtraction() {
        DoMathRequestDto request = new DoMathRequestDto(5, 3, "-");

        given()
                .contentType(ContentType.JSON)
                .body(request)
                .when()
                .post("http://localhost:8080/api/math/doMath")
                .then()
                .statusCode(200)
                .body("calcResponse", equalTo(2.0));
    }

    @Test
    public void testDoMath_Multiplication() {
        DoMathRequestDto request = new DoMathRequestDto(2, 3, "*");

        given()
                .contentType(ContentType.JSON)
                .body(request)
                .when()
                .post("http://localhost:8080/api/math/doMath")
                .then()
                .statusCode(200)
                .body("calcResponse", equalTo(6.0));
    }

    @Test
    public void testDoMath_Division() {
        DoMathRequestDto request = new DoMathRequestDto(6, 3, "/");

        given()
                .contentType(ContentType.JSON)
                .body(request)
                .when()
                .post("http://localhost:8080/api/math/doMath")
                .then()
                .statusCode(200)
                .body("calcResponse", equalTo(2.0));
    }
}
