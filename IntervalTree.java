import java.util.List;

public class IntervalTree<T extends Comparable<T>> implements IntervalTreeADT<T> {
	
	private IntervalNode<T> root;

	@Override
	public IntervalNode<T> getRoot() {
		return root;
	}

	@Override
	public void insert(IntervalADT<T> interval)
					throws IllegalArgumentException {
		insertHelper(root, interval);
	}
	
	private void insertHelper(IntervalNode<T> root, IntervalADT<T> interval) 
			throws IllegalArgumentException {
		// Check if the intervals are the same
		if((interval.getStart().compareTo(root.getInterval().getStart()) == 0) && 
				(interval.getEnd().compareTo(root.getInterval().getEnd()) == 0)) {
			throw new IllegalArgumentException();
		}
		
		// Compare the left end of the interval to the left end of the interval of the root
		if(interval.getStart().compareTo(root.getInterval().getStart()) < 0) {
			if(root.getLeftNode() == null) {
				IntervalNode<T> leftNode = new IntervalNode<T>(interval);
				root.setLeftNode(leftNode);
			} else {
				insertHelper(root.getLeftNode(), interval);
			}
		// If the left end of the interval is equal to the left end of the interval of 
		// the root, compare right ends
		} else if(interval.getStart().compareTo(root.getInterval().getStart()) == 0) {
			if(interval.getEnd().compareTo(root.getInterval().getEnd()) < 0) {
				if(root.getLeftNode() == null) {
					IntervalNode<T> leftNode = new IntervalNode<T>(interval);
					root.setLeftNode(leftNode);
				} else {
					insertHelper(root.getLeftNode(), interval);
				}
			}
		// Compare the right end of the interval to the right end of the interval of the root
		} else {
			if(root.getRightNode() == null) {
				IntervalNode<T> rightNode = new IntervalNode<T>(interval);
				root.setLeftNode(rightNode);
			} else {
				insertHelper(root.getLeftNode(), interval);
			}
		}	 
	}

	@Override
	public void delete(IntervalADT<T> interval)
					throws IntervalNotFoundException, IllegalArgumentException {
		deleteHelper(root, interval);
	}
	
	@Override
	public IntervalNode<T> deleteHelper(IntervalNode<T> node,
					IntervalADT<T> interval)
					throws IntervalNotFoundException, IllegalArgumentException {
		// TODO Auto-generated method stub
		int maxEnd = 0;
		
		if(node == null) {
			String message = interval.getLabel() + "[" + interval.getStart() + ", " + interval.getEnd() + "]";
			throw new IntervalNotFoundException(message);
		}
		
		IntervalNode<T> rightNode;
		IntervalNode<T> leftNode;
		
		if(node.getInterval().compareTo(interval) == 0) {
			if(node.getRightNode() != null) {
				node.setInterval(node.getSuccessor().getInterval());
				IntervalNode<T> returnNode = deleteHelper(node.getSuccessor(), interval);
				returnNode.setMaxEnd(recalculateMaxEnd(returnNode));
				return returnNode;
			} else {
				return node.getLeftNode();
			}
		} else if(node.getRightNode().getMaxEnd().compareTo(interval.getStart()) < 0) {
			rightNode = deleteHelper(node.getRightNode(), interval);
			if(rightNode.getMaxEnd().compareTo(interval.getEnd()) == 0)
				rightNode.setMaxEnd(recalculateMaxEnd(rightNode));
			return rightNode;
		} else/*(node.getLeftNode().getMaxEnd().compareTo(interval.getStart()) > 0)*/ {
			leftNode = deleteHelper(node.getLeftNode(), interval);
			if(leftNode.getMaxEnd().compareTo(interval.getEnd()) == 0)
				leftNode.setMaxEnd(recalculateMaxEnd(leftNode));
			return leftNode;
		}
	}
	
	private T recalculateMaxEnd(IntervalNode<T> nodeToRecalculate) {
		if(nodeToRecalculate.getLeftNode().getMaxEnd().compareTo
				(nodeToRecalculate.getRightNode().getMaxEnd()) > 0) {
			return nodeToRecalculate.getLeftNode().getMaxEnd();
		} else {
			return nodeToRecalculate.getRightNode().getMaxEnd();
		}
	}

