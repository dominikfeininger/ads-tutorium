package neuesUebungsblattBBaum;

/**

 * File: Btest.java

 * @author Robert ?

 */

import java.awt.*;

//xxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx

//                              B-BAUM-TEST-KLASSE

//xxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx

class Btest extends Frame {

	static Bbaum Baum1;

	// ------------------------------------------------------------------------------

	public Btest() {

		// Fenster einrichten:

		setLayout(null);

		addNotify();

		setSize(1000, 350);

		setTitle("B-Baum-Test");

		show();

	}

	// -------------------------------------------------------------------------------

	public void paint(Graphics g) {

		zeichnen(Baum1, g);

	}

	// ---gibt auf dem Grafikkontext g den Knoten k an der Position (x,y)
	// aus,mit-----

	// --einer Linie auf dessen Vater,an der Position (x2,y2)

	public void zeichne(Graphics g, Bknoten k, int x, int y, int x2, int y2) {

		if (k == null) {

			return;
		}

		g.setColor(new Color(0, 150, 0));

		g.fill3DRect(x, y, 50, 20, true);

		g.setColor(new Color(200, 200, 200));

		g.drawLine(x + 25, y, x2 + 25, y2 + 20);

		g.setColor(new Color(255, 255, 255));

		for (int i = 0; i < k.sa; i++)
			g
					.drawString(new Integer(k.s[i]).toString(), x + 6 + i * 25,
							y + 15);

		g.setColor(new Color(0, 0, 255));

		g.setColor(new Color(255, 150, 150));

		g.drawString(k.toString(), x - 30, y - 10);

	}

	// ------------gibt den Baum auf dem Grafikkontext g
	// aus-------------------------

	public void zeichnen(Bbaum b, Graphics g) {

		g.setColor(new Color(0, 0, 0));

		g.fillRect(0, 0, 1000, 500);

		g.setColor(new Color(255, 255, 255));

		g.drawString("B-BAUM-VISUALISIERUNG", 20, 40);

		g.drawString("bis zur Tiefe 3", 20, 55);

		g.setColor(new Color(255, 150, 150));

		g.drawString("Objekte", 20, 80);

		// tiefe 1:

		zeichne(g, b.Wurzel, 500, 50, 500, 30);

		// tiefe 2:

		zeichne(g, b.Wurzel.p[0], 200, 150, 480, 50);

		zeichne(g, b.Wurzel.p[1], 500, 150, 500, 50);

		zeichne(g, b.Wurzel.p[2], 800, 150, 520, 50);

		// tiefe 3:

		if (b.Wurzel.p[0] != null) {

			zeichne(g, b.Wurzel.p[0].p[0], 80, 250, 180, 150);

			zeichne(g, b.Wurzel.p[0].p[1], 200, 250, 200, 150);

			zeichne(g, b.Wurzel.p[0].p[2], 320, 250, 220, 150);

		}

		if (b.Wurzel.p[1] != null) {

			zeichne(g, b.Wurzel.p[1].p[0], 380, 250, 480, 150);

			zeichne(g, b.Wurzel.p[1].p[1], 500, 250, 500, 150);

			zeichne(g, b.Wurzel.p[1].p[2], 620, 250, 520, 150);

		}

		if (b.Wurzel.p[2] != null) {

			zeichne(g, b.Wurzel.p[2].p[0], 680, 250, 780, 150);

			zeichne(g, b.Wurzel.p[2].p[1], 800, 250, 800, 150);

			zeichne(g, b.Wurzel.p[2].p[2], 920, 250, 820, 150);

		}

	}

	// -------------------------------------------------------------------------------

	public static void main(String args[]) {

		System.out.println("-------- Bbaum-test----------");

		// Test:

		Baum1 = new Bbaum();

		Baum1.einfuegen(7);

		Baum1.einfuegen(19);

		Baum1.einfuegen(23);

		Baum1.einfuegen(4);

		Baum1.einfuegen(12);

		Baum1.einfuegen(17);

		Baum1.einfuegen(8);

		// Baum1.einfuegen(11);

		// Baum1.einfuegen(2);

		// Baum grafisch darstellen:

		Btest Test1 = new Btest();

	}

}
