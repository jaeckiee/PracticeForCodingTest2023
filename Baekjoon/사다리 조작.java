import java.util.*;

public class Main {
	public static int n;
	public static int m;
	public static int h;
	public static boolean[][] ladder;
	public static void main(String[] args) throws Exception{
		Scanner sc = new Scanner(System.in);
		n = sc.nextInt();
		m = sc.nextInt();
		h = sc.nextInt();
		ladder = new boolean[h][n - 1];
		int result = -1;
		for(int i = 0; i < m; i++) {
			int a = sc.nextInt();
			int b = sc.nextInt();
			int rowIndex = a - 1;
			int colIndex = b - 1;
			ladder[rowIndex][colIndex] = true;
		}
		List<Integer> listX = new ArrayList<>();
		List<Integer> listY = new ArrayList<>();
		for(int i = 0; i < h; i++) {
			for(int j = 0; j < n - 1; j++) {
				if(!ladder[i][j]) {
					listX.add(i);
					listY.add(j);
				}
			}
		}
		int listSize = listX.size();
		// check 3
		if(listSize >= 3) {
			for(int i = 0; i < listSize - 2; i++) {
				for(int j = i + 1; j < listSize - 1; j++) {
					for(int l = j + 1; l < listSize; l++) {
						int iX = listX.get(i);
						int iY = listY.get(i);
						if(ladder[iX][iY]) {
							continue;
						}
						if(iY - 1 >= 0 && ladder[iX][iY - 1]) {
							continue;
						}
						if(iY + 1 < n - 1 && ladder[iX][iY + 1]) {
							continue;
						}
						ladder[iX][iY] = true;
						int jX = listX.get(j);
						int jY = listY.get(j);
						if(ladder[jX][jY]) {
							ladder[iX][iY] = false;
							continue;
						}
						if(jY - 1 >= 0 && ladder[jX][jY - 1]) {
							ladder[iX][iY] = false;
							continue;
						}
						if(jY + 1 < n - 1 && ladder[jX][jY + 1]) {
							ladder[iX][iY] = false;
							continue;
						}
						ladder[jX][jY] = true;
						int lX = listX.get(l);
						int lY = listY.get(l);
						if(ladder[lX][lY]) {
							ladder[iX][iY] = false;
							ladder[jX][jY] = false;
							continue;
						}
						if(lY - 1 >= 0 && ladder[lX][lY - 1]) {
							ladder[iX][iY] = false;
							ladder[jX][jY] = false;
							continue;
						}
						if(lY + 1 < n - 1 && ladder[lX][lY + 1]) {
							ladder[iX][iY] = false;
							ladder[jX][jY] = false;
							continue;
						}
						ladder[lX][lY] = true;
						if(isCorrect(ladder)) {
							result = 3;
						}
						ladder[iX][iY] = false;
						ladder[jX][jY] = false;
						ladder[lX][lY] = false;
					}
				}
			}
		}
		// check 2
		if(listSize >= 2) {
			for(int j = 0; j < listSize - 1; j++) {
				for(int l = j + 1; l < listSize; l++) {
					int jX = listX.get(j);
					int jY = listY.get(j);
					if(ladder[jX][jY]) {
						continue;
					}
					if(jY - 1 >= 0 && ladder[jX][jY - 1]) {
						continue;
					}
					if(jY + 1 < n - 1 && ladder[jX][jY + 1]) {
						continue;
					}
					ladder[jX][jY] = true;
					int lX = listX.get(l);
					int lY = listY.get(l);
					if(ladder[lX][lY]) {
						ladder[jX][jY] = false;
						continue;
					}
					if(lY - 1 >= 0 && ladder[lX][lY - 1]) {
						ladder[jX][jY] = false;
						continue;
					}
					if(lY + 1 < n - 1 && ladder[lX][lY + 1]) {
						ladder[jX][jY] = false;
						continue;
					}
					ladder[lX][lY] = true;
					if(isCorrect(ladder)) {
						result = 2;
					}
					ladder[jX][jY] = false;
					ladder[lX][lY] = false;
				}
			}
		}
		// check 1
		if(listSize >= 1) {
			for(int l = 0; l < listSize; l++) {
				int lX = listX.get(l);
				int lY = listY.get(l);
				if(ladder[lX][lY]) {
					continue;
				}
				if(lY - 1 >= 0 && ladder[lX][lY - 1]) {
					continue;
				}
				if(lY + 1 < n - 1 && ladder[lX][lY + 1]) {
					continue;
				}
				ladder[lX][lY] = true;
				if(isCorrect(ladder)) {
					result = 1;
				}
				ladder[lX][lY] = false;
			}
		}
		// check 0
		if(isCorrect(ladder)) {
			result = 0;
		}
		System.out.println(result);
	}

	public static boolean isCorrect(boolean[][] currLadder){
		for(int i = 0; i < n; i++) {
			int currCol = i;
			int currRow = 0;
			while(currRow < h) {
				if(currCol >= 0 && currCol < n - 1 && currLadder[currRow][currCol]) {
					currCol = currCol + 1;
				}
				else if(currCol - 1 >= 0 && currCol < n && currLadder[currRow][currCol - 1]) {
					currCol = currCol - 1;
				}
				currRow++;
			}
			if(currCol != i) {
				return false;
			}
		}
		return true;
	}

}
