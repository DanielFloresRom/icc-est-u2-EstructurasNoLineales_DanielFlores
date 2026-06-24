package structures.trees.Ejercicio_04_depth;

import structures.node.Node;

public class Depth {

    public int maxDepth(Node<Integer> root) {
        if (root == null) return 0;

        int left = maxDepth(root.getLeft());
        int right = maxDepth(root.getRight());

        return Math.max(left, right) + 1;
    }
}