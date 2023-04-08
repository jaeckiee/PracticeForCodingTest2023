import java.util.*;

class Cor{
	int x;
	int y;
	int count;
	public Cor(int x, int y, int count) {
		this.x = x;
		this.y = y;
		this.count = count;
	}
}
public class Main {
	public static int n;
	public static int m;
	public static List<Integer> homeXList;
	public static List<Integer> homeYList;
	public static List<Integer> chickenXList;
	public static List<Integer> chickenYList;
	public static int[] dx = {-1, 0, 1, 0};
	public static int[] dy = {0, 1, 0, -1};
	public static int result;
	public static void main(String[] args) throws Exception{
		Scanner sc = new Scanner(System.in);
		n = sc.nextInt();
		m = sc.nextInt();
		result = 1 * n * n * n;
		homeXList = new ArrayList<>();
		homeYList = new ArrayList<>();
		chickenXList = new ArrayList<>();
		chickenYList = new ArrayList<>();
		for(int i = 0; i < n; i++) {
			for(int j = 0; j < n; j++) {
				int tmp = sc.nextInt();
				if(tmp == 1) {
					homeXList.add(i);
					homeYList.add(j);
				}
				else if(tmp == 2) {
					chickenXList.add(i);
					chickenYList.add(j);
				}
			}
		}
		getResult(chickenXList.size() - 1, 0, 0);
		System.out.println(result);
	}
	
	public static void getResult(int index, int count, int visit) {
		if(count > m) {
			return;
		}
		if(index == -1) {
			if(count == m) {
				int[][] map = new int[n][n];
				for(int i = 0; i < n; i++) {
					for(int j = 0; j < n; j++) {
						map[i][j] = 2 * n;
					}
				}
				for(int i = 0; i < chickenXList.size(); i++) {
					if((visit & (1 << i)) == (1 << i)) {
						int chickenX = chickenXList.get(i);
						int chickenY = chickenYList.get(i);
						bfs(chickenX, chickenY, map);
					}
				}
				int tmpResult = 0;
				for(int i = 0; i < homeXList.size(); i++) {
					int homeX = homeXList.get(i);
					int homeY = homeYList.get(i);
					tmpResult += map[homeX][homeY];
				}
				result = Math.min(result, tmpResult);
			}
			return;
		}
		getResult(index - 1, count + 1, visit * 2 + 1);
		getResult(index - 1, count, visit * 2);
	}
	
	public static void bfs(int x, int y, int[][] map) {
		boolean[][] visit = new boolean[n][n];
		Queue<Cor> q = new LinkedList<>();
		visit[x][y] = true;
		q.add(new Cor(x, y, 0));
		while(!q.isEmpty()) {
			Cor cor = q.poll();
			int corX = cor.x;
			int corY = cor.y;
			int count = cor.count;
			map[corX][corY] = Math.min(map[corX][corY], count);
			for(int i = 0; i < 4; i++) {
				if(corX + dx[i] < 0 || corX + dx[i] >= n) {
					continue;
				}
				if(corY + dy[i] < 0 || corY + dy[i] >= n) {
					continue;
				}
				if(visit[corX + dx[i]][corY + dy[i]]) {
					continue;
				}
				visit[corX + dx[i]][corY + dy[i]] = true;
				q.add(new Cor(corX + dx[i], corY + dy[i], count + 1));
			}
		}
	}
}
