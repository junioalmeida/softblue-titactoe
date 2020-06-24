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

	public void play(char symbol, Move move) {
		
		int i = move.getI();
		int j = move.getJ();
		
		//TODO Desenvolver checagem de vencedor
		//TODO Desenvolver checagem de termino do jogo
		//TODO Desenvolver verificar se a jogada e valida
		
		matrix[i][j] = symbol;
	}

}
