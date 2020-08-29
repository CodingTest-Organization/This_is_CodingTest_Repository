public class Kingdom {
    static int dx[] = {2,2,-2,-2,1,-1,1,-1};
    static int dy[] = {1,-1,1,-1,2,2,-2,-2};
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        String knight = sc.nextLine();
        int x = knight.charAt(0) - 'a';
        int y = knight.charAt(1) - '1';
        int cnt = 0;
        for(int k = 0; k<8;k++) {
            int nx = x + dx[k];
            int ny = y + dy[k];
            if (nx < 0 || 8 < nx || ny < 0 || 8 < ny) continue;
            cnt++;
        }

        System.out.println(cnt);

    }
}
