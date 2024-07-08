package org.example;

public class Tile {
    private boolean isMine;
    private int adjacentMines;
    private boolean isRevealed;
    private boolean flag;

    public Tile () {
        this.isMine = false;
        this.adjacentMines = 0;
        this.isRevealed = false;
        this.flag = false;
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

    public boolean isFlag() {
        return flag;
    }

    public void setFlag(boolean flag) {
        this.flag = flag;
    }

}
