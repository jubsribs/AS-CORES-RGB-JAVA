package model;

public abstract class Cor {
    private String codigo;
    private String nome;
    private String simbolo;

    public Cor(String codigo, String nome, String simbolo) {
    	this.codigo=codigo;
    	this.nome=nome;
    	this.simbolo = simbolo;
    }

    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getSimbolo() {
        return simbolo;
    }

    public void setSimbolo(String simbolo) {
        this.simbolo = simbolo;
    }

    public abstract int getLuminosidade();

    public abstract String toString();

    public abstract void clarear(float p);

    public abstract void escurecer(float p);

    public abstract Cor getDetalhesCor();
    
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
        return this.getLuminosidade()>=lMin & this.getLuminosidade() <= lMax;
    }
}
