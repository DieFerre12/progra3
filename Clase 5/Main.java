package progra3.clase5;
import java.util.ArrayList;
import java.util.List;
import java.util.ArrayList;
import java.util.List;

public class Main {
	public static void main(String[] args) {
		List<List<Integer>> grafo = new ArrayList<>();
		int numVertices = 10; // Replace 10 with the actual number of vertices
		for (int i = 0; i < numVertices; i++) {
			grafo.add(new ArrayList<>());
		}
		grafo.get(0).add(1);
		grafo.get(0).add(2); // A - C
		grafo.get(1).add(3); // B - D
		grafo.get(2).add(3); // C - D
		
		
	}
}