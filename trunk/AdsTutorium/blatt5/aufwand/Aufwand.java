package aufwand;

public class Aufwand {
	
	public static void main(String[] args) {
	int [] F = new int[10];
	
	for(int i=0; i< F.length-1;i++)
		F[i]=i;
	System.out.println(OvonWas1(F));
	System.out.println(OvonWas2(F));
	}

	static int OvonWas1(int[] F) {
		int cnt = 0;
		for (int i = 1; i < F.length - 1; i += 2) {
			int sum = 0;
			for (int j = i - 1; j < i + 2; j++) {
				sum += F[j];
				cnt++;
			}
			if (sum > 0)
				F[i] = F[i] / sum;
		}
		return cnt;
	}

	static int OvonWas2(int[] F) {
		int cnt = 0;
		for (int i = 1; i < F.length; i++) {
			int sum = 0;
			for (int j = i + 1; j < F.length; j++) {
				sum += F[j];
				cnt++;
			}
			if (sum > 0)
				F[i] = F[i] / sum;
		}
		return cnt;
	}

}
