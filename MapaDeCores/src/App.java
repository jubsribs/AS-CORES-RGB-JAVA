import Persistencia.CorDAO;
import Utils.FileUtil;
import connection.SQLConnection;
import interfaces.ICorDAO;
import model.*;
import model.sistemaCor.*;
import model.mapaCor.*;

import java.sql.SQLException;
import java.util.Collection;

public class App {
    public static void main(String[] args) {
        SQLConnection sql = new SQLConnection();

        try {
            sql.startConnection();
            sql.getConnection();
            FileUtil utils = new FileUtil();

//            MapaRGB.gerarArquivoMapa();
//
//            MapaRGB mapaRGB = (Imagem) utils.readFile("");

            ICorDAO corDAO = new CorDAO();

            corDAO.salvar(CMYK.PRETO);
//            corDAO.salvar(RGB.PRETO);
//            //corDAO.salvar(RGB.VERMELHO);
//            corDAO.salvar(RGB.VERDE);
//            corDAO.salvar(RGB.VERMELHO_ESCURO);
//            corDAO.salvar(RGB.AZUL_CLARO);



            Collection<Cor> cores = corDAO.findCoresBySimbolo("Rochas");

            for (Cor cor : cores) {
                System.out.println(cor);
            }


        } catch (Exception throwables) {
            System.out.println("Erro "+throwables);
            throwables.printStackTrace();
        }
    }
}
