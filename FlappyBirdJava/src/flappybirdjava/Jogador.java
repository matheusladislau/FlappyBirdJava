package flappybirdjava;
import java.awt.event.KeyEvent;
import javax.swing.JOptionPane;
import jplay.GameImage;
import jplay.Keyboard;
import jplay.Sprite;
import jplay.URL;
import jplay.Window;
public class Jogador extends Sprite{
    double velocidade=1.3;
    public Jogador(int x,int y) {
        super(URL.sprite("flappy2.png"),1);
        this.setTotalDuration((long)2000);
        this.x=x;
        this.y=y;
        rotation=0.3;
    }
    public boolean bater_janela(){
        if(this.y>559){
            return true;
        }
        return false;
    }
    public void setRotation(double rotation) {
        this.rotation = rotation;
    }
}
