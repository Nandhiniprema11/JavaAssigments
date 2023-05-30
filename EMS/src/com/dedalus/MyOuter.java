package com.dedalus;

class MyOuter
{
	int x =7;
	class MyInner
	{
		public void InnerMethod()
		{
			System.out.println("x == " + x);
		}
	}
	public void OuterMethod()
	{
		System.out.println("From outer method = " + x);
		MyInner inn = new MyInner();
		inn.InnerMethod();
	}
	public static void main(String[] a)
	{
	MyOuter mo = new MyOuter();
	//MyInner inn = new MyInner(); //invalid
	//inn.InnerMethod();
	//<outerclassname>.<innerclassname> objname = <outerclass instancename>.new <innerclassname>();
	
	MyOuter.MyInner mi = mo.new MyInner(); //instantiate inner class
	mi.InnerMethod();
	mo.OuterMethod();
	//mi.OuterMethod();  illegal
	//mo.InnerMethod();   illegal 
	
	//MyInner.MyOuter mm= mi1 new MyOuter();//invalid
		
	}

}

// Check whether the inner class can be abstract--> No
// can it be inherited-->Yes, inner classes in Java can be inherited by subclasses
// scope of instance variable within the inner class 
// scope of local variable within the inner class In the InnerClass, we can directly access both the outerVariable and the innerVariable because it is a regular inner class.

//In the StaticNestedClass, we need to pass an instance of the outer class explicitly to access the outerVariable because it is a static nested class.

//In the main method, we create an instance of the outer class and access the inner class and static nested class, demonstrating how the instance variables are accessed in each case.
