import Model.Characters;
import ReusableClass.Reusable;
import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;
import org.testng.Assert;
import org.testng.annotations.Test;
import static io.restassured.RestAssured.given;

import java.util.ArrayList;
import java.util.List;

public class TotalNumberofCharacter extends Base {

    private String res = base();
    private String next = null;
    private List<Characters> c= new ArrayList<>();

    @Test
    public void totalPeople() {
        JsonPath js = Reusable.rawToJson(res);// For parsing the json file responded.
        int peopleCount = js.getInt("count");
        for (int i = 1; i <= peopleCount + 1; ++i) {
            if (i == 17) {
                i++;
            }
            String responseStr = given().log().all().get("/people/"+i)
                    .then().log().all().assertThat()
                    .statusCode(200)
                    .extract().response().asString();

            js = Reusable.rawToJson(responseStr);
            String name = js.getString("name");
            int height = 0;
            try {
                height = js.getInt("height");
            }catch(NumberFormatException e){
                //If height is not a valid number just continue to the next loop
                continue;
            }
            Characters ch = new Characters(name, height);
            c.add(ch);

        }
        //Use an Assertion statement to verify the number of characters is 81 +1 since we skipped over number 17.
        int expected_count =82;
        int characters_size = c.size()+1;
        Assert.assertEquals(characters_size, expected_count);

    }


    public List<Characters> getC() {
        return new ArrayList<>(c);
    }
}
