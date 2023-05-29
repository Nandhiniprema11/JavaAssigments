package com.dedalus;

class MyFp {
	static int y;
	int z=99;
	public void display()
	{

		System.out.println("Welcome" +y);
	}
}
	
public class Child
{	public static void main(String[] args)
{
	 int x=89;
	 
	System.out.println("Welcome" +x);
	//System.out.println("Welcome" +y);
	MyFp mc=new MyFp();
	mc.display();
	System.out.println("z =" +mc.z);
	//System.out.println("z=" + new Child().z);

	//System.out.println("z =" +new Child());
	//System.out.println("z =" +new Child());
	}}

	

