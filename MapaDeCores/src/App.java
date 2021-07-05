import model.Cor;
import model.Imagem;
import model.sistemaCor.CMYK;
import model.sistemaCor.RGB;

public class App {
    public static void main(String[] args) {
        Cor pretoRGB = new RGB();
        Cor pretoCMYK = new CMYK();


        System.out.println("preto rgb " + pretoRGB);
        System.out.println("preto cmyk " + pretoCMYK);
    }
}
