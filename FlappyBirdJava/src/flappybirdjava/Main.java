package flappybirdjava;
import jplay.Window;
public class Main{
    public static void main(String args[]){
        Window window=new Window(800,600);
        Nivel level=new Nivel(window);
    }
        /*
        Window janela=new Window(800,600);
        Keyboard teclado=janela.getKeyboard();
        GameImage imagem_fundo=new GameImage(URL.sprite("menu.png"));
        imagem_fundo.draw();
        janela.update();
        while(true){
            if(teclado.keyDown(teclado.ESCAPE_KEY)){    
                System.exit(0);                        
            }
            if(teclado.keyDown(Keyboard.ENTER_KEY)){
               Nivel nivel=new Nivel(janela);
            }
        }
    }
*/
}