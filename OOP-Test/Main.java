public class Main {
    public static void main(String[] args) {
        System.out.println("Hello");
        Car porsche = new Car("Rot", 10);



        System.out.println(porsche.getMaxSpeed() + " " + porsche.getColor());

        porsche.setColor("Blau");

        System.out.println(porsche.getMaxSpeed() + " " + porsche.getColor());

        porsche.tuneSpeed(10);

        System.out.println(porsche.getMaxSpeed() + " " + porsche.getColor());

        Car.sayHello();
    }

}
