package service;

import java.util.Deque;
import java.util.LinkedList;
import java.util.concurrent.ThreadLocalRandom;

import models.Board;
import models.Cell;
import models.Dice;
import models.Jumper;
import models.Player;

public class GameService {
    private final Deque<Player> players = new LinkedList<>();
    private Dice dice;
    private Board board;
    private Player winner;

    public void startGame() {
        initGame();
        while (winner == null) {
            // check player turn
            Player player = getNextPlayer();
            System.out.println(player.name() + " is playing");

            // roll dice
            int diceValue = dice.roll();
            System.out.println(player.name() + " got " + diceValue);

            // move player
            int newPosition = player.position() + diceValue;
            if (newPosition > board.size()) {
                System.out.println(player.name() + " cannot move");
            } else if (newPosition == board.size()) {
                winner = player;
                System.out.println(player.name() + " won the game");
            } else {
                System.out.println(player.name() + " moved to " + newPosition);
                newPosition = getNewPosition(newPosition);
                player.position(newPosition);
            }
        }
    }

    private void initGame() {
        initPlayers();
        initDice();
        initBoard(10, 10);
    }

    private Player getNextPlayer() {
        Player player = players.removeFirst();
        players.addLast(player);
        return player;
    }

    private int getNewPosition(int newPosition) {
        Cell cell = board.cells()[newPosition];
        if (cell.getJumper() != null) {
            String jumper = cell.getJumper().from() < cell.getJumper().to() ? "ladder" : "snake";
            System.out.println("Got " + jumper + " at " + newPosition + " moving to " + cell.getJumper().to());
            return cell.getJumper().to();
        }
        return newPosition;
    }


    private void initPlayers() {
        players.add(new Player("Vanshaj", 0));
        players.add(new Player("Sarthak", 0));
    }

    private void initDice() {
        dice = new Dice(6, 1);
    }

    private void initBoard(int snakeCount, int ladderCount) {
        int size = 100;
        Cell[] cells = new Cell[size];
        for (int i = 0; i < size; i++) {
            cells[i] = new Cell();
        }
        board = new Board(size, cells);

        while (snakeCount > 0) {
            int start = ThreadLocalRandom.current().nextInt(1, size);
            int end = ThreadLocalRandom.current().nextInt(1, size);
            if (start > end) {
                board.cells()[start].setJumper(new Jumper(start, end));
                snakeCount--;
            }
        }
        while (ladderCount > 0) {
            int start = ThreadLocalRandom.current().nextInt(1, size);
            int end = ThreadLocalRandom.current().nextInt(1, size);
            if (start < end) {
                board.cells()[start].setJumper(new Jumper(start, end));
                ladderCount--;
            }
        }
    }


}
