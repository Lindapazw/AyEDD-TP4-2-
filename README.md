# Algoritmo de Compresión de Huffman

### Alumno: Linda Candela Paz
### Legajo: VINF013378
### DNI: 42379854

## Descripción

Este programa implementa el algoritmo de compresión de Huffman, que es una técnica de codificación basada en frecuencias de caracteres para reducir el tamaño de los datos. El programa genera un árbol binario de Huffman y asigna códigos binarios a cada carácter en función de su frecuencia. Estos códigos de Huffman se guardan en un archivo de texto para su posterior uso.

## Estructura del Proyecto

El código se divide en las siguientes partes:

1. **Clase `Huffman`:**
   - Implementa el algoritmo principal de compresión de Huffman.
   - Almacena los códigos generados en un array `TablaHuffmanCodigos[]`, que tiene espacio para 256 caracteres ASCII.
   - Incluye el método recursivo `GenerarCodigosDeHuffman_recursivo` que genera los códigos binarios siguiendo la estructura del árbol de Huffman.
   - El método `GuardarTabla` permite almacenar los códigos generados en un archivo de texto llamado `tabla_huffman.txt`.

2. **Clase `NodoArbol`:**
   - Representa un nodo del árbol de Huffman, con un símbolo, una frecuencia, y referencias a los nodos izquierdo y derecho.
   - Incluye un método `esHoja()` para verificar si un nodo es una hoja (un nodo sin hijos).



