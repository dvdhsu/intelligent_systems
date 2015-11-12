package search;

public interface Search {
	Node search(Node start, GoalTest test);
	int numNodesGenerated();
}
