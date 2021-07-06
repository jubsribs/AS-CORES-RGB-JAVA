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
    
    //checa se this apresenta luminosidade similar a cor repassada, dentro do limiarSimilaridade permitido 
    public boolean ehSimilar(Cor corParametro, double limiarSimilaridade) {
    	int lMin;
        int lMax;
        
        //validar o limiar (limiar <= 0.0: 0% | limiar >= 1.0: 100%) e calcula a luminosidade mínima e máxima
        if(limiarSimilaridade>=1.0){
            lMin = 0;
            lMax = (int) Math.round(corParametro.getLuminosidade()*2);
        }
        else if (limiarSimilaridade<=0.0){
            lMin = (int) corParametro.getLuminosidade();
            lMax = (int) corParametro.getLuminosidade();
        }
        else{
            lMin = (int) Math.round(corParametro.getLuminosidade()*limiarSimilaridade);
            lMax = (int) Math.round(corParametro.getLuminosidade()*(1+limiarSimilaridade));
        }
        
        //verifica a similaridade
        if (this.getLuminosidade()>=lMin & this.getLuminosidade()<=lMax)
        	return true;
        else
        	return false;
    }

    @Override
    public Imagem getNovoMapa(int altura, int largura) {
        return new Imagem(altura, largura);
    }
}
