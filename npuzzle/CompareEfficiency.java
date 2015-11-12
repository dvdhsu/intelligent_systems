package npuzzle;

import search.BreadthFirstFrontier;
import search.DepthFirstFrontier;
import search.GraphSearch;
import search.TreeSearch;
import search.IterativeDeepeningTreeSearch;
import search.GoalTest;
import search.Node;
import search.Frontier;
import search.Search;

public class CompareEfficiency {
	public static void main(String[] args) {
		System.out.println("This compares the efficiency between the 4 algorithms for the n puzzle.");
		System.out.println();
		
		Tiles init = new Tiles(new int[][] {
			{ 7, 4, 2 },
			{ 8, 1, 3 },
			{ 5, 0, 6 }
		});
		
		Node initNode = new Node(null, null, init);
		GoalTest goalTest = new TilesGoalTest();

		Frontier front;
		Search search;
		Node solution;
		
		System.out.println("We are starting with BFS Graph search.");

		front = new BreadthFirstFrontier();
		search = new GraphSearch(front);
		solution = search.search(initNode, goalTest);
		System.out.printf("That cost %2d nodes generated, and %2d nodes put in the frontier.", search.numNodesGenerated(), front.maxNodes());
		System.out.println("");
		System.out.println("");
		//new NPuzzlePrinting().printSolution(solution);
		

		System.out.println("We are starting with BFS Tree search.");

		front = new BreadthFirstFrontier();
		search = new TreeSearch(front);
		solution = search.search(initNode, goalTest);
		System.out.printf("That cost %2d nodes generated, and %2d nodes put in the frontier.", search.numNodesGenerated(), front.maxNodes());
		System.out.println("");
		System.out.println("");

		//new NPuzzlePrinting().printSolution(solution);

		System.out.println("We are starting with DFS Graph search.");
		front = new DepthFirstFrontier();
		search = new GraphSearch(front);
		solution = search.search(initNode, goalTest);
		System.out.printf("That cost %2d nodes generated, and %2d nodes put in the frontier.", search.numNodesGenerated(), front.maxNodes());
		System.out.println("");
		System.out.println("");

		//System.out.println("We are starting with DFS Tree search.");
		//front = new DepthFirstFrontier();
		//search = new TreeSearch(front);
		//solution = search.search(initNode, goalTest);
		//System.out.printf("That cost %2d nodes generated, and %2d nodes put in the frontier.", search.numNodesGenerated(), front.maxNodes());
		//System.out.println("");
		//System.out.println("");

		System.out.println("We are starting with Iterative Deepening Search.");
		IterativeDeepeningTreeSearch ts = new IterativeDeepeningTreeSearch();
		solution = ts.search(initNode, goalTest);
		System.out.printf("That cost %2d nodes generated, and %2d nodes put in the frontier.", ts.numNodesGenerated(), ts.frontierNodesGenerated());
		System.out.println("");
		System.out.println("");
	}
}
