package search;

public class TreeSearch implements Search {
	Frontier front;
	int max;

	public TreeSearch(Frontier f) {
		front = f;
		max = 0;
	}

	public Node search(Node start, GoalTest test) {
		front.addNode(start);
		max = 1;
		while (!front.isEmpty()) {
			Node node = front.removeNode();
			if (test.isGoal(node.state))
				return node;
			else {
				for (Action action : node.state.getApplicableActions()) {
					State newState = node.state.getActionResult(action);
					front.addNode(new Node(node, action, newState));
					max += 1;
				}
			}
		}
		return null;
	}

	public int numNodesGenerated() {
		return max;
	}
}