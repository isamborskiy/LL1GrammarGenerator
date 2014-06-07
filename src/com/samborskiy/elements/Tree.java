package com.samborskiy.elements;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Tree {
	public String node;
	public List<Tree> children;

	public Tree(String node, Tree... children) {
		this.node = node;
		this.children = Arrays.asList(children);
	}

	public Tree(String node) {
		this.node = node;
		this.children = new ArrayList<>();
	}

	@Override
	public String toString() {
		String ans = node.toLowerCase();
		if (children != null && !children.isEmpty()) {
			ans = "(" + ans;
			for (Tree child : children) {
				ans += " " + child.toString();
			}
			ans += ")";
		}
		return ans;
	}
}
