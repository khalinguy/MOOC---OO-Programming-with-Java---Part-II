/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package movingfigure;

import java.awt.Color;
import java.awt.Graphics;
import java.util.ArrayList;
import java.util.List;
/**
 *
 * @author Linh Nguyen
 */
public class CompoundFigure extends Figure {
    private List<Figure> compound;
    
    public CompoundFigure (){
        compound = new ArrayList<Figure>();
    }
    
    public void add (Figure f){
        compound.add(f);
    }
    
    @Override
    public void move (int dx, int dy){
        for (Figure figure: compound){
            figure.move(dx, dy);
        }
    }
    @Override
    public void draw(Graphics graphics) {
        graphics.setColor(Color.green);
        for (Figure figure: compound){
            figure.draw(graphics);
        }
    }
    
}
