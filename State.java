/*
Objective: Provide a framework for state data to be stored to determine the Banzhaf Actual Voting Power of Each State. Currently, State
objects are passed around in an arrayllist to add data to the states. First at Parser, to get the data held in the state.txt
file, and then to the PowerAlgo, which does the heavy lifting with the algorithm to determine the Banzhaf Actual Voting Power of Each State.
*/
public class State{

   private String name;
   private int votes;
   private int power;
   private double powerIndex;
   
   State(String n, int v){ // constructor. Runs when a state object is created.
      name = n;
      votes = v;
      power = 0;
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
   
   public int getPower(){
      return power;
   }
   
   public void setPower(int p){
      power = p;
   }
   
   public double getIndex(){ // get power index
      return powerIndex;
   }
   
   public void setIndex(double pIndex){ // set power index directly
      powerIndex = pIndex;
   }
   
   public void addToPow(int inc){ // add to power index (will be used a lot: Every time)
      power += inc;    // a state can cause a swing in voting decision)
   }
}
