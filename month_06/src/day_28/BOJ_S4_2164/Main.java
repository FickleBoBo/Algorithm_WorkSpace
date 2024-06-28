package day_28.BOJ_S4_2164;

import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();

        Queue<Integer> q = new ArrayDeque<>();
        for(int i=1 ; i<=N ; i++){
            q.offer(i);
        }

        while(q.size() > 1){
            q.poll();
            q.offer(q.poll());
        }

        System.out.println(q.poll());
    }
}
