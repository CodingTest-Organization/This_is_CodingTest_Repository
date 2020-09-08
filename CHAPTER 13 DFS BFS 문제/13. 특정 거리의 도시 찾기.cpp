#include <iostream>
#include <vector>
#include <queue>
#include <algorithm>
using namespace std;

#define MAX 300000 + 1
vector<int> a[MAX];
int d[MAX];

void bfs(int start) {
	queue<int> q;
	q.push(start);
	while (!q.empty()) {
		int node = q.front();
		q.pop();
		for (int i = 0; i < a[node].size(); i++) {
			int next = a[node][i];
			// 아직 방문하지 않았다면 
			if (!d[next]) {
				d[next] = d[node] + 1;
				q.push(next);
			}
		}
	}
}

vector<int> solution(int n, int k, int x) {
	vector<int> answer;
	bfs(x);
	for (int i = 1; i <= n; i++) {
		if (d[i] == k) {
			answer.push_back(i);
		}
	}
	if (answer.empty()) answer.push_back(-1);
	sort(answer.begin(), answer.end());
	return answer;
}

int main() {
	ios_base::sync_with_stdio(false);
	cin.tie(0); cout.tie(0);
	int n, m, k, x; cin >> n >> m >> k >> x;
	for (int i = 0; i < m; i++) {
		int u, v; cin >> u >> v;
		a[u].push_back(v);
	}
	for (auto node : solution(n, k, x)) {
		cout << node << '\n';
	}
}