#include <iostream>
#include <vector>
#include <algorithm>
#include <queue>
using namespace std;

/* vector라서 시간 초과 난 듯?
int solution(int n, vector<int> card) {
	int answer = 0, index = 0;
	sort(card.begin(), card.end());
	while (--n) {
		card.push_back(card[index] + card[index + 1]);
		answer += (card[index] + card[index + 1]);
		index += 2;
		sort(card.begin() + index, card.end());
	}
	return answer;
}
*/

int solution(int n, vector<int> card) {
	int answer = 0;
	priority_queue<int, vector<int>, greater<int>> pq;
	int len = card.size();
	for (int i = 0; i < len; i++) {
		pq.push(card[i]);
	}

	while (pq.size() != 1) {
		int first = pq.top();
		pq.pop();
		int second = pq.top();
		pq.pop();
		pq.push(first + second);
		answer += (first + second);
	}
	return answer;
}

int main() {
	ios_base::sync_with_stdio(false);
	cin.tie(0); cout.tie(0);

	int n; cin >> n;
	vector<int> card;
	for (int i = 0; i < n; i++) {
		int num; cin >> num;
		card.push_back(num);
	}

	cout << solution(n, card) << '\n';
}