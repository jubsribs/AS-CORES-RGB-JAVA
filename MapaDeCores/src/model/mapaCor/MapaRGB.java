package model.mapaCor;

import Utils.FileUtil;
import model.Cor;
import model.Imagem;
import model.sistemaCor.RGB;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;

public class MapaRGB extends Imagem {
    private RGB imagemRGB[][];

    public MapaRGB(int altura, int largura) {
        super(altura, largura);
    }

    public MapaRGB(Imagem original) {
        super(original);
    }

    public static void gerarArquivoMapa (MapaRGB mapa, String nome) {
        FileUtil utils = new FileUtil();
        try {
            utils.writeFile(mapa, nome);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
