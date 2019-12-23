/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package wormgame.domain;

import java.util.ArrayList;
import java.util.List;
import wormgame.Direction;

/**
 *
 * @author Linh Nguyen
 */
public class Worm {

    private int originalX;
    private int originalY;
    private Direction direction;
    private List<Piece> worm;
    private boolean grow;

    public Worm(int originalX, int originalY, Direction originalDirection) {
        this.originalX = originalX;
        this.originalY = originalY;
        this.direction = originalDirection;
        worm = new ArrayList<Piece>();
        worm.add(new Piece(originalX, originalY));
        this.grow = false;
    }

    public Direction getDirection() {
        return direction;
    }

    public void setDirection(Direction dir) {
        this.direction = dir;
    }

    public int getLength() {
        return worm.size();
    }

    public List<Piece> getPieces() {
        return this.worm;
    }

    public void move() {
        int newX = this.wormHeadX();
        int newY = this.wormHeadY();
        if (direction == Direction.UP) {
            newY--;
        } else if (direction == Direction.DOWN) {
            newY++;
        } else if (direction == Direction.LEFT) {
            newX--;
        } else if (direction == Direction.RIGHT) {
            newX++;
        }

        if (this.getLength() > 2 && !grow) {
            worm.remove(0);
        }

        if (grow = true) {
            grow = false;
        }

        worm.add(new Piece(newX, newY));
    }

    public void grow() {
        this.grow = true;
    }

    public boolean runsInto(Piece piece) {
        for (int i = 0; i < getLength(); i++) {
            if (worm.get(i).getX() == piece.getX() && worm.get(i).getY() == piece.getY()) {
                return true;
            }
        }
        return false;
    }

    public boolean runsIntoItself() {
        for (int i = 0; i < this.worm.size() - 1; i++) {
            if (this.worm.get(i).getX() == wormHeadX() && this.worm.get(i).getY() == wormHeadY()) {
                return true;
            }

        }

        return false;
    }

    public int wormHeadX() {
        return this.worm.get(this.worm.size() - 1).getX();
    }

    public int wormHeadY() {
        return this.worm.get(this.worm.size() - 1).getY();
    }
    
    
}
