package search;

import java.util.Set;
import java.util.LinkedHashSet;

public class GraphSearch implements Search {
	Frontier front;
	Set<State> seen;
	int max;

	public GraphSearch(Frontier f) {
		front = f;
		seen = new LinkedHashSet<State>();
		max = 0;
	}

	public Node search(Node start, GoalTest test) {
		front.addNode(start);
		seen.add(start.state);
		max = 1;
		while (!front.isEmpty()) {
			Node node = front.removeNode();

			// add node to set, since the invariant is that if it's in our front,
			// we haven't seen it before

			if (test.isGoal(node.state)) {
				return node;
			} else {
				for (Action action : node.state.getApplicableActions()) {
					State newState = node.state.getActionResult(action);

					// if we've seen it before, move on
					if (!seen.contains(newState)) {
				        seen.add(newState);
						max += 1;
						front.addNode(new Node(node, action, newState));
					}
				}
			}
		}
		return null;
	}

	public int numNodesGenerated() {
		return max;
	}
}
