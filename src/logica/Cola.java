/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package logica;

/**
 *
 * @author Nicolas
 * @param <T>
 */
public class Cola<T> {

    public static int tamanoMax;
    public static Object[] colaVector;
    public static int frente;
    public static int atras;
    public static int tamanoActual;

    public Cola(int tamano) {

        tamanoMax = tamano;
        colaVector = new Object[tamanoMax];
        frente = 0;
        atras = -1;
        tamanoActual = 0;
    }

    public void offer(T valor) {
        if (estaLlena()) {
            System.out.println("Cola llena. No se pueden insertar");
            return;
        }
        atras = (atras + 1) % tamanoMax;
        colaVector[atras] = valor;
        tamanoActual++;

    }

    public T pop() {

        if (estaVacia()) {
            System.out.println("Cola vacia. No se pueden eliminar");
            return null;
        }
        T eliminado = (T) colaVector[frente];
        frente = (frente + 1) % tamanoMax;
        tamanoActual--;
        return eliminado;

    }

    public T peek() {

        if (estaVacia()) {
            System.out.println("Cola vacia. No hay elementos para consultar");
            return null;
        }

        return (T) colaVector[frente];
    }

    public boolean estaLlena() {
        return tamanoActual == tamanoMax;
    }

    public boolean estaVacia() {
        return tamanoActual == 0;
    }

    public int size() {
        return tamanoActual;
    }

    public void mostrar() {
        if (estaVacia()) {
            System.out.println("Cola vacia");
            return;
        }
        int i = frente;
        for (int count = 0; count < tamanoActual; count++) {
            System.out.print(colaVector[i] + " ");
            i = (i + 1) % tamanoMax;
        }
        System.out.println();
    }

    public String aString() {
        String result = "";
        int i = frente;
        for (int count = 0; count < tamanoActual; count++) {
            result += colaVector[i] + " ";
            i = (i + 1) % tamanoMax;
        }
        return result;
    }

}
