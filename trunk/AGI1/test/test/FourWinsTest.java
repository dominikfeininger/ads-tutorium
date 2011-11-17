package test;

import static org.junit.Assert.*;

import model.Enum.ChipColor;
import model.Field;

import org.junit.Test;

import controller.Game;

public class FourWinsTest {
	
	//4 win
	//=====
	private Field field = new Field();

	//COLS
	//====
	@Test
	public void testCheckColumn() throws Exception {
		field.addChip(0, 0, ChipColor.YELLOW);
		field.addChip(0, 1, ChipColor.YELLOW);
		field.addChip(0, 2, ChipColor.YELLOW);
		field.addChip(0, 3, ChipColor.YELLOW);

		assertEquals(ChipColor.YELLOW, Game.check(field));
	}

	@Test
	public void testCheckColumn2() throws Exception {
		field.addChip(1, 0, ChipColor.YELLOW);
		field.addChip(1, 1, ChipColor.YELLOW);
		field.addChip(1, 2, ChipColor.YELLOW);
		field.addChip(1, 3, ChipColor.YELLOW);

		assertEquals(ChipColor.YELLOW, Game.check(field));
	}

	@Test
	public void testCheckColumnEnd() throws Exception {
		field.addChip(6, 0, ChipColor.YELLOW);
		field.addChip(6, 1, ChipColor.YELLOW);
		field.addChip(6, 2, ChipColor.YELLOW);
		field.addChip(6, 3, ChipColor.YELLOW);

		assertEquals(ChipColor.YELLOW, Game.check(field));
	}

	@Test
	public void testCheckColumnMiddleMiddle() throws Exception {
		field.addChip(3, 1, ChipColor.YELLOW);
		field.addChip(3, 2, ChipColor.YELLOW);
		field.addChip(3, 3, ChipColor.YELLOW);
		field.addChip(3, 4, ChipColor.YELLOW);

		assertEquals(ChipColor.YELLOW, Game.check(field));
	}

	@Test
	public void testCheckColumnMiddleMiddleWithRed() throws Exception {
		field.addChip(3, 1, ChipColor.YELLOW);
		field.addChip(3, 2, ChipColor.YELLOW);
		field.addChip(3, 3, ChipColor.RED);
		field.addChip(3, 4, ChipColor.YELLOW);
		field.addChip(3, 5, ChipColor.YELLOW);

		assertEquals(ChipColor.NONE, Game.check(field));
	}

	@Test
	public void testCheckColumnEndRed() throws Exception {
		field.addChip(6, 0, ChipColor.RED);
		field.addChip(6, 1, ChipColor.RED);
		field.addChip(6, 2, ChipColor.RED);
		field.addChip(6, 3, ChipColor.RED);

		assertEquals(ChipColor.RED, Game.check(field));
	}

	
	//ROWS
	//====
	@Test
	public void testCheckRowsRed() throws Exception {
		field.addChip(0, 0, ChipColor.RED);
		field.addChip(1, 0, ChipColor.RED);
		field.addChip(2, 0, ChipColor.RED);
		field.addChip(3, 0, ChipColor.RED);

		assertEquals(ChipColor.RED, Game.check(field));
	}
	
	public void testCheckRowsRed1() throws Exception {
		field.addChip(2, 0, ChipColor.RED);
		field.addChip(3, 0, ChipColor.RED);
		field.addChip(4, 0, ChipColor.RED);
		field.addChip(5, 0, ChipColor.RED);

		assertEquals(ChipColor.RED, Game.check(field));
	}
	
	public void testCheckRowsRed2() throws Exception {
		field.addChip(0, 6, ChipColor.RED);
		field.addChip(1, 6, ChipColor.RED);
		field.addChip(2, 6, ChipColor.RED);
		field.addChip(3, 6, ChipColor.RED);

		assertEquals(ChipColor.RED, Game.check(field));
	}
	
	public void testCheckRowsRed3() throws Exception {
		field.addChip(2, 6, ChipColor.RED);
		field.addChip(3, 6, ChipColor.RED);
		field.addChip(4, 6, ChipColor.RED);
		field.addChip(5, 6, ChipColor.RED);

		assertEquals(ChipColor.RED, Game.check(field));
	}
	
	
	//DIA
	//===	
	@Test
	public void testCheckDiagonalRed() throws Exception {
		field.addChip(0, 0, ChipColor.RED);
		field.addChip(1, 1, ChipColor.RED);
		field.addChip(2, 2, ChipColor.RED);
		field.addChip(3, 3, ChipColor.RED);

		assertEquals(ChipColor.RED, Game.check(field));
	}

	@Test
	public void testCheckDiagonalRedOtherSide() throws Exception {
		field.addChip(3, 0, ChipColor.RED);
		field.addChip(2, 1, ChipColor.RED);		
		field.addChip(1, 2, ChipColor.RED);
		field.addChip(0, 3, ChipColor.RED);

		assertEquals(ChipColor.RED, Game.check(field));
	}
	
	
	
}
