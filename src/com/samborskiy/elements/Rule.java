package com.samborskiy.elements;

public class Rule {

	private Element[] to;
	private String transSym = "";

	public Rule(Element... to) {
		assert (to.length > 0);
		this.to = to;
	}

	public Element get(int index) {
		return to[index];
	}

	public int size() {
		return to.length;
	}
	
	public void setTrans(String sym) {
		transSym = sym;
	}

	public String getTrans() {
		return transSym;
	}

	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();
		for (Element elem : to) {
			sb.append(" " + elem.get());
		}
		return sb.toString().substring(1);
	}

}
