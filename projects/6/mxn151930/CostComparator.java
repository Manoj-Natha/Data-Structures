import java.util.Comparator;

public class CostComparator implements Comparator<Edge> {

	@Override
	public int compare(Edge e1, Edge e2) {
		// TODO Auto-generated method stub
		if(e1.cost > e2.cost){
			return 1;
		} else if(e1.cost < e2.cost) {
			return -1;
		}
		return 0;
	}
	
	
	
}
