package com.samborskiy.elements;

public class Rule {

	private Element[] to;

	public Rule(Element... to) {
		assert (to.length > 0);
		this.to = to;
	}

	public Element getTo(int index) {
		return to[index];
	}

	public int size() {
		return to.length;
	}

	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();
		for (Element elem : to) {
			sb.append(" " + elem.get());
		}
		return sb.toString();
	}

}
