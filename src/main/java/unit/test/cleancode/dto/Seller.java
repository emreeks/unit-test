package unit.test.cleancode.dto;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class Seller {

    private Long id;
    private String name;
    private String email;

}
