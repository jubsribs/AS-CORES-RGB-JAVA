public class RGB {
    private int red;
    private int green;
    private int blue;
    
    public RGB(RGB cor) {//Construtor Copia
        this.red = cor.getR();
        this.green = cor.getG();
        this.blue = cor.getB();
    }
    
    public RGB() { //Construtor Cor Preta
        this.red = 0;
        this.green = 0;
        this.blue = 0;
    }
    
    public RGB (int r, int g, int b) { //Construtor CriarCor
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
    
   public RGB retornaInstanciaCorAtual() {
        RGB cor = new RGB(this.getR(), this.getG(), this.getB());
        
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
        String hex = "#"+Integer.toHexString(this.getR())+Integer.toHexString(this.getG())+Integer.toHexString(this.getB());
        return hex.toUpperCase();
    }
    
    public void verificarCor(RGB cor2) {
        if(this.getR() == cor2.getR() && this.getB() == cor2.getB() && this.getG() == cor2.getG()) 
            System.out.println("A CORES SAO IGUAIS");
    }
    
    public void clarear(float p){
        this.red = (int) (this.getR()*(1+p));
        this.green = (int) (this.getG()*(1+p));
        this.blue = (int) (this.getB()*(1+p));
    }
    
    public void escurecer(float p){
        this.red = (int) (this.getR()*(1-p));
        this.green = (int) (this.getG()*(1-p));
        this.blue = (int) (this.getB()*(1-p));
    }
    
}

