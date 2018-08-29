package com.dsbundle.binarytree;

import com.dsbundle.annotations.KeyProperty;

public class Fruit implements Comparable<Fruit> {
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

	@Override
	public int compareTo(final Fruit o) {
		return cost.compareTo(o.getCost());
	}
}
