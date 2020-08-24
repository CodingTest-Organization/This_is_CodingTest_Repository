#include <iostream>
#include <vector>
#include <algorithm>
using namespace std;

int solution(vector<int> adventurers, int n) {
	int answer = 0;
	int index = 0;
	// 모험가 내림차순 정렬
	sort(adventurers.begin(), adventurers.end(), greater<int>());
	// 해당 index의 모험가 수만큼 index를 증가시켜준다
	// 반복문이 돌때마다 answer을 1씩 증가시켜주며 정답을 구한다. 
	while (index < n) {
		index += adventurers[index];
		answer++;
	}
	return answer;
}

int main() {
	ios_base::sync_with_stdio(false);
	cin.tie(0); cout.tie(0);

	vector<int> adventurers;
	int n; cin >> n;
	for (int i = 0; i < n; i++) {
		int num; cin >> num;
		adventurers.push_back(num);
	}

	cout << solution(adventurers, n) << '\n';
}