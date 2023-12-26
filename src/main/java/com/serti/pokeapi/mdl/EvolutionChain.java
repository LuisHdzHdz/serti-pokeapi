package com.serti.pokeapi.mdl;

public class EvolutionChain {
	
	private int id;
	private String baby_trigger_item;
	private Chain chain;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getBaby_trigger_item() {
		return baby_trigger_item;
	}
	public void setBaby_trigger_item(String baby_trigger_item) {
		this.baby_trigger_item = baby_trigger_item;
	}
	public Chain getChain() {
		return chain;
	}
	public void setChain(Chain chain) {
		this.chain = chain;
	}
	
	@Override
	public String toString() {
		return "EvolutionChain [id=" + id + ", baby_trigger_item=" + baby_trigger_item + ", chain=" + chain + "]";
	}	
}
