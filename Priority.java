/**
 * @author Ambuj Gupta
 * @since 08-02-2020
 */
import java.util.*;
public class Priority
{
    public static void main(String arg[])
    {      
        InOut io=new InOut(arg[0],arg[1]);
        Boolean P=(arg.length!=2)&&(arg[2].equals("P"));
        ArrayList<Process> p = new ArrayList<Process>(2),q=new ArrayList<Process>(2);
        io.in.nextLine();
        while(io.in.hasNext())
		p.add(new Process(io.in.next(),io.in.nextInt(),io.in.nextInt(),io.in.nextInt()));
        Collections.sort(p,Process.priority);
        Collections.sort(p,Process.arrival);
        io.out.format("%2s %2s %2s %2s %3s %2s\n","P","CB","AT","WT","TAT","PR");
        int n=p.size(),w=(P)?1:0;String gantt=p.get(0).p+" ";
        float tw=0.0f,ttat=0.0f;
        while(p.size()!=0)
        {
            Process e=p.get(0);
            if(gantt.charAt(gantt.length()-2)!=e.p.charAt(1))
            gantt+=e.p+" ";
            if(P)
            e.ex--;
            else
            {
                e.ex=0;
                e.wt=w-e.at;w+=e.cb;
            }
            if(e.ex==0)
            {
                e.print(io.out);
                tw+=e.wt;ttat+=e.tat;
                p.remove(e);
            }
            for(int j=0;j<p.size();j++)
            {
                if(p.get(j).at<w && p.get(j).p!=e.p && P)
                p.get(j).wt++;
                if(p.get(j).at<=w)
                q.add(p.get(j));  
            }
            Collections.sort(q,Process.priority);
            for(int j=q.size()-1;j>-1;j--)
            {
                p.remove(q.get(j));
                p.add(0,q.get(j));
                q.remove(j);
            }
            if(P)
            w++;
        }
        io.out.println("Average Waiting Time:"+(tw/n));
        io.out.println("Average TurnAround Time:"+(ttat/n));
        io.out.println(gantt);
        io.in.close();io.out.close();
    }
}
