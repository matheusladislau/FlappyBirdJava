package flappybirdjava;
import java.awt.Color;
import java.awt.Font;
import java.util.Random;
import java.awt.event.KeyEvent;
import javax.swing.JOptionPane;
import jplay.GameImage;
import jplay.Keyboard;
import jplay.Window;
public class Level{
    private Window window;
    private Player player;
    private Keyboard keyboard;
    private GameImage background;
    public int nPipes=4;
    private Pipe[] pipes=new Pipe[nPipes];
    private boolean alive=true;
    Music music=new Music();
    int aux=0;
    Random random=new Random();
    public int points=0;
    static double gravity=2;
//
    Font f=new Font("arial",Font.BOLD,18);
    
    public void showPoints(Window window){
        window.drawText(("POINTS: "+this.points),20,50,Color.black,f);
    }
//
    public Level(Window window){
        this.window=window;
        keyboard=window.getKeyboard();
        background=new GameImage("src/image/background.png");
        player=new Player(25,250);
        showPoints(window);
        
        for (int i=0,j=1; i<nPipes; i++,j++) {
            int rand=random.nextInt(5);
            pipes[i]=new Pipe(rand,(800/j));
            pipes[i].x=(800/j)+pipes[i].width;
            i++;
            pipes[i]=new Pipe(rand,(800/j),1);
            pipes[i].x=(800/j)+pipes[i].width;
        }
        music.play("mus_birdsong.wav");
        while(aux==0){
            background.draw();
                for (int i=0; i<nPipes; i++) {
                    pipes[i].draw();
                }
                player.draw();
                window.update();
            if(keyboard.keyDown(keyboard.ESCAPE_KEY)){    
                System.exit(0);                        
            }
            if(keyboard.keyDown(Keyboard.UP_KEY)){
               aux=1;
            }
        }
        run();
    }
    public void run(){
        while(true){
            showPoints(window);
            update();
            fall();  
            fly();
        }
    }
    public void update(){
        for(int i=0; i<nPipes; i++){
            pipes[i].move();
        }
        replacePipe();
        verifyCollideWindow();
        for (int i=0; i<nPipes; i++) {
            if(pipes[i].collide(player)==true){
                alive=false;
            }   
        }
            if(alive==false){
                gameOver();
            }
        background.draw();
        for(int i=0; i<nPipes; i++){
            pipes[i].draw();
            pipes[i].collide(player);
        }
        player.draw();
        showPoints(window);
        window.update();
    }
    public void fly(){
        if(keyboard.keyDown(KeyEvent.VK_UP)){
            for(int i=0; i<7; i++){
                if(player.y>(0)){
                    player.y-=player.velocidade;
                    update();
                }
            }
        }
    }
    public void verifyCollideWindow(){
        if(player.collideWindow()){
           alive=false;
        }
    }
    public void gameOver(){
        music.play("fall.wav","umavez");
        player.setRotation(2);
        while(true){
            while(player.y<550){
                player.y+=4;
                background.draw();
                for (int i=0; i<nPipes; i++) {
                    pipes[i].draw();
                }
                player.draw();
                window.update();
            }       
            JOptionPane.showMessageDialog(null,"Game Over!\nPoints: "+points);
            music.stop();
            System.exit(0);
        }
        }
    public void fall(){
        player.y+=gravity;
        update();
    }
    public void replacePipe(){
        for (int i=0; i<nPipes; i++) {
            if(pipes[i].x<=(0-pipes[i].width)){
                int rand=random.nextInt(5);
                pipes[i].update(rand);
                pipes[i].x=800;
                points++;
                i++;
                pipes[i].update(rand,"");
                pipes[i].x=800;
                points++;
                points-=1;
            }
        }
    }
}
