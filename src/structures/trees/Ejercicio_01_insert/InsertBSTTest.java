package structures.trees.Ejercicio_01_insert;

import structures.node.Node;
import structures.trees.BinaryTree;

public class InsertBSTTest{
    public void insert(int[] numeros) {
        BinaryTree<Integer> arbol = new BinaryTree<>();

        for (int numero : numeros) {
            arbol.insert(numero);
        }
        System.out.print("InOrder: ");
        arbol.inOrder();

        printTree(arbol.getRoot());
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
