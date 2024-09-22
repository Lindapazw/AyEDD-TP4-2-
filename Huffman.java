
// Archivo: Huffman.java
// Alumno: Linda Paz
// Legajo: VINF013378
// DNI: 42379854

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

public class Huffman {
    // Tamaño máximo para la tabla de códigos (256 para todos los caracteres ASCII)
    static final int TAMANIO_TABLA = 256;
    
    // Array para almacenar los códigos generados
    static String[] TablaHuffmanCodigos = new String[TAMANIO_TABLA]; 

    // Método recursivo para generar los códigos de Huffman
    public static void GenerarCodigosDeHuffman_recursivo(NodoArbol AUXNODORAIZ, String codigo) {
        try {
            if (AUXNODORAIZ == null) {
                return; // No hay más nodos por recorrer
            }

            // Si llegamos a una hoja, almacenamos el código en la tabla
            if (AUXNODORAIZ.esHoja()) {
                TablaHuffmanCodigos[AUXNODORAIZ.simbolo] = codigo;
                return;
            }

            // Llamada recursiva para el subárbol izquierdo, concatenando '0'
            GenerarCodigosDeHuffman_recursivo(AUXNODORAIZ.izquierdo, codigo + "0");

            // Llamada recursiva para el subárbol derecho, concatenando '1'
            GenerarCodigosDeHuffman_recursivo(AUXNODORAIZ.derecho, codigo + "1");
        } catch (Exception e) {
            System.out.println("Error al generar los códigos de Huffman: " + e.getMessage());
        }
    }

    // Método para guardar la tabla de códigos en un archivo
    public static void GuardarTabla(String[] tabla) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter("tabla_huffman.txt"))) {
            for (int i = 0; i < tabla.length; i++) {
                if (tabla[i] != null) {
                    writer.write((char) i + ":" + tabla[i]);
                    writer.newLine();
                }
            }
        } catch (IOException e) {
            System.out.println("Error al guardar la tabla: " + e.getMessage());
        }
    }

    // Método principal para probar la generación de códigos
    public static void main(String[] args) {
        try {
            // Ejemplo de construcción manual del árbol de Huffman para fines de prueba
            NodoArbol raiz = new NodoArbol('*', 100); // Nodo raíz sin símbolo, solo frecuencia
            raiz.izquierdo = new NodoArbol('A', 45);
            raiz.derecho = new NodoArbol('*', 55);
            raiz.derecho.izquierdo = new NodoArbol('B', 25);
            raiz.derecho.derecho = new NodoArbol('C', 30);

            // Generamos los códigos de Huffman
            GenerarCodigosDeHuffman_recursivo(raiz, "");

            // Imprimimos los códigos generados
            for (int i = 0; i < TablaHuffmanCodigos.length; i++) {
                if (TablaHuffmanCodigos[i] != null) {
                    System.out.println("Símbolo: " + (char) i + " -> Código: " + TablaHuffmanCodigos[i]);
                }
            }

            // Guardar la tabla de códigos generada en un archivo
            GuardarTabla(TablaHuffmanCodigos);

        } catch (Exception e) {
            System.out.println("Error en el método principal: " + e.getMessage());
        }
    }
}

// Definición del Nodo del Árbol de Huffman
class NodoArbol {
    char simbolo;
    int frecuencia;
    NodoArbol izquierdo;
    NodoArbol derecho;

    // Constructor
    public NodoArbol(char simbolo, int frecuencia) {
        this.simbolo = simbolo;
        this.frecuencia = frecuencia;
        this.izquierdo = null;
        this.derecho = null;
    }

    // Método para verificar si es una hoja
    public boolean esHoja() {
        return (this.izquierdo == null && this.derecho == null);
    }
}
