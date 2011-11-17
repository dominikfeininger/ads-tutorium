package model;

import model.Enum.ChipColor;

public class Field {

	private static final int CHIPS_TO_WIN_4_WINS = 4;
	private static final int CHIPS_TO_WIN_TICTACTOE = 3;
	
	private static final int X_4_WINS = 7;
	private static final int Y_4_WINS = 6;
	
	private static final int X_TICTACTOE= 3;
	private static final int Y_TICTACTOE = 3;
	
	private Enum.ChipColor field[][];
	private int chipsToWin;
	
/**
 * default: VierGewinnt
 */
	public Field(){
		this(X_4_WINS, Y_4_WINS, CHIPS_TO_WIN_4_WINS);
	}

	public Field(int x, int y, int rowLength) {
		field = new Enum.ChipColor[x][y];
		chipsToWin = rowLength;
//		if (isTicTacToe){
//			field = new Enum.ChipColor[X_TICTACTOE][Y_TICTACTOE];
//			chipsToWin = CHIPS_TO_WIN_TICTACTOE;
//		}else{
//			field = new Enum.ChipColor[X_4_WINS][Y_4_WINS];
//			chipsToWin = CHIPS_TO_WIN_4_WINS;
//		}
	}
	
	public void addChip(int x, int y, ChipColor chipcolor) {
		this.field[x][y] = chipcolor;
	}
	
	
	//getter & setter	
	public Enum.ChipColor[][] getField() {
		return field;
	}

	public void setField(Enum.ChipColor field[][]) {
		this.field = field;
	}
	
	public int getChipsToWin() {
		return chipsToWin;
	}

	public void setChipsToWin(int chipsToWin) {
		this.chipsToWin = chipsToWin;
	}

}
