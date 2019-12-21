/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package movable;

/**
 *
 * @author Linh Nguyen
 */
public class Organism implements Movable{
    private int dx;
    private int dy;
    
    public Organism(int x, int y){
        this.dx = x;
        this.dy = y;
    }
    
    @Override
    public String toString(){
        return "x: " + dx +"; y: " + dy;
    }
    @Override
    public void move(int dx, int dy) {
        this.dx += dx;
        this.dy += dy;
    }
    
}
