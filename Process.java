/**
 * @author Ambuj Gupta
 * @since 05-02-2020
 */
import java.io.PrintWriter;
import java.util.Comparator;
public class Process
{
    String p;
    int cb,ex,at,wt,tat,pr;
    Process(String s,int c,int a)
    {
        p=s;cb=c;at=a;wt=0;tat=0;ex=c;
    }
    Process(String s,int c,int a,int r)
    {
        p=s;cb=c;at=a;wt=0;tat=0;ex=c;pr=r;
    }
    public void print(PrintWriter out)
    {
        tat=cb+wt;
        out.format("%2s %2s %2s %2s %3s ",p,cb,at,wt,tat);
		if(pr!=0)
			out.format("%2s",pr);
		out.println();
    }
    public static Comparator<Process> arrival=new Comparator<Process>() 
    {
        public int compare(Process p1,Process p2) 
        {
           return (p1.at-p2.at);
       }
    };
    public static Comparator<Process> burst=new Comparator<Process>() 
    {
        public int compare(Process p1,Process p2) 
        {
           return (p1.ex-p2.ex);
       }
    };
	public static Comparator<Process> priority=new Comparator<Process>() 
    {
        public int compare(Process p1,Process p2) 
        {
           return (p1.pr-p2.pr);
       }
    };
}
