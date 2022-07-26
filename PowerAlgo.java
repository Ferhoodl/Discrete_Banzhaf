/*
Objective: Determine Banzahf Power Index of each state. This class takes in an arraylist of State objects from
the Parser class that has each state's name and number of electoral votes filled in. This class currently
does its best to approximate each state's Banzahf Power Index value by creating a configurable number of
randomly generated elections, and executing the Banzahf algorithm on a small share of the actual number of
posible elections. It returns the arraylist with the power index values filled in for each state.
*/

import java.util.ArrayList;

public class PowerAlgo{
   public static ArrayList<State> crunch(ArrayList<State> states){
      
      // list of states in a coalition
      ArrayList<State> coalition;
      
      // total electoral votes of a coalition
      int voteCount;
      
      double totalIndex = 0;
      
      int iterationsDesired = 1000000;// <--- CHANGE THIS NUMBER for iteration change.
                                     // for me, 1 million elections takes 1 minute.
                                     // 3 million took 2:53 on an i5-8350U. Obviously single threaded.
      
      int iterationsDone = 0;
      
      
      // Randomly assign states to red or blue sides to simulate an election
      for(int i = 0; i < iterationsDesired; i++){
         do{
            voteCount = 0;
            coalition = new ArrayList<State>();
            
            for(State state : states){// for every State object in the list of states, we randomly
               if (Math.random() > .5){// decide to put it in the coalition or not
                  coalition.add(state);
               }
            }
            
            for(State state : coalition){voteCount += state.getVotes();}
         }while(voteCount < 270);
         
         for(State state : coalition){
            if ((voteCount - 2*state.getVotes()) < 270){
               state.addToPI(1);                               // a fish my sister made:    <O|||>{
            }
         }
         iterationsDone = iterationsDone + 1;
         System.out.format("%.2f", (double)iterationsDone / iterationsDesired * 100);
         System.out.println("% \n");
      }
      for(State state : states){ // add all indexes up for total index
         totalIndex += state.getIndex();
      }

      for(State state : states){ // divide every index by total index to get fraction (which is actual power index)
         state.setIndex(state.getIndex()/totalIndex);
      }
      return states;
   }
}