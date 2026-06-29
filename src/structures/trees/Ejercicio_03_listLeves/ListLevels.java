package structures.trees.Ejercicio_03_listLeves;

import structures.node.Node;
import java.util.*;

public class ListLevels {

    public List<List<Node<Integer>>> listLevels(Node<Integer> root) {
        List<List<Node<Integer>>> resultado = new ArrayList<>();

        if (root == null) return resultado;

        Queue<Node<Integer>> cola = new LinkedList<>();
        cola.add(root);

        while (!cola.isEmpty()) {
            int size = cola.size();
            List<Node<Integer>> nivel = new ArrayList<>();

            for (int i = 0; i < size; i++) {
                Node<Integer> actual = cola.poll();
                nivel.add(actual);

                if (actual.getLeft() != null)
                    cola.add(actual.getLeft());

                if (actual.getRight() != null)
                    cola.add(actual.getRight());
            }

            resultado.add(nivel);
        }

        return resultado;
    }
}