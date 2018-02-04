package flappybirdjava;
import jplay.Sprite;
import jplay.URL;
public class Obstaculo extends Sprite{
    double velocidade=0.7;
    int posicao;
    public Obstaculo(int aleatorio,int x) {
        super(URL.sprite("cano.png"),1);
        this.x=x;
        this.posicao=aleatorio;
        switch(aleatorio){
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
    
    public Obstaculo(int aleatorio,int x,int i){
        super(URL.sprite("cano2.png"),1);
        this.x=x;
        this.posicao=aleatorio;
        switch(aleatorio){
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
    
    public boolean colisao(Jogador jogador){
        if(((jogador.x>=this.x)&&(jogador.x<this.x+width))&&((jogador.y>=this.y)&&(jogador.y<this.y+height))){
            return true;
        }else
        return false;
    }
    public void mover(){
        this.x-=velocidade;
    }
    public void atualizar(int aleatorio){
        switch(aleatorio){
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
    public void atualizar(int aleatorio,String nada){
        switch(aleatorio){
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
