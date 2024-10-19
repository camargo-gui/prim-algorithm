public class Main {
    public static void main(String[] args) {
        Matriz matriz = Arquivo.converterParaMatriz("src/grafo.txt");
        System.out.printf("Árvore geradora mínima:\n%s", matriz.primAlgorithm());
    }
}