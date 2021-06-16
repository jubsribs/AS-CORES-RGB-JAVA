import model.Imagem;
import model.Pixel;

public class App {
    public static void main(String[] args) {
        Pixel pixel = new Pixel(0,0,0);
        Imagem imagem = new Imagem(2,2);


        System.out.println("PIXEL -> "+pixel);
        System.out.println("IMAGEM -> "+imagem);
    }
}
