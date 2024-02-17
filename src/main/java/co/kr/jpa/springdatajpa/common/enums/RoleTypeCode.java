package co.kr.jpa.springdatajpa.common.enums;


import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum RoleTypeCode {
    MANAGER,
    USER,
    GUEST;
}
