package com.samborskiy.elements;

public class Nonterminal implements Element {

	private String value;
	private String inherAtt = "";
	private String synthAtt = "";

	public Nonterminal(String value) {
		this.value = value;
	}

	@Override
	public String get() {
		return value;
	}

	@Override
	public String toString() {
		return value;
	}

	public void setInher(String att) {
		inherAtt = att;
	}

	public String getInher() {
		return inherAtt;
	}

	public void setSynth(String att) {
		synthAtt = att;
	}

	public String getSynth() {
		return synthAtt;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((value == null) ? 0 : value.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Nonterminal other = (Nonterminal) obj;
		if (value == null) {
			if (other.value != null)
				return false;
		} else if (!value.equals(other.value))
			return false;
		return true;
	}

}
