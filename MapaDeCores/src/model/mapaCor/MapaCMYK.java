package model.mapaCor;

import Utils.FileUtil;
import model.Cor;
import model.Imagem;
import model.sistemaCor.CMYK;
import model.sistemaCor.RGB;

import java.io.IOException;

public class MapaCMYK extends Imagem {
    private CMYK imagemCMYK[][];


    public MapaCMYK(int altura, int largura) {
        super(altura, largura);
    }

    public MapaCMYK(Imagem original) {
        super(original);
    }

    public void gerarArquivoMapa (MapaCMYK mapa, String nome) {
        FileUtil utils = new FileUtil();

        try {
            utils.writeFile(mapa, nome);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
