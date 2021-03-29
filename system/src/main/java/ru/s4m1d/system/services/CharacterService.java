package ru.s4m1d.system.services;

import org.apache.commons.io.IOUtils;
import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.HttpClientBuilder;
import ru.s4m1d.gurps.datamodel.CharacterDTO;
import ru.s4m1d.system.http.HTTPConstants;
import ru.s4m1d.system.json.JsonUtils;

import java.io.IOException;
import java.nio.charset.StandardCharsets;

public class CharacterService {
    public static CharacterDTO getCharacter(int id){
        HttpClient httpClient = HttpClientBuilder.create().build();
        HttpResponse httpResponse = null;
        CharacterDTO characterDTO = null;
        try {
            httpResponse = httpClient.execute(new HttpGet(HTTPConstants.BH_HOST+HTTPConstants.GET_CHARACTER+"?id="+id));
            String strCharacter = IOUtils.toString(httpResponse.getEntity().getContent(),StandardCharsets.UTF_8);
            characterDTO = (CharacterDTO) JsonUtils.getObjectFromJson(strCharacter,CharacterDTO.class);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return characterDTO;
    }
}
