import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;



    public class Main<places> {

        public static void main(String[] args) {

            String filename = "data3.txt";
            File file = new File(filename);
            Scanner input = null;
            try {
                input = new Scanner(file);
            } catch (FileNotFoundException e) {
                System.out.println(filename + ": Input file can not be found!\nExiting program...");
                System.exit(1);
            }
            int migrosIndex = -1;
            int i = 0;
            ArrayList<Place> places = new ArrayList<>();
            while (input.hasNext()) {
                String line = input.nextLine();
                String[] parts = line.split(",");
                double Xcoordinate = Double.parseDouble(parts[0]);
                double Ycoordinate = Double.parseDouble(parts[1]);
                Place temp;
                if (parts.length == 3 && parts[2].contains("Migros")) {
                    migrosIndex = i;
                    temp = new Place(1,Xcoordinate, Ycoordinate);
                } else {
                    temp = new Place(1,Xcoordinate, Ycoordinate);
                }
                places.add(temp);
                i++;
            }


            int n = places.size();
            double graph[][] = new double[n][n];

            for(i = 0; i<n; i++){
                for(int j = 0; j<n; j++){
                    graph[i][j] = dist(places.get(i), places.get(j));
                }
            }
            boolean visited[] = new boolean[n];
            visited[migrosIndex] = true;
            ArrayList<Integer> currentPath = new ArrayList<>();
            ArrayList<Integer> path = new ArrayList<>();
            double shortestPath = Double.MAX_VALUE;
            path.add(migrosIndex);
            System.out.print("Best Path: ");

            shortestPath = findShortestPath(graph, visited, migrosIndex, n, 1, 0, shortestPath, currentPath, path, migrosIndex);
            System.out.print("["+ (migrosIndex+1)+", ");
            for(int j = 0; j<path.size(); j++){
                if(j == path.size()-1){
                    System.out.println(path.get(j) +", "+ (migrosIndex+1) + "]");
                }else{
                    System.out.print(path.get(j) + ", ");
                }
            }
            System.out.println("Distance: " + shortestPath);

        }

        static double dist(Place a, Place b){
            if(a.equals(b)){
                return 0;
            }
            return Math.sqrt((a.getXcoordinate()-b.getXcoordinate())*(a.getXcoordinate()-b.getXcoordinate()) +
                    (a.getYcoordinate()-b.getYcoordinate())*(a.getYcoordinate()-b.getYcoordinate()));
        }



        static double findShortestPath(double[][] graph, boolean[] visited, int currPos, int n, int count, double cost, double ans,
                                       ArrayList<Integer> currentPath, ArrayList<Integer> path, int start)
        {
            if (count == n && graph[currPos][start] > 0)
            {
                if(ans > cost + graph[currPos][start]){
                    ans = cost + graph[currPos][start];
                    path.clear();
                    for(int i = 0; i<currentPath.size(); i++){
                        path.add(currentPath.get(i));
                    }
                }
                return ans;
            }

            for (int i = 0; i < n; i++)
            {
                if (visited[i] == false && graph[currPos][i] > 0)
                {
                    visited[i] = true;
                    //System.out.println(currPos + ", ");
                    currentPath.add(i+1);
                    ans = findShortestPath(graph, visited, i, n, count + 1, cost + graph[currPos][i], ans, currentPath, path, start);
                    Integer ii = new Integer(i+1);
                    currentPath.remove(ii);
                    visited[i] = false;
                }
            }

            return ans;
        }
    }

