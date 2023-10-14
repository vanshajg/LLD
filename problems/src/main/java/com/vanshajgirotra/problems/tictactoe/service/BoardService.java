package com.vanshajgirotra.problems.tictactoe.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Component;

import com.vanshajgirotra.problems.tictactoe.config.BoardConfig;
import com.vanshajgirotra.problems.tictactoe.exceptions.InvalidMoveException;
import com.vanshajgirotra.problems.tictactoe.models.Cell;

import jakarta.annotation.PostConstruct;
import lombok.Getter;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Component
@Getter
public class BoardService {
    private final BoardConfig config;
    private final List<List<Cell>> boardCells = new ArrayList<>();

    private int sideLength;

    @PostConstruct
    private void init() {
        for (int i = 0; i < config.getSideLength(); i++) {
            List<Cell> cells = new ArrayList<>();
            for (int j = 0; j < config.getSideLength(); j++) {
                cells.add(new Cell());
            }
            boardCells.add(cells);
        }
        sideLength = config.getSideLength();
    }

    public Cell getCell(int row, int col) {
        return boardCells.get(row).get(col);
    }

    public void setCellValue(int row, int col, String value) {

        if (row < 0 || row >= config.getSideLength() || col < 0 || col >= config.getSideLength()) {
            throw new InvalidMoveException();
        } else if (!boardCells.get(row).get(col).getCellValue().equals(Cell.EMPTY_CELL)) {
            throw new InvalidMoveException();
        }
        boardCells.get(row).get(col).setCellValue(value);
    }

    public void print() {
        for (int i = 0; i < config.getSideLength(); i++) {
            for (int j = 0; j < config.getSideLength(); j++) {
                System.out.print(boardCells.get(i).get(j).getCellValue() + " ");
            }
            System.out.println();
        }
    }
}
