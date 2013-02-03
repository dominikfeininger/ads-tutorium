package test.java.vierGewinntVerwaltung;

import static org.junit.Assert.*;


import javax.swing.text.html.HTMLDocument.HTMLReader.SpecialAction;

import main.java.addressManagement.Address;
import main.java.addressManagement.Person;
import main.java.tictactoe.Enum.ChipColor;
import main.java.tictactoe.Field;
import main.java.vierGewinntVerwaltung.SpielerVerwaltung;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

public class SpielerVerwaltungTest {
	
	//4 win
		//=====
	private Field field = new Field();

	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
	}

	@AfterClass
	public static void tearDownAfterClass() throws Exception {
	}

	@Before
	public void setUp() throws Exception {
		
		field.addChip(3, 1, ChipColor.YELLOW);
		field.addChip(3, 2, ChipColor.YELLOW);
		field.addChip(3, 3, ChipColor.RED);
		field.addChip(3, 4, ChipColor.YELLOW);
		field.addChip(3, 5, ChipColor.YELLOW);
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void test() {
		fail("Not yet implemented");
	}
	
	@Test
	public void testSpielerVerwaltung(){
		
		Address dietersAddresse = new Address("Mannheim");
		Person dieter = new Person("dieter");
		dieter.setAdress(dietersAddresse);
		
		assertEquals(dieter, SpielerVerwaltung.spielerVerwaltungStart());
	}
	
	@Test
	public void fourWinsTest(){
		assertEquals(ChipColor.RED, SpielerVerwaltung.fourWinsGame());
	}

}
