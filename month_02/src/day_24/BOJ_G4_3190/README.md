https://www.acmicpc.net/problem/3190

# 🔍 뱀
- 설계 시간 : 2min
- 구현 시간 : 104min
- 난이도 : 골드 4
- 알고리즘 : Dequeue
- 코드 길이 : 2191B
- 실행 시간 : 144ms(제한 1초)
- 메모리 : 13840KB

---

# 💡 아이디어

- 필요한 변수가 많다고 느꼈고 디버깅이 어려울 것 같아서 천천히 해봄
  - 맵에서 빈 곳은 0 / 뱀이 있는 곳은 -1 / 사과가 있는 곳은 1로 설정
  - 맵의 현황과 각종 데이터를 출력할 printMap 메서드 만듦
- 뱀의 머리와 꼬리에 대한 정보를 항상 들고 있어야 하므로 Dequeue 자료구조를 생각해봄
  - 뱀의 머리는 진행방향, 사과, 종료조건
  - 뱀의 꼬리는 삭제 or 유지
- 게임을 계속할지 판단하는 메소드와 뱀을 움직이는 메소드에 파라미터 넣기가 복잡해서 그냥 전부 static 변수로 만듦
- 회전때문에 델타배열이 필요했는데 이때 상우하좌 처럼 시계 or 반시계 방향으로 넣어줘야 % 연산으로 회전할 인덱스로 접근 가능

---

# 🧠 어려웠던 점

- 좀만 꼬여도 망할거 같아서 천천히 잘되는지 체크하며 구현해야해서 피곤했음
- 회전이나 종료에 대해서 초를 언제로 체크할지가 헷갈려서 피곤했음

---

# 🧐 좋은 풀이

- 다 비슷한듯