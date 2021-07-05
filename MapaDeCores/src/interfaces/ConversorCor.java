package interfaces;

import model.Cor;
import model.Imagem;

public interface ConversorCor {
    Cor converter(Cor cor);

    Imagem getNovoMapa(int altura, int largura);
}
