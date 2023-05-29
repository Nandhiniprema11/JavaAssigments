package com.dedalus;

abstract class Bird {
	int weight;
	int height=45;
	
	public abstract void eat() ;
	
	Bird(){
		
	}//This abstract class will implement in another classwhenever is required
	public void fly() {
		
	}
}

class Parrot extends Bird {
	public void eat() {
		System.out.println("Parrot999 eating");
	}
}

public class AbstractClass {

	public static void main(String[] args) {
		
		
			Parrot p =new Parrot();
			p.eat();
			
			Bird b = new Parrot();//PArrot overridden method and bird regular method
			b.eat();
	}

}