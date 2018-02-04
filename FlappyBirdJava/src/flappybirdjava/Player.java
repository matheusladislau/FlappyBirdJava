package flappybirdjava;
import jplay.Sprite;
public class Player extends Sprite{
    double velocidade=1.3;
    public Player(int x,int y) {
        super(("src/image/bird.png"),1);
        this.setTotalDuration((long)2000);
        this.x=x;
        this.y=y;
        rotation=0.3;
    }
    public boolean collideWindow(){
        if(this.y>559){
            return true;
        }
        return false;
    }
}
