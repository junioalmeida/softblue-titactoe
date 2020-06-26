package almeida.ferreira.junio.tictactoe.score;

import almeida.ferreira.junio.tictactoe.core.Player;

public interface ScoreManager {
	
	Integer getScore(Player player);
	void saveScore(Player player);
}
