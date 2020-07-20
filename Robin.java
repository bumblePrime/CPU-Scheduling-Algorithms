/**
 * @author Ambuj Gupta
 * @since 14-02-2020
 */
import java.util.*;
public class Robin
{
    public static void main(String arg[])
    {      
        InOut io=new InOut(arg[0],arg[1]);
        ArrayList<Process> p = new ArrayList<Process>(2),q=new ArrayList<Process>(2);
        io.in.nextLine();
        while(io.in.hasNext())
		p.add(new Process(io.in.next(),io.in.nextInt(),io.in.nextInt()));
        Collections.sort(p,Process.arrival);
        io.out.format("%2s %2s %2s %2s %3s\n","P","CB","AT","WT","TAT");
		String gantt="";
		int n=p.size(),tq=2,w=1,c=0;
        float tw=0.0f,ttat=0.0f;
		q.add(p.get(0));
        while(p.size()!=0)
        {
            c++;
            Process e=q.get(0);
            if(c!=tq)
            gantt+=e.p+" ";
            e.ex--;			
            if(e.ex==0)
            {
                e.print(io.out);
                tw+=e.wt;ttat+=e.tat;
                p.remove(e);q.remove(e);c=0;
            }		
            for(int j=0;j<p.size();j++)
            {
                if(p.get(j).at<w && p.get(j).p!=e.p)
                p.get(j).wt++;
                if(p.get(j).at<=w && q.indexOf(p.get(j))==-1)
                q.add(q.size(),p.get(j));
            }	
            if(c==tq)
			{
				q.remove(e);
				q.add(q.size(),e);
                c=0;
			}	
			w++;
        }
        io.out.println("Average Waiting Time:"+(tw/n));
        io.out.println("Average TurnAround Time:"+(ttat/n));
        io.out.println(gantt);
        io.in.close();io.out.close();
    }
}
