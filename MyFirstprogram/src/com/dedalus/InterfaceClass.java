package com.dedalus;

interface Birdd {
	// int weight;
	int height = 45; // public static final

	public void eat(); // public abstract//By default all the interface will be abstract

}

class Parrott implements Birdd {
	public void eat() {
		System.out.println("Parrot111 eating");
	}
}

 class Lion  implements Birdd{
	 public void eat() {
			System.out.println("Parrot3333 eating");
		}
	
}

public class InterfaceClass {

	public static void main(String[] args) {

		Parrot p = new Parrot();
		p.eat();

		Birdd b = new Parrott();
		b.eat();
	}

}