package br.com.aprendendo.quarkus;

import br.com.aprendendo.quarkus.domain.Student;
import io.quarkus.test.common.QuarkusTestResource;
import io.quarkus.test.h2.H2DatabaseTestResource;
import io.quarkus.test.junit.QuarkusTest;
import org.junit.jupiter.api.Test;

import javax.ws.rs.core.MediaType;
import java.util.UUID;

import static io.restassured.RestAssured.given;
import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.CoreMatchers.hasItems;

@QuarkusTest
@QuarkusTestResource(H2DatabaseTestResource.class)
public class StudentResourceTest {


    @Test
    public void createStudentEndpoint() {
        given()
         .contentType(MediaType.APPLICATION_JSON)
         .accept(MediaType.APPLICATION_JSON)
         .body(new Student("Jose","Marques"))
        .when()
         .post("/students")
        .then()

         .statusCode(201);
    }


    @Test
    public void findIdNotFoundEndpoint() {
        given().pathParam("id", UUID.randomUUID().toString())
          .when().get("/students/{id}")
          .then()
             .statusCode(404)
             .contentType(MediaType.APPLICATION_JSON);
    }

    @Test
    public void findIdEndpoint() {
        given().pathParam("id", "80834524-5421-3175-1974-365373936008")
                .when()
                    .get("/students/{id}")
                .then()
                    .statusCode(200)
                    .body("name",is("Anpyu"))
                    .body("lastName",is("Zucya"))
                    .contentType(MediaType.APPLICATION_JSON);
    }

    @Test
    public void findAllEndpoint() {
       given()
               .contentType(MediaType.APPLICATION_JSON).accept(MediaType.APPLICATION_JSON)
       .when()
               .get("/students/")
       .then()
               .statusCode(200)
               .body("name", hasItems("Anpyu","Turun","Numoa","Oldoe"))
               .body("size()", is(4));

    }

}