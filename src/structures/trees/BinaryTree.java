package structures.trees;

import structures.node.Node;

public class BinaryTree<T extends Comparable<? super T>> {

    private Node<T> root;
    private int peso;

    public BinaryTree() {
        this.root = null;
        this.peso = 0;
    }

    public boolean isEmpty() {
        return root == null;
    }

    public Node<T> getRoot() {
        return root;
    }

    public void setRoot(Node<T> node) {
        this.root = node;
        this.peso = pesoRecursivo(root);
    }

    public void setRoot(T value) {
        this.root = new Node<>(value);
        this.peso = 1;
    }

    public int getPeso() {
        return peso;
    }

    public void insert(T value) {
        Node<T> node = new Node<>(value);
        root = insertRecursivo(root, node);
        peso++;
    }

    public void insert(Node<T> value) {
        if (value != null) {
            root = insertRecursivo(root, value);
            peso++;
        }
    }

    private Node<T> insertRecursivo(Node<T> actual, Node<T> nodeInsertar) {
        if (actual == null) {
            return nodeInsertar;
        }

        if (nodeInsertar.getValue().compareTo(actual.getValue()) < 0) {
            actual.setLeft(insertRecursivo(actual.getLeft(), nodeInsertar));
        } else {
            actual.setRight(insertRecursivo(actual.getRight(), nodeInsertar));
        }

        return actual;
    }

    public void preOrder() {
        preOrderRecursivo(root);
        System.out.println();
    }

    private void preOrderRecursivo(Node<T> actual) {
        if (actual == null)
            return;
        System.out.print(actual.getValue() + " ");
        preOrderRecursivo(actual.getLeft());
        preOrderRecursivo(actual.getRight());
    }

    public void posOrder() {
        posOrderRecursivo(root);
        System.out.println();
    }

    private void posOrderRecursivo(Node<T> actual) {
        if (actual == null)
            return;
        posOrderRecursivo(actual.getLeft());
        posOrderRecursivo(actual.getRight());
        System.out.print(actual.getValue() + " ");
    }

    public void inOrder() {
        inOrderRecursivo(root);
        System.out.println();
    }

    private void inOrderRecursivo(Node<T> actual) {
        if (actual == null)
            return;
        inOrderRecursivo(actual.getLeft());
        System.out.print(actual.getValue() + " ");
        inOrderRecursivo(actual.getRight());
    }

    public int altura() {
        return alturaRecursivo(root);
    }

    private int alturaRecursivo(Node<T> actual) {
        if (actual == null)
            return 0;
        int alturaIzquierda = alturaRecursivo(actual.getLeft());
        int alturaDerecha = alturaRecursivo(actual.getRight());

        return Math.max(alturaIzquierda, alturaDerecha) + 1;
    }

    public int pesoRecorriendo() {
        return pesoRecursivo(root);
    }

    private int pesoRecursivo(Node<T> actual) {
        if (actual == null)
            return 0;
        int pesoIzquierda = pesoRecursivo(actual.getLeft());
        int pesoDerecha = pesoRecursivo(actual.getRight());
        return pesoDerecha + pesoIzquierda + 1;
    }

}