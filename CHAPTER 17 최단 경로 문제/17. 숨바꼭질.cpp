#include <iostream>
#include <algorithm>
#include <vector>
#include <queue>
using namespace std;

#define INF 1e9
vector<int> graph[20001];
int cnt[20001];

void solution(int start) {
	queue<int> q;
	q.push(start);
	cnt[start] = 0;
	while (!q.empty()) {
		int node = q.front(); q.pop();
		int dist = cnt[node] + 1;
		for (int i = 0; i < graph[node].size(); i++) {
			int next = graph[node][i];
			if (dist < cnt[next]) {
				cnt[next] = dist;
				q.push(next);
			}
		}
	}
}

int main() {
	ios_base::sync_with_stdio(false);
	cin.tie(0); cout.tie(0);

	int n, m; cin >> n >> m;
	for (int i = 0; i < m; i++) {
		int u, v; cin >> u >> v;
		graph[u].push_back(v);
		graph[v].push_back(u);
	}

	fill(cnt, cnt + 20001, INF);
	solution(1);

	int max_dist = *max_element(cnt + 1, cnt + n);
	int num, cnt_dist = 0;
	for (int i = n; i > 0; i--) {
		if (cnt[i] == max_dist) {
			num = i;
			cnt_dist++;
		}
	}
	cout << num << " " << max_dist << " " << cnt_dist << '\n';
}