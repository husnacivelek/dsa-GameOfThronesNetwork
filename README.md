# data-structures-and-algorithms-project4

*This was my fourth project for Data Structures And Algorithms lecture in university. The explanation made was as follows:

**Game of Thrones Network**

In this project we will model the connections between the characters of the famous TV series: Game of Thrones. The data is available in the link below: 

https://github.com/melaniewalsh/sample-social-network-datasets/blob/master/sample-datasets/game-of-thrones/got-edges.csv#L1

Our weighted graph will represent these data with edge-weights equal to the connection strength between two individual characters.

SeriesCharacter is an object with name.  The graph vertices are the Characters of this TV-Series. (Use a hash table to map SeriesCharacters into graph vertices).

In your main method, provide the following functionalities:

  A)	**ReadFileGOTGraph(‘’)** // loads GOT data and returns a graph
  
  B)	**printClosesestCharacters(toCharacter, threshold)** //strength is smaller than a threshold (e.g., 15)
  
  C)	**printFartherCharacters(toCharacter, threshold)** // strength is greater than a threshold (e.g., 15)
  
  D)	**isconnected(character1, character2):** User gives two characters, your program searches and prints a message indicating if these two characters are connected to each other.
  
  E)	**pathTo(character1, character2):** User gives two characters, then your program searches and prints the shortest path from character1 to character2. If there are several shortest paths, printing one of them is enough.
  
  F)	**delete(character1, character2):** User gives two characters, and your program deletes the connection between them.
  
  G)	**change(character1, character2, newWeight):** User gives two characters, and your program updates the connection strength between them by newWeight
  
  H)	**NumberofcharacterGroups:** Prints the connected components and Characters in each component. If there is only single group you can delete some links and test this functionality. 
  
  Eg. Component 1: Ali, Sansa, Jon
  
  Component 2: Veli, Kim, Deli
  
  I)	**Custom function1:** Add your own function which is not listed above.
  
  J)	**Custom function2:** Add your own function which is not listed above. 
  
  ---------------------------------------------------------------------
  
  *Note: For the first custom function, I wrote a function which prints all the connections of a single character. For the second, I wrote a function which takes two character names and a weight,
  checks the connection between them(if there exists or if it is the right weight), displays a message according to it.*
