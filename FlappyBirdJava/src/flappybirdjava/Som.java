package flappybirdjava;
import jplay.Sound;
import jplay.URL;
public class Som {
    private static Sound musica;
    public static void play(String nome_musica){
        stop();
        musica=new Sound(URL.audio(nome_musica));
        musica.play();
        musica.setRepeat(true);
    }
    public static void play(String nome_musica,String nada){
        musica=new Sound(URL.audio(nome_musica));
        musica.play();
        musica.setRepeat(false);
    }
    public static void stop(){
        if(musica!=null){
            musica.stop();
        }
    }
}
