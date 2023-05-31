import java.util.HashSet;
import java.util.Random;
import java.util.Set;

public class Gon {
    private Matriz matriz;
    private int raio = Integer.MAX_VALUE;
    private int numCentros;
    private Set<Integer> centros;

    public Gon(Matriz matriz) {
        this.matriz = matriz;
        this.numCentros = matriz.getNumCentros();
        this.centros = new HashSet<>();
    }

    public void GonAlgo() {
        Random random = new Random();
        int c1 = random.nextInt(matriz.getNumVertices() - 1) + 1;
        centros.add(c1);

        for (int i = 1; i < numCentros; i++) {
            executar();
        }

        calcularRaio();
        System.out.println(raio);
    }

    private void executar() {
        int maxDist = Integer.MIN_VALUE;
        int novoCentro = -1;

        for (int vertice = 1; vertice <= matriz.getNumVertices(); vertice++) {
            if (centros.contains(vertice)) {
                continue; // Ignorar vértices já selecionados como centros
            }

            int distMax = Integer.MAX_VALUE;
            for (Integer centro : centros) {
                int dist = matriz.matrizCusto[centro][vertice];
                distMax = Math.min(distMax, dist);
            }

            if (distMax > maxDist) {
                maxDist = distMax;
                novoCentro = vertice;
            }
        }

        centros.add(novoCentro);
    }

    private void calcularRaio() {
        int raioAtual = Integer.MIN_VALUE;
        // percorrer vertices da matriz de custo
        for (int i = 1; i <= matriz.getNumVertices(); i++) {
            int minDist = Integer.MAX_VALUE; 
            // calcular a qual centro o vertice esta ligado, percorrendo os centros
            for (Integer centro : centros) {
                // se a distancia do vertice para aquele centro for menor do que a definida previamente, atualizar
                minDist = Math.min(minDist, matriz.matrizCusto[i][centro]); 
            }
            // se a distancia definida entre o vertice e seu centro e maior que o raio atual (da combinacao), atualizar valor do raio atual
            raioAtual = Math.max(raioAtual, minDist); 
        }
        // se o raio da combinacao (atual) e menor do que o raio da solucao, atualizar valor da solucao
        raio = Math.min(raio, raioAtual);
    }
}
