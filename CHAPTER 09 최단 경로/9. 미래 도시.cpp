#include <iostream>
#include <vector>
#include <algorithm>
#include <string.h>
#include <queue>
using namespace std;

#define INF 1e9

/* 나의 코드
vector<int> a[101];

int bfs(int start, int end, int n) {
	int answer = 0;
	queue<int> q;
	vector<int> cnt(n+1, -1);

	q.push(start);
	cnt[start] = 0;
	while (!q.empty()) {
		int node = q.front(); q.pop();
		if (node == end) break;
		for (int i = 0; i < a[node].size(); i++) {
			int next = a[node][i];
			if (cnt[next] == -1) {
				cnt[next] = cnt[node] + 1;
				q.push(next);
			}
		}
	}
	return cnt[end];
}

int main() {
	ios_base::sync_with_stdio(false);
	cin.tie(0); cout.tie(0);

	int n, m, x, k; cin >> n >> m;
	for (int i = 0; i < m; i++) {
		int u, v; cin >> u >> v;
		a[u].push_back(v);
		a[v].push_back(u);
	}
	cin >> x >> k;

	int first, second;
	first = bfs(1, k, n);
	second = bfs(k, x, n);
	if (first == -1 || second == -1) cout << -1 << '\n';
	else cout << first + second << '\n';
}
*/

// 노드의 개수(N), 간선의 개수(M)
int n, m;
// 2차원 배열(그래프 표현)를 만들기
int graph[101][101];

int main(void) {
	cin >> n >> m;

	// 최단 거리 테이블을 모두 무한으로 초기화
	for (int i = 0; i < 101; i++) {
		fill(graph[i], graph[i] + 101, INF);
	}

	// 자기 자신에서 자기 자신으로 가는 비용은 0으로 초기화
	for (int a = 1; a <= n; a++) {
		for (int b = 1; b <= n; b++) {
			if (a == b) graph[a][b] = 0;
		}
	}

	// 각 간선에 대한 정보를 입력 받아, 그 값으로 초기화
	for (int i = 0; i < m; i++) {
		// A에서 B로 가는 비용은 C라고 설정
		int a, b, c;
		cin >> a >> b >> c;
		// 가장 짧은 간선 정보만 저장
		if (c < graph[a][b]) graph[a][b] = c;
	}

	// 점화식에 따라 플로이드 워셜 알고리즘을 수행
	// 다익스트라 : 하나의 정점 -> 모든 정점
	// 플로이드 워셜 : 모든 정점 -> 모든 정점
	for (int k = 1; k <= n; k++) {
		for (int a = 1; a <= n; a++) {
			for (int b = 1; b <= n; b++) {
				graph[a][b] = min(graph[a][b], graph[a][k] + graph[k][b]);
			}
		}
	}

	// 수행된 결과를 출력
	for (int a = 1; a <= n; a++) {
		for (int b = 1; b <= n; b++) {
			// 도달할 수 없는 경우, 0을 출력
			if (graph[a][b] == INF) {
				cout << 0 << ' ';
			}
			// 도달할 수 있는 경우 거리를 출력
			else {
				cout << graph[a][b] << ' ';
			}
		}
		cout << '\n';
	}
}