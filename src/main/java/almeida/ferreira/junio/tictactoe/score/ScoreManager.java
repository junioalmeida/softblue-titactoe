package almeida.ferreira.junio.tictactoe.score;

import java.io.IOException;

import almeida.ferreira.junio.tictactoe.core.Player;

public interface ScoreManager {
	
	Integer getScore(Player player);
	void saveScore(Player player) throws IOException;
}
