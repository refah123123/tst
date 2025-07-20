public class Main {
    public static void main(String[] args) {
        //Graph mygraph = new Graph(6);
        //mygraph.addEdge(0, 1);
        //mygraph.addEdge(1, 2);
        //mygraph.addEdge(4, 3);
        //mygraph.addEdge(4, 5);
        //System.out.println("Connected Components = " + mygraph.countCC());
        //mygraph.draw();


        Graph mygraph1 = new Graph(6);
        mygraph1.addEdge(0, 1);
        mygraph1.addEdge(1, 2);
        mygraph1.addEdge(4, 0);
        mygraph1.addEdge(4, 2);
        mygraph1.addEdge(4, 3);
        mygraph1.addEdge(0, 3);
        mygraph1.addEdge(5, 3);
        System.out.println("jarak 2 ke 5 = "+ mygraph1.bfs(2, 5));
        mygraph1.draw();


        }
}
