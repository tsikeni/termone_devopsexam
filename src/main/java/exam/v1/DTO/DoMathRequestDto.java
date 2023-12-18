package exam.v1.DTO;

import lombok.AllArgsConstructor;
import lombok.Data;

@Getter
@Setter
@AllArgsConstructor
@Tostring
public class DoMathRequestDto {
    private double operand1;
    private double operand2;
    private String operation;
}
