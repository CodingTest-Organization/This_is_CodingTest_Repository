#include <iostream>
#include <vector>
#include <algorithm>
#include <string.h>
#include <queue>
using namespace std;

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