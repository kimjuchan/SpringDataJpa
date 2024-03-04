package co.kr.jpa.springdatajpa.oauth.kakao;

import lombok.extern.slf4j.Slf4j;
import org.springframework.http.*;

import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

/**
 * 참조 : https://daramgda.tistory.com/80
 *
 *
 */
@RestController
@RequestMapping("/kakao")
@Slf4j
public class KakaoCallbackController {


    @GetMapping("/callback")
    public String kakaoCallback(@RequestParam("code") String code){

        //KAKAO Access Token  발급 요청 관련해서는 RestTemplate 사용해봄.(저번에 openAPI 가져올때 webClient 사용)
        RestTemplate rt = new RestTemplate();

        //HttpEntity( body , header) kakao에 전송할 데이터 설정.
        HttpHeaders headers = new HttpHeaders();
        headers.add("Content-Type", "application/x-www-form-urlencoded;charset=utf-8");

        MultiValueMap<String, String> params = new LinkedMultiValueMap<>();
        params.add("grant_type", "authorization_code");
        params.add("client_id", "b418d212d1b2366a51e45acf822cc401");
        params.add("redirect_uri", "http://localhost:8080/kakao/callback");
        params.add("code", code);

        HttpEntity<MultiValueMap<String, String>> kakaoTokenRequest = new HttpEntity<>(params, headers);

        // POST 방식으로 Http 요청한다. 그리고 response 변수의 응답 받는다.
        KakaoToken response = rt.exchange(
                "https://kauth.kakao.com/oauth/token", // https://{요청할 서버 주소}
                HttpMethod.POST, // 요청할 방식
                kakaoTokenRequest, // 요청할 때 보낼 데이터
                KakaoToken.class // 요청 시 반환되는 데이터 타입
        ).getBody();


        log.info("Access Token : " + response.getAccess_token());
        log.info("Access Token expired in : " + response.getExpires_in());
        log.info("Refresh Token : " +  response.getRefresh_token());
        log.info("Refresh Token : " + response.getRefresh_token_expires_in());
        log.info("Token Type : " + response.getToken_type());

        //사용자 정보 받기.
        //https://kapi.kakao.com/v2/user/me

        //HttpEntity( body , header) kakao에 전송할 데이터 설정.
        HttpHeaders headers_userInfo = new HttpHeaders();
        MultiValueMap<String, String> params2 = new LinkedMultiValueMap<>();
        //헤더값 application/json 설정 시 401 오류 발생.
        headers_userInfo.add("Content-Type", "application/x-www-form-urlencoded;charset=utf-8");
        headers_userInfo.add("Authorization", "Bearer " + response.getAccess_token());

        HttpEntity<MultiValueMap<String, String>> kakaoUserInfoRequest = new HttpEntity<>(params2,headers_userInfo);

        ResponseEntity<String> response2= rt.exchange(
                "https://kauth.kakao.com/oauth/token", // https://{요청할 서버 주소}
                HttpMethod.POST, // 요청할 방식
                kakaoUserInfoRequest, // 요청할 때 보낼 데이터
                String.class // 요청 시 반환되는 데이터 타입
        );

        return "카카오 토큰 요청 완료";
    }


}
