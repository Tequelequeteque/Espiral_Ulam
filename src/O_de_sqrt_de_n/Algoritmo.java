/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package O_de_sqrt_de_n;

import java.util.LinkedList;

/**
 *
 * @author Gomes
 */
public class Algoritmo {

    public static final Ponto retorno(int n) {
        int raizDeN = (int) Math.sqrt(n),
                variante_do_lado = 0,
                n_conhecido = 0;
        LinkedList<Ponto> lista = new LinkedList<Ponto>();
        if (raizDeN % 2 == 1) {//impar
            variante_do_lado = (int) Math.round(raizDeN / 2.0);
            n_conhecido = (int) Math.pow(raizDeN, 2);
            if (n >= n_conhecido + (2 * variante_do_lado) - 1) {//quadrante 2
//                System.out.println("quadrante 2");
                n_conhecido += (2 * variante_do_lado) - 1;
                for (int y = variante_do_lado; y >= -variante_do_lado && n_conhecido <= n; y--, n_conhecido++) {
                    lista.addLast(new Ponto(-variante_do_lado, y));
                }
            } else {//quadrante 1
//                System.out.println("quadrante 1");
                for (int x = variante_do_lado - 1; x >= -variante_do_lado && n_conhecido <= n; x--, n_conhecido++) {
                    lista.addLast(new Ponto(x, variante_do_lado));
                }
            }
        } else {//par 
            variante_do_lado = raizDeN / 2;
            n_conhecido = (int) Math.pow(raizDeN, 2);
            if (n >= n_conhecido + (2 * variante_do_lado)) {//quadrante 4
//                System.out.println("quadrante 4");
                n_conhecido += (2 * variante_do_lado);
                for (int y = -variante_do_lado; y <= variante_do_lado && n_conhecido <= n; y++, n_conhecido++) {
                    lista.addLast(new Ponto(variante_do_lado, y));
                }
            } else {//quadrante 3
//                System.out.println("quadrante 3");
                for (int j = -variante_do_lado; j <= variante_do_lado && n_conhecido <= n; j++, n_conhecido++) {
                    lista.addLast(new Ponto(j, -variante_do_lado));
                }
            }
        }
//        System.out.println(lista.size());
        return lista.getLast();
    }

    public static void main(String[] args) {
        for (int i = 0; i < 10; i++) {
            System.out.println(retorno(i).toString(i));
        }
    }
}
