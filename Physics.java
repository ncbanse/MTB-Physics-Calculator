import java.awt.*;
public class Physics {
   
   //classic kinematics equations
   
   /**
    * This method is a kinematic equation
    * @param a - Acceleration
    * @param t - Time
    * @return Position
    */
   public static double position(double a, double t) {
      return (a * Math.pow(t, 2))/2;
   }
   
   /**
    * This method is a kinematic equation
    * @param v - Initial Velocity
    * @param a - Acceleration
    * @param t - Time
    * @return Position
    */
   public static double position(double v, double a, double t) {
      return (v * t) + (a * Math.pow(t, 2))/2;
   }
   
   /**
    * This method is a kinematic equation
    * @param x - Initial Position
    * @param v - Initial Velocity
    * @param a - Acceleration
    * @param t - Time
    * @return Position
    */
   public static double position(double x, double v, double a, double t) {
      return x + (v * t) + (a * Math.pow(t, 2))/2;
   }
   
   /**
    * This method is a kinematic equation
    * @param a - Acceleration
    * @param t - Time
    * @return Velocity
    */
   public static double velocity(double a, double t) {
      return (a * t);
   }
   
   /**
    * This method is a kinematic equation
    * @param v - Initial Velocity
    * @param a - Acceleration
    * @param t - Time
    * @return Velocity
    */
   public static double velocity(double v, double  a, double t) {
      return v + (a * t);
   }
   
   /**
    * This method is a kinematic equation
    * @param v - Initial Velocity
    * @param a - Acceleration
    * @param x - Change in Position
    * @return Velocity
    */
   public static double velocityNoT(double v, double a, double x) {
      return Math.pow(Math.pow(v,2) + 2 * a * x, .5);
   }
   
   /**
    * This method is a kinematic equation
    * @param a - Acceleration
    * @param x - Change in Position
    * @return Velocity
    */
   public static double velocityNoT(double a, double x) {
      return Math.pow(2 * a * x, .5);
   }
   
   /**
    * This method is a kinematic equation
    * @param v - Velocity
    * @param x - Change in Position
    * @return Acceleration
    */
   public static double accelNoT(double v, double x) {
      return (Math.pow(v, 2)/(2 * x));
   }
   
   /**
    * This method is a kinematic equation
    * @param v - Velocity
    * @param r - Radius
    * @return Acceleration
    */
   public static double aCent(double v, double r) {
      return Math.pow(v, 2)/r;
   }
   
   /**
    * This method is a kinematic equation
    * @param v - Change in Velocity
    * @param t - Time
    * @return Acceleration
    */
   public static double aVT(double v, double t) {
      return v/t;
   }
   
   /**
    * This method is a kinematic equation
    * @param mew - Coefficient of Friction
    * @param Fn - Normal Force
    * @return Friction Force
    */
   public static double Fs(double mew, double Fn) {
      return mew*Fn;
   }
   
   /**
    * This method is a kinematic equation
    * @param ak - Acceleration or Spring Constant
    * @param mx - Mass or Spring Compression
    * @return Force
    */
   public static double amF(double ak, double mx) {
      return ak*mx;
   }
   
   /**
    * This method is a kinematic equation
    * @param F - Force
    * @param ma - Mass or Acceleration
    * @return Mass or Acceleration
    */
   public static double Fma(double F, double ma) {
      return F/ma;
   }
   
   /**
    * This method is a kinematic equation
    * @param v - Change in Velocity
    * @param a - Acceleration
    * @return Time
    */
   public static double timeVA(double v, double a) {
      return v/a;
   }
   
   /**
    * This method is a kinematic equation
    * @param w - Power
    * @param vf - Velocity or Force
    * @return Velocity or Force
    */
   public static double vfWVF(double w, double vf) {
      return w/vf;
   }
   
   /**
    * This method is a kinematic equation
    * @param v - Velocity
    * @param f - Force
    * @return Power
    */
   public static double wVF(double v, double f) {
      return v * f;
   }
   
   
   /*period and frequency calculations
   public static double perPenSpr(double lm, double gk) {
      return 2*3.14159*Math.pow(lm/gk, .5);
   }
   
   public static double lengMassPenSpr(double T, double gk) {
      return Math.pow(T/(2*3.14159), 2) * gk;
   }
   
   public static double gkPenSpr(double T, double lm) {
      return lm/Math.pow(T/(2*3.14159), 2);
   }
   */
   
   //energy calculations
   
   /**
    * This method is a kinematic equation with multiple uses
    * @param mIk - Mass or Inertia or Spring Constant
    * @param vwx - Velocity or Angular Velocity or Spring Compression
    * @return Energy
    */
   public static double jRSK(double mIk, double vwx) {
      return .5*mIk*Math.pow(vwx, 2);
   }
   
   
   /**
    * This method is a kinematic equation with multiple uses
    * @param RSK - Energy
    * @param vwx - Velocity or Angular Velocity or Spring Compression
    * @return Mass or Inertia or Spring Constant
    */
   public static double mIkRSK(double RSK, double vwx) {
      return (RSK*2)/Math.pow(vwx, 2);
   }
   
   /**
    * This method is a kinematic equation with multiple uses
    * @param RSK - Energy
    * @param mIk - Mass or Inertia or Spring Constant
    * @return Velocity or Angular Velocity or Spring Compression
    */
   public static double vwxRSK(double RSK, double mIk) {
      return Math.pow((RSK*2)/mIk, .5);
   }
   
   /**
    * This method is a kinematic equation with multiple uses
    * @param m - Mass
    * @param g - Gravitational Acceleration
    * @param h - Height
    * @return Energy
    */
   public static double jG(double m, double g, double h) {
      return m*g*h;
   }
   
   /**
    * This method is a kinematic equation with multiple uses
    * @param mgh - Mass or Acceleration or Distance
    * @param MGH - Mass or Acceleration or Distance
    * @param j - Energy
    * @return Mass or Acceleration or Distance
    */
   public static double mghG(double mgh, double MGH, double j) {
      return j/(mgh*MGH);
   }
   
   
   
   //conversions calculations
   
   /**
    * This method is a conversion equation
    * @param rad - Radians
    * @return Degrees
    */
   public static double radDeg(double rad) {
      return (rad*180)/3.14159;
   }
   
   /**
    * This method is a conversion equation
    * @param deg - Degrees
    * @return Radians
    */
   public static double degRad(double deg) {
      return (deg*3.14159)/180;
   }
   
   /**
    * This method is a conversion equation
    * @param fp - Frequency or Period
    * @return Frequency or Period
    */
   public static double inverse(double fp) {
      return 1/fp;
   }
   
   
   
}