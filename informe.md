# Informe de Práctica - Estructuras No Lineales

**Estudiante:** Daniel Flores  
**Práctica:** Estructuras No Lineales - Árboles Binarios  


---

## Objetivo General

Implementar y comprender el funcionamiento de los árboles binarios de búsqueda (BST) mediante el desarrollo de 4 algoritmos: inserción, inversión, listado por niveles y cálculo de profundidad máxima. Cada ejercicio busca reforzar el uso de recursividad y estructuras de datos no lineales en Java.

---

## Ejercicio 01 - Inserción en BST

### Objetivo
Insertar valores en un árbol binario de búsqueda respetando su propiedad fundamental: los valores menores al nodo actual van a la izquierda y los mayores o iguales van a la derecha.

### Lógica
El método recorre el árbol de forma recursiva buscando la posición correcta para el nuevo nodo. Si llega a un nodo `null`, inserta ahí. Si el valor es menor al nodo actual baja por la izquierda, si es mayor baja por la derecha.

### Método
```java
public void insert(T value) {
    Node<T> node = new Node<>(value);
    root = insertRecursivo(root, node);
    peso++;
}

private Node<T> insertRecursivo(Node<T> actual, Node<T> nodeInsertar) {
    if (actual == null) return nodeInsertar;

    if (nodeInsertar.getValue().compareTo(actual.getValue()) < 0)
        actual.setLeft(insertRecursivo(actual.getLeft(), nodeInsertar));
    else
        actual.setRight(insertRecursivo(actual.getRight(), nodeInsertar));

    return actual;
}
```

### Pruebas
- Árbol vacío: inserta el primer nodo como raíz.
- Un solo nodo: el segundo valor va a izquierda o derecha según corresponda.
- Varios niveles: el árbol se construye correctamente con `{5, 3, 7, 2, 4, 6, 8}`.

### Resultados
```
----------- Ejercicio 1 (Insert BST) -----------
Inserted: 5 3 7 2 4 6 8
```

---

## Ejercicio 02 - Invertir Árbol

### Objetivo
Invertir un árbol binario de forma que cada nodo tenga sus hijos izquierdo y derecho intercambiados, resultando en una imagen espejo del árbol original.

### Lógica
Se recorre el árbol en preorden. En cada nodo se intercambian los hijos usando una variable temporal, luego se repite recursivamente para cada subárbol.

### Método
```java
public void invertTree(Node<Integer> root) {
    invertirRec(root);
}

private void invertirRec(Node<Integer> actual) {
    if (actual == null) return;

    Node<Integer> temp = actual.getLeft();
    actual.setLeft(actual.getRight());
    actual.setRight(temp);

    invertirRec(actual.getLeft());
    invertirRec(actual.getRight());
}
```

### Pruebas
- Árbol vacío: no hace nada, retorna sin error.
- Un solo nodo: no tiene hijos que intercambiar, se mantiene igual.
- Varios niveles: el árbol `{5, 3, 7, 2, 4, 6, 8}` queda completamente invertido.

### Resultados
```
----------- Ejercicio 2 (Invert Tree) -----------
Arbol original:
            7
        5
            3
Arbol invertido:
            3
        5
            7
```

---

## Ejercicio 03 - Listar Niveles

### Objetivo
Recorrer el árbol nivel por nivel y devolver una lista de listas, donde cada sublista contiene los nodos de ese nivel. Si el árbol tiene N niveles se devuelven N listas.

### Lógica
Se usa BFS (Búsqueda por Anchura) con una cola. Se agrega la raíz a la cola y en cada iteración se procesan todos los nodos del nivel actual (según el tamaño de la cola en ese momento). Los hijos de cada nodo procesado se agregan a la cola para el siguiente nivel.

### Método
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

            if (actual.getLeft() != null) cola.add(actual.getLeft());
            if (actual.getRight() != null) cola.add(actual.getRight());
        }
        resultado.add(nivel);
    }
    return resultado;
}
```

### Pruebas
- Árbol vacío: retorna lista vacía.
- Un solo nodo: retorna una lista con una sublista que contiene solo la raíz.
- Varios niveles: árbol `{4, 2, 7, 1, 3, 6, 9}` produce 3 niveles correctamente.

### Resultados
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

### Objetivo
Calcular la profundidad máxima del árbol, es decir, el número de nodos en el camino más largo desde la raíz hasta una hoja.

### Lógica
Se usa recursividad. El caso base es un nodo `null` que retorna 0. Para cada nodo se calcula la profundidad del subárbol izquierdo y derecho, y se retorna el mayor de los dos más 1 (por el nodo actual).

### Método
```java
public int maxDepth(Node<Integer> root) {
    if (root == null) return 0;

    int left = maxDepth(root.getLeft());
    int right = maxDepth(root.getRight());

    return Math.max(left, right) + 1;
}
```

### Pruebas
- Árbol vacío: retorna 0.
- Un solo nodo: retorna 1.
- Árbol con 4 niveles: árbol `{4, 2, 7, 1, 3}` con nodo `8` como hijo izquierdo de `1` retorna 4.

### Resultados
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

---

## Conclusiones

- La recursividad es la herramienta principal para trabajar con árboles binarios, ya que su estructura jerárquica se presta naturalmente para este tipo de soluciones.
- BFS con cola es la técnica adecuada para recorrer el árbol por niveles, ya que garantiza procesar todos los nodos de un nivel antes de pasar al siguiente.
- El uso de genéricos en `BinaryTree<T>` permite reutilizar la estructura con cualquier tipo de dato comparable.
- Todos los algoritmos manejan correctamente los casos borde: árbol vacío y árbol de un solo nodo.

---
