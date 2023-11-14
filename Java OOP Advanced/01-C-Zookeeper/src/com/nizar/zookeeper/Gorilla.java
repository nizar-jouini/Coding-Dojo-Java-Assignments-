package com.nizar.zookeeper;

public class Gorilla extends Mammal {
	
//	ZERO ARGS CONSTRUCTOR
	public Gorilla() {
		super();
	}
	
	public void throwSomething() {
		System.out.println("the gorilla has thrown something");
		super.setEnergyLevel(getEnergyLevel() - 5);
	}
	
	public void eatBananas() {
		System.out.println("the gorilla is happy");
		super.setEnergyLevel(getEnergyLevel() + 10);
	}
	
	public void climb() {
		System.out.println("the gorilla has climbed a tree");
		super.setEnergyLevel(getEnergyLevel() - 10);
	}
}
