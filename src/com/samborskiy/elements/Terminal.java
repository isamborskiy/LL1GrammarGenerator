package com.samborskiy.elements;

public class Terminal implements Element {

	public static final Terminal EPS = new Terminal("EPS", "", false);
	public static final Terminal EOF = new Terminal("EOF", "$", false);

	private String name;
	private String matchValue;
	private boolean isConst;

	public Terminal(String name, String matchValue, boolean isConst) {
		this.name = name;
		this.matchValue = matchValue;
		this.isConst = isConst;
	}

	@Override
	public String get() {
		return name;
	}

	public String match() {
		return matchValue;
	}

	public boolean isConst() {
		return isConst;
	}

	@Override
	public String toString() {
		return name;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((name == null) ? 0 : name.hashCode());
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
		Terminal other = (Terminal) obj;
		if (name == null) {
			if (other.name != null)
				return false;
		} else if (!name.equals(other.name))
			return false;
		return true;
	}

}
