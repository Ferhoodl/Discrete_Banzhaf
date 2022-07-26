import java.io.File;  // Import the File class
import java.io.FileNotFoundException;  // Import this class to handle errors
import java.util.Scanner; // Import the Scanner class to read text files
import java.util.ArrayList;// Lets our program use arraylists

/*
Objective: Take in a file and return State objects from State.java that contain the state names and number of
electoral votes in that file, so that they can be processed by PowerAlgo.java to determine the Banzhaf Power
Index values of each state.
*/

public class Parse{
   public static ArrayList<State> parse(String file){
   
      ArrayList<State> states = new ArrayList<State>(); // make empty list of states
      
    try {
      File myObj = new File(file); // open the text file
      Scanner myReader = new Scanner(myObj);
      while (myReader.hasNextLine()) {// loop for every line of the text file
         String data = myReader.nextLine(); // get new line of data
         /*
         if(!data.contains("=")){ // if at the end of the file, exit
            break;
         }
         */
         String[] dataSplit = data.split("=", 2); // split line into an arrya of length 2 by the "=" in the file
         String name = dataSplit[0]; // name is first thing in array
         int votes = Integer.parseInt(dataSplit[1]); // votes is second thing in array
         State state = new State(name, votes); // create new state with name and votes
         states.add(state); // add the new state to the list of states
      }
      myReader.close();
    }catch (FileNotFoundException e) {
      System.out.println("An error occurred.");
      e.printStackTrace();
    }
   return states; // return the states list with the power indexes filled in
   }
}