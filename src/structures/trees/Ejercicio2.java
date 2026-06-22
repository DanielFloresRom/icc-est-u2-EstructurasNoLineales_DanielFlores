package structures.trees;

import structures.node.Node;

public class Ejercicio2 {

    public void invertTree(Node<Integer> root) {
        System.out.println("Arbol original:");
        printTree(root);
        System.out.println("\nArbol invertido:");
        invertirRec(root);
        printTree(root);
    }

    private void invertirRec(Node<Integer> actual) {
        if (actual==null){
            return;
        }
        Node<Integer> temp = actual.getLeft();
        actual.setLeft(actual.getRight());
        actual.setRight(temp);

        invertirRec(actual.getLeft());
        invertirRec(actual.getRight());
    }

    public void printTree(Node<Integer> root) {
        System.out.println("Imprimiendo el arbol");
        printTreeRecursivo(root, 0);
    }

    private void printTreeRecursivo(Node<Integer> node, int nivel) {
        if (node == null) {
            return;
        }

        printTreeRecursivo(node.getRight(), nivel + 1);

        for (int i = 0; i < nivel; i++) {
            System.out.print("\t");
        }
        System.out.println(node.getValue());

        printTreeRecursivo(node.getLeft(), nivel + 1);
    }
}