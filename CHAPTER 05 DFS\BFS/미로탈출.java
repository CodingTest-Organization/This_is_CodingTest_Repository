package dfsorbfs;

/*		미로 탈출
		시간 제한 1초 | 메모리 제한 128MB

		동빈이는 N X M크기의 직사각형 형태의 미로에 갖혀 있다. 미로에는 여러 마리의 괴물이 있어 이를 피해야 한다.
		동빈이의 위치는 (1,1)이고 미로의 출구는 (N,M)의 위치에 존재하며 한번에 한 칸 씩 이동할 수 있다.
		이때 괴물이 있는 부분은 0이고, 괴물이 없는 부분은 1로 표시되어 있다. 미로는 반드시 탈출할 수 있는 형태로 제시된다.
		이때 동빈이가 탈출하기 위해 움직여야 하는 최소칸의 갯수를 구하시오. 칸을 셀 때는 시작 칸과 마지막칸을 모두 포함해서 게산한다.

		입력 조건
		첫째 줄에 두 정수 N,M(4<=N, M<=200)이 주어집니다. 다음 N개의 줄에는 각각 M개의 정수 혹은(0,혹은 1)로 미로의 정보가 주어진다.
		각각의 수들은 공백 없이 붙어서 입력으로 제시된다.
		또한 시작칸과 마지막칸은 항상 1이다.
		출력 조건

		첫째 줄에 최소 이동 칸의 개수를 출력한다.
		입력 예시1	출력 예시1
		5 6
		1 0 1 0 1 0
		1 1 1 1 1 1
		0 0 0 0 0 1
		1 1 1 1 1 1
		1 1 1 1 1 1		10
		*/


import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Main01 {

	static final int[] moveX = {-1, 0, 1, 0};
	static final int[] moveY = {0, -1, 0, 1};

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt(); // 도착지 x
		int m = sc.nextInt(); // 도착지 y
		boolean[][] visited = new boolean[n][m]; // 방문한곳 추적
		int[][] moved = new int[n][m]; // 이동한 장소에 이동한 횟수를 누적
		int[][] map = new int[n][m]; // 미로지도
		for(int i=0; i<n; i++) {
			for (int j = 0; j < m; j++) {
				map[i][j] = sc.nextInt();
			}
		}

		////////
		Queue<int[]> q = new LinkedList<>();
		q.add(new int[]{0, 0});
		moved[0][0] = 1; // 처음 시작위치도 count

		while(!q.isEmpty()){ // 큐가 비어질때까지.
			int[] xy = q.poll();
			for(int i=0; i<4; i++){ // 동서남북 = 4번
				int x = xy[0]; // 현재좌표 x
				int y = xy[1]; // 현재좌표 y
				int nextX = x + moveX[i]; // 현재좌표 + 이동할 좌표 x (동서남북)
				int nextY = y + moveY[i]; // 현재좌표 + 이동할 좌표 y (동서남북)

				if (nextX < 0 || nextY < 0 || nextX >= n || nextY >= m) continue; // 이동할 좌표가 배열(map)의 index를 넘어섰을 경우.
				if (visited[nextX][nextY] || map[nextX][nextY] == 0) continue;    // 이동할 좌표에 방문한적 있을 경우, 괴물을 만났을 경우.
				q.add(new int[]{nextX, nextY}); // 다음에 방문할 장소 add
				moved[nextX][nextY] = moved[x][y] + 1; // 다음에 방문한 곳에 이동한 횟수 저장
				visited[nextX][nextY] = true; // 방문완료 표시
			}// end for
		}// end while

		System.out.println("-----------");
		System.out.println(moved[n-1][m-1]);
	}// end main



}
