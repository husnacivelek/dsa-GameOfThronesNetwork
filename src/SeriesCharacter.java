import java.util.LinkedList;


public class SeriesCharacter {
    int index;
    public String name;
    LinkedList<Edge> edges;

    public SeriesCharacter(String name)
    {
        this.name = name;
        edges = new LinkedList<>();

    }

    public String getName() {
        return name;
    }

    public int getIndex() {
        return index;
    }

    public void setIndex(int index) {
        this.index = index;
    }


    public boolean addEdge(Edge edge){
        return edges.add(edge);
    }


    public void removeEdge(Edge edge) {
        if (edges.contains(edge)) {
            edges.remove(edge);
        } else {
            System.out.println("Edge not found!");
        }

    }

}

