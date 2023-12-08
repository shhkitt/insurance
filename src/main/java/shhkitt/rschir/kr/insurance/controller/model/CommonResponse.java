package shhkitt.rschir.kr.insurance.controller.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CommonResponse {
    String code;
    String message;

    public CommonResponse(String code){
        this.code = code;
        message = null;
    }
}
