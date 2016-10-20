/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package O_de_um;


/**
 *
 * @author Gomes
 */
public class Algoritmo {
    
    public static final int DIAMETRO_MAX = 10;
    public static final int ESCALA = DIAMETRO_MAX / 5;

    public static final boolean primo(int n) {
        for (int i = 2; n <= 1 || i < n / 2; i++) {
            if (n <= 1 || n % i == 0) {
                return false;
            }
        }
        return true;
    }

    public static final int decompositor(int n) {
        int retorno = 2;// todos são divisiveis por ele mesmo e 1
        for (int div = 2; div <= n / 2; div++) {
            if (n % div == 0) {
                retorno++;
            }
        }
        return retorno;
    }

    public static final Ponto retorno(int n) {
        int raizDeN = (int) Math.sqrt(n),
                variante_do_lado = 0,
                n_conhecido = 0;
        if (raizDeN % 2 == 1) {//impar
            variante_do_lado = (int) Math.round(raizDeN / 2.0);
            n_conhecido = (int) Math.pow(raizDeN, 2);
            if (n >= n_conhecido + (2 * variante_do_lado)) {//quadrante 2
//                System.out.println("quadrante 2");
                n_conhecido += (2 * variante_do_lado) - 1;
                return new Ponto(-variante_do_lado, variante_do_lado - (n - n_conhecido));
            } else {//quadrante 1
//                System.out.println("quadrante 1");
                return new Ponto(variante_do_lado - (n - n_conhecido) - 1, variante_do_lado);
            }
        } else {//par 
            variante_do_lado = raizDeN / 2;
            n_conhecido = (int) Math.pow(raizDeN, 2);
            if (n >= n_conhecido + (2 * variante_do_lado)) {//quadrante 4
//                System.out.println("quadrante 4");
                n_conhecido += (2 * variante_do_lado);
                return new Ponto(variante_do_lado, -variante_do_lado + (n - n_conhecido));
            } else {//quadrante 3
//                System.out.println("quadrante 3");
                return new Ponto(-variante_do_lado + (n - n_conhecido), -variante_do_lado);
            }
        }
    }

    public static void main(String[] args) {
        for (int i = 0; i < Integer.MAX_VALUE; i++) {
            System.out.println(retorno(i).toString(i));
        }
    }
}
