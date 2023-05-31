public class App {
    public static void main(String[] args) throws Exception {
        Matriz matriz = new Matriz();
        String arquivo = "arquivos/pmed40.txt"; // Nome do arquivo de dados a ser lido
        matriz.gerarMatrizCusto(arquivo);

        //ForcaBruta FB = new ForcaBruta(matriz);
        //FB.gerarCombinacoes();

        Gon gon = new Gon(matriz);
        gon.GonAlgo();
    }
}
