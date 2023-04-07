import java.util.*;

class Cor{
	public int x;
	public int y; 
	public Cor(int x, int y) {
		this.x = x;
		this.y = y;
	}
	@Override
	public int hashCode() {
		return x + y;
	}
	@Override
	public boolean equals(Object o) {
		Cor cor = (Cor) o;
		if(this.x == cor.x && this.y == cor.y) {
			return true;
		}
		return false;
	}
}

class Edge {
	public Cor cor1;
	public Cor cor2;
	public Edge(Cor cor1, Cor cor2) {
		this.cor1 = cor1;
		this.cor2 = cor2;
	}
	@Override
	public int hashCode() {
		return cor1.x + cor1.y + cor2.x + cor2.y;
	}
	
	@Override
	public boolean equals(Object o) {
		Edge edgeO = (Edge) o;
		if(this.cor1.x == edgeO.cor1.x && this.cor1.y == edgeO.cor1.y && this.cor2.x == edgeO.cor2.x && this.cor2.y == edgeO.cor2.y){
			return true;
		}
		if(this.cor1.x == edgeO.cor2.x && this.cor1.y == edgeO.cor2.y && this.cor2.x == edgeO.cor1.x && this.cor2.y == edgeO.cor1.y){
			return true;
		}
		return false;
	}
}
public class Main {
	public static int numOfCurve;
	public static Set<Cor> set;
	public static void main(String[] args) throws Exception{
		Scanner sc = new Scanner(System.in);
		set = new HashSet<>();
		int result = 0;
		numOfCurve = sc.nextInt();
		for(int i = 0; i < numOfCurve; i++) {
			int y = sc.nextInt();
			int x = sc.nextInt();
			int d = sc.nextInt();
			int g = sc.nextInt();
			Set<Cor> tmpSet = new HashSet<>();
			Cor endCor = new Cor(x, y);
			int secondX = x;
			int secondY = y;
			if(d == 0) {
				secondY++;
			}
			else if(d == 1) {
				secondX--;
			}
			else if(d == 2) {
				secondY--;
			}
			else if(d == 3) {
				secondX++;
			}
			Cor center = new Cor(secondX, secondY);
			tmpSet.add(endCor);
			tmpSet.add(center);
			for(int tmpG = 0; tmpG < g; tmpG++) {
				Set<Cor> tmpSet2 = new HashSet<>();
				for(Cor cor : tmpSet) {
					tmpSet2.add(cor);
					Cor newCor = getRotatedCor(cor, center);
					tmpSet2.add(newCor);
				}
				tmpSet = tmpSet2;
				center = getRotatedCor(endCor, center);
			}
			for(Cor cor : tmpSet) {
				set.add(cor);
			}	
		}
		for(int i = 0; i < 100; i++) {
			for(int j = 0; j < 100; j++) {
				Cor cor1 = new Cor(i, j);
				Cor cor2 = new Cor(i, j + 1);
				Cor cor3 = new Cor(i + 1, j);
				Cor cor4 = new Cor(i + 1, j+ 1);
				if(!set.contains(cor1)) {
					continue;
				}
				if(!set.contains(cor2)) {
					continue;
				}
				if(!set.contains(cor3)) {
					continue;
				}
				if(!set.contains(cor4)) {
					continue;
				}
				result++;
			}
		}
		System.out.println(result);
	}
	public static Cor getRotatedCor(Cor source, Cor center) {
		int centerX = center.x;
		int centerY = center.y;
		int sourceX = source.x;
		int sourceY = source.y;
		int tmpX = sourceX - centerX;
		int tmpY = sourceY - centerY;
		return new Cor(centerX + tmpY, centerY - tmpX);
	}
}
