package flappybirdjava;
import jplay.Sprite;
public class Pipe extends Sprite{
    double velocity=0.7;
    int position;
    public Pipe(int random,int x) {
        super("src/image/pipe.png",1);
        this.x=x;
        this.position=random;
        switch(random){
            case 0:
                this.y=300; 
                break;
            case 1:
                this.y=400;
                break;
            case 2:
                this.y=450;
                break;
            case 3:
                this.y=500;
                break;
            case 4:
                this.y=350;
                break;
            default:
                break;
            }
        }       
    
    public Pipe(int random,int x,int i){
        super("src/image/pipe2.png",1);
        this.x=x;
        this.position=random;
        switch(random){
            case 0:
                this.y=-150;
                break;
            case 1:
                this.y=-100;
                break;
            case 2:
                this.y=-75;
                break;
            case 3:
                this.y=-50;
                break;
            case 4:
                this.y=-125;
                break;
             default: 
                break;
            }
        } 
    
    public boolean collide(Player player){
        if(((player.x>=this.x)&&(player.x<this.x+width))&&((player.y>=this.y)&&(player.y<this.y+height))){
            return true;
        }else
        return false;
    }
    
    public void move(){
        this.x-=velocity;
    }
    
    public void update(int random){
        switch(random){
            case 0:
                this.y=300; 
                break;
            case 1:
                this.y=400;
                break;
            case 2:
                this.y=450;
                break;
            case 3:
                this.y=500;
                break;
            case 4:
                this.y=350;
                break;
            default:
                break;
            }
    }
    public void update(int random,String nada){
        switch(random){
            case 0:
                this.y=-150;
                break;
            case 1:
                this.y=-100;
                break;
            case 2:
                this.y=-75;
                break;
            case 3:
                this.y=-50;
                break;
            case 4:
                this.y=-125;
                break;
            default: 
                break;
            }
    }
}
