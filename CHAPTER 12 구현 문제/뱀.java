package _12.Implentation;

import java.util.*;

class Move {
    int time;
    char direction;

    public Move(int time, char direction) {
        this.time = time;
        this.direction = direction;
    }
}

class Node {
    int x;
    int y;

    public Node(int x, int y) {
        this.x = x;
        this.y = y;
    }
}

public class Snake {
    static int n, l;
    static int[][] maps = new int[101][101];
    static List<Move> info = new ArrayList<>();

    static int dx[] = {0, 1, 0, -1};
    static int dy[] = {1, 0, -1, 0};

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();


        int k = sc.nextInt();

        for (int i = 0; i < k; i++) {
            int x = sc.nextInt();
            int y = sc.nextInt();
            maps[x][y] = 1;
        }

        l = sc.nextInt();

        for (int i = 0; i < l; i++) {
            int time = sc.nextInt();
            char direction = sc.next().charAt(0);
            info.add(new Move(time, direction));
        }

        int result = simulation();
        System.out.println(result);
    }

    public static int rotate(int direction, char code) {
        if (code == 'L') return (direction + 3)% 4;
        return (direction + 1) % 4;
    }

    private static int simulation() {
        int x = 1, y = 1;
        int time = 0; // 시간
        int index = 0; // 순서
        int direction = 0; // 오른쪽을 보고 시작 // 오른쪽은 동쪽임

        maps[x][y] = 2;
        Queue<Node> q = new LinkedList<>();
        q.offer(new Node(x, y));

        while (true) {
            int nx = x + dx[direction];
            int ny = y + dy[direction];
            if (1 <= nx && nx <= n && 1 <= ny && ny <= n && maps[nx][ny] != 2) {

                if (maps[nx][ny] == 0) {
                    maps[nx][ny] = 2;
                    q.offer(new Node(nx, ny));
                    Node prev = q.poll();
                    maps[prev.x][prev.y] = 0;
                }

                if (maps[nx][ny] == 1) {
                    maps[nx][ny] = 2;
                    q.offer(new Node(nx, ny));
                }
            } else {
                time +=1;
                break;
            }

            x = nx;
            y = ny;
            time += 1;
            if (index < l && info.get(index).time == time) {
                direction = rotate(direction, info.get(index).direction);
                index += 1;
            }
        }
        return time;
    }
}
