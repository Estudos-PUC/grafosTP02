
public class ForcaBruta {
    private Matriz matriz;
    private int raio = Integer.MAX_VALUE;
    private static int numCombinacoes = 0;

    public ForcaBruta(Matriz matriz) {
        this.matriz = matriz;
    }

    public void gerarCombinacoes() {
        int escolher = matriz.getNumCentros();
        int totalElementos = matriz.getNumVertices();
        int[] combinacaoAtual = new int[escolher];
        int raioAtual = Integer.MAX_VALUE;
        gerarCombinacoesRecursivamente(1, totalElementos, 0, combinacaoAtual, 0, raioAtual);
        System.out.println(numCombinacoes);
        System.out.println(raio);
    }

    private  void gerarCombinacoesRecursivamente(int inicio, int fim, int indiceAtual, int[] combinacaoAtual,
                                                       int indiceCombinacao, int raioAtual) {
        if (indiceCombinacao == combinacaoAtual.length) {
            numCombinacoes++;
            raioAtual = getRaio(combinacaoAtual);
            if(raioAtual < raio) {
                raio = raioAtual;
            }
            return;
        }

        if (indiceAtual == fim - combinacaoAtual.length + indiceCombinacao + 1) {
            return;
        }

        combinacaoAtual[indiceCombinacao] = indiceAtual;
        gerarCombinacoesRecursivamente(inicio, fim, indiceAtual + 1, combinacaoAtual, indiceCombinacao + 1, raioAtual);
        gerarCombinacoesRecursivamente(inicio, fim, indiceAtual + 1, combinacaoAtual, indiceCombinacao, raioAtual);
    }

    private int getRaio(int[] combinacaoAtual) {
        int raioAtual = -1;
        for (int i : combinacaoAtual) {
            for (int j = 1; j < matriz.getNumVertices(); j++) {
                if(matriz.matrizCusto[i][j] > raioAtual) {
                    raioAtual = matriz.matrizCusto[i][j];
                }
            }
        }
        return raioAtual;
    }
}
