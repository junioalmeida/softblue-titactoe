package almeida.ferreira.junio.tictactoe.score;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

import almeida.ferreira.junio.tictactoe.core.Player;

public class FileScoreManager implements ScoreManager{

	private static final Path SCORE_PATH = Path.of("score.txt");
	private Map<String, Integer> scoreMap = new HashMap<>();
	
	public FileScoreManager() throws IOException {
		setup();
	}

	private void setup() throws IOException {
		
		if(!Files.exists(SCORE_PATH)) {
			Files.createFile(SCORE_PATH);
		}else {
			
			try (BufferedReader reader = Files.newBufferedReader(SCORE_PATH)){
				
				String line;
				
				while((line = reader.readLine()) != null) {
					String[] tokens = line.split("\\|");
					
					if(tokens.length != 2) {
						throw new IOException("O arquivo de gravação de pontuação foi corrompido.");
					}
					
					scoreMap.put(tokens[0], Integer.parseInt(tokens[1]));
				}
			}
		}
	}

	@Override
	public Integer getScore(Player player) {
		return scoreMap.get(player.getName().toUpperCase());
	}

	@Override
	public void saveScore(Player player) throws IOException {
		
		Integer score = getScore(player);
		
		if(score == null) {
			score = 0;
		}
		
		score++;
		
		scoreMap.put(player.getName().toUpperCase(), score);
		
		try (BufferedWriter writer = Files.newBufferedWriter(SCORE_PATH)){
			
			Set<Map.Entry<String, Integer>> entries = scoreMap.entrySet();
			
			for (Map.Entry<String, Integer> entry : entries) {
				
				String nameWrite = entry.getKey();
				Integer scoreWrite = entry.getValue();
				
				writer.write(nameWrite + "|" + scoreWrite);
				writer.newLine();
			}
		}
	}
	
	

}
