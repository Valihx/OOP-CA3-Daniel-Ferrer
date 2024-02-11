import java.io.FileNotFoundException;
import java.util.*;
import java.io.File;
import java.util.ArrayList;


/**
 *  Name: Daniel Ferrer
 *  Class Group: GD2A
 */

public class CA3_Question3
{
    public static void readFile(String fileName) throws FileNotFoundException
    {
        Map<String, ArrayList<String>> identifiers = new HashMap<>();
        Scanner scan = new Scanner(new File(fileName));
        int lnCount=0;

        while(scan.hasNextLine()){
            lnCount++;
            String line = scan.nextLine();

            Scanner sc = new Scanner(line);
            sc.useDelimiter("[^A-Za-z0-9_]+");

            while(sc.hasNext()){
                String identifier = sc.next();
                if(!identifiers.containsKey(identifier)){
                    identifiers.put(identifier,new ArrayList<>());
                }
                identifiers.get(identifier).add(String.valueOf(lnCount));
            }
        }

        //display
        for (Map.Entry<String, ArrayList<String>> entry : identifiers.entrySet())
        {
            System.out.print(entry.getKey() + " - ");
            ArrayList<String> ln = entry.getValue();
            for (int i = 0; i < ln.size(); i++)
            {
                System.out.print(ln.get(i));
                if (i < ln.size() - 1)
                {
                    System.out.print(",");
                }
            }
            System.out.printf("\n" );
        }

    }

    public static void main(String[] args) throws FileNotFoundException {
        readFile("CA3_Question1.java");
    }
}
