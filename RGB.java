public class RGB {
    private int red;
    private int blue;
    private int green;
    
    public RGB(RGB cor) {//Construtor Copia
        this.red = cor.getR();
        this.blue = cor.getB();
        this.green = cor.getG();
    }
    
    public RGB() { //Construtor Cor Preta
        this.red = 0;
        this.blue = 0;
        this.green = 0;
    }
    
    public RGB (int r , int b, int g) { //Construtor CriarCor
        this.red = r;
        this.blue = b;
        this.green = g;
    }
    
      public RGB retornaInstanciaCorAtual() {
        RGB cor = new RGB(this.getR(), this.getB(), this.getG());
        
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
        if(this.getR() == cor2.getR() && this.getB() == cor2.getB() && this.getG() == cor2.getG()) {
            System.out.println("A CORES SAO IGUAIS");
        }
        
}

