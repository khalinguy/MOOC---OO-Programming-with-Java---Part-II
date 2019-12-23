/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package game;
import gameoflife.GameOfLifeBoard;
import java.util.Random;
/**
 *
 * @author Linh Nguyen
 */
public class PersonalBoard extends GameOfLifeBoard {
    
    public PersonalBoard (int width, int height){
        super (width, height);
    }
    
    
    @Override
    public void initiateRandomCells(double probabilityForEachCell) {
        for (int x = 0; x < super.getWidth(); x++){
            for (int y= 0; y < super.getHeight(); y++){
                if (new Random().nextDouble() < probabilityForEachCell){
                    this.turnToLiving(x, y);
                }
            }
        }
    }

    @Override
    public boolean isAlive(int x, int y) {
        if (this.isInBoard(x, y) && super.getBoard()[x][y] == true){
            return true;
        }
        return false;
    }

    @Override
    public void turnToLiving(int x, int y) {
        if (this.isInBoard(x, y)){
            super.getBoard() [x] [y] = true;
        }
    }

    @Override
    public void turnToDead(int x, int y) {
        if (this.isInBoard(x, y)){
            super.getBoard() [x] [y] = false;
        }
    }

 

    @Override
    public void manageCell(int x, int y, int livingNeighbours) {
        if (livingNeighbours < 2 || livingNeighbours > 3){
            this.turnToDead(x, y);
        }
        
        if (livingNeighbours == 3){
        this.turnToLiving(x, y);
        }
    }
    
    public boolean isInBoard (int x, int y){
        
        if (x < 0 || y < 0 || x >= super.getWidth() || y >= super.getHeight()){
            return false;
        }
        
        return true;
    }

    @Override
    public int getNumberOfLivingNeighbours(int x, int y) {
        int alive = 0;
        
        for (int i = x -1; i <= x + 1; i++){
            for (int j = y - 1; j <= y + 1; j++){
                if (this.isAlive(i, j)){
                    alive ++;
                }
            }
        }
        if (this.isAlive(x, y)){
            alive--;
        }

        return alive;
    }
    
}
