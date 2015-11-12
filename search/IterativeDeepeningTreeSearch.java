package search;

public class IterativeDeepeningTreeSearch implements Search {
	protected int max = 0;
	private Frontier front;

	public IterativeDeepeningTreeSearch() {
	}

	public Node search(Node init, GoalTest goalTest) {
		this.max = 0;

		int currentDepth = 0;
		while (currentDepth < 100) {
			this.front = new DepthFirstFrontier();
			this.front.addNode(init);
			while (!front.isEmpty()) {
				Node node = front.removeNode();
				if (goalTest.isGoal(node.state))
					return node;
				else {
					for (Action action : node.state.getApplicableActions()) {
						State newState = node.state.getActionResult(action);
						Node next = new Node(node, action, newState, node.depth + 1);
						this.front.addNode(next);
						this.max += 1;
					}
				}
			}

			currentDepth++;
		}
		return null;
	}

	public int numNodesGenerated() {
		return this.max;
	}

	public int frontNodesGenerated() {
		return front.maxNodes();
	}
}