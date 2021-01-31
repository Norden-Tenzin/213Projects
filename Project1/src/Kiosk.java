package Project1.src;

public class Kiosk {
  public void run() {
    // takes care of all the commands
    Library library = new Library()
  }
}

/*
    • This class is the user interface class that handles the input and output. You must define a run() method
    or you will lose 5 points.
    • You can define the data members you need and define some private methods to handle the commands.
    Make sure you follow the ground rules and have a good programming style.
    (e) RunProject1 class is a driver class to run your Project 1. The main method will call the run() method in the
    Kiosk class.
*/

class RunProject1 {
  public static void main(String[] args) {
    new Kiosk().run();
  }
}
