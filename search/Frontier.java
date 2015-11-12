package search;

public interface Frontier {
	boolean addNode(Node node);
	boolean clear();
	boolean isEmpty();
	Node removeNode();
	int maxNodes();
}
