#include <iostream>
#include <vector>
#include <algorithm>
using namespace std;

class Student {
public:
	string name;
	int score;
	Student(string name, int score) {
		this->name = name;
		this->score = score;
	}
	// 정렬 기준 : 점수가 낮은 순서 
	bool operator < (Student& other) {
		return this->score < other.score;
	}
};


int main() {
	ios_base::sync_with_stdio(false);
	cin.tie(0); cout.tie(0);

	vector<Student> students;
	int n; cin >> n;
	while (n--) {
		string name; 
		int score;
		cin >> name >> score;
		students.push_back(Student(name, score));
	}

	sort(students.begin(), students.end());

	for (int i = 0; i < students.size(); i++) {
		cout << students[i].name << " ";
	}
}