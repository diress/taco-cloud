package sia.tacocloud.domain;

import lombok.Data;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.util.List;

/**
 * Created by bvasilenko on 01.02.2019.
 */
@Data
public class Taco {
    @NotNull
    @Size(min=5, message="Name must be at least 5 characters long")
    private String name;

    private @Size(min=1, message="You must choose at least 1 ingredient")
    List<String> ingredients;
}
