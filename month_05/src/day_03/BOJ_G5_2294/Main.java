package day_03.BOJ_G5_2294;

import java.util.Arrays;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int k = sc.nextInt();
        int[] arr = new int[1+n];
        for(int i=1 ; i<=n ; i++){
            arr[i] = sc.nextInt();
        }
        Arrays.sort(arr);

        int[][] dp = new int[1+n][1+k];

        for(int i=1 ; i<=n ; i++){
            for(int j=1 ; j<=k ; j++){
                if(j%arr[i]==0){
                    dp[i][j] = j / arr[i];
                }
                else{
                    if(arr[i] > j){
                        dp[i][j] = dp[i-1][j];
                    }
                    else{
                        if(dp[i-1][j]==0 && dp[i][j-arr[i]]==0){
                            //
                        }
                        else if(dp[i-1][j]==0){
                            dp[i][j] = dp[i][j-arr[i]]+1;
                        }
                        else if(dp[i][j-arr[i]]==0){
                            dp[i][j] = dp[i-1][j];
                        }
                        else{
                            dp[i][j] = Math.min(dp[i-1][j], dp[i][j-arr[i]]+1);
                        }

                    }
                }

            }
        }

//        for(int i=0 ; i<=n ; i++){
//            for(int j=0 ; j<=k ; j++){
//                System.out.print(dp[i][j] + " ");
//            }
//            System.out.println();
//        }

        if(dp[n][k] != 0) System.out.println(dp[n][k]);
        else System.out.println(-1);
    }
}
