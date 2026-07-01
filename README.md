# Estructuras No Lineales - Árboles Binarios

**Estudiante:** Daniel Flores  
**Práctica:** Estructuras No Lineales  


---

## Descripción General

Este proyecto implementa operaciones sobre árboles binarios de búsqueda (BST) en Java. Se desarrollaron 4 ejercicios que cubren inserción, inversión, listado por niveles y cálculo de profundidad máxima de un árbol binario.

La estructura base utilizada es `BinaryTree<T>` con nodos genéricos `Node<T>`, lo que permite trabajar con cualquier tipo de dato comparable.

---

## Ejercicio 01 - Inserción en BST

### Descripción
Implementar el método `insert` que inserta un valor en un árbol binario de búsqueda respetando la regla: valores menores van a la izquierda, valores mayores o iguales van a la derecha.

### Método `insert`
```java
public void insert(T value) {
    Node<T> node = new Node<>(value);
    root = insertRecursivo(root, node);
    peso++;
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
```

### Lógica
- Si el nodo actual es `null`, se inserta el nuevo nodo en esa posición.
- Si el valor a insertar es menor al actual, se recurre hacia la izquierda.
- Si es mayor o igual, se recurre hacia la derecha.

### Salida de consola
```
----------- Ejercicio 1 (Insert BST) -----------
Inserted: 5
Inserted: 3
Inserted: 7
...
```

---

## Ejercicio 02 - Invertir Árbol

### Descripción
Implementar el método `invertTree` que invierte un árbol binario, intercambiando los hijos izquierdo y derecho de cada nodo de forma recursiva.

### Método `invertTree`
```java
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
```

### Lógica
- Se recorre el árbol en preorden.
- En cada nodo se intercambian los hijos izquierdo y derecho usando una variable temporal.
- Se repite recursivamente para todos los nodos.

### Salida de consola
```
----------- Ejercicio 2 (Invert Tree) -----------
Árbol original:
        7
    5
        3
Árbol invertido:
        3
    5
        7
```

---

## Ejercicio 03 - Listar Niveles

### Descripción
Implementar el método `listLevels` que devuelve una lista de listas, donde cada sublista contiene los nodos de un mismo nivel del árbol.

### Método `listLevels`
```java
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
```

### Lógica
- Se usa una cola (BFS - Búsqueda por anchura).
- En cada iteración se procesan todos los nodos del nivel actual.
- Los hijos de cada nodo se agregan a la cola para el siguiente nivel.

### Salida de consola
```
----------- Ejercicio 3 (List Levels) -----------
Input:
        4
      2    7
   1   3  6   9

Output:
4
2 -> 7
1 -> 3 -> 6 -> 9
```

---

## Ejercicio 04 - Profundidad Máxima

### Descripción
Implementar el método `maxDepth` que calcula la profundidad máxima de un árbol binario, es decir, el número de nodos en el camino más largo desde la raíz hasta una hoja.

### Método `maxDepth`
```java
public int maxDepth(Node<Integer> root) {
    if (root == null) return 0;

    int left = maxDepth(root.getLeft());
    int right = maxDepth(root.getRight());

    return Math.max(left, right) + 1;
}
```

### Lógica
- Caso base: si el nodo es `null`, retorna 0.
- Se calcula recursivamente la profundidad del subárbol izquierdo y derecho.
- Se retorna el máximo entre ambos más 1 (por el nodo actual).

### Salida de consola
```
----------- Ejercicio 4 (Depth) -----------
Input:
      4
    2    7
  1   3
8

Output:
4
```

### Metodo filtrarYOrdenar
Filtra personas por edad mínima, elimina duplicados (nombre y edad, ignorando mayúsculas) y devuelve un Set ordenado por edad descendente y nombre ascendente.

