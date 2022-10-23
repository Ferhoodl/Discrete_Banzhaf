/*
Objective: Determine Banzhaf Actual Voting Power of Each State of each state. This class takes in an arraylist of State objects from
the Parser class that has each state's name and number of electoral votes filled in. This class currently
does its best to approximate each state's Banzhaf Actual Voting Power of Each State by creating a configurable number of
randomly generated elections, and executing the Banzhaf algorithm on a small share of the actual number of
posible elections. It returns the arraylist with the Banzhaf Actual Voting Power filled in for each state.
*/

import java.util.ArrayList;

public class PowerAlgo{
   public static ArrayList<State> crunch(ArrayList<State> states, int iters){
      
      // list of states in a coalition
      ArrayList<State> coalition;
      
      // total electoral votes of a coalition
      int voteCount;
      
      double totalIndex = 0;
      
      int iterationsDesired = iters; // <--- CHANGE THIS NUMBER for iteration change.
                                     // for me, 1 million elections takes 1 minute. 3 million took 2:53 with a single thread of a n intel i5-8350U
      
      int iterationsDone = 0;
      
      
      for(int i = 0; i < iterationsDesired; i++){ // simulate iterationsDesired nunber of elections 
         do{
            voteCount = 0;
            coalition = new ArrayList<State>(); // list of states generated in random coalition
            
            for(State state : states){// for every State object in the list of states, we randomly
               if (Math.random() > .5){// decide to put it in the coalition or not
                  coalition.add(state);
               }
            }
            
            for(State state : coalition){voteCount += state.getVotes();} // get total number of electoral votes in a coalition
         }while(voteCount < 270); // make sure that the previo sline adds to 270 or more
         
         for(State state : coalition){ // this for loop looks at each state and checks to see if it changes the outcome of the election.
            if ((voteCount - 2*state.getVotes()) < 270){// if the election is changed, add one to that state's total number of swings
               state.addToPI(1);                               // a fish my sister made:    <O|||>{
            }
         }
         iterationsDone = iterationsDone + 1;
         System.out.format("%.2f", (double)iterationsDone / iterationsDesired * 100); // print out progress
         System.out.println("% \n");
      }
      for(State state : states){ // add all indexes up for total index
         totalIndex += state.getIndex();
      }

      for(State state : states){ // divide every index by total index to get fraction (which is Banzhaf Actual Voting Power of Each State)
         state.setIndex(state.getIndex()/totalIndex);
      }
      return states;
   }
}
