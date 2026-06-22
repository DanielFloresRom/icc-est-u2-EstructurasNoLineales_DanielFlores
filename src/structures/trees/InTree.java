package structures.trees;

import structures.node.Node;

public class InTree {

    private Node<Integer> root;
    private int peso;
    // Constructor

    public InTree() {
        this.root = null;
        this.peso = 0;
    }

    public Node<Integer> getRoot() {
        return root;
    }

    public void setRoot(Node<Integer> root) {
        this.root = root;
    }

    public void setRoot(Integer value) {
        Node<Integer> node = new Node<>(value);
        this.root = node;
    }

    public void add(int value) {
        Node<Integer> node = new Node<>(value);
        root = addRecursivo(root, node);

    }

    public Node<Integer> addRecursivo(
            Node<Integer> actual,
            Node<Integer> nodeInsertar) {

        if (actual == null)
            return nodeInsertar;

        if (actual.getValue() > nodeInsertar.getValue()) {
            actual.setLeft(addRecursivo(actual.getLeft(), nodeInsertar));
        } else {
            actual.setRight(addRecursivo(actual.getRight(), nodeInsertar));

        }

        return actual;
    }

    public void preOrder() {
        preOrdenRecursivo(root);
    }

    private void preOrdenRecursivo(Node<Integer> actual) {
        if (actual == null)
            return;

        System.out.println(actual);
        preOrdenRecursivo(actual.getLeft());
        preOrdenRecursivo(actual.getRight());
    }

    public void posOrder() {
        posOrderRecursivo(root);
    }

    private void posOrderRecursivo(Node<Integer> actual) {
        if (actual == null)
            return;

        posOrderRecursivo(actual.getLeft());
        posOrderRecursivo(actual.getRight());
        System.out.println(actual);
    }

    public void inOrder() {
        inOrderRecursivo(root);
    }

    private void inOrderRecursivo(Node<Integer> actual) {
        if (actual == null)
            return;

        inOrderRecursivo(actual.getLeft());
        System.out.println(actual);
        inOrderRecursivo(actual.getRight());
    }

    public int getHigh() {
        return getHighRecursivo(this.root);
    }

    private int getHighRecursivo(Node<Integer> actual) {
        if (actual == null) {
            return 0;
        }

        int alturaIzquierda = getHighRecursivo(actual.getLeft());
        int alturaDerecha = getHighRecursivo(actual.getRight());

        return Math.max(alturaIzquierda, alturaDerecha) + 1;
    }

    public int getPeso() {
        return getPesoRecursivo(this.root);
    }

    private int getPesoRecursivo(Node<Integer> actual) {
        if (actual == null) {
            return 0;
        }

        int alturaIzquierda = getPesoRecursivo(actual.getLeft());
        int alturaDerecha = getPesoRecursivo(actual.getRight());

        return alturaIzquierda + alturaDerecha + 1;
    }
}
