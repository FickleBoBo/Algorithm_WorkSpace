package day_23.BOJ_S3_15649;

import java.util.Scanner;

public class Main {

    static StringBuilder sb = new StringBuilder();
    static int N;
    static int M;
    static int[] arr;
    static int[] sel;
    static boolean[] visited;

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        N = sc.nextInt();
        M = sc.nextInt();
        arr = new int[N];
        sel = new int[M];
        visited = new boolean[N];

        permutation(0);

        System.out.print(sb.toString());

    }

    private static void permutation(int sidx){
        if(sidx == M){
            for(int i=0 ; i<M ; i++){
                sb.append(sel[i] + " ");
            }
            sb.append("\n");
            return;
        }

        for(int i=0 ; i<N ; i++){
            if(!visited[i]){
                sel[sidx] = i+1;
                visited[i] = true;
                permutation(sidx+1);
                visited[i] = false;
            }

        }

    }

}
