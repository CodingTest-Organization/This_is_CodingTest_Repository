#include <iostream>
#include <algorithm>
#include <vector>
#include <queue>
using namespace std;

#define INF 1e9

vector<pair<int,int>> city[30001];
int cost[30001];

void solution(int start, int n) {
	priority_queue<pair<int, int>> pq; // {next node,time}
	pq.push({ start,0 });
	cost[start] = 0;
	while (!pq.empty()) {
		int node = pq.top().first;
		int time = pq.top().second;
		pq.pop();
		for (int i = 0; i < city[node].size(); i++) {
			int next_node = city[node][i].first;
			int next_time = city[node][i].second + time;
			if (cost[next_node] > next_time) {
				cost[next_node] = next_time;
				pq.push({ next_node, next_time });
			}
		}
	}
}

int main() {
	ios_base::sync_with_stdio(false);
	cin.tie(0); cout.tie(0);

	int n, m, c; cin >> n >> m >> c;
	for (int i = 0; i < m; i++) {
		int x, y, z; cin >> x >> y >> z;
		city[x].push_back({ y,z });
	}

	fill(cost, cost + 30001, INF);
	solution(c, n);

	int count = -1, answer = 0;
	for (int i = 1; i <= n; i++) {
		if (cost[i] != INF) {
			count++;
			answer = max(answer, cost[i]);
		}
	}

	cout << count << " " << answer << '\n';
}