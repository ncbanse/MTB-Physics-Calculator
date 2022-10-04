import java.awt.*;
import java.util.*;
public class eqInt {

   /**
    * This method simulates the power required to accelerate an abject to a specified speed in a specified amount of time
    * @param console - Lets me use Scanner
    */
   public static void powerVAT(Scanner console) {
      // user inputs Mass
      System.out.print("What is the rider's mass? (kg) ");
      double m = console.nextDouble();
      System.out.print("What is the bike's mass? (kg) ");
      m += console.nextDouble();
      System.out.print("What is the mass of the electronics? (kg) ");
      m += console.nextDouble();
      // user inputs desired top speed
      System.out.print("What is the max speed? (mph) ");
      double v = console.nextDouble();
      double vF = .44704 * v;
      // user inputs Time to accelerate from 0 m/s to desired top speed
      System.out.print("How fast do you want to reach the max speed? (s) ");
      double t = console.nextDouble();
      System.out.println();
      double a = Physics.aVT(vF, t);
      // user inputs what decimal place they want the result to be rounded to
      System.out.print("What decimal place do you want displayed? (from 10ths-100,000ths) ");
      double round = console.nextDouble();
      System.out.println();
      
      // program outputs the acceleration required to reach the top speed in the specified amount of time
      System.out.println("The acceleration is " + (Math.ceil(a * round) / round) + "m/s^2");
      double f = Physics.amF(a, m);
      // program outputs the force required to reach the top speed in the specified amount of time
      System.out.println("The force required is " + (Math.ceil(f * round) / round) + "N");
      double w = (Math.ceil(Physics.wVF(vF, f) * round) / round);
      // program outputs the power required to reach the top speed in the specified amount of time
      System.out.println("The power required to accelerate an object with a mass of " + m + "kg to " + v + "mph in " + t + "seconds =");
      System.out.println(w + "watts");
      System.out.println();
   }
   
   /**
    * This method simulates the force on a bike crank when going off a drop to flat on a hard tail mountain bike
    * @param console - Lets me use Scanner
    */
   public static void HTdtfCranks(Scanner console) {
      // user inputs Mass
      System.out.print("What is the rider's mass? (kg) ");
      double m = console.nextDouble();
      System.out.print("What is the bike's mass? (kg) ");
      m += console.nextDouble();
      // user inputs the height of drop
      System.out.print("What is the drop hight? (m) ");
      double h = console.nextDouble();
      // user inputs the distance between their butt, and the seat in the lowered position
      System.out.print("What is your seat clearance? (mm) ");
      double sc = console.nextDouble()/1000;
      // user inputs tire width
      System.out.print("What is the tire width? (in) ");
      double tw = (console.nextDouble()*25.4)/1000;
      // user inputs the aproximate ratio of force on their cranks to force on their handle bars
      System.out.print("What is your weight distrobution? (back to front decimal) ");
      double wDist = console.nextDouble();
      System.out.println();
      // user inputs what decimal place they want the result to be rounded to
      System.out.print("What decimal place do you want displayed? (from 10ths-100,000ths) ");
      double round = console.nextInt();
      System.out.println();
      double travel = sc + tw;
      double fg = Physics.amF(9.807, m);
      double gpe = Physics.jG(m, 9.807, h);
      double vf = Physics.vwxRSK(gpe, m);
      double f = Physics.amF(Physics.accelNoT(vf, travel), m);
      double fc = Math.ceil(((f + fg)/2) * round * wDist)/round;
      
      // program outputs the force on the crank arm
      System.out.println("The force on your cranks will be " + fc + "N per crank");
      System.out.println();
   }
   
   /**
    * This method simulates the force on a bike crank when going off a drop on a hard tail mountain bike
    * @param console - Lets me use Scanner
    */
   public static void HTdropCranks(Scanner console) {
      // user inputs Mass
      System.out.print("What is the rider's mass? (kg) ");
      double m = console.nextDouble();
      System.out.print("What is the bike's mass? (kg) ");
      m += console.nextDouble();
      // user inputs initial velocity
      System.out.print("What is the rider's initial horizontal speed? (m/s) ");
      double vi = console.nextDouble();
      // user inputs drop height
      System.out.print("What is the drop hight? (m) ");
      double h = console.nextDouble();
      // user inputs the angle of the landing relative to horizontal
      System.out.print("What is the angle of the landing? (deg) ");
      double lAngle = Physics.degRad(console.nextDouble());
      
      // program checks if the rider will hit the landing by checking simulating the drop
      double vf = Physics.velocityNoT(9.807, h);
      double vfAngle = Math.atan(vf/vi);
      double difAngle = vfAngle - lAngle;
      double vTan = vf * Math.sin(difAngle);
      if (vTan <= 0) {
         System.out.println("You missed the landing!");
      } else {
         double vfT = vf * Math.cos(difAngle);
         
         // user inputs the distance between their butt, and the seat in the lowered position
         System.out.print("What is your seat clearance? (mm) ");
         double sc = console.nextDouble()/1000;
         // user inputs tire width
         System.out.print("What is the tire width? (in) ");
         double tw = (console.nextDouble()*25.4)/1000;
         // user inputs the aproximate ratio of force on their cranks to force on their handle bars
         System.out.print("What is your weight distrobution? (back to front decimal) ");
         double wDist = console.nextDouble();
         System.out.println();
         // user inputs what decimal place they want the result to be rounded to
         System.out.print("What decimal place do you want displayed? (from 10ths-100,000ths) ");
         double round = console.nextDouble();
         System.out.println();
         double travel = sc + tw;
         double fg = Physics.amF(9.807, m);
         vfT = Math.ceil(vfT * round)/round;
         
         // program outputs the force on the crank arm, and the instantanious velocity when you land
         double f = Physics.amF(Physics.accelNoT(vTan, travel), m) + fg * Math.sin(lAngle);
         double fc = Math.ceil(f * wDist * .5 * round)/round;
         System.out.println("The force on your cranks will be " + fc + "N per crank");
         System.out.println("Your tangential velocity after you land will be " + vfT + "m/s");
         System.out.println();
      }
   }
   
