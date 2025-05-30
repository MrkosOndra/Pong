package PongGame.Managers;

import java.util.ArrayList;
import java.util.List;
/**
 * Manages game statistics such as wins, losses, and coins earned.
 */
public class StatsManager {
    private static int player1Wins = 0;
    private static int player2Wins = 0;
    private static int aiWins = 0;
    private static int totalGames = 0;

    private static final List<String> matchHistory = new ArrayList<>();
    /**
     * Records the result of a finished match and updates statistics.
     * This method updates the total number of games played and adds
     * the outcome to the match history. It also increments the win counter
     * for the appropriate player or AI depending on the match type and result.</p>
     *
     * @param twoPlayers   true if the game was played between two human players, false if against AI
     * @param player1Won   true if player 1 won the game, false otherwise
     * @param score1       the final score of player 1
     * @param score2       the final score of player 2 or AI
     */
    public static void recordMatch(boolean twoPlayers, boolean player1Won, int score1, int score2) {
        totalGames++;
        String result;

        if (player1Won) {
            player1Wins++;
            result = "Hráč 1 vyhrál " + score1 + ":" + score2 + (twoPlayers ? " proti Hráči 2" : " proti AI");
        } else {
            if (twoPlayers) {
                player2Wins++;
                result = "Hráč 2 vyhrál " + score2 + ":" + score1 + " proti Hráči 1";
            } else {
                aiWins++;
                result = "AI vyhrála " + score2 + ":" + score1 + " proti Hráči 1";
            }
        }

        matchHistory.add(result);
    }

    public static int getPlayer1Wins() {
        return player1Wins;
    }

    public static int getPlayer2Wins() {
        return player2Wins;
    }

    public static int getAiWins() {
        return aiWins;
    }

    public static int getTotalGames() {
        return totalGames;
    }

    public static List<String> getMatchHistory() {
        return matchHistory;
    }

}


