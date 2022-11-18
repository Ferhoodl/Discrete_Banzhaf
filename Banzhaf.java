import java.util.ArrayList; // Lets our program use arraylists

//The Actual Voting Power of States is the Total of A State's Winning Coalitions / Number of Winning Coalitions

/*
Objective: This is the main class. It tells the Parser class to turn a text file of states and electoral votes
into an arraylist of State objects with names and votes values filled in, but the Banzhaf normalized of Each State
missing. Then, the arraylist is sent to the PowerAlgo class, where our algorithm to approximate the Banzhaf normalized of Each State is applied. 
An arraylist with each state's normalized is filled in, and the Banzhaf normalized of Each State is printed to the console.
*/

public class Banzhaf{
   public static void main(String args[]){
   
      // create a list of states that contains names and electoral votes values
      ArrayList<State> states = Parse.parse("states.txt");
      
      // Number of elections to simulate with this program
      int electionIterations = 100000;// for me, 1 million elections takes 1 minute.
                                   // 3 million took 2:53 with a single thread of a n intel i5-8350U

      // take that list of states and fill in the proper powerIndex values
      states = PowerAlgo.crunch(states, electionIterations);
      
      // print out the states and power indexes
      int totalIndex = 0; // keep track of total number of 
      System.out.println("The Banzhaf Actual Voting Power of Each State is as follows:");
      for(State state : states){
         System.out.println(state.getName() + " Normalized INDEX: " + state.getIndex());
         System.out.println(state.getName() + " RAW VALUE: " + state.getPower());
         System.out.println("");
         totalIndex = totalIndex + (int)PowerAlgo.getTotalPower();
      }
      System.out.println("Total power: " + totalIndex); //owen's divisor
   }
}
