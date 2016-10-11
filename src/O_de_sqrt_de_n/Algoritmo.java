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
                raio_do_quadrado = 0,
                n_conhecido = 0;
        LinkedList<Ponto> lista = new LinkedList<Ponto>();
        if (raizDeN % 2 == 1) {//impar
            raio_do_quadrado = (int) Math.round(raizDeN / 2.0);
            n_conhecido = (int) Math.pow(raizDeN, 2);
            if (n >= n_conhecido + (2 * raio_do_quadrado) - 1) {//quadrante 2
//                System.out.println("quadrante 2");
                n_conhecido += (2 * raio_do_quadrado) - 1;
                for (int y = raio_do_quadrado; y >= -raio_do_quadrado && n_conhecido <= n; y--, n_conhecido++) {
                    lista.addLast(new Ponto(-raio_do_quadrado, y));
                }
            } else {//quadrante 1
//                System.out.println("quadrante 1");
                for (int x = raio_do_quadrado - 1; x >= -raio_do_quadrado && n_conhecido <= n; x--, n_conhecido++) {
                    lista.addLast(new Ponto(x, raio_do_quadrado));
                }
            }
        } else {//par 
            raio_do_quadrado = raizDeN / 2;
            n_conhecido = (int) Math.pow(raizDeN, 2);
            if (n >= n_conhecido + (2 * raio_do_quadrado)) {//quadrante 4
//                System.out.println("quadrante 4");
                n_conhecido += (2 * raio_do_quadrado);
                for (int y = -raio_do_quadrado; y <= raio_do_quadrado && n_conhecido <= n; y++, n_conhecido++) {
                    lista.addLast(new Ponto(raio_do_quadrado, y));
                }
            } else {//quadrante 3
//                System.out.println("quadrante 3");
                for (int j = -raio_do_quadrado; j <= raio_do_quadrado && n_conhecido <= n; j++, n_conhecido++) {
                    lista.addLast(new Ponto(j, -raio_do_quadrado));
                }
            }
        }
//        System.out.println(lista.size());
        return lista.getLast();
    }

    public static void main(String[] args) {
        for (int i = 0; i < 10001; i++) {
            System.out.println(retorno(i).toString(i));
        }
    }
}
