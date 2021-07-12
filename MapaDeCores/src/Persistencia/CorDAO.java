package Persistencia;

import connection.SQLConnection;
import interfaces.ICorDAO;
import model.Cor;
import model.sistemaCor.CMYK;
import model.sistemaCor.RGB;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Collection;
import java.util.HashSet;
import java.util.Set;

public class CorDAO implements ICorDAO {
    private final Connection conn = new SQLConnection().getConnection();

    public CorDAO() throws SQLException {

    }

    private static final String COR_INSERT = "INSERT INTO COR(codigo, nome, simbolo, atr1, atr2, atr3, atr4, tipo) VALUES (?, ?, ?, ?, ?, ?, ?, ?)";
    private static final String COR_SELECT_ALL = "SELECT codigo, nome, simbolo, atr1, atr2, atr3, atr4, tipo FROM COR WHERE simbolo = ?";

    @Override
    public void salvar(Cor cor) throws Exception {
        PreparedStatement pStmt = this.conn.prepareStatement(COR_INSERT);
        pStmt.setString(1, cor.getCodigo());
        pStmt.setString(2, cor.getNome());
        pStmt.setString(3, cor.getSimbolo());

        if(cor instanceof RGB) {
            pStmt.setInt(4, ((RGB) cor).getR());
            pStmt.setInt(5, ((RGB) cor).getG());
            pStmt.setInt(6, ((RGB) cor).getB());
            pStmt.setInt(7, 0);
            pStmt.setString(8, "RGB");
        } else {
            pStmt.setInt(4, ((CMYK) cor).getCyan());
            pStmt.setInt(5, ((CMYK) cor).getMagenta());
            pStmt.setInt(6, ((CMYK) cor).getYellow());
            pStmt.setInt(7, ((CMYK) cor).getKey());
            pStmt.setString(8, "CMYK");
        }

        pStmt.executeUpdate();
    }

    @Override
    public Collection<Cor> findCoresBySimbolo(String pSimbolo) throws Exception {
        Set<Cor> cores = new HashSet<Cor>();
        PreparedStatement pStmt = this.conn.prepareStatement(COR_SELECT_ALL);
        pStmt.setString(1, pSimbolo);
        ResultSet rSet = pStmt.executeQuery();
        while(rSet.next()) {
            Cor cor = null;
            String codigo = rSet.getString("codigo");
            String nome = rSet.getString("nome");
            String simbolo = rSet.getString("simbolo");

            String tipoCor = rSet.getString("tipo");

            if(tipoCor.equals("RGB")) {
                int R = rSet.getInt("atr1");
                int G = rSet.getInt("atr2");
                int B = rSet.getInt("atr3");

                cor = new RGB(codigo, nome, simbolo, R, G, B);
            } else if(tipoCor.equals("CMYK")) {
                int C = rSet.getInt("atr1");
                int M = rSet.getInt("atr2");
                int Y = rSet.getInt("atr3");
                int K = rSet.getInt("atr4");

                cor = new CMYK(codigo, nome, simbolo, C, M, Y, K);
            }
            cores.add(cor);
        }
        return cores;
    }
}