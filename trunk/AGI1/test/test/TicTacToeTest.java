package test;

import static org.junit.Assert.*;

import model.Field;
import model.Enum.ChipColor;

import org.junit.Test;

import controller.Game;

public class TicTacToeTest {

	//TICTACTOE
		//=========
	
	
	Field field = new Field(3,3,3);
	
		//COLS
		//====
		@Test
		public void testCheckColumnTic() throws Exception {
			field.addChip(0, 0, ChipColor.YELLOW);
			field.addChip(0, 1, ChipColor.YELLOW);
			field.addChip(0, 2, ChipColor.YELLOW);

			assertEquals(ChipColor.YELLOW, Game.check(field));
		}
		
		@Test
		public void testCheckColumnTic1() throws Exception {
			field.addChip(1, 0, ChipColor.YELLOW);
			field.addChip(1, 1, ChipColor.YELLOW);
			field.addChip(1, 2, ChipColor.YELLOW);

			assertEquals(ChipColor.YELLOW, Game.check(field));
		}
		
		@Test
		public void testCheckColumnTic2() throws Exception {
			field.addChip(2, 0, ChipColor.YELLOW);
			field.addChip(2, 1, ChipColor.YELLOW);
			field.addChip(2, 2, ChipColor.YELLOW);

			assertEquals(ChipColor.YELLOW, Game.check(field));
		}
		
		//ROWS
			//====
		
		@Test
		public void testCheckRowsTic() throws Exception {
			field.addChip(0, 0, ChipColor.YELLOW);
			field.addChip(1, 0, ChipColor.YELLOW);
			field.addChip(2, 0, ChipColor.YELLOW);

			assertEquals(ChipColor.YELLOW, Game.check(field));
		}
		@Test
		public void testCheckRowsTic1() throws Exception {
			field.addChip(0, 0, ChipColor.YELLOW);
			field.addChip(1, 0, ChipColor.YELLOW);
			field.addChip(2, 0, ChipColor.YELLOW);

			assertEquals(ChipColor.YELLOW, Game.check(field));
		}
		@Test
		public void testCheckRowsTic2() throws Exception {
			field.addChip(0, 0, ChipColor.YELLOW);
			field.addChip(1, 0, ChipColor.YELLOW);
			field.addChip(2, 0, ChipColor.YELLOW);

			assertEquals(ChipColor.YELLOW, Game.check(field));
		}
		
		//DIAGONALS
			//====
		@Test
		public void testCheckDiagonalTic() throws Exception {
			field.addChip(0, 0, ChipColor.YELLOW);
			field.addChip(1, 1, ChipColor.YELLOW);
			field.addChip(2, 2, ChipColor.YELLOW);

			assertEquals(ChipColor.YELLOW, Game.check(field));
		}
		@Test
		public void testCheckDiagonalTic1() throws Exception {
			field.addChip(0, 2, ChipColor.YELLOW);
			field.addChip(1, 1, ChipColor.YELLOW);
			field.addChip(2, 0, ChipColor.YELLOW);

			assertEquals(ChipColor.YELLOW, Game.check(field));
		}
		
		@Test
		public void testCheckDiagonalTicRed() throws Exception {
			field.addChip(0, 2, ChipColor.RED);
			field.addChip(1, 1, ChipColor.RED);
			field.addChip(2, 0, ChipColor.RED);

			assertEquals(ChipColor.RED, Game.check(field));
		}
		
		@Test
		public void testCheckDiagonalTicRedNot() throws Exception {
			field.addChip(0, 2, ChipColor.RED);
			field.addChip(1, 1, ChipColor.YELLOW);
			field.addChip(2, 0, ChipColor.RED);

			assertEquals(ChipColor.NONE, Game.check(field));
		}
		

}
