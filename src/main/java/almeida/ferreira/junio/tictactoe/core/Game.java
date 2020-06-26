package almeida.ferreira.junio.tictactoe.core;

import almeida.ferreira.junio.tictactoe.Constants;
import almeida.ferreira.junio.tictactoe.score.ScoreManager;
import almeida.ferreira.junio.tictactoe.ui.UI;

public class Game {

	private Board board;
	private Player[] players;
	private int currentPlayerIndex;
	private ScoreManager scoreManager;

	public Game() {
		board = new Board();
		players = new Player[Constants.SYMBOL_PLAYERS.length];
		currentPlayerIndex = -1;
		scoreManager = getScoreManager();
	}

	public void play() {

		UI.printGameTitle();

		for (int i = 0; i < players.length; i++) {
			players[i] = createPlayer(i);
		}

		boolean gameEnded = false;
		boolean sequenceFound;
		Player currentPlayer = nextPlayer();

		while (!gameEnded) {

			board.print();

			UI.printNewLine();

			try {
				sequenceFound = currentPlayer.play();
			} catch (InvalidMoveException e) {
				UI.printText("ERRO: " + e.getMessage());
				continue;
			}

			if (sequenceFound) {
				gameEnded = true;
			} else if (board.isFull()) {
				gameEnded = true;
				currentPlayer = null;
			} else {
				currentPlayer = nextPlayer();
			}
		}

		UI.printNewLine();

		if (currentPlayer == null) {
			UI.printText("O jogo ficou empatado.");
		} else {
			UI.printText("O(a) Jogador(a) '" + currentPlayer.getName() + "' venceu a partida!");

			scoreManager.saveScore(currentPlayer);
		}

		board.print();
		UI.printNewLine();
		UI.printText("Fim do Jogo!");

	}

	private Player createPlayer(int index) {

		String name = UI.readText("Jogador(a) " + (index + 1) + " =>");
		char symbol = Constants.SYMBOL_PLAYERS[index];

		Player player = new Player(name, symbol, board);

		Integer score = scoreManager.getScore(player);

		if (score != null) {
			String word = score <= 1 ? "vitória" : "vitórias";
			UI.printText("O jogador '" + player.getName() + "' possui " + score + word);
		}

		UI.printText("\t->'" + name + "' vai utilizar o símbolo '" + symbol + "'.");

		return player;
	}

	private Player nextPlayer() {

		currentPlayerIndex = (currentPlayerIndex + 1) % players.length;

		return players[currentPlayerIndex];
	}

	private ScoreManager getScoreManager() {
		return null;
	}

}
