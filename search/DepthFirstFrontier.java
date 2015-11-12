package search;

import java.util.Stack;

public class DepthFirstFrontier implements Frontier {
	Stack<Node> stack;
	int max;
	
	public DepthFirstFrontier() {
		stack = new Stack<Node>();
		max = 0;
	}
	
    public boolean addNode(Node node) {
      stack.push(node);
      max = (stack.size() > max) ? stack.size() : max;
      return true;
    }

    public boolean clear() {
      stack.clear();
      return true;
    }

    public boolean isEmpty() {
      return stack.isEmpty();
    }

    public Node removeNode() {
      return stack.pop();
    }
    
    public int maxNodes() {
    	return max;
    }
}
