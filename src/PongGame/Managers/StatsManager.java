package PongGame.Managers;

import java.util.ArrayList;
import java.util.List;

public class StatsManager {
    private static int player1Wins = 0;
    private static int player2Wins = 0;
    private static int aiWins = 0;
    private static int totalGames = 0;

    private static final List<String> matchHistory = new ArrayList<>();

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

    public static void resetStats() {
        player1Wins = 0;
        player2Wins = 0;
        aiWins = 0;
        totalGames = 0;
        matchHistory.clear();
    }
}


