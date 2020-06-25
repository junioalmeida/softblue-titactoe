package almeida.ferreira.junio.tictactoe.core;

import almeida.ferreira.junio.tictactoe.Constants;
import almeida.ferreira.junio.tictactoe.ui.UI;

public class Game {

	private Board board;
	private Player[] players;
	private int currentPlayerIndex;

	public Game() {
		board = new Board();
		players = new Player[Constants.SYMBOL_PLAYERS.length];
		currentPlayerIndex = -1;
	}

	public void play() {

		UI.printGameTitle();

		for (int i = 0; i < players.length; i++) {
			players[i] = createPlayer(i);
		}

		boolean gameEnded = false;
		boolean sequenceFound;
		Player currentPlayer = null;

		while (!gameEnded) {

			currentPlayer = nextPlayer();
			
			board.print();
			
			UI.printNewLine();
			
			sequenceFound = currentPlayer.play();

			if (sequenceFound) {
				//UI.printText("O(a) Jogador(a) '" + currentPlayer.getName() + "' venceu a partida!");
				gameEnded = true;
			} else if (board.isFull()) {
				gameEnded = true;
				currentPlayer = null;
			}
		}
		
		UI.printNewLine();
		
		if(currentPlayer == null) {
			UI.printText("O jogo ficou empatado.");
		}else {
			UI.printText("O(a) Jogador(a) '" + currentPlayer.getName() + "' venceu a partida!");
		}
		
		board.print();
		UI.printNewLine();
		UI.printText("Fim do Jogo!");

	}

	private Player createPlayer(int index) {

		String name = UI.readText("Jogador(a) " + (index + 1) + " =>");
		char symbol = Constants.SYMBOL_PLAYERS[index];

		Player player = new Player(name, symbol, board);

		UI.printText("\t->'" + name + "' vai utilizar o símbolo '" + symbol + "'.");

		return player;
	}

	private Player nextPlayer() {

		currentPlayerIndex = (currentPlayerIndex + 1) % players.length;

		return players[currentPlayerIndex];
	}

}
