package org.apink.controller;

import org.apink.domain.NaverLoginToken;
import org.apink.domain.NaverToken;
import org.apink.domain.NaverUser;
import org.apink.service.LoginService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.client.RestTemplate;

import javax.servlet.http.HttpSession;
import java.io.UnsupportedEncodingException;
import java.math.BigInteger;
import java.net.URLEncoder;
import java.security.SecureRandom;

@Controller
public class NaverLoginController {

	private static final String CERTIFICATE_URI = "https://nid.naver.com/oauth2.0/authorize?";
	private static final String TOKEN_URI = "https://nid.naver.com/oauth2.0/token?";
	private static final String USER_INFO_URI = "https://openapi.naver.com/v1/nid/me";

	@Value("${spring.naver.client.id}")
	private String clientId;
	@Value("${spring.naver.client.secret}")
	private String clientSecret;
	@Value("${spring.naver.redirect}")
	private String redirectUri;

	private LoginService loginService;

	@Autowired
	public void setLoginServie(LoginService loginService) {
		this.loginService = loginService;
	}

	@GetMapping(path = "/login")
	public String login(HttpSession session, @RequestParam(required = false) String originPath)
			throws UnsupportedEncodingException {
		System.out.println(originPath);
		originPath="/reservations";
		String apiURL = requestCertification(session, originPath);
		System.out.println("api" + apiURL);
		return "redirect:" + apiURL;
	}

	@GetMapping(path = "/login/callback")
	public String callback(@RequestParam(value = "code", required = false) String code,
						   @RequestParam(value = "state") String state, @RequestParam(value = "originPath") String originPath,
						   HttpSession session) {

		if (session.getAttribute("state").equals(state)) {
			NaverUser naverUser = requestUserInfo(code, state);
			session.setAttribute("user", loginService.LogIn(naverUser));

			System.out.println(originPath);
			return "redirect:" + originPath;
		} else {
			return "redirect:/";
		}
	}

	private String requestCertification(HttpSession session, String originPath) throws UnsupportedEncodingException {
		String encodedOriginPath = URLEncoder.encode(originPath, "UTF-8");
		session.setAttribute("state", getState());
		String apiUrl = CERTIFICATE_URI + "client_id=" + clientId + "&response_type=code" + "&redirect_uri="
				+ URLEncoder.encode(redirectUri + "?originPath=" + encodedOriginPath, "UTF-8") + "&state="
				+ session.getAttribute("state");
		return apiUrl;
	}

	@SuppressWarnings({ "rawtypes", "unchecked" })
	private NaverUser requestUserInfo(String code, String state) {
		RestTemplate restTemplate = new RestTemplate();
		NaverToken naverToken = restTemplate
				.getForObject(
						TOKEN_URI + "client_id=" + clientId + "&client_secret=" + clientSecret
								+ "&grant_type=authorization_code" + "&state=" + state + "&code=" + code,
						NaverToken.class);

		HttpHeaders header = new HttpHeaders();
		header.set("Authorization", naverToken.getTokenType() + " " + naverToken.getAccessToken());
		ResponseEntity<NaverLoginToken> loginToken;
		loginToken = restTemplate.exchange(USER_INFO_URI, HttpMethod.GET, new HttpEntity(header),
				NaverLoginToken.class);

		return loginToken.getBody().getResponse();
	}

	private String getState() {
		SecureRandom random = new SecureRandom();
		return new BigInteger(130, random).toString(32);
	}

}
