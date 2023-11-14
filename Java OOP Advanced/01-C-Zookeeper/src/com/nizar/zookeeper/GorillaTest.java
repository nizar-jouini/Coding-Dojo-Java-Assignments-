package com.nizar.zookeeper;

public class GorillaTest {

	public static void main(String[] args) {
		
		Gorilla g = new Gorilla();
		
		g.throwSomething();
		g.throwSomething();
		g.throwSomething();
		
		g.eatBananas();
		g.eatBananas();
		
		g.climb();
		
		System.out.println(g.displayEnergy());
	}

}
