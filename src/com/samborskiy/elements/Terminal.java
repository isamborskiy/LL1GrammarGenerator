package com.samborskiy.elements;

public class Terminal implements Element {

	public static final Terminal EPS = new Terminal("EPS");
	public static final Terminal END = new Terminal("$");
	public static final Terminal NUM = new Terminal("n");

	private String value;

	public Terminal(String value) {
		this.value = value;
	}

	@Override
	public String get() {
		return value;
	}

	@Override
	public String toString() {
		return value.equals(EPS) ? "" : value;
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
		Terminal other = (Terminal) obj;
		if (value == null) {
			if (other.value != null)
				return false;
		} else if (!value.equals(other.value))
			return false;
		return true;
	}

}
