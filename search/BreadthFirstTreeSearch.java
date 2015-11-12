package search;

public class BreadthFirstTreeSearch {
	public static Node findSolution(State initialConfiguration, GoalTest goalTest) {
		BreadthFirstFrontier frontier = new BreadthFirstFrontier();
		frontier.addNode(new Node(null, null, initialConfiguration));
		while (!frontier.isEmpty()) {
			System.out.println("searching");
			Node node = frontier.removeNode();
			if (goalTest.isGoal(node.state))
				return node;
			else {
				for (Action action : node.state.getApplicableActions()) {
					State newState = node.state.getActionResult(action);
					frontier.addNode(new Node(node, action, newState));
				}
			}
		}
		return null;
	}
}
