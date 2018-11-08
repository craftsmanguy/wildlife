package com.ilmani.dream.wildlives.framework.security;

public final class SecurityInformationFacade {

	private static final SecurityInformationFacade INSTANCE = new SecurityInformationFacade();
	private static final ThreadLocal<String> TOKEN_LOCAL_THREAD = new ThreadLocal<String>();
	private static final ThreadLocal<String> LOGIN_LOCAL_THREAD = new ThreadLocal<String>();

	private SecurityInformationFacade() {
	}

	public static SecurityInformationFacade getInstance() {
		return INSTANCE;
	}

	public void setAuthenticationToken(String token) {
		TOKEN_LOCAL_THREAD.set(token);
	}

	public void setAuthenticationLogin(String loginId) {
		LOGIN_LOCAL_THREAD.set(loginId);
	}

	public String getAuthenticationToken() {
		return TOKEN_LOCAL_THREAD.get();
	}

	public String getAuthenticationLogin() {
		return LOGIN_LOCAL_THREAD.get();
	}

	public void clear() {
		TOKEN_LOCAL_THREAD.remove();
	}

}
