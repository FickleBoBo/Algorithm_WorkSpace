package day_01.BOJ_G4_9252;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        // Scanner를 이용한 풀이
        Scanner sc = new Scanner(System.in);
        char[] arr1 = sc.next().toCharArray();
        char[] arr2 = sc.next().toCharArray();
        int len1 = arr1.length;
        int len2 = arr2.length;

        int[][] dp = new int[1+len1][1+len2];

        for(int i=1 ; i<=len1 ; i++){
            for(int j=1 ; j<=len2 ; j++){

                // 새로 추가되는 문자가 서로 동일하면 길이 + 1
                if(arr1[i-1] == arr2[j-1]){
                    dp[i][j] = dp[i-1][j-1] + 1;
                }
                // 새로 추가되는 문자가 서로 다르면 지금까지 구한 길이
                else{
                    dp[i][j] = Math.max(dp[i-1][j], dp[i][j-1]);
                }
            }
        }

        // 실제 LCS를 저장하는 배열
        char[] lcs = new char[dp[len1][len2]];
        int r = len1;
        int c = len2;
        int idx = lcs.length - 1;
        while(idx >= 0){
            if(dp[r][c] == dp[r-1][c]){
                r--;
            }
            else if(dp[r][c] == dp[r][c-1]){
                c--;
            }
            else{
                lcs[idx] = arr1[r-1];
                r--;
                c--;
                idx--;
            }
        }

        System.out.println(lcs.length);
        for(int i=0 ; i<lcs.length ; i++){
            System.out.print(lcs[i]);
        }
    }
}
