package day_28.BOJ_G3_1005;

import java.util.*;

public class Main {
    public static void main(String[] args) {
        // Scanner 풀이
        Scanner sc = new Scanner(System.in);

        int T = sc.nextInt();
        for(int tc=1 ; tc<=T ; tc++){

            // 1. 입력 받기
            int N = sc.nextInt();
            int K = sc.nextInt();

            int[] Darr = new int[1+N];    // 각 건물당 건설에 걸리는 시간을 저장한 배열
            for(int i=1 ; i<=N ; i++){
                Darr[i] = sc.nextInt();
            }

            List<Integer>[] adj = new ArrayList[1+N];    // 인접리스트로 건물의 연결관계 저장
            for(int i=1 ; i<=N ; i++){
                adj[i] = new ArrayList<>();
            }
            int[] degree = new int[1+N];    // 진입차수를 저장하는 배열

            for(int i=0 ; i<K ; i++){
                int X = sc.nextInt();
                int Y = sc.nextInt();
                adj[X].add(Y);
                degree[Y]++;
            }

            int W = sc.nextInt();    // 승리하기 위해 건설해야 할 건물의 번호



            // 2. 위상 정렬
            Queue<Integer> q = new LinkedList<>();    // queue를 활용한 위상 정렬
            int[] dp = new int[1+N];    // 건물을 건설하는데 걸리는 최소 시간을 저장하는 dp 테이블

            for(int i=1 ; i<=N ; i++){    // 진입차수가 0인 건물(=사전 작업이 없는)을 queue에 넣어줌
                if(degree[i] == 0){
                    q.offer(i);
                    dp[i] = Darr[i];    // 최소 시간을 해당 건물을 건설하는데 걸리는 시간
                }
            }

            while(!q.isEmpty()){    // 위상 정렬이 끝날 때까지
                int item = q.poll();

                for(int next : adj[item]){    // 각각의 다음 작업에 대해서

                    // 해당 건물을 건설하는데 걸리는 최소시간은
                    // A : 현재까지 구한 해당 건물을 건설하기까지 걸리는 시간
                    // B : 선행 건물을 건설하는데 걸린 최소 시간 + 해당 건물을 건설하는데 걸리는 시간
                    // A, B 중 더 작은 값이 해당 건물을 건설하기까지 걸리는 최소 시간
                    dp[next] = Math.max(dp[next], dp[item] + Darr[next]);

                    degree[next]--;    // 진입차수를 하나 줄여줌
                    if(degree[next] == 0){    // 진입차수가 0이 되면 queue에 넣어줌
                        q.offer(next);
                    }
                }
            }

            System.out.println(dp[W]);

        }
        sc.close();
    }
}
