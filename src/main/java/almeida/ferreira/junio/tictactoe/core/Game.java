package almeida.ferreira.junio.tictactoe.core;

import almeida.ferreira.junio.tictactoe.Constants;
import almeida.ferreira.junio.tictactoe.ui.UI;

public class Game {

	private Board board;
	private Player[] players;
	
	public Game() {
		board = new Board();
		players = new Player[Constants.SYMBOL_PLAYERS.length];
	}

	public void play() {

		UI.printGameTitle();
		
		board.print();
		
		//UI.readText("Nome do Jogador:");

	}

}
