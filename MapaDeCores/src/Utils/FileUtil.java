package Utils;

import model.Imagem;

import java.io.*;

public class FileUtil {
    private static final String path = "C:\\";

    public void writeFile(Imagem imagem, String fileName) throws IOException {
        FileOutputStream out = new FileOutputStream(FileUtil.path +fileName);
        ObjectOutputStream oos = new ObjectOutputStream(out);
        oos.writeObject(imagem);
        oos.close();
        out.close();
    }

    public Imagem readFile(String fileName) throws IOException, ClassNotFoundException{
       Imagem imagem = null;
        FileInputStream in = new FileInputStream(FileUtil.path +fileName);
        ObjectInputStream ois = new ObjectInputStream(in);
        imagem = (Imagem) ois.readObject();
        ois.close();
        in.close();

        return imagem;
    }
}
