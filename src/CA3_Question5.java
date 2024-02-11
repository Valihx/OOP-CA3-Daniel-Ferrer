import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;
/**
 *  Name: Daniel Ferrer
 *  Class Group: GD2A
 */

public class CA3_Question5
{

    public static void main(String[] args)
    {
        Scanner sc = new Scanner(System.in);
        Queue<String> takeoffs = new LinkedList<>();
        Queue<String> landings = new LinkedList<>();
        String flightSymbol;
        boolean db=true;

        while(db){
            System.out.println("\nCommand List:" +
                    "\n'takeoff flightSymbol' to queue a takeoff" +
                    "\n'land flightSymbol' to queue a landing" +
                    "\n'next' to complete an action" +
                    "\n'quit' to quit the program\n");
            String userAction = sc.nextLine();
            if(userAction.contains("takeoff ")){
                String[] words = userAction.split(" "); //used copilot for the split command
                String takeoffSymbol = words[1];
                takeoffs.add(takeoffSymbol);
                System.out.println("takeoffs in queue: "+takeoffs);
                System.out.println("landings in queue: "+landings);
            }

            else if(userAction.contains("land ")){
                String[] words = userAction.split(" ");
                String landSymbol = words[1];
                landings.add(landSymbol);
                System.out.println("takeoffs in queue: "+takeoffs);
                System.out.println("landings in queue: "+landings);
            }

            else if(userAction.contains("next")){
                if(!landings.isEmpty()){
                    System.out.println("Landing the pending flights first...");
                    for(int i=0;i<landings.size();i++) {
                        System.out.println("landing: " + landings.poll() + "\nLanding complete.");
                    }
                }
                if(!takeoffs.isEmpty()){
                    System.out.println("Taking off flights");
                    for(int i=0;i<takeoffs.size();i++) {
                        System.out.println("Taking off: " + takeoffs.poll() + "\nTakeoff complete.");
                    }
                }
            }

            else if(userAction.contains("quit")){
                db=false;
            }
        }

    }
}
