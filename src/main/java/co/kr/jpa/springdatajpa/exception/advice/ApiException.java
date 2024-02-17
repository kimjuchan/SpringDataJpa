package co.kr.jpa.springdatajpa.exception.advice;
import co.kr.jpa.springdatajpa.common.enums.ApiErrorCode;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Date;

@Getter
@AllArgsConstructor
@NoArgsConstructor
public class ApiException {
    //Excepion 발생 time
    private Date apiExceptionDate;
    private ApiErrorCode apiErrorCode;
    private String apiMessage;
}
