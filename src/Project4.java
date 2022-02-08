import java.io.File;
import java.io.IOException;
import java.util.LinkedList;
import java.util.Scanner;


public class Project4 {
    public static void main(String[] args) throws IOException
    {
        System.out.println("Reading file...");
        int index = 0;
        Scanner kb = new Scanner(System.in, "ISO-8859-9");
        File f = new File("got-edges.csv");
        LinkedList<SeriesCharacter> listch = new LinkedList<>();
        Scanner sc = new Scanner(f);
        sc.nextLine();

        while(sc.hasNext()){
            String txt = sc.nextLine();
            String[] characterArray = txt.split(",");

            SeriesCharacter from = new SeriesCharacter(characterArray[0]);
            SeriesCharacter to = new SeriesCharacter(characterArray[1]);

            boolean fromb = true;
            boolean tob = true;


            for (SeriesCharacter s: listch){
                if (s.name.equals(from.name)){
                    fromb = false;
                    from = s;
                }
                if (s.name.equals(to.name)){
                    tob = false;
                    to = s;
                }
            }

            if (fromb){
                listch.add(from);
                from.setIndex(index++);
            }

            if (tob){
                listch.add(to);
                to.setIndex(index++);
            }

            Edge edge = new Edge(to, Integer.parseInt(characterArray[2]));
            from.addEdge(edge);

        }
        sc.close();


        Graph graph = new Graph(listch);

        for (SeriesCharacter s: listch){
            int a = 0;
            while(a != s.edges.size()){
                graph.addEdge(s, s.edges.get(a).to);
                a++;
            }
        }


        int opt = 0;
        while (opt != 11){
            System.out.println();
            System.out.println();
            System.out.println("1)Print Graph");
            System.out.println("2)Print Closer Characters Than Threshold");
            System.out.println("3)Print Farther Character Than Threshold");
            System.out.println("4)Check if they are connected");
            System.out.println("5)Take the shortest path");
            System.out.println("6)Delete Connection");
            System.out.println("7)Change Connection");
            System.out.println("8)Print Components");
            System.out.println("9)Print connections of the character");
            System.out.println("10)Guess the connection");
            System.out.println("11)Exit");

            System.out.print("Enter your option: ");
            opt = Integer.parseInt(kb.nextLine());

            if(opt == 1){
                graph.printGraph();

            }
            else if (opt == 2){
                System.out.print("Enter the character: ");
                String character = kb.nextLine();
                System.out.print("Enter the threshold: ");
                int threshold = Integer.parseInt(kb.nextLine());
                graph.printCloserCharacters(character, threshold);

            }else if(opt == 3){
                System.out.print("Enter the character: ");
                String character = kb.nextLine();
                System.out.print("Enter the threshold: ");
                int threshold = Integer.parseInt(kb.nextLine());
                graph.printFartherCharacters(character, threshold);

            }else if(opt == 4){
                System.out.print("Enter the first character: ");
                String character1 = kb.nextLine();
                System.out.print("Enter the second character: ");
                String character2 = kb.nextLine();
                if (graph.isConnected(character1, character2))
                    System.out.println("Yes, they are connected");
                else
                    System.out.println("No, they are not connected");

            }else if (opt == 5){
                System.out.print("Enter the first character: ");
                String character1 = kb.nextLine();
                System.out.print("Enter the second character: ");
                String character2 = kb.nextLine();
                graph.pathTo(character1,character2);

            }else if (opt == 6){
                System.out.print("Enter the first character: ");
                String character1 = kb.nextLine();
                System.out.print("Enter the second character: ");
                String character2 = kb.nextLine();
                graph.delete(character1,character2);
            }else if (opt == 7){
                System.out.print("Enter the first character: ");
                String character1 = kb.nextLine();
                System.out.print("Enter the second character: ");
                String character2 = kb.nextLine();
                System.out.print("Enter the new weight: ");
                int newWeight = Integer.parseInt(kb.nextLine());
                graph.change(character1,character2,newWeight);

            }else if(opt == 8){
                System.out.println("Connected components are: ");
                graph.connectedComponents();

            }else if (opt == 9){
                System.out.print("Enter the character: ");
                String character = kb.nextLine();
                graph.printCharacterConnections(character);

            }else if (opt == 10){
                System.out.print("Enter the first character: ");
                String character1 = kb.nextLine();
                System.out.print("Enter the second character: ");
                String character2 = kb.nextLine();
                System.out.print("Enter the weight: ");
                int weight = Integer.parseInt(kb.nextLine());
                graph.guessConnection(character1,character2,weight);

            }else if (opt == 11){
                break;
            }
        }

    }
}
