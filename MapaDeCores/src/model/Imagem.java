package model;

import conversor.Conversor;
import model.sistemaCor.RGB;
import model.sistemaCor.CMYK;

import java.awt.*;
import java.io.Serializable;

public abstract class Imagem implements Serializable {
    private Cor[][] cores;

    public Imagem(int altura, int largura) {
        this.cores = new Cor[altura][largura];
    }

    public Imagem(Imagem original) {
        int altura = original.getAltura();
        int largura = original.getLargura();

        this.cores = new Cor[altura][largura];

        for(int i = 0; i< altura; i++)
            for(int j=0; j<largura; j++)
                this.cores[i][j] = original.getPixel(i,j);
    }

    public boolean matchesPercent(Cor cor,double pctMinimo, double limiarSimilaridade) {
    	int matches = 0;

    	//percorre linha
    	for(int i=0;i<this.cores.length;i++) {
    		//percorre coluna
    		for(int j=0;j<this.cores[0].length;j++) {
    			if (cores[i][j].ehSimilar(cor,limiarSimilaridade))
        				matches++;
    		}
    	}
    	
    	//calcula a percentagem de matches
    	double pctMatch = matches/(cores.length*cores[0].length);
    	
    	//verifica se a percentagem de matches atende ao percentual mÃ­nimo
    	return pctMatch>=pctMinimo;
    }
    
    //retorna a percentagem de similaridade (prevalencia de uma cor especifica na imagem)
    public double similaridade(Cor cor) {
    	int matches = 0;

    	for(int i=0;i<this.cores.length;i++) {//percorre linha
    		for(int j=0;j<this.cores[0].length;j++) {//percorre coluna
    			if (cores[i][j].equals(cor))
        				matches++;//incrementa os matches
    		}
    	
    	}
    	
    	//calcula a percentagem de matches (0.01=1% | 1=100%)
    	double pctMatch = matches/(cores.length*cores[0].length);
    	
    	return pctMatch;
    }

    public boolean verificaIgualdadeImagens(Imagem img1, Imagem img2) {
        if(comparaDimensaoImagens(img1, img2))
            return comparaImagens(img1, img2);

        return false;
    }

    private boolean comparaImagens(Imagem img1, Imagem img2) {
        for(int i = 0; i< img1.getAltura(); i++) {
            for(int j = 0; j< img1.getLargura(); j++)
                if(!img1.cores[i][j].toString().equals(img2.cores[i][j].toString()))
                    return false;
        }

        return true;
    }

    private boolean comparaDimensaoImagens(Imagem img1, Imagem img2) {
        return img1.getAltura() == img2.getAltura()
                && img1.getLargura() == img2.getLargura();
    }

    public boolean isFragmento(Imagem imagem) {
        Imagem copia = imagem.clone();
        for(int iCont = 0; iCont < 4; iCont++) {
            if(this.fragmento(copia))
                return true;
            copia = copia.girar90();
        }
        return false;
    }

    public Imagem clone() {
        return this.recortar(0, 0, this.getAltura(), this.getLargura());
    }

    private boolean fragmento(Imagem imagem) {
        for(int iCont = 0; iCont <= this.getAltura() - imagem.getAltura(); iCont++)
            for(int jCont = 0; jCont <= this.getLargura() - imagem.getLargura(); jCont++)
                if (this.recortar(iCont, jCont, imagem.getAltura(), imagem.getLargura()).equals(imagem))
                    return true;
        return false;
    }

    public Imagem recortar(int x, int y, int hTam, int lTam) {
        int altura = ((this.getAltura() - x) < hTam) ? (this.getAltura() - x) : hTam;
        int largura = ((this.getLargura() - y) < lTam) ? (this.getLargura() - y) : lTam;

        Imagem nova = null;
        for(int iCont = x, iNova = 0; iCont < altura + x; iCont++, iNova++)
            for(int jCont = y, jNova = 0; jCont < largura + y; jCont++, jNova++)
                nova.setPixel(iNova, jNova, this.getPixel(iCont, jCont));
        return nova;
    }

    public Imagem girar90() {
        Imagem nova = null;

        for(int jCont = 0; jCont < this.getLargura(); jCont++)
            for(int iCont = this.getAltura() - 1, iNova = 0; iCont >= 0; iCont--, iNova++)
                nova.setPixel(jCont, iNova, this.getPixel(iCont, jCont));
        return nova;
    }

    public int getAltura() {
        return this.cores.length;
    }

    public int getLargura() {
        return this.cores[0].length;
    }

    public Cor getPixel(int x, int y){
        return this.cores[x][y];
    }

    public void setPixel(int posY, int posX, Cor novaCor) {
        this.cores[posY][posX] = novaCor;
    }
}
