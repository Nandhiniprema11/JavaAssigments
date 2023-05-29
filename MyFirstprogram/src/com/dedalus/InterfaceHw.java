package com.dedalus;

//First interface
interface Drawable {
 void draw();
}

//Second interface extending the first interface
interface Colorable extends Drawable {
 void setColor(String color);
}

//Class implementing the Colorable interface
class Circle implements Colorable {
 private String color;

 @Override
 public void draw() {
     System.out.println("Drawing a circle");
 }

 @Override
 public void setColor(String color) {
     this.color = color;
     System.out.println("Setting circle color to " + color);
 }
}

//Main class
public class InterfaceHw {
 public static void main(String[] args) {
     Circle circle = new Circle();
     circle.draw();
     circle.setColor("Red");
 }
}
