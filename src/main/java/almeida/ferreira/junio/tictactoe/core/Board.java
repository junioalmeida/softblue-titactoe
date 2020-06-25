package almeida.ferreira.junio.tictactoe.core;

import almeida.ferreira.junio.tictactoe.Constants;
import almeida.ferreira.junio.tictactoe.ui.UI;

public class Board {

	private char[][] matrix;

	public Board() {

		matrix = new char[Constants.BOARD_SIZE][Constants.BOARD_SIZE];
		clear();
	}

	public void clear() {

		for (int i = 0; i < Constants.BOARD_SIZE; i++) {
			for (int j = 0; j < Constants.BOARD_SIZE; j++) {
				matrix[i][j] = ' ';
			}
		}
	}

	public void print() {
		UI.printNewLine();
		for (int i = 0; i < Constants.BOARD_SIZE; i++) {
			for (int j = 0; j < Constants.BOARD_SIZE; j++) {
				System.out.print(matrix[i][j]);

				if (j + 1 < Constants.BOARD_SIZE) {
					UI.printTextWithoutNewLine(" | ");
				}
			}

			UI.printNewLine();

			if (i + 1 < Constants.BOARD_SIZE) {
				UI.printText("---------");
			}
		}
	}

	public boolean isFull() {

		for (int i = 0; i < Constants.BOARD_SIZE; i++) {
			for (int j = 0; j < Constants.BOARD_SIZE; j++) {
				if (matrix[i][j] == ' ')
					return false;
			}
		}

		return true;
	}

	public boolean play(Player player, Move move) {

		int i = move.getI();
		int j = move.getJ();
		
		// TODO Desenvolver checagem de termino do jogo
		// TODO Desenvolver verificar se a jogada e valida

		matrix[i][j] = player.getSymbol();
		
		return checkRows(player) || checkColumns(player) || checkDiagonal1(player) || checkDiagonal2(player);
	}

	private boolean checkRows(Player player) {

		for (int i = 0; i < Constants.BOARD_SIZE; i++) {
			if (checkRow(i, player))
				return true;
		}

		return false;
	}

	private boolean checkRow(int i, Player player) {

		char symbol = player.getSymbol();

		for (int j = 0; j < Constants.BOARD_SIZE; j++) {
			if (symbol != matrix[i][j])
				return false;
		}

		return true;
	}

	private boolean checkColumns(Player player) {

		for (int j = 0; j < Constants.BOARD_SIZE; j++) {
			if (checkColumn(j, player))
				return true;
		}

		return false;
	}

	private boolean checkColumn(int j, Player player) {

		char symbol = player.getSymbol();

		for (int i = 0; i < Constants.BOARD_SIZE; i++) {
			if (symbol != matrix[i][j])
				return false;
		}

		return true;
	}

	private boolean checkDiagonal1(Player player) {

		char symbol = player.getSymbol();

		for (int i = 0; i < Constants.BOARD_SIZE; i++) {
			if(symbol != matrix[i][i]) {
				return false;
			}
		}
		
		return true;
	}

	private boolean checkDiagonal2(Player player) {

		char symbol = player.getSymbol();
		int lastLine = Constants.BOARD_SIZE - 1;
		
		for (int i = 0, j = lastLine; i <= lastLine; i++, j--) {
			if(symbol != matrix[i][j]) {
				return false;
			}
		}
		
		return true;
	}
	
}
