/**
 *  Name: Daniel Ferrer
 *  Class Group: GD2A
 */
import java.util.Scanner;
import java.util.Stack;

/**
 *  Name: Daniel Ferrer
 *  Class Group: GD2A
 */
public class CA3_Question1
{
    public static void runSimulation() {
        Scanner scanner = new Scanner(System.in);
        Stack<Integer> driveway = new Stack<Integer>();
        Stack<Integer> street = new Stack<Integer>();

        System.out.println("Hello, please follow instructions to add or remove cars from the stack");
        System.out.println(" 1. Enter a positive number to add a car to the stack \n 2. Enter a negative number to remove a car from the stack \n 3. Enter 0 to exit");

        while (true) {
            int userChoice = scanner.nextInt();

            if (userChoice == 0) {
                break;
            }
            else if (userChoice > 0) {
                if (driveway.search(userChoice) == -1) {
                    driveway.push(userChoice);
                    System.out.println("Your driveway is now looking like this: "+driveway);

                }
                else {
                    System.out.println("That stack is already full, the current state of your stack is: "+driveway);
                }
            }
            else if(userChoice < 0) {
                removeCar(driveway,street,userChoice);
                System.out.println("the current state of your driveway is: "+driveway);
                System.out.println("the current state of the street is: "+street);

            }
        }
    }

    public static void removeCar(Stack<Integer> driveway,Stack<Integer> street,int userChoice){
        int removeCar = userChoice * -1;
        if (driveway.search(removeCar) == -1) {
            System.out.println("This car hasn't been found in the driveway");
        }
        else{
            if(driveway.isEmpty()){
                driveway.pop();
                street.push(removeCar);
            }
            else if(!driveway.isEmpty()){
                while(!driveway.isEmpty()){
                    int carTransition=driveway.peek();
                    driveway.pop();
                    street.push(carTransition);
                        if(removeCar==carTransition) {
                            street.pop();
                            while(!street.isEmpty()){
                                driveway.push(street.pop());
                            }
                            street.push(carTransition);
                            break;
                        }
                }
            }
        }

    }


    public static void main(String[] args) {
        runSimulation();
    }
}
