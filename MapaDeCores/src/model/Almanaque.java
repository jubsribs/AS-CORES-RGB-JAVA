package model;
import model.sistemaCor.RGB;


public class Almanaque {
    private Imagem mapas[];
    private int qtdMapas;

    public Almanaque(int tamanho) {
        if(tamanho>0) {
            this.mapas = new Imagem[tamanho];
        }else {
            this.mapas = new Imagem[1];
        }

        this.qtdMapas = 0;
    }

    private void setQtdMapas(int qtd){
        this.qtdMapas=qtd;
    }

    public int getQtdMapas(){
        return this.qtdMapas;
    }

    public void addMapa(Imagem mapa) {

        //verifica se o Almanaque tem espaço vazio
        if(getQtdMapas()<this.mapas.length){
            //inclui novo mapa na última posição
            this.mapas[getQtdMapas()]=mapa;
        }else {//almanaque cheio
            //aumenta no array para tamanho atual+1
            this.mapas=this.aumentarAlmanaque(this.mapas.length+1);
            //inclui novo mapa na última posição
            this.mapas[getQtdMapas()]=mapa;
        }

        //anda o sentinela
        this.setQtdMapas(this.getQtdMapas()+1);
    }

    private Imagem[] aumentarAlmanaque(int novoTamanho) {
        //verifica se novo tamanho é maior
        if(novoTamanho>this.mapas.length) {
            //cria novo array
            Imagem [] novoArray = new Imagem[novoTamanho];
            //copia os mapas para o novo array
            for(int i=0;i<this.mapas.length;i++) {
                novoArray[i]=this.mapas[i];
            }
            //retorna o novo array
            return novoArray;
        }else{//o novo tamanho é menor ou igual
            //retorna o array original
            return this.mapas;
        }
    }

    public Imagem[] getImagemPorLuminosidade(int red, int green,
                                             int blue, double pctMinimo, double limiarSimilaridade) {

        Imagem resultado[] = new Imagem[this.mapas.length];
        int matches=0;

        RGB cor = new RGB(red,green,blue);

        int l = cor.getLuminosidade();
        int lMin = (int) Math.round(l*limiarSimilaridade);
        int lMax = (int) Math.round(l*(1+limiarSimilaridade));

        //percorre o almanaque
        for (int i=0;i<getQtdMapas();i++)
            //verifica se o mapa atual dá match nos parâmetros
            if(mapas[i].matchesPercent(lMin,lMax,pctMinimo)) {
                resultado[matches]=mapas[i];
                matches++;
            }
        return resultado;
    }

}
