import java.io.*;
import java.util.Random;

public class Game {
//test
    private static final String GAME_STATE_FILE = "gameState.csv";

    public static void main(String[] args) {
        Random random = new Random();
        GameState gameState = readGameStateFromFile();

        int randomNumber = random.nextInt(10);
        int randomNumber2 = random.nextInt(10);
        int totalRoll = randomNumber + randomNumber2;
        gameState.setSpacesMoved(gameState.getSpacesMoved() + totalRoll);

        if (gameState.getSpacesMoved() >= 50) {
            System.out.println("Game over");
            gameState.setSpacesMoved(0);
            gameState.setCoinAmount(0);
            gameState.setStarAmount(0);
        }

        System.out.println("You rolled: " + totalRoll);
        System.out.println("Total spaces moved: " + gameState.getSpacesMoved());
        System.out.println("You have " + gameState.getCoinAmount() + " coins");
        System.out.println("You have " + gameState.getStarAmount() + " stars");

        writeGameStateToFile(gameState);
    }

    public static GameState readGameStateFromFile() {
        try (BufferedReader br = new BufferedReader(new FileReader(GAME_STATE_FILE))) {
            String line = br.readLine();
            if (line != null) {
                String[] parts = line.split(",");
                int spacesMoved = Integer.parseInt(parts[0]);
                int coinAmount = Integer.parseInt(parts[1]);
                int starAmount = Integer.parseInt(parts[2]);
                return new GameState(spacesMoved, coinAmount, starAmount);
            }
        } catch (IOException | NumberFormatException e) {
            System.out.println("Error reading file: " + e);
        }
        return new GameState();
    }

    public static void writeGameStateToFile(GameState gameState) {
        try (BufferedWriter bw = new BufferedWriter(new FileWriter(GAME_STATE_FILE))) {
            String csvLine = String.format("%d,%d,%d",
                    gameState.getSpacesMoved(), gameState.getCoinAmount(), gameState.getStarAmount());
            bw.write(csvLine);
        } catch (IOException e) {
            System.out.println("Error writing file: " + e);
        }
    }
}//end class