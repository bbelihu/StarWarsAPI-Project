import io.restassured.RestAssured;
import static io.restassured.RestAssured.*;
import org.apache.log4j.Logger;
import org.testng.annotations.Test;

public class EndPoint {
    private static Logger logger;
    @Test
    public String verifyEndpoint(){
        //Instantiate logger
        logger= Logger.getLogger(EndPoint.class);
        //The uri we need.
       RestAssured.baseURI = "https://swapi.dev/api";


       //Get the response and check if the status is 200.
        String res = given().log().all().get("/people")
                .then().log().all().assertThat()
                .statusCode(200)
                .extract().response().asString();

        logger.info(res);
        return res;



    }
}
