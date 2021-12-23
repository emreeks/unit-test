package unit.test.cleancode.response;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class SaveProductResponse {

    private Boolean success;
    private String errorMessage;

}
