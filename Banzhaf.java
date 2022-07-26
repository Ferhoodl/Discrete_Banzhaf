import java.util.ArrayList; // Lets our program use arraylists

/*
Objective: This is the main class. It tells the Parser class to turn a text file of states and electoral votes
into an arraylist of State objects with names and votes values filled in, but Banzahf Power Index values
missing. Then, the arraylist is sent to the PowerAlgo class, where our algorith to approximate the Banzahf
values is applied. An arraylist with each state's power index value is filled in, and the values are printed
to the console.
*/

public class Banzhaf{
   public static void main(String args[]){
   
      // create a list of states that contains names and electoral votes values
      ArrayList<State> states = Parse.parse("states.txt");
      
      // take that list of states and fill in the proper powerIndex values
      states = PowerAlgo.crunch(states);
      
      // print out the states and power indexes

      System.out.println("The Banzhaf Power Index of each state is as follows:");
      for(State state : states){
         System.out.println(state.getName() + ": " + state.getIndex());
      }
   }
}