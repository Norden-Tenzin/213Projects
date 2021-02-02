package Project1.src;

import java.util.Scanner;

public class Kiosk {

  public void run() {
    // takes care of all the commands
    Library l1 = new Library();
    Scanner sc = new Scanner(System.in);
    while (true) {
      String commandLine = sc.nextLine();
      if (commandLine.equalsIgnoreCase("Q")) break;
      if (!commandLine.contains(",")) {
        
      } // Might be a print command.
      else {
        String commandParts [] = commandLine.split(",");

        // TODO other than ideal cases
        if(commandParts[0].equals("A")){
          l1.add(new Book(commandParts[1], new Date(commandParts[2])));
          System.out.println(commandParts[1] + " added to the Library.");
        } // Add book 
        if(commandParts[0].equals("R")){
          System.out.println(commandParts[1]);
          if(l1.remove(new Book(commandParts[1]))){
            System.out.println("Book# " + commandParts[1] + " removed.");
          } else {
            System.out.println("Unable to remove.");
          }
        } // Remove book
        if(commandParts[0].equals("O")){
          if(l1.checkOut(new Book(commandParts[1]))){
            System.out.println("You've checked out Book# " + commandParts[1] + " Enjoy!");
          } else {
            System.out.println("Book# " + commandParts[1] + " is not available.");
          }
        } // Checkout book
        if(commandParts[0].equals("I")){
          if(l1.returns(new Book(commandParts[1]))){
            System.out.println("Book# " + commandParts[1] + " return has completed. Thanks!");
          } else {
            System.out.println("Unable to return Book# " + commandParts[1] + ".");
          }
        } // Return book
      } // Might be a method command 
      // Process command
      // if command includes commas, split and then assign

    }
    System.out.println("Exiting");
    sc.close();
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
