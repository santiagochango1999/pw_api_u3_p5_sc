package com.example.demo.security;

import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import io.jsonwebtoken.Jwts;

@Component
public class JwtUtils {
	private static final org.slf4j.Logger LOG = LoggerFactory.getLogger(JwtUtils.class);

	public boolean validateJwt(String authToken) {
		try {
			Jwts.parser().setSigningKey("MIGeMA0GCSqGSIb3DQEBAQUAA4GMADCBiAKBgFwZL3qE6ppMKtBtyRFuTQObdXN1hIa2XWKclNd5tzbEWL55GuJJYRx6pQcuZh/c2p+NNZr1ueorfpKdWc3nMK78VFwbhrXopJHSveh2yZ2nL8AuqJ6vzq0hP9M7VZP4Rc33fBw8BRMFxbWAfUJRgjJT/R0rZISaIjVMGj6hadlAgMBAAE=").parseClaimsJws(authToken);
			return true;
		} catch (Exception e) {
			// TODO: handle exception
			LOG.error("ERRRRRRRRRRORRRR	", e);
		}
		return false;

	}
	
	public String getUserNameFromjwtToken(String token) {
		return Jwts.parser().setSigningKey("MIGeMA0GCSqGSIb3DQEBAQUAA4GMADCBiAKBgFwZL3qE6ppMKtBtyRFuTQObdXN1hIa2XWKclNd5tzbEWL55GuJJYRx6pQcuZh/c2p+NNZr1ueorfpKdWc3nMK78VFwbhrXopJHSveh2yZ2nL8AuqJ6vzq0hP9M7VZP4Rc33fBw8BRMFxbWAfUJRgjJT/R0rZISaIjVMGj6hadlAgMBAAE=").parseClaimsJws(token).getBody().getSubject();
	}
}
