package search;

import java.util.Arrays;
import java.util.Scanner;

/*
        HAPTER 07 이진 탐색
        떡볶이 떡 만들기
        오늘 동빈이는 여행 가신 부모님을 대신하여 떡집 일을 하기로 했다. 오늘은 떡복이 떡을 만드는 날이다. 동빈이네 떡볶이 떡은 재밌게도 떡볶이 떡의 길이가 일정하지 않다. 대신에 한 봉지에 들어가는 떡의 총 길이는 절단기로 맞춰준다.

        절단기 높이(H)를 지정하면 줄지어진 떡을 한 번에 절단한다. 높이가 H보다 긴 떡은 H 위의 부분이 잘릴 것이고, 낮은 떡은 잘리지 않는다.

        19 , 14 , 10 , 17 = > 15

        15 , 14 , 10 , 15

        4 0 0 2 => 6

        손님이 왔을 때 요청한 총 길이가 M일 때 적어도 M만큼의 떡을 얻기 위해 절단기에 설정할 수 있는 높이의 최댓값을 구하는 프로그램을 작성하시오.

        입력 조건

        첫째 줄에 떡의 개수 N과 요청한 떡의 길이 M이 주어진다.(1<= N <= 1,000,000, 1<= M <= 2,000,000,000)
        둘째 줄에는 떡의 개별 높이가 주어진다. 떡 높이의 총합은 항상 M이상이므로, 손님은 필요한 양만큼 떡을 사갈 수 있다. 높이는 10억보다 작거나 같은 양의 정수 또는 0이다.
        출력 조건

        적어도 M만큼의 떡을 집에 가져가기 위해 절단기에 설정할 수 있는 높이의 최댓값을 출력한다.
        입력예시                                                출력 예시
        4 6
        19 15 10 17                                             15
*/
public class Main01 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt(); // 떡의 갯수
        int m = sc.nextInt(); // 요청한 떡의 길이

        int[] array = new int[n];
        for(int i=0; i<n; i++){
            array[i] = sc.nextInt();
        }

        Arrays.sort(array);
        int max = array[array.length-1];

        int sum = 0;
        int i = 0;
        for(i=max; i>0; i--){ // array의 가장 큰 값부터 0까지.
            sum = 0;
            for(int j=0; j<n; j++){
                if(array[j] > i){
                    sum += array[j]-i;
                }
            }
            if(sum == m){
                break;
            }
        }
        System.out.println(i);
    }

}
























