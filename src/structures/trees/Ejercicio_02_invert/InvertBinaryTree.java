package structures.trees.Ejercicio_02_invert;

import structures.node.Node;

public class InvertBinaryTree {

    public void invertTree(Node<Integer> root) {
        invertirRec(root);
    }

    private void invertirRec(Node<Integer> actual) {
        if (actual == null) {
            return;
        }

        Node<Integer> temp = actual.getLeft();
        actual.setLeft(actual.getRight());
        actual.setRight(temp);

        invertirRec(actual.getLeft());
        invertirRec(actual.getRight());
    }
}