#include <iostream>
#include <vector>
#include <algorithm>
using namespace std;

#define MAX 1000000
int num[MAX];

int main() {
	ios_base::sync_with_stdio(false);
	cin.tie(0); cout.tie(0);

	int n, x; cin >> n >> x;
	for (int i = 0; i < n; i++) {
		int index = 0; cin >> index;
		num[index]++;
	}

	num[x] == 0 ? cout << "-1" : cout << num[x];
}