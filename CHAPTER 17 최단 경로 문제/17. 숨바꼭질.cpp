#include <iostream>
#include <algorithm>
#include <vector>
#include <queue>
using namespace std;

#define INF 1e9

/* 나의 코드 
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
*/

int n, m;
int start = 1;
vector<pair<int, int> > graph[20001];
int d[20001];

void dijkstra(int start) {
	priority_queue<pair<int, int> > pq;
	pq.push({ 0, start });
	d[start] = 0;
	while (!pq.empty()) { 
		int dist = -pq.top().first; 
		int now = pq.top().second; 
		pq.pop();
		if (d[now] < dist) continue;
		for (int i = 0; i < graph[now].size(); i++) {
			int cost = dist + graph[now][i].second;
			if (cost < d[graph[now][i].first]) {
				d[graph[now][i].first] = cost;
				pq.push(make_pair(-cost, graph[now][i].first));
			}
		}
	}
}

int main(void) {
	cin >> n >> m;

	for (int i = 0; i < m; i++) {
		int u, v; cin >> u >> v;
		graph[u].push_back({ v,1 });
		graph[v].push_back({ u,1 });
	}

	fill(d, d + 20001, INF);

	dijkstra(start);

	// 가장 최단 거리가 먼 노드 번호(동빈이가 숨을 헛간의 번호)
	int maxNode = 0;
	// 도달할 수 있는 노드 중에서, 가장 최단 거리가 먼 노드와의 최단 거리
	int maxDistance = 0;
	// 가장 최단 거리가 먼 노드와의 최단 거리와 동일한 최단 거리를 가지는 노드들의 리스트
	vector<int> result;

	for (int i = 1; i <= n; i++) {
		if (maxDistance < d[i]) {
			maxNode = i;
			maxDistance = d[i];
			result.clear();
			result.push_back(maxNode);
		}
		else if (maxDistance == d[i]) {
			result.push_back(i);
		}
	}

	cout << maxNode << ' ' << maxDistance << ' ' << result.size() << '\n';
}