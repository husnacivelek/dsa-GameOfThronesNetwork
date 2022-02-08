public class Edge {

    public SeriesCharacter to;
    private int weight;

    public Edge(SeriesCharacter to, int weight) {

        this.to = to;
        this.weight = weight;
    }

    public int getWeight() {
        return weight;
    }

    public void setWeight(int weight){
        this.weight = weight;

    }

}

