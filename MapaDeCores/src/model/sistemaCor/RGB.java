package model.sistemaCor;

import model.Cor;

public class RGB extends Cor {
    public static final RGB PRETA  = new RGB(0,0,0);
    public static final RGB BRANCA = new RGB(255,255,255);
    public static final RGB RED = new RGB(255,0,0);
    public static final RGB GREEN = new RGB(0,255,0);
    public static final RGB BLUE = new RGB(0,0,255);
    private int red;
    private int green;
    private int blue;

    public RGB(RGB cor) {//Construtor Copia
        this(cor.getR(),cor.getG(),cor.getB());
    }

    public RGB() { //Construtor Cor Preta
        this(0,0,0);
    }

    public RGB (int r, int g, int b) { //Construtor CriarCor
        this.setR(r);
        this.setG(g);
        this.setB(b);
    }

    public RGB retornaInstanciaCorAtual() {
        RGB cor = new RGB(this.getR(), this.getG(), this.getB());

        return cor;
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
    
    private void setRGB(int r, int g, int b){//Altera os valores de R, G e B
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
        if(this.getR() == cor.getR() && this.getB() == cor.getB() && this.getG() == cor.getG()){
            return true;
        }
        return false;
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

    public RGB getGrey(){
        int luminosidade = this.getLuminosidade();
        return new RGB(luminosidade,luminosidade,luminosidade);
    }

    @Override
    public String toString() {
        String hex = "#";
        if(this.getR()<=15){
            hex=hex+"0"+Integer.toHexString(this.getR());
        }else{
        	hex=hex+Integer.toHexString(this.getR());
        }

        if(this.getG()<=15){
        	hex=hex+"0"+Integer.toHexString(this.getG());
        }else{
        	hex=hex+Integer.toHexString(this.getG());
        }

        if(this.getB()<=15){
        	hex=hex+"0"+Integer.toHexString(this.getB());
        }else{
        	hex=hex+Integer.toHexString(this.getB());
        }

        return hex.toUpperCase();
    }

    @Override
    public Cor converter(Cor cor) {
        if(cor instanceof RGB) return cor;

        CMYK novaCor = (CMYK) cor;
        int R = (int) Math.round(255 * (1 - (novaCor.getCyan() / 100.0)) * (1 - (novaCor.getKey() / 100.0));
        int G = (int) Math.round(255 * (1 - (novaCor.getMagenta() / 100.0)) * (1 - (novaCor.getKey() / 100.0));
        int B = (int) Math.round(255 * (1 - (novaCor.getYellow() / 100.0)) * (1 - (novaCor.getKey() / 100.0));

        return new RGB(R, G, B);
    }
}
