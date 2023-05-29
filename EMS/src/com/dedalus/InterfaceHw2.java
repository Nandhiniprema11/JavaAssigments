package com.dedalus;

interface Animal {
	Void Feed();
}

interface Excercise extends Animal{
	void setExcer(String Excer);
}

class Walk implements Excercise
{
	private String excer;
	 public void feed() {
	     System.out.println("Feeding the Animal");
	 } 
	 public void setExcer(String excer) {
	     this.excer = excer;
	     System.out.println("Animal is " + excer);

}
}


public interface InterfaceHw2 {
	 public static void main(String[] args) {
		 Walk wl = new Walk();
		 wl.feed();
		 wl.setExcer("Walking");
}
}
