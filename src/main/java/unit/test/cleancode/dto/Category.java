package unit.test.cleancode.dto;

import lombok.Builder;
import lombok.Data;

import java.math.BigDecimal;

@Data
@Builder
public class Category {

    private Long id;
    private String name;
    private BigDecimal commission;

}
