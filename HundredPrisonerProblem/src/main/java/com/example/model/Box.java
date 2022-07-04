package com.example.model;

public class Box {

	private int label;
	private int value;

	public void setLabel(int label) {
		this.label = label;
	}

	public int getValue() {
		return value;
	}

	public Box(int label) {
		super();
		this.label = label;
	}

	public void setValue(int value) {
		this.value = value;
	}

	public int getLabel() {
		return label;
	}

}
