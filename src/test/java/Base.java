import io.restassured.RestAssured;
import static io.restassured.RestAssured.given;
public class Base {
    public static String base(){
        RestAssured.baseURI = "https://swapi.dev/api";
        String res = given().log().all().get("/people").then().log().all().assertThat().statusCode(200).extract()
                .response().asString();
        return res;
    }
}
