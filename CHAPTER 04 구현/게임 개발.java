package implement;

import java.util.Scanner;

// 현재 위치에서 현재 방향을 기준으로 왼쪽 방향(반시계 방향으로 90도 회전한 방향)부터 차례대로 갈 수 있다.
// 캐릭터의 바로 왼쪽 방향에 아직 가보지 않은 칸이 존재한다면, 왼쪽 방향으로 회전한 다음 왼쪽으로 한칸을 전진한다. 왼쪽 방향에 가보지 않은 칸이 없다면, 왼쪽 방향으로만 회전을 수행하고 1단계로 돌아간다.
// 만약 네 방향 모두 이미 가본 칸이거나 바다로 되어 있는 경우에는, 바라보는 방향을 유지한 채로 한 칸 뒤로 가고 1단계로 돌아간다. 단, 이때 뒤쪽 방향이 바다인 칸이라 뒤로 갈 수 없는 경우에는 움직임을 멈춘다.


public class Main01 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt(); // map row
		int m = sc.nextInt(); // map col
		int a = sc.nextInt(); // 캐릭 row
		int b = sc.nextInt(); // 캐릭 col
		int d = sc.nextInt(); // 캐릭 direction
		
		
		int[][] map = new int[n][m];
		
		for(int i=0; i<n; i++) {
			for(int j=0; j<m; j++) {
				map[i][j] = sc.nextInt();
			}
		}
		
		User user = new User(a, b, d, map);
		System.out.println(user.show());
		
		sc.close();
	}

}




class User{
	int row; // 캐릭 x 좌표
	int col; // 캐릭 y 좌표
	int direction; // 바라보고 있는 방향 ===  0:북 , 1:서, 2:남, 3:동
	int[][] map; // 지도  === 가본곳:-1, 방문하지않은곳:0, 바다:1
	int[][] move = {
			{-1, 0}, // 북
			{0, -1}, // 서
			{1, 0},  // 남
			{0, 1}   // 동
	}; // 반시계 방향을 바라볼 때 바껴질 좌표 값 북->서->남->동
	
	public User(int a, int b, int d, int[][] map) {
		this.row = a;
		this.col = b;
		this.direction = d;
		this.map = map;
	}
	
	public int show() {
		map[row][col] = -1; // 처음 시작한 장소는 방문한것이기 때문에 -1
		int answer = 1; // 처음 방문했기에 1로 초기화		
		
		while(true) {
			int directionCount = 0;
			
			for(int i=0; i<4; i++) { // 동서남북 4번돌아보며 확인
				// 북,서,남,동 순서
				direction = direction + 1 > 3? 0 : direction+1;
				
				int x = move[direction][0]; // 바라보고 있는 방향의 좌표값을 증감하기위해
				int y = move[direction][1]; 
				
				if(map[row + x][col + y] == 0) { // 가보지 않은 곳.
					map[row + x][col + y] = -1; // 타일 1로 바꿔주고
					row += x; // 캐릭 좌표 옮겨주고
					col += y; 
					answer++; // 밟은 타일수 1증가.
					break;
				}else { // 바다 or 땅일경우
					directionCount++;
				}
			}
			
			if(directionCount == 4) { // 동서남북 확인 다 했는데 갈곳이 없었을경우
				row -= move[direction][0]; // 바라보는 방향에서 뒤로가기위해  빼준다.
				col -= move[direction][1]; 
				if(map[row][col] == 1) { // 뒤로가는 방향에 바다가 있을 경우
					break;
				}
			}
			
		}
		
		return answer;
	}
	
	
}
