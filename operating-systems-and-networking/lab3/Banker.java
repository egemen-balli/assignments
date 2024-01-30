//Egemen Balli 30 Oct 2023
public class Banker {
    int n = 5;
    int m = 5;
    int maxMatrix[][] = new int[][] {
            {7, 5, 3, 3, 6},
            {3, 2, 2, 2, 3},
            {9, 0, 2, 2, 2},
            {4, 3, 3, 3, 4},
            {5, 3, 3, 3, 5}
    };
    int allocMatrix[][] = new int[][] {
            {0, 1, 0, 0, 0},
            {2, 0, 0, 1, 1},
            {3, 0, 2, 1, 0},
            {0, 0, 2, 2, 1},
            {0, 0, 3, 0, 0}
    };
    int total[] = {10, 5, 10, 8, 9};
    int available[] = new int[m];
    int need[][] = new int[n][m];
    int safeSequence[] = new int[n];

    void displayMatrix(int matrix[][]) {
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                System.out.print(matrix[i][j] + " ");
            }
            System.out.println();
        }
        System.out.println();
    }

    void calculateNeed() {
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                need[i][j] = maxMatrix[i][j] - allocMatrix[i][j];
            }
        }
    }

    void isSafe() {
        int count = 0;

        boolean visited[] = new boolean[n];
        for (int i = 0; i < n; i++) {
            visited[i] = false;
        }

        int work[] = new int[m];
        for (int i = 0; i < m; i++) {
            work[i] = available[i];
        }

        while (count < n) {
            boolean flag = false;
            for (int i = 0; i < n; i++) {
                if (visited[i] == false) {
                    int j;
                    for (j = 0; j < m; j++) {
                        if (need[i][j] > work[j]) break;
                    }
                    if (j == m) {
                        safeSequence[count] = i;
                        count++;
                        visited[i] = true;
                        flag=true;
                        for (j = 0; j < m; j++) {
                            work[j] = work[j] + allocMatrix[i][j];
                        }
                    }
                }
            }
            if (flag == false) {
                break;
            }
        }

        if (count < n) {
            System.out.println("System is Unsafe!");
        } else {
            System.out.println("Safe Sequence:");
            for (int i = 0; i < n; i++) {
                System.out.print("P" + safeSequence[i]);
                if (i != n - 1) System.out.print(" -> ");
            }
            System.out.println("\nSystem is safe.");
        }
    }

    public static void main(String[] args) {
        Banker banker = new Banker();
        banker.calculateNeed();
        System.out.println("Maximum Matrix:");
        banker.displayMatrix(banker.maxMatrix);
        System.out.println("Allocated Matrix:");
        banker.displayMatrix(banker.allocMatrix);

        System.out.println("Total Resources:");
        for(int a:banker.total){
            System.out.print(a + " ");
        }
        System.out.println();
        System.out.println();

        for (int i = 0; i < banker.n; i++) {
            for (int j = 0; j < banker.m; j++) {
                banker.total[j] -= banker.allocMatrix[i][j];
            }
        }

        for (int i = 0; i < banker.m; i++){
            banker.available[i] += banker.total[i];
        }

        System.out.println("Available Resources:");
        for(int a:banker.available){
            System.out.print(a + " ");
        }
        System.out.println();
        System.out.println();

        banker.isSafe();
    }
}
