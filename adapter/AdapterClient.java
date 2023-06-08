package adapter;

interface Bird {
	public void makeSound();//It defines the common interface for birds and declares the makeSound() method.
}

class Duck implements Bird {

	@Override
	public void makeSound() {
		System.out.println("Duck says quack quack");// It is a concrete implementation of the Bird interface. 
		//It implements the makeSound() method and prints "Duck says quack quack" when invoked.
	}
}

class BirdAdapter implements Bird {//It implements the Bird interface and acts as an adapter for the WhiteDuck class. 
	//The adapter wraps an instance of WhiteDuck 
	//and delegates the makeSound() method to the squeak() method of WhiteDuck.

	private WhiteDuck whiteDuck;

	public BirdAdapter(WhiteDuck duck) {
		this.whiteDuck =duck;
	}

	@Override
	public void makeSound() {
		this.whiteDuck.squeak();
	}

}

//Adaptee//It represents an Adaptee, which is the class that needs to be adapted. It has a squeak() method that prints "Squeaking".
class WhiteDuck {
	public void squeak() {
		System.out.println("Squeaking");
	}
}

//Client
public class AdapterClient {//It serves as the client code that demonstrates the usage of the Adapter pattern. 
	//It creates a Duck object and calls its makeSound() method. Then, it creates a BirdAdapter object, passing a WhiteDuck instance, and calls its makeSound() method.

	public static void main(String[] args) {
		Bird duck = new Duck();
		duck.makeSound();

		Bird toyBird = new BirdAdapter(new WhiteDuck());//New functionality introuduced in a adapter class Same function but different input and output
		toyBird.makeSound();
		
		//By using the BirdAdapter class, we can make the WhiteDuck class compatible with the Bird interface, allowing it to be used as a Bird object. This demonstrates the Adapter pattern, which enables objects with different interfaces to work together.
	}

}
