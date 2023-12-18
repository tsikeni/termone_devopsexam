package exam.v1.Controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import exam.v1.DTO.DoMathRequestDto;
import exam.v1.Exceptions.InvalidOperationException;
import exam.v1.Payload.ApiResponse;
import exam.v1.ServiceImpl.MathOperatorImpl;

@RestController

@RequestMapping("/api/v1/math")
public class MathController {
    private final MathOperatorImpl mathOperatorImpl;

    public MathController(MathOperatorImpl mathOperatorImpl) {
        this.mathOperatorImpl = mathOperatorImpl;
    }

    @PostMapping
    public ResponseEntity<ApiResponse> create(@RequestBody DoMathRequestDto dto) throws InvalidOperationException {
        return ResponseEntity.ok(ApiResponse.success(mathOperatorImpl.doMath(dto.getOperand1(), dto.getOperand2(), dto.getOperation())));
    }
}

