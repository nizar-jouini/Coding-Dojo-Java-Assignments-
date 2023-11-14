package com.nizar.zookeeper;

public class Mammal {
//	MEMBER VARIABLES
	private int energyLevel = 100;
	
	
//	ZERO ARGS CONSTRUCTOR
	public Mammal() {
		
	}

//	ALL ARGS CONSTRAUCTOR
	public Mammal(int energyLevel) {
		this.energyLevel = energyLevel;
	}
	
	public String displayEnergy() {
		return "The energy level is: " + energyLevel;
	}



//	 Getters & Setters
	public int getEnergyLevel() {
		return energyLevel;
	}

	public void setEnergyLevel(int energyLevel) {
		this.energyLevel = energyLevel;
	}

}
