package com.nizar.zookeeper;

public class Bat extends Mammal {
	
	public Bat() {
		super(300);
	}
	
	public void fly() {
		System.out.println("sound of a bat taking off");
		super.setEnergyLevel(getEnergyLevel() - 50);
	}
	
	public void eatHumans(int numHuman) {
		System.out.println("so- well, never mind,");
		super.setEnergyLevel(getEnergyLevel() + (25 * numHuman));
	}
	
	public void attackTown() {
		System.out.println("sound of a town on fire");
		super.setEnergyLevel(getEnergyLevel() - 100);
	}
}
