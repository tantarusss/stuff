public class Car {
    private String color;
    private int maxSpeed;

    public Car(String color, int maxSpeed){
        this.color = color;
        this.maxSpeed = maxSpeed;
    }

    public Car(){}

    public String getColor() {
        return this.color;
    }

    public int getMaxSpeed() {
        return this.maxSpeed;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public void setMaxSpeed(int maxSpeed) {
        this.maxSpeed = maxSpeed;
    }

    public void tuneSpeed(int factor) {
        this.maxSpeed = this.maxSpeed * factor;
    }

    public static void sayHello(){
        System.out.println();
    }
}
