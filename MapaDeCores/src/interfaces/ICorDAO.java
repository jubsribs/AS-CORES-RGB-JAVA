package interfaces;

import model.Cor;
import model.Imagem;

import java.util.Collection;

public interface ICorDAO {

    public void salvar(Cor cor) throws Exception;
    public Collection<Cor> findCoresBySimbolo(String simbolo) throws Exception;

}
