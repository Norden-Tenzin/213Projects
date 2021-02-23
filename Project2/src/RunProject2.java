/**
 * This class is used to run the PayrollProcessing class. It is useful later for multithreading. 
 *  @Tenzin Norden, @Vedant Mehta
 */
package Project2.src;

public class RunProject2 {

   /**
    * Used to run the payroll processing class. Will be useful later for threading
    * 
    * @param args
    */
   public static void main(String[] args) {
      new PayrollProcessing().run();
   }
}
