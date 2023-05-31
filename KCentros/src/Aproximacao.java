import java.util.ArrayList;
import java.util.List;

public class Aproximacao {
    private Matriz matriz;
    private int raio;
    private int numCentros;
    private List<Integer> centros;

    public Aproximacao(Matriz matriz) {
        this.matriz = matriz;
        this.raio = Integer.MAX_VALUE;
        this.numCentros = matriz.getNumCentros();
        this.centros = new ArrayList<>();
    }

    public void GonAlgo() {
        int c1 = 1;
        centros.add(c1);
        
        for(int i = 1; i < numCentros; i++) {
            System.out.println(i);
        }
    }
}
