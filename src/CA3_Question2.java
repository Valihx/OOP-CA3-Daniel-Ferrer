import org.w3c.dom.xpath.XPathResult;

import java.awt.*;
import java.util.Scanner;
import java.util.Stack;

/**
 *  Name: Daniel Ferrer
 *  Class Group: GD2A
 */
public class CA3_Question2
{
    /*
        Starter function to create the 2D array and populate it with 0

     */
    public static int[][]  floodFillStart() {
        Scanner sc = new Scanner(System.in);
        int[][] arr = new int[10][10];
        for (int x = 0; x < 10; x++)
        {
            for (int y = 0; y < 10; y++)
            {
                arr[x][y] = 0;
            }
        }
        return arr;
    }
    /*
        Helper function to display the image
     */
    public static void display(int[][] arr)
    {
        for (int x = 0; x < 10; x++)
        {
            for (int y = 0; y < 10; y++)
            {
                System.out.printf("%4d", arr[x][y]);
            }
            System.out.println();
        }
    }
    private static void fill(int row, int column, int[][] arr) {
        Stack<Pair> parameters = new Stack<>();
        parameters.push(new Pair(row,column));
        int count = 1;

        while(!parameters.isEmpty()){
            Pair current = parameters.pop();
             row = current.row;
             column = current.column;

            if(arr[row][column] == 0){
                arr[row][column] = count++;

                //north
                if(row > 0 && arr[row-1][column]==0){
                    parameters.push(new Pair(row-1,column));
                }
                //south
                if(row < 9 && arr[row+1][column]==0){//south
                    parameters.push(new Pair(row+1,column));
                }
                //west
                if(column > 0 && arr[row][column-1]==0){
                    parameters.push(new Pair(row,column-1));
                }
                //east
                if(column<9 && arr[row][column+1]==0){
                    parameters.push(new Pair(row,column+1));
                }



            }

        }


    }

    public static void start()
    {
        int[][] arr = floodFillStart();
        Scanner scanner = new Scanner(System.in);

        System.out.println("Enter the row");
        int row = scanner.nextInt();
        System.out.println("Enter the column");
        int column = scanner.nextInt();

        fill(row,column,arr);
        display(arr);
    }
    public static void main(String[] args) {
        start();
    }

}
