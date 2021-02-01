package Project1.src;

import java.util.Scanner;

public class Kiosk {

  public void run() {
    // takes care of all the commands

    Library l1 = new Library();
    l1.add(new Book("helllo", new Date()));
    l1.add(new Book("helllo", new Date("07/29/1999")));
    l1.add(new Book("helllo", new Date("11/15/1999")));
    // if(new Book("helllo", new Date("07/29/1999")).getDate().getYear() == new Book("helllo", new Date("07/29/1999")).getDate().getYear()){
    //   System.out.println("YEs");
    // }
    l1.printByDate();
    // Scanner sc = new Scanner(System.in);
    // while (true) {
    //   String command = sc.nextLine();

    //   if (command.equalsIgnoreCase("Q")) break;

    //   if (!command.contains(",")) {}
    //   // Process command
    //   // if command includes commas, split and then assign

    // }
    // sc.close();
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
