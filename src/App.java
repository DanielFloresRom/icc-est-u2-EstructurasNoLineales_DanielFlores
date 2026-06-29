import collections.set.Sets;
import java.util.Set;
import models.Contacto;
import models.Persona;
import structures.node.Node;
import structures.trees.BinaryTree;
import structures.trees.Ejercicio1;
import structures.trees.Ejercicio2;
import structures.trees.InTree;

public class App {
    public static void main(String[] args) throws Exception {
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

    }

    private static void runBinaryTree() {
        BinaryTree<String> arbolString = new BinaryTree<>();
        BinaryTree<Persona> arbolPersonas = new BinaryTree<>();
        arbolPersonas.insert(new Persona("Pablo", 30));
        arbolPersonas.insert(new Persona("Ana", 25));
        arbolPersonas.insert(new Persona("Luis", 35));
        arbolPersonas.insert(new Persona("Maria", 28));
    }

    private static void runEjercicio1() {
        Ejercicio1 ejercicio1 = new Ejercicio1();
        System.out.println("----------------Ejercicio 1---------------");
        int[] numeros = new int[] { 5, 3, 7, 2, 4, 6, 8 };
        ejercicio1.insert(numeros);

    }

    private static void runEjercicio2() {
        Ejercicio2 ejercicio2 = new Ejercicio2();
        int[] numeros = new int[] { 5, 3, 7, 2, 4, 6, 8 };
        BinaryTree<Integer> tree = new BinaryTree<>();
        for (int num : numeros) {
            tree.insert(num);
        }
        Node<Integer> root = tree.getRoot();
        ejercicio2.invertTree(root);

    }

    public static void runIntTree() {

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
}