#include <iostream>
#include <vector>
#include <algorithm>
using namespace std;

int main() {
	ios_base::sync_with_stdio(false);
	cin.tie(0); cout.tie(0);

	vector<int> nums;

	int n; cin >> n;
	for (int i = 0; i < n; i++) {
		int num; cin >> num;
		nums.push_back(num);
	}

	sort(nums.begin(), nums.end(), greater<int>());
	for (int i = 0; i < n; i++) {
		cout << nums[i] << " ";
	}
}