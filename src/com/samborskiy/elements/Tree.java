package com.samborskiy.elements;

import java.awt.Color;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.StructureGraphic.v1.DSTreeNode;
import org.StructureGraphic.v1.DSutils;

public class Tree implements DSTreeNode {
	private String node = "";
	private String text = "";
	private List<Tree> children;

	public Tree(String node, String text, Tree... children) {
		this.node = node;
		this.text = text;
		this.children = Arrays.asList(children);
	}

	public Tree(String node, String text) {
		this.node = node;
		this.text = text;
		this.children = new ArrayList<>();
	}

	public void show() {
		DSutils.show(this, 60, 30);
	}

	public int size() {
		return children.size();
	}

	public Tree get(int i) {
		return children.get(i);
	}

	public String getText() {
		return text;
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

	@Override
	public DSTreeNode[] DSgetChildren() {
		return (DSTreeNode[]) children.toArray(new DSTreeNode[children.size()]);
	}

	@Override
	public Color DSgetColor() {
		return Color.black;
	}

	@Override
	public Object DSgetValue() {
		return node + (text.isEmpty() ? "" : " [" + text + "]");
	}
}
