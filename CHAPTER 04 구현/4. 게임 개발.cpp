#include <iostream>
#include <vector>
using namespace std;

// map 저장 
int map[55][55];
//          북 동 남 서 
int dx[] = { -1,0,1,0 };
int dy[] = { 0,1,0,-1 };
int n, m;
// 방문한 칸의 수 
int cnt = 1;

int solution(int x, int y, int d) {
	// 범위 안에 있을 때만 실행 
	if (0 < x && x < n - 1 && 0 < y && y < m - 1) {
		// 방문했을 때 -1로 변경 
		map[x][y] = -1;
		for (int i = 0; i < 4; i++) {
			// 왼쪽 판별
			// 북(0) -> 서(3)
			// 서(3) -> 남(2)
			// 남(2) -> 동(1)
			// 동(1) -> 북(0)
			d = (d + 3) % 4;
			// (nx,ny) -> 왼쪽으로 회전한 위치 
			int nx = x + dx[d];
			int ny = y + dy[d];
			// 가볼 공간이 있을 때
			if (map[nx][ny] == 0) {
				cnt++;
				return solution(nx, ny, d);
			}
		}
		// 네 방향 모두 가본 공간이면 실행
		// 후진할 위치 정하기
		switch (d)
		{
			// 북(0)
			case 0: x++; break;
			// 동(1)
			case 1: y--; break;
			// 남(2)
			case 2: x--; break;
			// 서(3)
			case 3: y++; break;
			default:
				break;
		}
		// 후진한 공간이 바다이면 return cnt
		if (map[x][y] == 1)
			return cnt;
		else return solution(x, y, d);
	}
}

int main() {
	ios_base::sync_with_stdio(false);
	cin.tie(0); cout.tie(0);
	int x, y, d;

	cin >> n >> m;
	cin >> x >> y >> d;

	for (int i = 0; i < n; i++) {
		for (int j = 0; j < m; j++) {
			cin >> map[i][j];
		}
	}

	cout << solution(x, y, d) << '\n';
}