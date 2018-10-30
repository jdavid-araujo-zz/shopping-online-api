package com.david.shoppingcart.api.util.enumeration;

public enum OrderStatus {
	
	   PENDENTE("pendente"),
	   CONCLUIDO("concluido");
	 
	    private String descricao;
	 
	OrderStatus(String descricao) {
	        this.descricao = descricao;
	    }
	 
	    public String getDescricao() {
	        return descricao;
	    }

}
