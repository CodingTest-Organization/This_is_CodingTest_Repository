#include <cstdio>
#include <algorithm>
#include <queue>
using namespace std;

int a[105][105];
int d[105][105];
int ax[] = { 0,0,-1,1 };
int ay[] = { -1,1,0,0 };
int n, m;

void bfs(int x, int y) {
	queue < pair<int, int>> q;
	q.push(make_pair(x, y));
	while (!q.empty()) {
		int x = q.front().first;
		int y = q.front().second;
		q.pop();
		for (int i = 0; i < 4; i++) {
			int nx = x + ax[i];
			int ny = y + ay[i];
			if (0 <= nx && nx < n && 0 <= ny && ny < m) {
				if (a[nx][ny] == 1 && d[nx][ny] == 0) {
					q.push(make_pair(nx, ny));
					d[nx][ny] = d[x][y] + 1;
				}
			}
		}
	}
}

int main() {
	scanf_s("%d %d", &n, &m);
	for (int i = 0; i < n; i++) {
		for (int j = 0; j < m; j++) {
			scanf_s("%1d", &a[i][j]);
		}
	}
	d[0][0] = 1;
	bfs(0, 0);
	printf("%d\n", d[n - 1][m - 1]);
}