	@Override
	public List<IntervalADT<T>> findOverlapping(
					IntervalADT<T> interval) {
		List list = (List) new IntervalTree();
		return findOverlappingHelper(root, interval, list);
		
	}
	
	private List<IntervalADT<T>> findOverlappingHelper(
			IntervalNode<T> root, IntervalADT<T> interval, List<IntervalADT<T>> list) {
		if(root == null) {
			return list;
		}
		
		if(root.getInterval().getStart().compareTo(interval.getStart()) == 0 && 
				root.getInterval().getEnd().compareTo(interval.getEnd()) == 0) {
			list.add(root.getInterval());
		}
		
		if(root.getLeftNode().getMaxEnd().compareTo(interval.getStart()) > 0) {
			return findOverlappingHelper(root.getLeftNode(), interval, list);
		}
		
		if(root.getRightNode().getMaxEnd().compareTo(interval.getStart()) > 0) {
			return findOverlappingHelper(root.getRightNode(), interval, list);
		}
		
		return list;
	}

	@Override
	public List<IntervalADT<T>> searchPoint(T point) throws IllegalArgumentException {
		// TODO Auto-generated method stub
		return searchPointHelper(root, point);
	}
	
	private List<IntervalADT<T>> searchPointHelper(IntervalNode<T> root, T point) 
			throws IllegalArgumentException {
		List list = (List) new IntervalTree();
		if(point == null) {
			throw new IllegalArgumentException();
		}
		
		if(root.getInterval().getStart().compareTo(point) < 0 && 
				root.getInterval().getEnd().compareTo(point) > 0) {
			list.add(root);
		}
		
		if(root.getLeftNode() != null) {
			if(point.compareTo(root.getLeftNode().getMaxEnd()) > 0) {
				return list;
			} else {
				return searchPointHelper(root.getLeftNode(), point);
			}
		}
		
		if(root.getRightNode() != null) {
			if(point.compareTo(root.getRightNode().getInterval().getStart()) < 0) {
				return list;
			} else {
				return searchPointHelper(root.getRightNode(), point);
			}
		}
		
		return list;
	}

	@Override
	public int getSize() {
		return sizeHelper(root);
	}
	
	private int sizeHelper(IntervalNode<T> root) {
		if(root == null) {
			return 0;
		}
		
		int maxSize = 0;
		
		if(root.getLeftNode() != null) {
			maxSize += 1 + sizeHelper(root.getLeftNode());
		}
		
		if(root.getRightNode() != null) {
			maxSize += 1 + sizeHelper(root.getRightNode());
		}
		
		return 1 + maxSize;
	}

	@Override
	public int getHeight() {
		return heightHelper(root);
	}
	
	private int heightHelper(IntervalNode<T> root) {
		if(root == null) {
			return 0;
		}
		
		int maxHeight = 0;
		int leftNodeHeight = 0;
		int rightNodeHeight = 0;
		
		if(root.getLeftNode() != null && root.getRightNode() != null) {
			leftNodeHeight = heightHelper(root.getLeftNode());
			rightNodeHeight = heightHelper(root.getLeftNode());
			if(leftNodeHeight > rightNodeHeight) {
				maxHeight = leftNodeHeight;
			} else {
				maxHeight = rightNodeHeight;
			}
		} else if(root.getLeftNode() != null) {
			return maxHeight += 1;
		} else if(root.getLeftNode() == null) {
			if(root.getRightNode() != null) {
				return maxHeight += 1;
			} else {
				return maxHeight;
			}
		}	
		
		return maxHeight;
	}

	@Override
	public boolean contains(IntervalADT<T> interval) {
		return contains(root, interval);	
	}
	
	private boolean contains(IntervalNode<T> root, IntervalADT<T> interval) {
		if(root.getInterval().compareTo(interval) == 0) {
			return true;
		}
		
		if(interval.compareTo(root.getInterval()) < 0) {
			if(root.getLeftNode() != null)
				return contains(root.getLeftNode(), interval);
		} else if (interval.compareTo(root.getInterval()) > 0){
			return contains(root.getRightNode(), interval);
		}
		
		return false;
	}

	@Override
	public void printStats() {
		System.out.println("Height: " + getHeight());
		System.out.println("Size: " + getSize());
	}

}
