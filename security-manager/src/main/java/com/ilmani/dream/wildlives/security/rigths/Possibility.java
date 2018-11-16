package com.ilmani.dream.wildlives.security.rigths;

import com.ilmani.dream.wildlives.framework.exceptions.AuthenticationException;

public interface Possibility {
	
	public String checkUserRightsForAction(String ressource, String id) throws AuthenticationException;

}
