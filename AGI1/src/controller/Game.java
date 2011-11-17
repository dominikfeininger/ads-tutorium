package controller;

import model.Enum.ChipColor;
import model.Field;

public class Game {

 public static ChipColor check(Field field) {

		if (checkColumn(field) != ChipColor.NONE)
			return checkColumn(field);
		if (checkRow(field) != ChipColor.NONE)
			return checkRow(field);
		if (checkDiagonal(field) != ChipColor.NONE)
			return checkDiagonal(field);

		return ChipColor.NONE;
	}

	private static ChipColor checkColumn(Field field) {
		int sameChipsInColumn;

		// foreach chipcolor
		for (ChipColor color : ChipColor.values()) {

			// foreach col
			for (int i = 0; i < field.getField().length; i++) {
				sameChipsInColumn = 0;

				// each cell
				for (int j = 0; j < field.getField()[0].length; j++) {

					if (field.getField()[i][j] == color) {
						sameChipsInColumn++;
					} else {
						// when incorrect chipcolor -> null
						sameChipsInColumn = 0;
					}
					if (sameChipsInColumn >= field.getChipsToWin()) {
						return color;
					}
				}
			}
		}

		return ChipColor.NONE;
	}

	public static ChipColor checkRow(Field field) {
		int sameChipsInRow;

		// foreach chipcolor
		for (ChipColor color : ChipColor.values()) {

			// foreach row
			for (int i = 0; i < field.getField()[0].length; i++) {
				sameChipsInRow = 0;

				// each cell
				for (int j = 0; j < field.getField().length; j++) {

					if (field.getField()[j][i] == color) {
						sameChipsInRow++;
					} else {
						// when incorrect chipcolor -> null
						sameChipsInRow = 0;
					}
					if (sameChipsInRow >= field.getChipsToWin()) {
						return color;
					}
				}
			}
		}

		return ChipColor.NONE;
	}

	public static ChipColor checkDiagonal(Field field) {
		int sameChipsInDia;

		// foreach chipcolor
		for (ChipColor color : ChipColor.values()) {
			sameChipsInDia = 0;
			
			//DIAGONAL rightUp
			//================
			//foreach row (only the first possible cell)
			for (int i = 0; i < field.getField().length - (field.getChipsToWin() - 1); i++) {
				sameChipsInDia = 0;
				// foreach col (only the first possible cell)
				for (int j = 0; j < field.getField()[0].length	- (field.getChipsToWin() - 1); j++) {

					if (field.getField()[i][j] == color) {
						sameChipsInDia++;

						//check other 3 in dia
						for (int k = 1; k < field.getChipsToWin(); k++) {
							if (field.getField()[i + k][j + k] == color) {
								sameChipsInDia++;
							} else {
								sameChipsInDia = 0;
							}
						}
						
						if (sameChipsInDia >= field.getChipsToWin()) {
							return color;
						}
					}
				}
			}

			//DIAGONAL RightDown
			//==================
			sameChipsInDia = 0;
			//foreach row (only the first possible cell)
			for (int i = 0; i < field.getField().length - (field.getChipsToWin() - 1); i++) {
				sameChipsInDia = 0;
				// foreach col (only the first possible cell)
				for (int j = (field.getChipsToWin() - 1); j < field.getField()[0].length; j++) {

					if (field.getField()[i][j] == color) {
						sameChipsInDia++;

						//check other 3 in dia
						for (int k = 1; k < field.getChipsToWin(); k++) {
							if (field.getField()[i + k][j - k] == color) {
								sameChipsInDia++;
							} else {
								sameChipsInDia = 0;
							}
						}						
						if (sameChipsInDia >= field.getChipsToWin()) {
							return color;
						}
					}
				}
			}
		}
		return ChipColor.NONE;
	}
}