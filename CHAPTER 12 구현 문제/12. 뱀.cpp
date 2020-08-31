#include <iostream>
#include <deque>
#include <queue>
using namespace std;
int apple[105][105];
int map[105][105];
//          동 남 서 북
int dx[] = { 0,1,0,-1 };
int dy[] = { 1,0,-1,0 };
int n;
deque<pair<int, int>> snake;
queue<pair<int, char>> snake_dir;

int solution() {
	// 현재 위치 (x,y) 방향 dir
	int x = 1, y = 1, dir = 0;
	int time = 0;

	while (1) {
		// 방향 정보 판단 
		// x초 일 때만 실행 
		if (!snake_dir.empty() && time == snake_dir.front().first) {
			// 오른쪽 회전
			if (snake_dir.front().second == 'D') {
				dir = (++dir) % 4;
			}
			// 왼쪽 회전
			else {
				--dir;
				if (dir == -1) dir = 3;
			}
			// 방향 정보에서 빼줌
			snake_dir.pop();
		}

		// 위치 이동 
		x += dx[dir];
		y += dy[dir];

		// 뱀의 위치가 보드 범위 안에 존재하고 map이 0일 때만
		if (0 < x && x <= n && 0 < y && y <= n && map[x][y] == 0) {
			map[x][y] = 1;
			// 머리가 이동했기 때문에 덱의 앞에 넣어주기 
			snake.push_front(make_pair(x, y));
			if (apple[x][y] == 0) {
				// 사과가 없을 때 할 것
				// 1. map에서 꼬리 지워주기
				// 2. snake에서 꼬리 지워주기
				int tail_x = snake.back().first;
				int tail_y = snake.back().second;
				map[tail_x][tail_y] = 0;
				snake.pop_back();
			}
			else {
				// 사과가 있을 때 할 것
				// 1. 사과 위치 삭제 
				apple[x][y] = 0;
			}
			time++;
		}
		// 범위 안에 없으면 return time
		else return time;
	}
}

int main() {
	ios_base::sync_with_stdio(false);
	cin.tie(0); cout.tie(0);

	// 사과 위치 저장 
	int k; cin >> n >> k;
	while (k--) {
		int r, c; cin >> r >> c;
		apple[r][c] = 1;
	}

	int l; cin >> l;
	// map에 뱀의 길이만큼 이동한 잔상을 1로 찍어준다 
	// -> 자기 자신의 몸과 부딪히면 게임이 끝나는 것을 판별하기 위해서 
	map[1][1] = 1;
	snake.push_back(make_pair(1, 1));

	// snake 방향 정보 저장
	while (l--) {
		int num;
		char c;
		cin >> num >> c;
		snake_dir.push({ num,c });
	}

	cout << solution() + 1 << '\n';
}