import java.io.*;
import java.util.PriorityQueue;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.io.File;
import java.util.HashMap;

public class Kruskals {

	static Map<String, Integer> cityNameToIntMap = new HashMap<>();
	static Map<Integer, String> cityIntToNameMap = new HashMap<>();
	static ArrayList<Edge> edges = new ArrayList<>();
	static ArrayList<Edge> kruskal_edges = new ArrayList<>();

	private ArrayList<Edge> Kruskal(List<Edge> edges, int numVertices) {

		DisjSets ds = new DisjSets(edges.size());
		
		Comparator<Edge> comparator = new CostComparator();
		PriorityQueue<Edge> pq = new PriorityQueue<Edge>(edges.size(), comparator);
		for (int i = 0; i < edges.size() ; i++) {
			pq.add(edges.get(i));
		}
		ArrayList<Edge> mst = new ArrayList<>();
		while (mst.size() != numVertices - 1) {
			
			Edge e = pq.remove(); // Edge e = (u, v)

			int uset = ds.find(e.getu());
			int vset = ds.find(e.getv());

			if (uset != vset) { // the edge is to be accepted
				mst.add(e);
				ds.union(uset, vset);
			}
		}
		return mst;
	}
   
/* Add Edge function adds one edge to the graph.*/

	private void addEdge(String line) {

		String[] data = line.split(",");
		
		int u = cityNameToIntMap.get(data[0]);

		for (int j = 1; j < data.length; j = j + 2) {

			int v = cityNameToIntMap.get(data[j]);
			int cost = Integer.parseInt(data[j + 1]);
			Edge e = new Edge(cost);

			e.setu(u);
			e.setv(v);
			edges.add(e);
		}
	}

	public static void main(String args[]) {

		Kruskals k = new Kruskals();

		try {
			int numVertices = 0;
			File link_data = new File("assn9_data.csv");
			FileReader fileReader = new FileReader(link_data);
			BufferedReader br = new BufferedReader(fileReader);

			String line = null;
			String lines = "";
			String lineArray[];
			int i = 1;
			while ((line = br.readLine()) != null) {
				lineArray = line.split(",");
				cityNameToIntMap.put(lineArray[0], i);
				
				cityIntToNameMap.put(i,lineArray[0]);
				lines = lines + "\n" + line;
				i++;
				numVertices++;
			}
			br.close();

			lineArray = lines.split("\n");

			for (i = 1; i < lineArray.length; i++) {
				
				k.addEdge(lineArray[i]);

			}
			
			kruskal_edges = k.Kruskal(edges, numVertices);

			System.out.println("The Kruskal edges are");
			for(i=0; i< kruskal_edges.size(); i++) {
				String city1 = cityIntToNameMap.get((kruskal_edges.get(i).u));
				String city2 = cityIntToNameMap.get((kruskal_edges.get(i).v));
				int cost = kruskal_edges.get(i).cost;
			System.out.println(city1+"  "+ city2+ " "+cost);
			}

		} catch (IOException e) {
			e.printStackTrace();
		}

	}
}
