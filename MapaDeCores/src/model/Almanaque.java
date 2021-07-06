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
    
    //aumenta o array para o novoTamanho
    private Imagem[] aumentarArray(Imagem arrayOriginal[],int novoTamanho) {
        //verifica se novo tamanho é maior
        if(novoTamanho>arrayOriginal.length) {
            //cria novo array
            Imagem novoArray[] = new Imagem[novoTamanho];
            //copia os mapas para o novo array
            for(int i=0;i<arrayOriginal.length;i++) {
                novoArray[i]=arrayOriginal[i];
            }
            //retorna o novo array
            return novoArray;
        }else{//o novo tamanho é menor ou igual
            //retorna o mesmo array
            return arrayOriginal;
        }
    }

    public Imagem[] getImagemPorLuminosidade(int red, int green,
                                             int blue, double pctMinimo, double limiarSimilaridade) {

        Imagem resultado[]= new Imagem[1];
        int matches=0;
        resultado[0]=null;

        Cor corParametro = new RGB(red,green,blue);

        //percorre o almanaque
        for (int i=0;i<getQtdMapas();i++)
            //verifica se o mapa atual dá match nos parâmetros
            if(this.mapas[i].matchesPercent(corParametro,pctMinimo,limiarSimilaridade)) {
                //se esse não for o primeiro match
            	if(matches>0){
            		//aumenta o array de resultados
            		resultado=aumentarArray(resultado,matches+1);
            	}
            	//copia a imagem
            	resultado[matches]=this.mapas[i];
            	//anda o sentinela
            	matches++;
            }
        
        //verifica se a busca retornou vazia
        if (resultado[0]==null)
        	return null;
        else
        	return resultado;
    }

}
