package com.vanshajgirotra.problems.tictactoe.service;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Service;

import com.vanshajgirotra.problems.tictactoe.config.GameConfig;
import com.vanshajgirotra.problems.tictactoe.exceptions.InvalidMoveException;
import com.vanshajgirotra.problems.tictactoe.models.Cell;
import com.vanshajgirotra.problems.tictactoe.models.Player;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@RequiredArgsConstructor
@Service
public class GameService implements CommandLineRunner {

    private static final String EXIT_GAME_COMMAND = "exit";

    private final BoardService board;
    private final GameConfig config;
    private final List<Player> playerList = new ArrayList<>();
    private boolean isOver;
    private int turn = -1;

    @Override
    public void run(String... args) throws Exception {
        inputPlayers();
        board.print();
        while (!isOver) {
            turn++;
            turn %= playerList.size();
            try {
                inputMove();
                board.print();
                if (checkWinner()) {
                    System.out.println(playerList.get(turn).getName() + " won the game");
                    isOver = true;
                }
            } catch (InvalidMoveException exception) {
                System.out.println("wrong move");
                turn--;
            }
        }
    }

    private boolean checkWinner() {
        List<Cell> rowWise = new ArrayList<>();
        List<Cell> colWise = new ArrayList<>();
        List<Cell> diagonalWise = new ArrayList<>();
        List<Cell> reverseDiagonalWise = new ArrayList<>();
        for (int i = 0; i < board.getSideLength(); i++) {
            for (int j = 0; j < board.getSideLength(); j++) {
                rowWise.add(board.getCell(i, j));
                colWise.add(board.getCell(j, i));
            }
            if (checkListForWinner(rowWise) || checkListForWinner(colWise)) {
                return true;
            }
            diagonalWise.add(board.getCell(i, i));
            reverseDiagonalWise.add(board.getCell(i, board.getSideLength() - i - 1));

            rowWise.clear();
            colWise.clear();
        }
        return checkListForWinner(diagonalWise) || checkListForWinner(reverseDiagonalWise);
    }

    private boolean checkListForWinner(List<Cell> list) {
        return list.stream().distinct().count() == 1 && !Objects.equals(list.get(0).getCellValue(), Cell.EMPTY_CELL);
    }


    private void inputPlayers() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        for (int i = 0; i < config.getMaxPlayers(); i++) {
            String[] playerInput = br.readLine().split(" ");
            playerList.add(new Player(playerInput[1], playerInput[0]));
        }
    }

    private void inputMove() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String input = br.readLine();
        if (input.equals(EXIT_GAME_COMMAND)) {
            isOver = true;
            return;
        }

        String[] inputCommands = input.split(" ");
        int row = Integer.parseInt(inputCommands[0]) - 1;
        int col = Integer.parseInt(inputCommands[1]) - 1;
        board.setCellValue(row, col, playerList.get(turn).getSelectedCharacter());
    }
}

