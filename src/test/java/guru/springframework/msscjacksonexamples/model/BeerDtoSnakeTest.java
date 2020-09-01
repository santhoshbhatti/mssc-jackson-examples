package guru.springframework.msscjacksonexamples.model;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.json.JsonTest;
import org.springframework.test.context.ActiveProfiles;

@JsonTest
@ActiveProfiles("snake")
public class BeerDtoSnakeTest extends BaseTest{
    @Autowired
    ObjectMapper objectMapper;
    @Test
    public void snakeTest() throws JsonProcessingException {
        String beerString = objectMapper.writeValueAsString(getBeerDto());
        System.out.println(beerString);
    }
}
