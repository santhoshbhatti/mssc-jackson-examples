package guru.springframework.msscjacksonexamples.model;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Null;
import javax.validation.constraints.Positive;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.OffsetDateTime;
import java.util.UUID;

/**
 * Created by jt on 2019-04-20.
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class BeerDto {

    /*@JsonProperty annotation overrides the property naming strategy and
    * uses the name specified in the annotation ----so our snake or kebeb case
    * will be ignored
    * As shown below
    * {"beerName":"Kingfisher","beerStyle":"Lager","upc":454345322,"price":10,
    * "createdDate":"2020-09-01T13:27:48.385087+05:30",
    * "lastUpdatedDate":"2020-09-01T13:27:48.385212+05:30","beerId":"3c0b01c2-55b6-476b-860e-a43907cb2c0e"}
    *
    * now deserilize test wont work as the id property is renmed to beerId in the serilized json.
    * but it wont fail...it just does not populate the id in the beer dto object
    * */
    @Null
    @JsonProperty("beerId")
    private UUID id;

    @NotBlank
    private String beerName;

    @NotBlank
    private String beerStyle;

    @Positive
    private Long upc;

    @JsonFormat(shape = JsonFormat.Shape.STRING)
    private BigDecimal price;
    @JsonFormat(pattern = "yyyy-MM-dd'T'HH:mm:ssZ",shape = JsonFormat.Shape.STRING)
    private OffsetDateTime createdDate;
    private OffsetDateTime lastUpdatedDate;

    @JsonSerialize(using = LocalDateSerializer.class)
    @JsonDeserialize(using = LocalDateDeserializer.class)
    private LocalDate myLocalDate;
}
