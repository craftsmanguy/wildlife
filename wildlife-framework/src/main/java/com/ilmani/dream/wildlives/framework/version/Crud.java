package com.ilmani.dream.wildlives.framework.version;

public enum Crud {
	SAVE("SAVE"), UPDATE("UPDATE"), GET("GET"), FIND("FIND"), DELETE("DELETE");
	
	private String action;
    
	Crud(String action) {
        this.action = action;
    }
    
    public String getAction() {
        return action;
    }

}
