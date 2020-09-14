package sort;

import java.util.Arrays;
import java.util.Scanner;
import java.util.StringTokenizer;

/*
        CHAPTER 06 정렬
        성적이 낮은 순서로 학생 출력하기
        N명의 학생 정보가 있다. 학생 정보는 학생의 이름과 학생의 성적으로 구분된다. 각 학생의 이름과 성적 정보가 주어졌을 때 성적이 낮은 순서대로 학생의 이름을 출력하는 프로그램을 작성하시오.

        입력 조건

        첫 번째 출에는 학생의 수N이 입력 된다.(1<=N <=100,000)
        두 번째 줄 부터 N + 1 번째 줄에는 학생의 이름을 나타내는 문자열 A와 학생의 성적을 출력하는 정수 B가 공백으로ㅠ 구분되어 입력된다. 문자열 A의 길이와 학생의 성적은 100이하의 자연수이다.
        출력 조건

        모든 학생의 이름을 성적이 낮은 순서대로 출력한다. 성적이 동일한 학생들의 순서는 자유롭게 출력해도 괜찮다.
        입력 예시                               출력 예시
        2
        홍길동 95
        이순신 77                               이순신 홍길동
*/
public class Main02 {
    static String[] names;
    static int[] scores;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        sc.nextLine();

        names = new String[n];
        scores = new int[n];

        for (int i = 0; i < n; i++) {
            String[] array = sc.nextLine().split(" ");
            names[i] = array[0];
            scores[i] = Integer.parseInt(array[1]);
        }

        ///

        quickSort(scores, 0, scores.length - 1);

        for (int i = 0; i < n; i++) {
            System.out.print(names[i] + " ");
        }

    }

    private static void quickSort(int[] scores, int start, int end) {
        int p = partition(scores, start, end);
        if (start < p - 1) {
            quickSort(scores, start, p - 1);
        }
        if (end > p) {
            quickSort(scores, p, end);
        }
    }

    private static int partition(int[] scores, int start, int end) {
        int pivot = scores[(start + end) / 2];
        while (start <= end) {
            while (scores[start] < pivot) start++;
            while (scores[end] > pivot) end--;
            if (start <= end) {
                int num = scores[start];
                scores[start] = scores[end];
                scores[end] = num;

                String temp = names[start];
                names[start] = names[end];
                names[end] = temp;
                start++;
                end--;
            }
        }
        return start;
    }

}
























