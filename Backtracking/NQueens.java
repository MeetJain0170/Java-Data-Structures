import java.util.List;
import java.util.ArrayList;
import java.util.Scanner;

public class NQueens {
    public static void QueensUtil(int j, int n, List<Integer>board, boolean[]rows, boolean[]diag1, boolean[] diag2, List<List<Integer>> result){
        if(j>n){
            result.add(new ArrayList<>(board));
            return;
        }
        for(int i=1; i<=n; i++){
            if(!rows[i] && !diag1[i+j]&& !diag2[i-j+n]){
                board.add(i);
                rows[i]=true;
                diag1[i+j]=true;
                diag2[i-j+n]=true;
                QueensUtil(j+1, n, board, rows, diag1, diag2, result);

                board.remove(board.size()-1);
                rows[i]=false;
                diag1[i+j]=false;
                diag2[i-j+n]=false;
            }
        }
    }
    public static List<List<Integer>> nQueens(int n){
        List<List<Integer>> result= new ArrayList<>();
        List<Integer>board=new ArrayList<>();
        boolean[]rows=new boolean[n+1];
        boolean[]diag1=new boolean[2*n+1];
        boolean[]diag2=new boolean[2*n+1];
        
        QueensUtil(1, n, board, rows, diag1, diag2, result);
        return result;
    }
    public static void printBoards(List<List<Integer>> solutions, int n) {
        int count = 1;
        for (List<Integer> board : solutions) {
            System.out.println("Solution #" + count++);
            for (int row : board) {
                for (int i = 1; i <= n; i++) {
                    if (i == row) System.out.print("Q ");
                    else System.out.print(". ");
                }
                System.out.println();
            }
            System.out.println();
        }
    }    
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Give the dimension of the board: ");
        int n = sc.nextInt();
        List<List<Integer>> result=nQueens(n);
        printBoards(result, n);
        sc.close();
    }
}
