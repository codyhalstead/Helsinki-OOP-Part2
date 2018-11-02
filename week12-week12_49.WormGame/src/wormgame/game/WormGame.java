package wormgame.game;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Random;
import javax.swing.Timer;
import wormgame.Direction;
import wormgame.domain.Apple;
import wormgame.domain.Worm;
import wormgame.gui.Updatable;

public class WormGame extends Timer implements ActionListener {

    private int width;
    private int height;
    private boolean continues;
    private Updatable updatable;
    private Worm worm;
    private Random rand;
    private Apple apple;

    public WormGame(int width, int height) {
        super(1000, null);

        this.rand = new Random();
        this.width = width;
        this.height = height;
        this.continues = true;
        this.worm = new Worm(width/2, height/2, Direction.DOWN);
        this.apple = new Apple(rand.nextInt(width), rand.nextInt(height));
        while(worm.runsInto(apple)){
            this.apple = new Apple(rand.nextInt(width), rand.nextInt(height));
        }

        addActionListener(this);
        setInitialDelay(2000);

    }


    public boolean continues() {
        return continues;
    }

    public void setUpdatable(Updatable updatable) {
        this.updatable = updatable;
    }

    public int getHeight() {
        return height;
    }

    public int getWidth() {
        return width;
    }

    @Override
    public void actionPerformed(ActionEvent ae) {
        if (!continues) {
            return;
        }
        worm.move();
        if(worm.runsInto(apple)){
            worm.grow();
            this.apple = new Apple(rand.nextInt(width), rand.nextInt(height));
            while(worm.runsInto(apple)){
                this.apple = new Apple(rand.nextInt(width), rand.nextInt(height));
            }    
        }
        if(worm.runsIntoItself() || worm.leavesBorder(width, height)){
            this.continues = false;
        }
        this.updatable.update();
        this.setDelay(1000/worm.getLength());
    }
    
    public Worm getWorm(){
        return this.worm;
    }
    
    public void setWorm(Worm worm){
        this.worm = worm;
    }
    
    public Apple getApple(){
        return this.apple;
    }
    
    public void setApple(Apple apple){
        this.apple = apple;
    }
}
