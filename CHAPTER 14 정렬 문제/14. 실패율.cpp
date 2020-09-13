#include <string>
#include <vector>
#include <algorithm>
#include <iostream>

using namespace std;

bool cmp(pair<double, int>& a, pair<double, int>& b) {
    if (a.first == b.first) return a.second < b.second;
    return a.first > b.first;
}

vector<int> solution(int N, vector<int> stages) {
    vector<int> answer;
    double num = stages.size();
    vector<pair<double, int>> score;
    for (int i = 1; i <= N; i++) {
        if (num == 0) score.push_back({ 0 ,i });
        else {
            int cnt = count(stages.begin(), stages.end(), i);
            score.push_back({ cnt / num ,i });
            num -= cnt;
        }
    }
    sort(score.begin(), score.end(), cmp);
    for (auto a : score) {
        answer.push_back(a.second);
    }
    return answer;
}

int main() {
	ios_base::sync_with_stdio(false);
	cin.tie(0); cout.tie(0);

	int N = 5;
	vector<int> stages = { 2,1,2,6,2,4,3,3 };
	for (auto a : solution(N,stages)) {
		cout << a << " ";
	}
}