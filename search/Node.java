package search;

public class Node {
	public final Node parent;
	public final Action action;
	public final State state;
	public int depth;
	
	public Node(Node parent, Action action, State state) {
		this.parent = parent;
		this.action = action;
		this.state = state;
		this.depth = -1;
	}
	
	public Node(Node parent, Action action, State state, int depth) {
		this.parent = parent;
		this.action = action;
		this.state = state;
		this.depth = depth;
	}
}
