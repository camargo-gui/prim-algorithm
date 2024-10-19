public class Matriz {
    private final int[][] matriz;

    public Matriz(int[][] matriz) {
        this.matriz = matriz;
    }

    public String primAlgorithm() {
        int n = matriz.length;
        int[] parent = new int[n];
        int[] key = new int[n];
        boolean[] ocultos = new boolean[n];
        
        for (int i = 0; i < n; i++) {
            key[i] = Integer.MAX_VALUE;
            ocultos[i] = false;
        }

        key[0] = 0;
        parent[0] = -1;
        
        for (int i = 0; i < n - 1; i++) {
            int u = buscaMenor(key, ocultos);
            ocultos[u] = true;

            for (int v = 0; v < n; v++) {
                if (matriz[u][v] != 0 && !ocultos[v] && matriz[u][v] < key[v]) {
                    parent[v] = u;
                    key[v] = matriz[u][v];
                }
            }
        }

        return printAGM(parent, n);
    }
    
    private String printAGM(int[] parent, int n) {
        StringBuilder sb = new StringBuilder();
        sb.append(String.format("%-10s %-10s %-10s\n", "Vértice", "Aresta", "Peso"));

        for (int i = 1; i < n; i++) {
            char from = (char) ('A' + parent[i]);
            char to = (char) ('A' + i);
            sb.append(String.format("%-10c %-10c %-10d\n", from, to, matriz[i][parent[i]]));
        }

        int total = 0;
        for (int i = 1; i < n; i++) {
            total += matriz[i][parent[i]];
        }
        sb.append(String.format("Peso total: %d\n", total));

        return sb.toString();
    }
    
    private int buscaMenor(int[] key, boolean[] mstSet) {
        int min = Integer.MAX_VALUE;
        int minIndex = -1;

        for (int v = 0; v < matriz.length; v++) {
            if (!mstSet[v] && key[v] < min) {
                min = key[v];
                minIndex = v;
            }
        }

        return minIndex;
    }
}
