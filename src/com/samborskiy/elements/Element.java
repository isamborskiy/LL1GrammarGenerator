package com.samborskiy.elements;

public interface Element {

	public String get();
	
	default public boolean isTerm() {
		return this.getClass().equals(Terminal.class);
	}

}
