package hackerearth;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

//https://www.hackerearth.com/practice/basic-programming/recursion/recursion-and-backtracking/practice-problems/algorithm/a-tryst-with-chess/
class ChessTryst {
    public static void main(String args[] ) throws Exception {
        /*BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String testCase[] = br.readLine().split(" ");
        int I = Integer.parseInt(testCase[0]);
        int J = Integer.parseInt(testCase[1]);
        int N = Integer.parseInt(testCase[2]);*/
        int[][] board = new int[10][10];
        //System.out.println(blocks(I, J, N, board));
        System.out.println(blocks(4, 7, 6, board));
    }

    private static int blocks(int I, int J, int N, int board[][]) {
        if (N==0)
            return 0;
        int count = 0;
        Integer moves[] = possibleMoves(I, J, board);
        for(int i = 0; i < moves.length-1; i=i+2) {
            count = count + 1 + blocks(moves[i], moves[i+1], N-1, board);
        }
        return count;
    }

    private static Integer[] possibleMoves(int x, int y, int board[][]) {
        List<Integer> moves = new ArrayList<>();
        if(x-2 >= 0 && y-1 >= 0) {
            moves.add(x-2);
            moves.add(y-1);
        }
        if(x-1 >= 0 && y-2 >= 0) {
            moves.add(x-1);
            moves.add(y-2);
        }
        if(x-2 >= 0 && y+1 < 10) {
            moves.add(x-2);
            moves.add(y+1);
        }
        if(x+1 < 10 && y-2 >= 0) {
            moves.add(x+1);
            moves.add(y-2);
        }
        if(x-1 >= 0 && y+2 < 10) {
            moves.add(x-1);
            moves.add(y+2);
        }
        if(x+2 < 10 && y-1 >= 0) {
            moves.add(x+2);
            moves.add(y-1);
        }
        if(x+1 < 10 && y+2 < 10) {
            moves.add(x+1);
            moves.add(y+2);
        }
        if(x+2 < 10 && y+1 < 10) {
            moves.add(x+2);
            moves.add(y+1);
        }

        Integer[] arr = new Integer[moves.size()];
        return moves.toArray(arr);
    }
}

