package com.dedalus;

class Toadd {
	static int X = 300;
	static int Y = 200; 
	int Z;
	int A;
	
	public void Add()
	{
		Z=X+Y;
		System.out.println("Addition =" +Z);	
    }
	
	public void Sub()
	{
		A=X-Y;
		System.out.println("Subtraction =" +A);	
	}
}

public class Protadd 
{
	public static void main(String[] args)
		{
		Toadd TA= new Toadd();
	    TA.Add();
	    TA.Sub();
	}
}
