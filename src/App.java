import collections.set.Sets;
import java.util.Set;
import models.Contacto;
import models.Persona;
import structures.node.Node;
import structures.trees.BinaryTree;
import structures.trees.InTree;
import structures.trees.Ejercicio_01_insert.InsertBSTTest;
import structures.trees.Ejercicio_02_invert.InvertBinaryTree;
import structures.trees.Ejercicio_03_listLeves.ListLevels;
import structures.trees.Ejercicio_04_depth.Depth;

import java.util.List;

public class App {

    public static void main(String[] args) throws Exception {
<<<<<<< HEAD
        //runIntTree();
        //runBinaryTree();
        //runEjercicio1();
        //runEjercicio2();
        runSets();
    }

    private static void runSets() {
        Sets sets = new Sets();
        // Implementacion -> HashSet hashcode
        System.out.println("--------HashSet--------");
        Set<String> hashSet = sets.construirHashSet();
        System.out.println(hashSet);
        System.out.println("Size= "+hashSet.size());
        System.out.println(hashSet.contains("F"));

        //Implementacion -> LinkedHashSet
        System.out.println("--------LinkedHashSet--------");
        Set<String> linkedHashSet = sets.construirLinkedHashSet();
        System.out.println(linkedHashSet);
        System.out.println("Size= "+linkedHashSet.size());
        System.out.println(linkedHashSet.contains("F"));
        
        //Implementacion -> TreeSet 
        System.out.println("--------TreeSet--------");
        Set<String> treeSet = sets.construirTreeSet();
        System.out.println(treeSet);
        System.out.println("Size= "+treeSet.size());
        System.out.println(treeSet.contains("F"));

        //Implementacion -> Hash Contacto Set
        System.out.println("--------Hash Contacto Set--------");
        Set<Contacto> hCSet =sets.construirHashSetContacto();
        System.out.println(hCSet);
        System.out.println("Size= "+hCSet.size());

=======
        runIntTree();
        runBinaryTree();
        runEjercicio1();
        runEjercicio2();
        runEjercicio3();
        runEjercicio4();
>>>>>>> 6b887dd5a9483b4cdeb80570d6bf0ca7f552f01f
    }

    private static void runBinaryTree() {
        System.out.println("\n----------- BinaryTree con Persona -----------");

        BinaryTree<Persona> arbolPersonas = new BinaryTree<>();
        arbolPersonas.insert(new Persona("Pablo", 30));
        arbolPersonas.insert(new Persona("Ana", 25));
        arbolPersonas.insert(new Persona("Luis", 35));
        arbolPersonas.insert(new Persona("Maria", 28));

        System.out.print("InOrder Personas: ");
        arbolPersonas.inOrder();
    }

    private static void runEjercicio1() {
        System.out.println("\n----------- Ejercicio 1 (Insert BST) -----------");

        InsertBSTTest ejercicio1 = new InsertBSTTest();
        int[] numeros = {5, 3, 7, 2, 4, 6, 8};
        ejercicio1.insert(numeros);
    }

    private static void runEjercicio2() {
        System.out.println("\n----------- Ejercicio 2 (Invert Tree) -----------");

        int[] numeros = {5, 3, 7, 2, 4, 6, 8};
        BinaryTree<Integer> tree = new BinaryTree<>();

        for (int num : numeros) {
            tree.insert(num);
        }

        Node<Integer> root = tree.getRoot();

        System.out.println("Árbol original:");
        printTree(root, 0);

        InvertBinaryTree ejercicio2 = new InvertBinaryTree();
        ejercicio2.invertTree(root);

        System.out.println("\nÁrbol invertido:");
        printTree(root, 0);
    }

    private static void runEjercicio3() {
        System.out.println("\n----------- Ejercicio 3 (List Levels) -----------");

        int[] numeros = {4, 2, 7, 1, 3, 6, 9};
        BinaryTree<Integer> tree = new BinaryTree<>();

        for (int num : numeros) {
            tree.insert(num);
        }

        Node<Integer> root = tree.getRoot();

        System.out.println("Input:");
        System.out.println("        4");
        System.out.println("      2    7");
        System.out.println("   1   3  6   9");

        ListLevels ejercicio3 = new ListLevels();
        List<List<Node<Integer>>> niveles = ejercicio3.listLevels(root);

        System.out.println("\nOutput:");
        for (int i = 0; i < niveles.size(); i++) {
            List<Node<Integer>> lista = niveles.get(i);
            for (int j = 0; j < lista.size(); j++) {
                System.out.print(lista.get(j).getValue());
                if (j < lista.size() - 1) {
                    System.out.print(" -> ");
                }
            }
            System.out.println();
        }
    }
    private static void runEjercicio4() {
        System.out.println("\n----------- Ejercicio 4 (Depth) -----------");

        Node<Integer> root = new Node<>(4);
        Node<Integer> n2 = new Node<>(2);
        Node<Integer> n7 = new Node<>(7);
        Node<Integer> n1 = new Node<>(1);
        Node<Integer> n3 = new Node<>(3);
        Node<Integer> n8 = new Node<>(8);

        root.setLeft(n2);
        root.setRight(n7);
        n2.setLeft(n1);
        n2.setRight(n3);
        n1.setLeft(n8);

        System.out.println("Input:");
        System.out.println("      4");
        System.out.println("    2    7");
        System.out.println("  1   3");
        System.out.println("8");

        Depth ejercicio4 = new Depth();
        int profundidad = ejercicio4.maxDepth(root);

        System.out.println("\nOutput:");
        System.out.println(profundidad);
    }

    public static void runIntTree() {

        System.out.println("\n----------- InTree -----------");

        InTree arbolNumero = new InTree();
        Node<Integer> nodo1 = new Node<>(50);
        Node<Integer> nodo2 = new Node<>(10);
        Node<Integer> nodo3 = new Node<>(30);

        arbolNumero.setRoot(nodo1);
        nodo1.setRight(nodo2);
        nodo2.setLeft(nodo3);

        System.out.println(arbolNumero.getRoot());
        System.out.println(arbolNumero.getRoot().getRight());
        System.out.println(arbolNumero.getRoot().getLeft());

        System.out.println("Preorden:");
        arbolNumero.preOrder();

        System.out.println("Inorden:");
        arbolNumero.inOrder();

        System.out.println("Postorden:");
        arbolNumero.posOrder();

        System.out.println("--- ALTURA DEL ARBOL ---");
        System.out.println(arbolNumero.getHigh());

        System.out.println("--- PESO DEL ARBOL ---");
        System.out.println(arbolNumero.getPeso());
    }

    private static void printTree(Node<Integer> node, int nivel) {
        if (node == null) return;

        printTree(node.getRight(), nivel + 1);

        for (int i = 0; i < nivel; i++) {
            System.out.print("\t");
        }
        System.out.println(node.getValue());

        printTree(node.getLeft(), nivel + 1);
    }
}