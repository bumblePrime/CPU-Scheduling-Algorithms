/**
 * I have defined a class for Scanner and PrintWriter Objects so that i don't have to declare them in every program, rather i can just make an object of this class
 * and use it for reading and writing data from and to a file.It's totally optional, you can declare them in the main progrsm, i just find it easier to do it this way.
 * 
 * @author Ambuj Gupta
 * @since 16-01-2020
 */
import java.util.*;
import java.io.*;
public class InOut
{
    Scanner in=null;
    PrintWriter out=null;
    InOut(String input,String output)
    {
        try{
            if(input.length()!=0)
            in=new Scanner(new File(input));
            if(output.length()!=0)
            out=new PrintWriter(new BufferedWriter(new FileWriter(output)));//("arg[1]",true) for appending file
        }
        catch(Exception e)
        {
            System.out.println("File Not Found");
            System.exit(0);
        }
    } 
}