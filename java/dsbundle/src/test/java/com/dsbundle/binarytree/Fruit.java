package com.dsbundle.binarytree;

public class Fruit {
	private String name;
	@KeyProperty
	private Float cost;

	public Fruit(String name, Float cost) {
		this.name = name;
		this.cost = cost;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Float getCost() {
		return cost;
	}

	public void setCost(Float cost) {
		this.cost = cost;
	}

	@Override
	public String toString() {
		return "Friut [name=" + name + ", cost=" + cost + "]";
	}
}
