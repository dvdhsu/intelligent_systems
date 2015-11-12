package search;

import java.util.LinkedList;
import java.util.Queue;

public class BreadthFirstFrontier implements Frontier {
	Queue<Node> fifoQueue;
	int max;
	
	public BreadthFirstFrontier() {
		fifoQueue = new LinkedList<Node>();
		max = 0;
	}
	
    public boolean addNode(Node node) {
      boolean succ = fifoQueue.add(node);
      max = (fifoQueue.size() > max) ? fifoQueue.size() : max;
      return succ;
    }

    public boolean clear() {
      fifoQueue.clear();
      return true;
    }

    public boolean isEmpty() {
      return fifoQueue.isEmpty();
    }

    public Node removeNode() {
      return fifoQueue.remove();
    }
    
    public int maxNodes() {
    	return max;
    }
}
