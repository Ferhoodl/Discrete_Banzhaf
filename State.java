/*
Objective: Provide a framework for state data to be stored to determine the Banzahf Power index of each one. Currently, State
objects are passed around in an arrayllist to add data to the states. First at Parser, to get the data held in the state.txt
file, and then to the PowerAlgo, which does the heavy lifting with the algorithm to determine the power index values of each state.
*/
public class State{

   private String name;
   private int votes;
   private double powerIndex;
   
   State(String n, int v){ // constructor. Runs when a state object is created.
      name = n;
      votes = v;
      powerIndex = 0;
   }
   
   public String getName(){ // get state name
      return name;
   }
   
   public void setName(String n){ // rename state
      name = n;
   }
   
   public int getVotes(){ // get number of electoral votes of a state
      return votes;
   }
   
   public void setVotes(int v){ // set electoral votes of state
      votes = v;
   }
   
   public double getIndex(){ // get power index
      return powerIndex;
   }
   
   public void setIndex(double index){ // set power index directly
      powerIndex = index;
   }
   
   public void addToPI(int inc){ // add to power index (will be used a lot: Every time
      powerIndex += inc;    // a state can cause a swing in voting decision)
   }
}