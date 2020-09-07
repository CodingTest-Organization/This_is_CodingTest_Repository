#include <iostream>
#include <queue>
#include <algorithm>
using namespace std;

int map[505][505];
bool chk[505][505];
int dx[] = { 0,0,-1,1 };
int dy[] = { -1,1,0,0 };
int n, m;

int bfs(int a, int b) {
	int answer = 0;
	queue<pair<int, int>> q;
	q.push({ a,b });
	chk[a][b] = true;
	while (!q.empty()) {
		int x = q.front().first;
		int y = q.front().second;
		q.pop();
		answer++;
		for (int i = 0; i < 4; i++) {
			int nx = x + dx[i];
			int ny = y + dy[i];
			if (0 <= nx && nx < n && 0 <= ny && ny < m) {
				if (map[nx][ny] == 1 && !chk[nx][ny]) {
					q.push({ nx,ny });
					chk[nx][ny] = true;
				}
			}
		}
	}
	return answer;
}

int main() {
	int cnt = 0;
	int answer = 0;
	cin >> n >> m;
	for (int i = 0; i < n; i++) {
		for (int j = 0; j < m; j++) {
			cin >> map[i][j];
		}
	}

	for (int i = 0; i < n; i++) {
		for (int j = 0; j < m; j++) {
			if (map[i][j] == 1 && !chk[i][j]) {
				answer = max(answer, bfs(i, j));
				cnt++;
			}
		}
	}

	cout << cnt << '\n' << answer << '\n';
}