   /**
    * This method simulates the force on a bike crank when going off a jump to flat on a hard tail mountain bike
    * @param console - Lets me use Scanner
    */
   public static void HTjtfCranks(Scanner console) {
      // user inputs the angle of the takeoff relative to horizontal
      System.out.print("What is the lip angle? (deg) ");
      double jAngle = Physics.degRad(console.nextDouble());
      // user inputs initial velocity
      System.out.print("What is your initial speed? (m/s) ");
      double vi = console.nextDouble();
      double vH = vi * Math.cos(jAngle);
      double vV = vi * Math.sin(jAngle);
      // user inputs the height of the drop
      System.out.print("How much lower is the landing (can be negative)? (m) ");
      double h = console.nextDouble();
      // user inputs Mass
      System.out.print("What is the rider's mass? (kg) ");
      double m = console.nextDouble();
      System.out.print("What is the bike's mass? (kg) ");
      m += console.nextDouble();
      // user inputs the distance between their butt, and the seat in the lowered position
      System.out.print("What is your seat clearance? (mm) ");
      double sc = console.nextDouble()/1000;
      // user inputs tire width
      System.out.print("What is the tire width? (in) ");
      double tw = (console.nextDouble()*25.4)/1000;
      // user inputs the aproximate ratio of force on their cranks to force on their handle bars
      System.out.print("What is your weight distrobution? (back to front decimal) ");
      double wDist = console.nextDouble();
      System.out.println();
      // user inputs what decimal place they want the result to be rounded to
      System.out.print("What decimal place do you want displayed? (from 10ths-100,000ths) ");
      double round = console.nextDouble();
      System.out.println();
      double travel = sc + tw;
      double vfV = Physics.velocityNoT(-1*vV, 9.807, h);
      double t = Physics.timeVA(vfV + vV, 9.807);
      double x = vH * t;
      double fg = Physics.amF(9.807, m);
      double f = Physics.amF(Physics.accelNoT(vfV, travel), m) + fg;
      double fc = Math.ceil(f * wDist * .5 * round)/round;
      
      // program outputs the force on the crank arm, and the instantanious velocity when you land
      System.out.println("The force on your cranks will be " + fc + "N per crank");
      System.out.println("your velocity after you land would be " + Math.ceil(vH * round)/round + "m/s");
      System.out.println();
   }
   
   /**
    * This method simulates the force on a bike crank when going off a jump on a hard tail mountain bike
    * @param console - Lets me use Scanner
    */
   public static void HTjumpCranks(Scanner console) {
      // user inputs the angle of the takeoff relative to horizontal
      System.out.print("What is the lip angle? (deg) ");
      double jAngle = Physics.degRad(console.nextDouble());
      // user inputs initial velocity
      System.out.print("What is your initial velocity? (m/s) ");
      double vi = console.nextDouble();
      double vH = vi * Math.cos(jAngle);
      double vV = vi * Math.sin(jAngle);
      // user inputs the height of the drop
      System.out.print("How much lower is the landing (can be negative)? (m) ");
      double h = console.nextDouble();
      // user inputs the angle of the landing relative to horizontal
      System.out.print("What is the angle of the landing? (deg) ");
      double lAngle = Physics.degRad(console.nextDouble());
      
      // program checks if the rider will hit the landing by checking simulating the drop
      double vf = Physics.velocityNoT(-vV, 9.807, h);
      double vfAngle = Math.atan(vf/vi);
      double difAngle = vfAngle - lAngle;
      double vTan = vf * Math.sin(difAngle);
      if (vTan <= 0) {
         System.out.println("You missed the landing!");
      } else {
         double vfT = vf * Math.cos(difAngle);
         // user inputs Mass
         System.out.print("What is the rider's mass? (kg) ");
         double m = console.nextDouble();
         System.out.print("What is the bike's mass? (kg) ");
         m += console.nextDouble();
         // user inputs the distance between their butt, and the seat in the lowered position
         System.out.print("What is your seat clearance? (mm) ");
         double sc = console.nextDouble()/1000;
         // user inputs tire width
         System.out.print("What is the tire width? (in) ");
         double tw = (console.nextDouble()*25.4)/1000;
         // user inputs the aproximate ratio of force on their cranks to force on their handle bars
         System.out.print("What is your weight distrobution? (back to front decimal) ");
         double wDist = console.nextDouble();
         System.out.println();
         // user inputs what decimal place they want the result to be rounded to
         System.out.print("What decimal place do you want displayed? (from 10ths-100,000ths) ");
         double round = console.nextDouble();
         System.out.println();
         double travel = sc + tw;
         double fg = Physics.amF(9.807, m);
         vfT = Math.ceil(vfT * round)/round;
         
         // program outputs the force on the crank arm, and the instantanious velocity when you land
         double f = Physics.amF(Physics.accelNoT(vTan, travel), m) + fg * Math.sin(lAngle);
         double fc = Math.ceil(f * wDist * .5 * round)/round;
         System.out.println("The force on your cranks will be " + fc + "N per crank");
         System.out.println("Your tangential velocity after you land will be " + vfT + "m/s");
         System.out.println();

         
         
      }
      
   }
   
}