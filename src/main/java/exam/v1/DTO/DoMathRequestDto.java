package exam.v1.DTO;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;


@Getter
@Setter
@AllArgsConstructor
@ToString
public class DoMathRequestDto {
    private double operand1;
    private double operand2;
    private String operation;
}
