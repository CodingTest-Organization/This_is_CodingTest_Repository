package sort;

import java.util.Scanner;

/*
        CHAPTER 06 정렬
        위에서 아래로
        하나의 수열에는 다양한 수가 존재 한다. 이러한 수는 크기에 상관없이 나열되어 있다. 이 수를 큰 수 부터 작은 수의 순서로 정렬해한다. 수열을 내림차순으로 정렬하는 프로그램을 만드시오.

        입력 조건

        첫째 줄에 수열에 속해 있는 수의 개수 N이 주어진다.(1 <= N <= 500)
        둘째 줄부터 N+1번째 줄까지 N개의 수가 입력된다. 수의 범위는 1 이상 100,000 이하의 자연수이다.
        출력 조건

        입력으로 주어진 수열이 내림 차순으로 정렬된 결과를 공백으로 구분하여 출력한다. 동일한 수의 순서는 자유롭게 출력해도 괜찮다.
        입력 예시                       출력 예시

        3
        15
        27
        12                              27 15 12
*/
public class Main03 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] array = new int[n];

        for(int i=0; i<n; i++){
            array[i] = sc.nextInt();
        }

        quickSort(array, 0, array.length-1);

        for(int val : array){
            System.out.print(val + " ");
        }

    }

    private static void quickSort(int[] array, int start, int end) {
        int p = partition(array, start, end);
        if(start < p-1){ // array의 왼쪽
            quickSort(array, start, p-1);
        }
        if(end > p){ // array의 오른쪽
            quickSort(array, p, end);
        }
    }

    private static int partition(int[] array, int start, int end) {
        int pivot = array[(start + end)/2]; // 중앙값
        while(start <= end){ // 가장작은 값과 큰 값이 교차하였을 경우.
            while(pivot < array[start]) start++; // pivot 기준으로 array의 왼쪽부터 pivot보다 작은 값을 찾는다.
            while(pivot > array[end]) end--;     // pivot 기준으로 array의 왼쪽부터 pivot보다 큰 값을 찾는다.
            if(start <= end){
                int temp = array[start];
                array[start] = array[end];
                array[end] = temp;
                start++;
                end--;
            }
        }
        return start;
    }

}
























