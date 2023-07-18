import java.util.Iterator;
import java.util.LinkedList;
import java.util.NoSuchElementException;


public class BinaryTree<T> implements Iterable<T> {

    T data;
    BinaryTree<T> left;
    BinaryTree<T> right;

    public BinaryTree() {
        data = null;
    }

    public BinaryTree(T t) {
        data = t;
        left = null;
        right = null;
    }

    public void addLeftChild(BinaryTree<T> t) {
        left = t;
    }

    public void addRightChild(BinaryTree<T> t) {
        right = t;
    }

    @Override
    public Iterator<T> iterator() {
        return new BinaryTreeIterator(this);
    }

    private class BinaryTreeIterator implements Iterator<T> {

        private LinkedList<BinaryTree<T>> list = new LinkedList<>();

        BinaryTreeIterator(BinaryTree<T> tree) {
            if (tree.data != null)
                list.add(tree);
        }

        @Override
        public boolean hasNext() {
            return !list.isEmpty();
        }

        @Override
        public T next() {
            if (!hasNext())
                throw new NoSuchElementException();
            BinaryTree<T> tree = list.remove();
            if (tree.left != null)
                list.add(tree.left);
            if (tree.right != null)
                list.add(tree.right);
            return tree.data;
        }
    }
}
