import java.util.List;

public class IntervalTree<T extends Comparable<T>> implements IntervalTreeADT<T> {

    private IntervalNode<T> root;
    private int size;
    private int height;



    @Override
    public IntervalNode<T> getRoot() {
        return root;
    }

    @Override
    public void insert(IntervalADT<T> interval)
        throws IllegalArgumentException {
        root = insert(this.root, interval); 
    }

    private IntervalADT<T> insert(IntervalNode root, IntervalADT<T> interval) {
        if (interval == null) 
            throw new IllegalArgumentException();
        if (root.getInterval().compareTo(interval) == 0 ) 
            throw new IllegalArgumentException();
        if (root.getMaxEnd().compareTo(interval.getMaxEnd()) < 0)
            root.setMaxEnd(interval.getMaxEnd());
        if (root.getInterval().compareTo(interval) < 0)
            return insert(root.getRightNode(), interval);
        if (root.getInterval().compareTo(interval) > 0)
            return insert(root.getLeftNode(), interval);
    }

    @Override
    public void delete(IntervalADT<T> interval)
        throws IntervalNotFoundException, IllegalArgumentException {
        if (interval == null) 
            throw new IllegalArgumentException();
        deleteHelper(root, interval);
    }

    @Override
    public IntervalNode<T> deleteHelper(IntervalNode<T> node,
            IntervalADT<T> interval)
        throws IntervalNotFoundException, IllegalArgumentException {
        if (node == null)
            throw new IllegalArgumentException();
        if (node.getInterval().compareTo(interval) == 0) {
            if (node.getRightNode() != null) {
                node.setInterval(node.getSuccessor().getInterval);
                deleteHelper(node.getSuccessor(), interval);
                //Update the maxEnd
                node.setMaxEnd(node.getSuccessor().getMaxEnd());


               //TODO Problem here. Maybe update all left subtree
               
                // return the node
                return node;    
            }
            if (node.getRightNode() == null)
                return node.getLeftNode;
        }
        //TODO If interval is in the right subtree,
        if (node.getInterval().compareTo(interval) < 0) {
            node.setRightNode(deleteHelper(node.getRightNode));

            //TODO  Update the MaxEnd if necessary

            return node;
        }
        if (node.getInterval().compareTo(interval) > 0) {
            node.setLeftNode(deleteHelper(node.getLeftNode));

            //TODO Update the MaxEnd if necessary

        }
       return node; 
    } 
    @Override
    public List<IntervalADT<T>> findOverlapping(
            IntervalADT<T> interval) {
        // TODO Auto-generated method stub
            }

    @Override
    public List<IntervalADT<T>> searchPoint(T point) {
        // TODO Auto-generated method stub
    }

    @Override
    public int getSize() {
        // TODO Auto-generated method stub
    }

    @Override
    public int getHeight() {
        // TODO Auto-generated method stub
    }

    @Override
    public boolean contains(IntervalADT<T> interval) {
        // TODO Auto-generated method stub
    }

    @Override
    public void printStats() {
        // TODO Auto-generated method stub

    }

}
