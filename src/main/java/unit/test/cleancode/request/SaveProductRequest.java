package unit.test.cleancode.request;

import lombok.Builder;
import lombok.Data;
import unit.test.cleancode.dto.Product;

@Builder
@Data
public class SaveProductRequest {

    private Product product;

}
