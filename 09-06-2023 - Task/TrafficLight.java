package DesignPattern;

public class TrafficLight {
    private enum LightColor {
        RED,
        YELLOW,
        GREEN
    }
    
    private LightColor currentColor;
    
    public TrafficLight() {//TrafficLight class also has a default constructor that initializes the currentColor to RED, 
        currentColor = LightColor.RED;
    }
    
    public void changeColor() {//The changeColor() method is responsible for changing the color of the traffic light. It uses a switch statement to check the current color and
    	//transitions to the next color based on the current color.
        switch (currentColor) {
            case RED:
                currentColor = LightColor.GREEN;
                break;
            case YELLOW:
                currentColor = LightColor.RED;
                break;
            case GREEN:
                currentColor = LightColor.YELLOW;
                break;
        }
    }
    
    public void displayColor() {//The displayColor() method prints out the meaning of the current color of the traffic light.
        switch (currentColor) {
            case RED:
                System.out.println("Red light - Stop");
                break;
            case YELLOW:
                System.out.println("Yellow light - Prepare to stop");
                break;
            case GREEN:
                System.out.println("Green light - Go");
                break;
        }
    }
    
    public static void main(String[] args) {
        TrafficLight trafficLight = new TrafficLight();
        
        // Simulate the traffic light changing colors
        //TrafficLight object is created, and a loop is used to simulate the traffic light changing colors. It calls the displayColor() method to show the current color
        //and then calls the changeColor() method to transition to the next color. 
        for (int i = 0; i < 10; i++) {
            trafficLight.displayColor();
            trafficLight.changeColor();
        }
    }
}
