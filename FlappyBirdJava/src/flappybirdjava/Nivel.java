package flappybirdjava;
import java.awt.Color;
import java.awt.Font;
import java.util.Random;
import java.awt.event.KeyEvent;
import javax.swing.JOptionPane;
import jplay.GameImage;
import jplay.Keyboard;
import jplay.URL;
import jplay.Window;
public class Nivel{
    private Window janela;
    private Jogador jogador;
    private Keyboard teclado;
    private GameImage imagem_fundo;
    public int nobstaculos=4;
    private Obstaculo[] obstaculos=new Obstaculo[nobstaculos];
    private boolean vivo=true;
    Music musica=new Music();
    int a=0;
    Random gerador = new Random();
    public int pontos=0;
    static double gravidade=2;
//
    Font f=new Font("arial",Font.BOLD,18);
    public void mostrarPontos(Window janela){
        janela.drawText(("PONTOS: "+this.pontos),20,50,Color.black,f);
    }
//
    public Nivel(Window window){
        this.janela=window;
        teclado=janela.getKeyboard();
        imagem_fundo=new GameImage("src/image/background.png");
        jogador=new Jogador(25,250);
        mostrarPontos(janela);
        
        for (int i=0,j=1; i<nobstaculos; i++,j++) {
            int aleatorio=gerador.nextInt(5);
            obstaculos[i]=new Obstaculo(aleatorio,(800/j));
            obstaculos[i].x=(800/j)+obstaculos[i].width;
            i++;
            obstaculos[i]=new Obstaculo(aleatorio,(800/j),1);
            obstaculos[i].x=(800/j)+obstaculos[i].width;
        }
        musica.play("mus_birdsong.wav");
        while(a==0){
            imagem_fundo.draw();
                for (int i=0; i<nobstaculos; i++) {
                    obstaculos[i].draw();
                }
                jogador.draw();
                janela.update();
            if(teclado.keyDown(teclado.ESCAPE_KEY)){    
                System.exit(0);                        
            }
            if(teclado.keyDown(Keyboard.UP_KEY)){
               a=1;
            }
        }
        run();
    }
    public void run(){
        while(true){
            mostrarPontos(janela);
            atualizar();
            cair();  
            voar();
        }
    }
    public void atualizar(){
        for(int i=0; i<nobstaculos; i++){
            obstaculos[i].mover();
        }
        reporObstaculo();
        verificarBatidaJanela();
        for (int i=0; i<nobstaculos; i++) {
            if(obstaculos[i].colisao(jogador)==true){
                vivo=false;
            }   
        }
            if(vivo==false){
                morrer();
            }
        imagem_fundo.draw();
        for(int i=0; i<nobstaculos; i++){
            obstaculos[i].draw();
            obstaculos[i].colisao(jogador);
        }
        jogador.draw();
        mostrarPontos(janela);
        janela.update();
    }
    public void voar(){
        if(teclado.keyDown(KeyEvent.VK_UP)){
            for(int i=0; i<7; i++){
                if(jogador.y>(0)){
                    jogador.y-=jogador.velocidade;
                    atualizar();
                }
            }
        }
    }
    public void verificarBatidaJanela(){
        if(jogador.bater_janela()){
           vivo=false;
        }
    }
    public void morrer(){
        musica.play("fall.wav","umavez");
        jogador.setRotation(2);
        while(true){
            while(jogador.y<550){
                jogador.y+=4;
                imagem_fundo.draw();
                for (int i=0; i<nobstaculos; i++) {
                    obstaculos[i].draw();
                }
                jogador.draw();
                janela.update();
            }       
            JOptionPane.showMessageDialog(null,"Você morreu!");
            musica.stop();
            System.exit(0);
        }
        }
    public void cair(){
        jogador.y+=gravidade;
        atualizar();
    }
    public void reporObstaculo(){
        for (int i=0; i<nobstaculos; i++) {
            if(obstaculos[i].x<=(0-obstaculos[i].width)){
                int aleatorio=gerador.nextInt(5);
                obstaculos[i].atualizar(aleatorio);
                obstaculos[i].x=800;
                pontos++;
                i++;
                obstaculos[i].atualizar(aleatorio,"");
                obstaculos[i].x=800;
                pontos++;
                pontos-=1;
            }
        }
    }
}
