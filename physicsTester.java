import java.awt.*;
public class physicsTester {
   public static void main(String[] args) {
      double time = 1.0;            // s
      double acceleration = 10.0;   // m/s^2
      double velocityF = 10.0;      // m/s
      double positionF = 5.0;       // m
      double velocity = 0.0;        // m/s
      double position = 0.0;        // m
      double mass = 1.0;            // kg
      
      System.out.println("position = " + Physics.position(acceleration, time) + "m");
      System.out.println("position with velocity = " + Physics.position(velocity, acceleration, time) + "m");
      System.out.println("position with velocity and position = " + Physics.position(position, velocity, acceleration, time) + "m");
      System.out.println();
      System.out.println("velocity = " + Physics.velocity(acceleration, time) + "m/s");
      System.out.println("velocity no time = " + Physics.velocityNoT(acceleration, positionF) + "m/s");
      System.out.println();
      System.out.println("time with velocity, position, and acceleration = " + Physics.timeVA(Physics.velocityNoT(acceleration, positionF), acceleration) + "s");
      System.out.println();
      System.out.println("gravitational potential energy = " + Physics.jG(mass, acceleration, positionF) + " Joules");
      System.out.println("velocity with energy = " + Physics.vwxRSK(Physics.jG(mass, acceleration, positionF), mass) + "m/s");
   }
}