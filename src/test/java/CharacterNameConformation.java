import Model.Characters;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.List;

public class CharacterNameConformation extends  Base {
    private String res = base();
    private TotalNumberofCharacter t = new TotalNumberofCharacter();
    private List<String> names = new ArrayList<>();
    private List<Integer> heights = new ArrayList<>();
    private List<Characters> c = new ArrayList<>();

    @Test
    public void nameTest(){
        t.totalPeople();
        c = t.getC();
        for(int i=0; i<c.size(); ++i){
            int height = c.get(i).getHeight();
            String name = c.get(i).getName();
            if(height> 200){
                heights.add(height);
                names.add(name);
            }
        }
        Assert.assertEquals(names.get(0), "Darth Vader");
        Assert.assertEquals(names.get(1), "Chewbacca");
        Assert.assertEquals(names.get(2), "Roos Tarpals");
        Assert.assertEquals(names.get(3), "Rugor Nass");
        Assert.assertEquals(names.get(4), "Yarael Poof");
        Assert.assertEquals(names.get(5), "Lama Su");
        Assert.assertEquals(names.get(6), "Taun We");
        Assert.assertEquals(names.get(7), "Grievous");
        Assert.assertEquals(names.get(8), "Tarfful");
        Assert.assertEquals(names.get(9), "Tion Medon");
    }
}
