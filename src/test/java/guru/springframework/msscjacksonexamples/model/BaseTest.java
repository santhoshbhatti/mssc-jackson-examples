package guru.springframework.msscjacksonexamples.model;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.OffsetDateTime;
import java.util.UUID;

public class BaseTest {
    public BeerDto getBeerDto(){
        BeerDto beerDto=BeerDto
                .builder()
                .id(UUID.randomUUID())
                .beerName("Kingfisher")
                .beerStyle("Lager")
                .createdDate(OffsetDateTime.now())
                .lastUpdatedDate(OffsetDateTime.now())
                .price(new BigDecimal(10.0))
                .myLocalDate(LocalDate.now())
                .upc(454345322L)
                .build();
        return beerDto;
    }
}
