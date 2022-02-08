import java.util.*;

public class Graph{

    HashMap<SeriesCharacter, LinkedList<SeriesCharacter>> graph;
    int size = 0;
    LinkedList<SeriesCharacter> characters;


    public Graph(LinkedList<SeriesCharacter> characters)

    {
        this.characters = characters;
        size = characters.size();
        graph = new HashMap<>();
        for (SeriesCharacter sch: characters)
            graph.put(sch, new LinkedList<SeriesCharacter>());
    }


    public void addEdge(SeriesCharacter from, SeriesCharacter to)
    {

        graph.get(from).add(to);


    }

    public void printGraph()
    {
        for(SeriesCharacter sch: characters)
        {
            System.out.println("Adjacency list of vertex " + characters.get(sch.index).name);


            for (int k = 0; k < graph.get(sch).size(); ++k)
                System.out.print(graph.get(sch).get(k).name + "  ");



            System.out.println();
            System.out.println();
        }
    }

    private void DFS(SeriesCharacter node, boolean[] visited,
                     ArrayList<String> traversal){
        if(!visited[node.index]){
            traversal.add(node.name);
            visited[node.index] = true;

            this.graph.get(node).forEach(v -> DFS(v, visited, traversal));
        }
    }


    public int connectedComponents(){

        boolean[] visited = new boolean[size];
        int components = 0;

        for(int i=1; i < size; i++) {
            ArrayList<String> traversal = new ArrayList<>();
            if(!visited[i]) {
                DFS(characters.get(i), visited, traversal);
                System.out.println(traversal);
                components++;
            }
        }

        return components;
    }


    public int printShortestPath(SeriesCharacter[] parent, SeriesCharacter s, SeriesCharacter d)
    {
        int level = 0;

        if (parent[s.index] == null)
        {
            System.out.print(s.name + "  ");
            return level;
        }
        printShortestPath(parent, parent[s.index], d);

        level++;
        if (s.index < size)
            System.out.print(s.name + "  ");

        return level;
    }

    public int findShortestPath(SeriesCharacter src, SeriesCharacter dest)
    {
        boolean[] visited = new boolean[size];
        SeriesCharacter[] parent = new SeriesCharacter[size];


        for (int i = 0; i < size; i++)
        {
            visited[i] = false;
            parent[i] = null;
        }


        Queue<SeriesCharacter> queue = new LinkedList<>();


        visited[src.index] = true;
        queue.add(src);

        while (!queue.isEmpty())
        {

            SeriesCharacter s = queue.peek();

            if (s == dest)
                return printShortestPath(parent, s, dest);
            queue.poll();

            for (SeriesCharacter i : this.graph.get(s))
            {
                if (!visited[i.index])
                {
                    visited[i.index] = true;
                    queue.add(i);
                    parent[i.index] = s;
                }
            }
        }
        return 0;
    }

    public void printCloserCharacters(String toCharacter, int threshold){

        boolean found = false;
        for(SeriesCharacter sch: characters){
            if (sch.name.equalsIgnoreCase(toCharacter)){
                found = true;
                System.out.println();
                System.out.println("Characters closer to " + sch.name + " than the threshold: ");
                for (int k = 0; k < sch.edges.size(); ++k)
                    if (sch.edges.get(k).getWeight() < threshold)
                        System.out.print(sch.edges.get(k).to.name + "  ");
            }
            if(found)
                break;
        }

    }

    public void printFartherCharacters(String toCharacter, int threshold){

        boolean found = false;
        for(SeriesCharacter sch: characters){
            if (sch.name.equalsIgnoreCase(toCharacter)){
                found = true;
                System.out.println();
                System.out.println("Characters farther to " + sch.name + " than the threshold: ");
                for (int k = 0; k < sch.edges.size(); ++k)
                    if (sch.edges.get(k).getWeight() > threshold)
                        System.out.print(sch.edges.get(k).to.name + "  ");
            }
            if(found)
                break;
        }
    }

    public boolean isConnected(String ch1, String ch2){
        boolean connected = false;

        for(SeriesCharacter sch: characters){
            if (sch.name.equalsIgnoreCase(ch1) || sch.name.equalsIgnoreCase(ch2)){
                System.out.println();
                for (int k = 0; k < sch.edges.size(); ++k)
                    if (sch.edges.get(k).to.name.equalsIgnoreCase(ch2) || sch.edges.get(k).to.name.equalsIgnoreCase(ch1))
                        connected = true;
            }
            if (connected)
                break;

        }
        return connected;

    }

    public void pathTo(String ch1, String ch2){
        SeriesCharacter s = new SeriesCharacter(ch1);
        SeriesCharacter c = new SeriesCharacter(ch1);

        for(SeriesCharacter sch: characters){
            if (sch.name.equalsIgnoreCase(ch1))
                s = sch;

            if (sch.name.equalsIgnoreCase(ch2))
                c = sch;
        }
        System.out.println();
        System.out.printf("Shortest path between %s and %s: " , s.name,c.name);
        findShortestPath(s,c);

    }


    public void delete(String ch1, String ch2){

        boolean found = false;
        for(SeriesCharacter sch: characters){
            if (sch.name.equalsIgnoreCase(ch1)){
                System.out.println();
                for (int k = 0; k < sch.edges.size(); ++k)
                    if (sch.edges.get(k).to.name.equalsIgnoreCase(ch2)){
                        found = true;
                        sch.edges.remove(k);
                        graph.get(sch).remove(k);
                    }
            }
            if (found)
                break;

        }
    }

    public void change(String ch1, String ch2, int newWeight){

        boolean found = false;
        for(SeriesCharacter sch: characters){
            if (sch.name.equalsIgnoreCase(ch1)){
                System.out.println();
                for (int k = 0; k < sch.edges.size(); ++k)
                    if (sch.edges.get(k).to.name.equalsIgnoreCase(ch2)){
                        found = true;
                        sch.edges.get(k).setWeight(newWeight);
                    }
            }
            if (found)
                break;

        }
    }

    public void printCharacterConnections(String ch){
        boolean found = false;
        for(SeriesCharacter sch: characters){
            if (sch.name.equalsIgnoreCase(ch)){
                System.out.println();
                System.out.println("Connections of " + sch.name + ":");
                for (int k = 0; k < sch.edges.size(); ++k){
                    found = true;
                    System.out.print(sch.edges.get(k).to.name + "  ");
                }

            }
            if (found)
                break;

        }
    }

    public void guessConnection(String ch1,String ch2,int weight){
        System.out.println();
        boolean found = false;
        for(SeriesCharacter sch: characters){
            if (sch.name.equalsIgnoreCase(ch1))
                for (int k = 0; k < sch.edges.size(); ++k)
                    if (sch.edges.get(k).to.name.equalsIgnoreCase(ch2))
                        if (sch.edges.get(k).getWeight() == weight){
                            found = true;
                            System.out.println("Your guess is right");
                            return;
                        }else{
                            System.out.println("No, it is " + sch.edges.get(k).getWeight());
                            return;
                        }
            if(found)
                break;


        }
        System.out.println("There is no connection between them");



    }

}
 