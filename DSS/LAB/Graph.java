import java.util.LinkedList;
import java.util.Queue;
public class Graph {
    int noVertics;
    LinkedList<Integer>[] adjLists;
    boolean[] visited;

    public Graph( int noVertics)
    {
        this.noVertics=noVertics;
        adjLists=new LinkedList[noVertics];
        visited=new boolean[noVertics];
        for(int i=0;i<noVertics;i++)
        {
            adjLists[i]=new LinkedList<>();
        }
    }

    public void addEdge(int src,int dest)
    {
        adjLists[src].add(dest);
        adjLists[dest].add(src);
    }
    public void DFS(int vertex)
    {
        visited[vertex]=true;
        System.out.println(vertex +" ");
        for(int adj : adjLists[vertex])
        {
            // System.out.println(adj);
            if(!visited[adj])
            {
                DFS(adj);
            }
        }
    }
    public void BFS(int vertex)
    {
        boolean visited[]=new boolean[noVertics];
        Queue<Integer>queue=new  LinkedList<Integer>();
        visited[vertex]=true;
        queue.add(vertex);
        while (!queue.isEmpty()) {
            vertex=queue.poll();
            System.out.print(vertex+" |");    
            for(int i : adjLists[vertex])
            {
                if(!visited[i])
                {
                    visited[i]=true;
                    queue.add(i);
                }
            } 
        }
    
    }

    public static void main(String[] args) {

        Graph graph =new Graph(5);

        graph.addEdge(0, 1);
        graph.addEdge(0, 4);
        graph.addEdge(1, 2);
        graph.addEdge(1, 4);
        graph.addEdge(2, 3);
        graph.addEdge(3, 3);
        graph.addEdge(3, 4);

        System.out.println("DFS");
        graph.DFS(0);
        System.out.println("BFS");

        graph.BFS(0);

    }

}
