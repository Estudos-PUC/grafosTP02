public class App {
    public static void main(String[] args) throws Exception {
        Matriz matriz = new Matriz();
        String arquivo = "arquivos/pmed1.txt"; // Nome do arquivo de dados a ser lido
        matriz.gerarMatrizCusto(arquivo);
        matriz.imprimirMatrizArq("teste.txt");
        ForcaBruta FB = new ForcaBruta(matriz);
        FB.gerarCombinacoes();
    }
}
