package interfaces;

import model.Cor;
import model.Imagem;

public interface IConversorCor {
    Cor converter(Cor cor);

    Imagem getNovoMapa(int altura, int largura);
}
