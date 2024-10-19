import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class Arquivo {

    public static Matriz converterParaMatriz(String caminhoArquivo) {
        List<int[]> linhas = new ArrayList<>();
        try (BufferedReader br = new BufferedReader(new FileReader(caminhoArquivo))) {
            br.readLine();

            String linha;
            while ((linha = br.readLine()) != null) {
                String[] valores = linha.trim().split("\\s+");

                int[] numeros = new int[valores.length];
                for (int i = 0; i < valores.length; i++) {
                    numeros[i] = Integer.parseInt(valores[i]);
                }
                linhas.add(numeros);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        int[][] matriz = new int[linhas.size()][];
        for (int i = 0; i < linhas.size(); i++) {
            matriz[i] = linhas.get(i);
        }

        return new Matriz(matriz);
    }
}
