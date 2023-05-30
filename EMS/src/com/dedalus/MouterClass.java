package com.dedalus;

class MouterClass//Outer class-->Outer method--> Minner Class---> Minner Method

{
	int x =10;
	public void OuterMethod()
	{
		int j=90;
		class MinnerClass
		{
			int z=10;
			
			public void minnerMethod()
			{
			System.out.println("Hello ..." + x + j);
			}
			
			/*public void display()
			{
				System.out.println("Innerclass" + z);
			}*/
		}
		MinnerClass mic = new MinnerClass();
		mic.minnerMethod();		
		
	}	
	public static void main(String[] a)
	{
		
	MouterClass moc = new MouterClass();
	moc.OuterMethod();
		
	//	MinnerClass mic = new MinnerClass();Ilegal
	//	mic.minnerMethod();
		
	// MouterClass moc1 =new MinnerClass();Ilegal
		
	// MinnerClass mic1 =new MouterClass();Ilegal		
		
	//MouterClass moc1 = new MouterClass();Ilegal		
	//moc1.minnerMethod(); No need to call it specifically when outer method is called automatically inner method will be called.
	
	}
}


//Create instance and local variable inside the inner class and access
// Can the method local inner class be abstract?

//No, a method-local inner class cannot be declared as abstract in Java. 
//The abstract keyword is used to define abstract classes or methods, which are meant to be extended or overridden by subclasses. 
