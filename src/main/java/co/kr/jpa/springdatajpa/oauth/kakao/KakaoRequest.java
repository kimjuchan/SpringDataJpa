package co.kr.jpa.springdatajpa.oauth.kakao;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class KakaoRequest {
    String grant_type;
    String client_id;
    String redirect_uri;
    String code;
}
