/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package O_de_um;

import static GUI.Desenhos.primo;

/**
 *
 * @author Gomes
 */
public class Algoritmo {

    public static final Ponto retorno(int n) {
        int raizDeN = (int) Math.sqrt(n),
                raio_do_quadrado = 0,
                n_conhecido = 0;
        if (raizDeN % 2 == 1) {//impar
            raio_do_quadrado = (int) Math.round(raizDeN / 2.0);
            n_conhecido = (int) Math.pow(raizDeN, 2);
            if (n >= n_conhecido + (2 * raio_do_quadrado)) {//quadrante 2
//                System.out.println("quadrante 2");
                n_conhecido += (2 * raio_do_quadrado) - 1;
                return new Ponto(-raio_do_quadrado, raio_do_quadrado - (n - n_conhecido));
            } else {//quadrante 1
//                System.out.println("quadrante 1");
                return new Ponto(raio_do_quadrado - (n - n_conhecido) - 1, raio_do_quadrado);
            }
        } else {//par 
            raio_do_quadrado = raizDeN / 2;
            n_conhecido = (int) Math.pow(raizDeN, 2);
            if (n >= n_conhecido + (2 * raio_do_quadrado)) {//quadrante 4
//                System.out.println("quadrante 4");
                n_conhecido += (2 * raio_do_quadrado);
                return new Ponto(raio_do_quadrado, -raio_do_quadrado + (n - n_conhecido));
            } else {//quadrante 3
//                System.out.println("quadrante 3");
                return new Ponto(-raio_do_quadrado + (n - n_conhecido), -raio_do_quadrado);
            }
        }
    }

    public static void main(String[] args) {
        for (int i = 0; i < 10; i++) {
            System.out.println(retorno(i).toString(i));
        }
        System.out.println(primo(6));
    }
}
