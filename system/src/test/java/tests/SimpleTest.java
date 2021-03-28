package tests;

import com.fasterxml.jackson.core.JsonProcessingException;
import org.testng.annotations.Test;
import ru.s4m1d.gurps.datamodel.CharacterDTO;
import ru.s4m1d.sys.json.JsonUtils;

public class SimpleTest {
    //@Test
    public void test1() throws JsonProcessingException {
        System.out.println();
    }
    //@Test
    public void test2() throws JsonProcessingException {
        String json = JsonUtils.getJsonFromObject(
                new CharacterDTO("","","",1,1,1,1)
        );
        CharacterDTO charDto = (CharacterDTO) JsonUtils.getObjectFromJson(json,CharacterDTO.class);
        System.out.println(JsonUtils.getJsonFromObject(charDto));
    }
}
