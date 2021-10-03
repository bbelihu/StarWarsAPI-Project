import Model.Characters;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.List;

public class CharacterHeight extends Base {
    private String res = base();
    private TotalNumberofCharacter t = new TotalNumberofCharacter();
    private List<Integer> char_height = new ArrayList<>();
    private List<Characters> c = new ArrayList<>();



    @Test
    public void heightTest(){
        t.totalPeople();
        c = t.getC();
        for(int i=0; i<c.size(); ++i){
            int height = c.get(i).getHeight();
            if(height> 200){
                char_height.add(height);
            }
        }
       int acutal= char_height.size();
       int expected = 10;
       Assert.assertEquals(acutal,expected);
    }
}
