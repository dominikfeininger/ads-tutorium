package klausur;

import static gdi.MakeItSimple.*;

public class binäreSuche {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int w = 5;
		int[] array = { 1, 2, 3, 4, 5, 6, 7, 7, 8, 9 };
		int r = search(array, w);

		println(r);
	}

	/*
	 * static int searchRekursiv(int[] f, int k) { int unten = f[0]; int oben =
	 * f[f.length - 1]; int mitte = (unten + oben) / 2; int[] i = new
	 * int[(f.length - 1) - mitte]; if (k > mitte) { for (int s = mitte; s <
	 * f.length; s++) { i[s] = f[mitte + s]; } searchRekursiv(i, k); } else if
	 * (k < mitte) { for (int s = 0; s < mitte; s++) { i[s] = f[s]; }
	 * searchRekursiv(i, k); } else if (k == f[0]) { int e = f[0]; return e; }
	 * else { return -1; } }
	 */

	static int search(int[] f, int k) {
		int l = f.length - 1;
		int counter = 0;
		while (counter < l) {
			int mitte = (counter + l) / 2;
			if (f[mitte] == k) {
				return mitte;
			} else if (k < f[mitte]) {
				l = mitte - 1;
			} else
				counter = mitte + 1;
		}
		return -1;
	}

}
