package guru.springframework.msscjacksonexamples.model;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.json.JsonTest;

import java.io.IOException;

import static org.junit.jupiter.api.Assertions.*;
@JsonTest
class BeerDtoTest extends BaseTest{

    @Autowired
    ObjectMapper objectMapper;

    @Test
    public void serilizeDto() throws JsonProcessingException {
        BeerDto dto=getBeerDto();
        String dtoJson = objectMapper.writeValueAsString(dto);
        System.out.println(dtoJson);
    }

    @Test
    public void deserilizeJson() throws IOException {
        BeerDto beerDto = objectMapper.readValue(
                "{\"beerName\":\"Kingfisher\",\"beerStyle\":\"Lager\"," +
                        "\"upc\":454345322,\"price\":\"10\",\"createdDate\":\"2020-09-01T15:32:52+0530\"," +
                        "\"lastUpdatedDate\":\"2020-09-01T15:32:52.84473+05:30\"," +
                        "\"myLocalDate\":\"20200901\",\"beerId\":\"ab8d16fb-08bc-49a5-b6cb-f5a55e052c9c\"}",BeerDto.class);

        System.out.println(beerDto.toString());

    }

}