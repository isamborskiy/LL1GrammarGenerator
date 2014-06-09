package com.samborskiy.elements;

import java.awt.Color;
import java.util.ArrayList;
import java.util.List;

import org.StructureGraphic.v1.DSTreeNode;
import org.StructureGraphic.v1.DSutils;

public abstract class Tree implements DSTreeNode {
	public String node = "";
	public String text = "";
	protected List<Tree> children = new ArrayList<>();

	public void show() {
		DSutils.show(this, 60, 30);
	}

	public int size() {
		return children.size();
	}

	public Tree get(int i) {
		return children.get(i);
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
