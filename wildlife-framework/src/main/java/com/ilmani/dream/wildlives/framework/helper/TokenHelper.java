package com.ilmani.dream.wildlives.framework.helper;

import java.security.Key;
import java.security.NoSuchAlgorithmException;
import java.util.Date;

import javax.crypto.KeyGenerator;
import javax.crypto.spec.SecretKeySpec;
import javax.ws.rs.container.ContainerRequestContext;
import javax.ws.rs.core.HttpHeaders;
import javax.xml.bind.DatatypeConverter;

import com.ilmani.dream.wildlives.framework.dto.auth.AuthentifyPersonDto;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.JwtBuilder;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;

public class TokenHelper {

	public static String createJwtTokenWithAESAlogirthm(AuthentifyPersonDto person, long ttlMillis, String privateKey)
			throws NoSuchAlgorithmException {

		KeyGenerator keyGen = KeyGenerator.getInstance("AES");
		keyGen.init(128);
		// Key key = keyGen.generateKey();

		byte[] apiKeySecretBytes = DatatypeConverter.parseBase64Binary(privateKey);
		Key signingKey = new SecretKeySpec(apiKeySecretBytes, SignatureAlgorithm.HS512.getJcaName());

		long nowMillis = System.currentTimeMillis();
		Date now = new Date(nowMillis);

		JwtBuilder builder = Jwts.builder().setId(person.getId()).setSubject(person.getUsername())
				.setIssuer(person.getIssuer()).setIssuedAt(now).signWith(SignatureAlgorithm.HS512, signingKey);

		if (ttlMillis >= 0) {
			long expMillis = nowMillis + ttlMillis;
			Date exp = new Date(expMillis);
			builder.setExpiration(exp);
		}
		return builder.compact();
	}

	public static String extractToken(ContainerRequestContext requestContext) {
		String jwtToken = null;
		String tokenWithBearer = requestContext.getHeaders().getFirst(HttpHeaders.AUTHORIZATION);
		if (tokenWithBearer != null) {
			jwtToken = tokenWithBearer.replaceFirst("[B|b]earer ", "");
		}
		return jwtToken;
	}

	public static String parseJWT(String jwtToken, String secretKey) {
		Claims claims = Jwts.parser().setSigningKey(DatatypeConverter.parseBase64Binary(secretKey)).parseClaimsJws(jwtToken)
				.getBody();
		System.out.println("ID: " + claims.getId());
		System.out.println("Subject: " + claims.getSubject());
		System.out.println("Issuer: " + claims.getIssuer());
		System.out.println("Expiration: " + claims.getExpiration());
		return claims.getSubject();

	}

}
