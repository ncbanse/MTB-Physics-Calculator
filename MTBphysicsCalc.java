import java.awt.*;
import java.util.*;
public class MTBphysicsCalc {
   // test
   
   /**
    * This is the main method, it lets the user select what type of simulation they want to ru
    */
   public static void main(String[] args) {
      Scanner console = new Scanner(System.in);
      // user inputs yes or no
      System.out.print("Do you want to run a simulation? ");
      String runAgain = console.next();
      int numOfSims = 0;
      // any answer that contains y or Y is true
      while (runAgain.indexOf("y") >= 0 || runAgain.indexOf("Y") >= 0) {
         System.out.println();
         System.out.println("What do you want to simulate?");
         System.out.println("Type 1 if you want to simulate a drop with a flat landing");
         System.out.println("Type 2 if you want to simulate a drop with an angled landing");
         System.out.println("Type 3 if you want to simulate a jump with a flat landing");
         System.out.println("Type 4 if you want to simulate a jump with an angled landing");
         System.out.println("Type 5 if you want to simulate the power requirement of an E-bike");
         System.out.print("Type answere here: ");
         // user inputs the simulation type number
         int simType = console.nextInt();
         System.out.println();
         numOfSims++;
         // checks what sim type the user selected, and calls the respective method
         if (simType == 1) {
            eqInt.HTdtfCranks(console);
         } else if (simType == 2) {
            eqInt.HTdropCranks(console);
         } else if (simType == 3) {
            eqInt.HTjtfCranks(console);
         } else if (simType == 4) {
            eqInt.HTjumpCranks(console);
         } else if (simType == 5) {
            eqInt.powerVAT(console);
         } else { // if user doesn't input a number that coresponds to a sim type
            System.out.println();
            System.out.println("Next time pick one of the options please.");
         }
         System.out.println();
         // user inputs yes or no
         System.out.print("Do you want to run anouther simulation? ");
         runAgain = console.next();
         
      }
      if (numOfSims == 0) { // snarky code ;)
         System.out.println("Then why did you run me?");
      } else { // not so snarky code :)
         System.out.println("Ok, good bye");
      }
   }
}