package model;

public class Pixel {
    public static final Pixel PRETA  = new Pixel(0,0,0);
    public static final Pixel BRANCA = new Pixel(255,255,255);
    public static final Pixel RED = new Pixel(255,0,0);
    public static final Pixel GREEN = new Pixel(0,255,0);
    public static final Pixel BLUE = new Pixel(0,0,255);
    private int red;
    private int green;
    private int blue;

    public Pixel(Pixel pixel) {//Construtor Copia
        this.red = pixel.getR();
        this.green = pixel.getG();
        this.blue = pixel.getB();
    }

    public Pixel() { //Construtor Cor Preta
        this.red = 0;
        this.green = 0;
        this.blue = 0;
    }

    public Pixel (int r, int g, int b) { //Construtor CriarCor
        this.setPixel(r,g,b);
    }

    public Pixel retornaInstanciaCorAtual() {
        Pixel cor = new Pixel(this.getR(), this.getG(), this.getB());

        return cor;
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

    public String getHex(){
        String hex = "#"+Integer.toHexString(this.getR())
                +Integer.toHexString(this.getG())
                +Integer.toHexString(this.getB());

        return hex.toUpperCase();
    }

    public void verificarCor(Pixel cor2) {
        if(this.getR() == cor2.getR() && this.getB() == cor2.getB() && this.getG() == cor2.getG())
            System.out.println("A CORES SAO IGUAIS");
    }

    public void clarear(float p){
        int r = (int) (this.getR()*(1+p));
        int g = (int) (this.getG()*(1+p));
        int b = (int) (this.getB()*(1+p));
        this.setPixel(r,g,b);
    }

    public void escurecer(float p){
        int r = (int) (this.getR()*(1-p));
        int g = (int) (this.getG()*(1-p));
        int b = (int) (this.getB()*(1-p));
        this.setPixel(r,g,b);
    }

    public void turnGrey(){//converte a cor para seu equivalente em escala de cinza
        int luminosidade = this.getLuminosidade();
        setPixel(luminosidade,luminosidade,luminosidade);
    }

    private void setPixel(int r, int g, int b){//Altera os valores de R, G e B truncando p/ valores entre 0 e 255
        if(r<0){
            this.red = 0;
        }else if(r>255){
            this.red = 255;
        }else{
            this.red = r;
        }

        if(g<0){
            this.green = 0;
        }else if(g>255){
            this.green = 255;
        }else{
            this.green = g;
        }

        if(b<0){
            this.blue = 0;
        }else if(b>255){
            this.blue = 255;
        }else{
            this.blue = b;
        }
    }
}
