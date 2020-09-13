class Student{
        String name;
        int exam;

        public Student(String name, int exam) {
            this.name = name;
            this.exam = exam;
        }
}

public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();

        List<Student> students = new ArrayList<>(n);

         for(int i = 0; i<n;i++) {
            String name =sc.next();
            int value = sc.nextInt();
            students.add(new Student(name,value));
        }

         students.sort((o1, o2) -> o1.exam - o2.exam);

        for(int i = 0; i<students.size();i++) {
            System.out.print(students.get(i).name + " ");
        }
}
