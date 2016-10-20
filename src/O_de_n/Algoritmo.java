/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package O_de_n;

/**
 *
 * @author Gomes
 */
public class Algoritmo {
    public static final Ponto retorno(int n) {
        Ponto[] lista = new Ponto[n+1];
        lista[0] = new Ponto(0, 0);
        int variante_do_lado = 1;
        for (int n_conhecido = 1; n_conhecido <= n;variante_do_lado++) {
            for (int x = variante_do_lado - 1; x >= -variante_do_lado && n_conhecido <= n; x--) {
                lista[n_conhecido++] = new Ponto(x, variante_do_lado);
            }
            for (int y = variante_do_lado - 1; y >= -variante_do_lado && n_conhecido <= n; y--) {
                lista[n_conhecido++] = new Ponto(-variante_do_lado, y);
            }
            for (int j = -variante_do_lado + 1; j <= variante_do_lado && n_conhecido <= n; j++) {
                lista[n_conhecido++] = new Ponto(j, -variante_do_lado);
            }
            for (int y = -variante_do_lado + 1; y <= variante_do_lado && n_conhecido <= n; y++) {
                lista[n_conhecido++] = new Ponto(variante_do_lado, y);
            }
        }
        return lista[lista.length - 1];
    }

    public static void main(String[] args) {
       for (int i = 0; i < 10001; i++) {
            System.out.println(retorno(i).toString(i));
        }
    }
}
