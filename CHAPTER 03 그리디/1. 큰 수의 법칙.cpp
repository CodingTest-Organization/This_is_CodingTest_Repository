/*
1. 큰 수의 법칙

큰수의 법칙은 일반적으로 통계분야에서 다루어지는 내용이지만, 동빈이는 본인만의 방식으로 다르게 사용하고 있다.
동빈이는 큰 수의 법칙은 다양한 수로 이루어진 배열이 있을때 주어진 수들을 M번 더하여 가장 큰 수를 만드는 법칙이다.
단, 배열의 특정한 인덱스에 해당하는 수가 연속적으로 K번을 초과하여 더해질 수 없다는 특징이 있다.

입력 조건 :
- 첫째 줄에 N(2 <= N <= 1000), M(1 <= M <= 10, 000), K(1 <= K <= 10, 000)의 자연수가 주어지며, 각 자연수는 공백으로 구분한다.
- 둘째 줄에 N개의 자연수가 주어진다.각 자연수는 공백으로 구분한다.단 각각의 자연수는 1이상 10, 000이하의 수로 주어진다.
- 입력으로 주어지는 K는 항상 M보다 작거나 같다.

출력 조건 :
- 첫째 줄에 동빈이의 큰수의 법칙에 따라 더해진 답을 출력한다.

입력 예시 :
5 8 3
2 4 5 4 6
출력 예시 :
46
*/

#include <iostream>
#include <vector>
#include <algorithm>
using namespace std;

int solution(vector<int>& nums, int m, int k) {
	int answer = 0;
	// num[0] = 가장 큰 수 
	// num[1] = 두번째로 큰 수 만 사용
	// m / (k + 1) = 전체 m개 / (가장 큰 수가 k개 + 두 번째로 큰 수가 1개)
	// m % (k + 1) = 위의 계산식의 나머지 개수 
	answer = nums[0] * (m / (k + 1) * k + m % (k + 1)) + nums[1] * (m / (k + 1));
	return answer;
}

int main() {
	ios_base::sync_with_stdio(false);
	cin.tie(0); cout.tie(0);

	// n m k 입력
	int n, m, k; cin >> n >> m >> k;
	vector<int> nums;
	int answer = 0;

	// 각 자연수 입력 받아서 vector에 저장
	for (int i = 0; i < n; i++) {
		int num; cin >> num;
		nums.push_back(num);
	}

	// nums 내림차순 정렬
	sort(nums.begin(), nums.end(), greater<int>());
	cout << solution(nums, m, k) << '\n';
}