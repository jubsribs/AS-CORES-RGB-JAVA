package model.sistemaCor;

import model.Cor;

public class RGB extends Cor {
    public static final RGB PRETO  = new RGB("P01","PRETO","TERRA",0,0,0);
    public static final RGB BRANCO = new RGB("B01","BRANCO","CONSTRUCOES",255,255,255);
    public static final RGB VERMELHO = new RGB("VO1","VERMELHO","AREA PROIBIDA",255,0,0);
    public static final RGB VERMELHO_ESCURO = new RGB("VO1","VERMELHO ESCURO","AREA PROIBIDA",128,0,0);
    public static final RGB VERDE = new RGB("VD1","VERDE","ARVORE",0,255,0);
    public static final RGB AZUL = new RGB("A01","AZUL","AGUAS E CHARCOS",0,0,255);
    public static final RGB AZUL_CLARO = new RGB("A02","AZUL CLARO","AGUAS E CHARCOS",0,181,255);
    public static final RGB CYANO = new RGB("C02","CYANO","MAR",0,255,255);
    public static final RGB AMARELO_CLARO = new RGB("A01","AMARELO CALRO","SOLAR",255,255,0);
    private int red;
    private int green;
    private int blue;

    public RGB(String codigo, String nome, String descricao) {
        super(codigo, nome, descricao);
    }
    
    public RGB(String codigo, String nome, String simbolo, int red, int green, int blue) {
        this(codigo,nome,simbolo);
    	this.red=red;
        this.green=green;
        this.blue=blue;
    }

    public RGB(RGB cor) {
        this(cor.getCodigo(), cor.getNome(), cor.getSimbolo(), cor.getR(), cor.getG(), cor.getB());
    }

    private void setR(int red) {
        if(red<0){
            this.red = 0;
        }else if(red>255){
            this.red = 255;
        }else{
            this.red = red;
        }
    }

    private void setG(int green) {
        if(green<0){
            this.green = 0;
        }else if(green>255){
            this.green = 255;
        }else{
            this.green = green;
        }
    }

    private void setB(int blue) {
        if(blue<0){
            this.blue = 0;
        }else if(blue>255){
            this.blue = 255;
        }else{
            this.blue = blue;
        }
    }

    public void setRGB(int r, int g, int b){//Altera os valores de R, G e B
        this.setR(r);
        this.setG(g);
        this.setB(b);
    }


    public int getR(){
        return this.red;
    }

    public int getG(){
        return this.green;
    }

    public int getB(){
        return this.blue;
    }

    public int getLuminosidade() {
        double luminosidade = (this.getR()*0.3 + this.getG()*0.59 + this.getB()*0.11);
        return (int) Math.round(luminosidade);
    }

    public boolean equals(RGB cor) { //
        return this.getR() == cor.getR() && this.getB() == cor.getB() && this.getG() == cor.getG();
    }
    
    public boolean equivale(RGB cor) {
    	return this.equals(cor);
    }

    public void clarear(float p){
        int r = (int) (this.getR()*(1+p));
        int g = (int) (this.getG()*(1+p));
        int b = (int) (this.getB()*(1+p));
        this.setRGB(r,g,b);
    }

    @Override
    public void escurecer(float p){
        int r = (int) (this.getR()*(1-p));
        int g = (int) (this.getG()*(1-p));
        int b = (int) (this.getB()*(1-p));
        this.setRGB(r,g,b);
    }

    @Override
    public Cor getDetalhesCor() {
        return null;
    }

    public RGB getGrey() {
        int luminosidade = this.getLuminosidade();
        RGB rgbGrey = this;
        rgbGrey.setRGB(luminosidade, luminosidade, luminosidade);

        return rgbGrey;
    }

    @Override
    public String toString() {
        String hex = "#"+getColorDigits(this.getR())+getColorDigits(this.getG())+getColorDigits(this.getB());

        return hex.toUpperCase();
    }
    
    private String getColorDigits(int color) {
        if (color < 15)
            return "0" + Integer.toHexString(color);
        else 
        	return Integer.toHexString(color);
    }
    
    public static RGB converter(CMYK cor) {
        
    	int R = (int) Math.round(255 * (1 - (cor.getCyan() / 100.0)) * (1 - (cor.getKey() / 100.0)));
        int G = (int) Math.round(255 * (1 - (cor.getMagenta() / 100.0)) * (1 - (cor.getKey() / 100.0)));
        int B = (int) Math.round(255 * (1 - (cor.getYellow() / 100.0)) * (1 - (cor.getKey() / 100.0)));

        return new RGB(cor.getCodigo(),cor.getNome(),cor.getSimbolo(),R, G, B);
    }
}