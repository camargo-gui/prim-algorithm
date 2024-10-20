public class Main {
    public static void main(String[] args) {
        Matriz matriz = Arquivo.converterParaMatriz("src/grafo_2.txt");
        System.out.printf("Árvore geradora mínima:\n%s", matriz.primAlgorithm());
    }
}