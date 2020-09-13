static class Student implements Comparable<Student>{
        String name;
        int kor;
        int eng;
        int math;

        public Student(String name, int kor, int eng, int math) {
            this.name = name;
            this.kor = kor;
            this.eng = eng;
            this.math = math;
        }

        @Override
        public int compareTo(Student o) {

            if (o.kor == this.kor && this.eng == o.eng && this.math == o.math) {
                return this.name.compareTo(o.name);
            }

            if (o.kor == this.kor && this.eng == o.eng) {
                return o.math - this.math;
            }

            if (o.kor == this.kor) {
                return this.eng - o.eng;
            }
            return o.kor - this.kor;
        }
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        Student[] students = new Student[n];
        for(int i = 0; i<n;i++) {
            students[i] = new Student(sc.next(),sc.nextInt(),sc.nextInt(),sc.nextInt());
        }
        Arrays.sort(students);

        for(int i = 0 ;i<n;i++) {
            System.out.println(students[i].name);
        }
    }
