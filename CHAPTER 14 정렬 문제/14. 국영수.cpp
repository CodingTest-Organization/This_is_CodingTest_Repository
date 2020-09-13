#include <iostream>
#include <vector>
#include <algorithm>
using namespace std;

class Student {
public:
	string name;
	int kor;
	int eng;
	int math;
	Student(string name, int kor, int eng, int math) {
		this->name = name;
		this->kor = kor;
		this->eng = eng;
		this->math = math;
	}
	bool operator < (Student& other) {
		if (this->kor == other.kor)
			if (this->eng == other.eng)
				if (this->math == other.math)
					// 4. 사전순으로 증가하는 순서 
					return this->name < other.name;
				else
					// 3. 수학 점수 감소하는 순서 
					return this->math > other.math;
			else
				// 2. 영어 점수 증가하는 순서
				return this->eng < other.eng;
		else
			// 1. 국어 점수가 감소하는 순서
			return this->kor > other.kor;
	}
};

int main() {
	ios_base::sync_with_stdio(false);
	cin.tie(0); cout.tie(0);

	vector<Student> students;
	int n; cin >> n;
	for (int i = 0; i < n; i++) {
		string name;
		int kor, eng, math;
		cin >> name >> kor >> eng >> math;
		students.push_back(Student(name, kor, eng, math));
	}
	sort(students.begin(), students.end());

	for (int i = 0; i < n; i++) {
		cout << students[i].name << '\n';
	}
}