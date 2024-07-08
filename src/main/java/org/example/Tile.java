package org.example;

public class Tile {
    private boolean isMine;
    private int adjacentMines;
    private boolean isRevealed;

    public Tile () {
        this.isMine = false;
        this.adjacentMines = 0;
        this.isRevealed = false;
    }

    public boolean isMine() {
        return isMine;
    }

    public void setMine (boolean isMine) {
        this.isMine = isMine;
    }

    public int getAdjacentMines() {
        return adjacentMines;
    }

    public void setAdjacentMines(int adjacentMines) {
        this.adjacentMines = adjacentMines;
    }

    public boolean isRevealed() {
        return isRevealed;
    }

    public void reveal() {
        this.isRevealed = true;
    }

}
