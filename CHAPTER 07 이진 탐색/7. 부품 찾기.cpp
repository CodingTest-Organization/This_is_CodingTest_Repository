#include <iostream>
#include <vector>
#include <algorithm>
#include <set>
using namespace std;

int main() {
	ios_base::sync_with_stdio(false);
	cin.tie(0); cout.tie(0);

	set<int> storage;
	int n; cin >> n;
	for (int i = 0; i < n; i++) {
		int num; cin >> num;
		storage.insert(num);
	}
	int m; cin >> m;
	bool flag = true;
	for (int i = 0; i < m; i++) {
		int num; cin >> num;
		if (storage.count(num) == 0) {
			flag = false;
			break;
		}
	}
	flag ? cout << "YES\n" : cout << "NO\n";
}