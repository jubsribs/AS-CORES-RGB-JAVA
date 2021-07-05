package model;

import interfaces.ConversorCor;
import model.sistemaCor.RGB;

public abstract class Cor implements ConversorCor {
    public static final RGB BRANCA = new RGB(255,255,255);

    public abstract int getLuminosidade();

    /*public abstract void getGrey();*/

    public abstract String toString();

    public abstract void clarear(float p);

    public abstract void escurecer(float p);

    @Override
    public Imagem getNovoMapa(int altura, int largura) {
        return new Imagem(altura, largura);
    }
}
