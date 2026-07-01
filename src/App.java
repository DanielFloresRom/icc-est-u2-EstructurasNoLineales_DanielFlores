import collections.maps.Maps;
import collections.set.Sets;
import evaluacion.PersonaController;

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

import java.util.ArrayList;
import java.util.List;

public class App {
    public static void main(String[] args) throws Exception {
        runIntTree();
        //runBinaryTree();
        runEjercicios();
        runSets();
        
    }

    
    private static void runSets() {
        Sets sets = new Sets();

        //Implementacion -> HashSet hashcode

        System.out.println("\n-------------HashCode-----------");
        Set<String> hashSet = sets.construirHashSet();
        System.out.println(hashSet);
        System.out.println("Size = " + hashSet.size());
        System.out.println(hashSet.contains("F"));


        System.out.println("\n-------------LinkedHashCode-----------");
        Set<String> lSet = sets.construirLinkedHashSet();
        System.out.println(lSet);
        System.out.println("Size = " + lSet.size());
        System.out.println(lSet.contains("F"));

        System.out.println("\n-------------TreeSet-----------");
        Set<String> tSet = sets.construirTreeSet();
        System.out.println(tSet);
        System.out.println("Size = " + tSet.size());
        System.out.println(tSet.contains("F"));

        System.out.println("\n-------------HashSet Contacto-----------");
        Set<Contacto> hCSet = sets.construirHashSetContacto();
        System.out.println(hCSet);
        System.out.println("Size = " + hCSet.size());

        System.out.println("\n-------------TreeSet Contacto-----------");
        Set<Contacto> thCSet = sets.construirTreeSetContacto();
        System.out.println(thCSet);
        System.out.println("Size = " + thCSet.size());
        
        System.out.println("\n-------------Mapa-----------");
        Maps maps = new Maps();
        maps.contruirHashMap();

        System.out.println("\n-------------Ejercicio 1-----------");

        List<Persona> personas = new ArrayList<>();

        personas.add(new Persona("Juan Pérez", 25));
        personas.add(new Persona("juan pérez", 25)); // Duplicado
        personas.add(new Persona("Ana", 30));
        personas.add(new Persona("Carlos", 18));
        personas.add(new Persona("Luis", 40));

        PersonaController controller = new PersonaController();

        Set<Persona> resultado = controller.filtrarYOrdenar(personas, 20);

        for (Persona p : resultado) {
            System.out.println(p.getNombre() + " - " + p.getEdad());
        }

}


    private static void runEjercicios(){
        // ----------------------------
        InsertBSTTest ejercicio1 = new InsertBSTTest();
        int[] numeros = new int[]{5,3,7,2,4,6,8};
        ejercicio1.insert(numeros);
        
        // ---------------------------
        InvertBinaryTree ejercicio2 = new InvertBinaryTree();
        int[] numeros2 = new int[] {5,3,7,2,4,6,8};

        BinaryTree<Integer> arbol = new BinaryTree<>();
        for(int numero: numeros2)
            arbol.insert(numero);

        Node<Integer> root = arbol.getRoot();
        ejercicio2.invertTree(root);

        // ---------------------------------
        ListLevels ejercicio3 = new ListLevels();
        
        int[] numeros3 = new int[]{4,2,7,1,3,6,9};

        BinaryTree<Integer> arbolEjercicio3 = new BinaryTree<>();
        
        for (int numero : numeros3) {
             arbolEjercicio3.insert(numero);
            }

        List<List<Node<Integer>>> niveles = ejercicio3.listLevels(arbolEjercicio3.getRoot());

        System.out.println("\n------------Ejercicio 3-----------");

            for (List<Node<Integer>> nivel : niveles) {
                for (Node<Integer> nodo : nivel) {
                System.out.print(nodo.getValue() + " ");
                }
                System.out.println();
            }

        //--------------------------------------
        Depth ejercicio4 = new Depth();
       

        Node<Integer> root4 = new Node<>(4);
        root4.setLeft(new Node<>(2));
        root4.setRight(new Node<>(7));

        root4.getLeft().setLeft(new Node<>(1));
        root4.getLeft().setRight(new Node<>(3));

        root4.getLeft().getLeft().setLeft(new Node<>(8));

        int profundidad = ejercicio4.maxDepth(root4);

        System.out.println("\n------------Ejercicio 4-----------");


        System.out.println("Input:");
        System.out.println("    " + root4.getValue());
        System.out.println("  " + root4.getLeft().getValue() + "     " + root4.getRight().getValue());
        System.out.println(" " + root4.getLeft().getLeft().getValue() + "   " + root4.getLeft().getRight().getValue());
        System.out.println(root4.getLeft().getLeft().getLeft().getValue());

        System.out.println();
        System.out.println("Output: " + profundidad);
        
    }

    private static void runBinaryTree() {
        BinaryTree<String> arbolStrings = new BinaryTree<>();
        BinaryTree <Persona> arbolPersonas = new BinaryTree<>();

        arbolPersonas.insert(new Persona("pablo", 30));
        arbolPersonas.insert(new Persona("ana", 25));
        arbolPersonas.insert(new Persona("luis", 35));
        arbolPersonas.insert(new Persona("maria", 28));
    }
    
    public static void runIntTree(){

        
        InTree arbolNumero = new InTree();
        // Node <Integer> nodo1 = new Node<>(50);
        // Node <Integer> nodo2 = new Node<>(10);
        // Node <Integer> nodo3 = new Node<>(30);

        // arbolNumero.setRoot(nodo1);
        // nodo1.setRight(nodo2);
        // nodo2.setLeft(nodo3);

        // System.out.println(arbolNumero.getRoot());
        // System.out.println(arbolNumero.getRoot().getRight().getLeft()); 

        //nodo3.setLeft(nodo1);

        arbolNumero.add(50);
        arbolNumero.add(10);
        arbolNumero.add(30);
        arbolNumero.add(60);
        arbolNumero.add(75);
        arbolNumero.add(55


        );
        

        System.out.println("\nPreorden: ");
        arbolNumero.preOrder();

        System.out.println("\nInorden: ");
        arbolNumero.inOrder();

        System.out.println("\nPostorden: ");
        arbolNumero.posOrder();

        System.out.println("\nArbol Altura: " + arbolNumero.getHigh());

        System.out.println("Peso: " + arbolNumero.getPeso());
        
        
        
    }
}
