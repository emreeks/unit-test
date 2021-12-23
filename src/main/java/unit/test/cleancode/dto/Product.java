package unit.test.cleancode.dto;

import lombok.Builder;
import lombok.Data;

import java.math.BigDecimal;

@Data
@Builder
public class Product {

    private String title;
    private BigDecimal price;
    private Integer stock;
    private String description;
    private Long categoryId;
    private Long sellerId;

}
