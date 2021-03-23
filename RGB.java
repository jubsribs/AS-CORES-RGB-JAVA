public class RGB
{
    private int red;
    private int blue;
    private int green;
    
    public  RGB(RGB cor){//Construtor Copia
        
        this.red=cor.getR();
        this.blue=cor.getB();
        this.green=cor.getG();
    
    }
    public  RGB(){ //Construtor Cor Preta
        
        this.red=cor.getR(0);
        this.blue=cor.getB(0);
        this.green=cor.getG(0);
    
    }
    public int getR(){
        return this.red;
    }
    
    public void setR(int r){
        this.red = r;
    }
    
    public int getG(){
        return this.green;
    }
    
    public void setG(int g){
        this.green= g;
    }
    
    public int getB(){
        return this.blue;
    }
    
    public void setB(int b){
        this.blue = b;
    }
    
    int getLuminosidade(){
        double luminosidade = (this.getR()*0.3 + this.getG()*0.59 + this.getB()*0.11)/255;
        return (int) Math.round(luminosidade);
    }
    
    public String getHex(){
        String hex = "#"+Integer.toHexString(this.getR())+Integer.toHexString(this.getG())+Integer.toHexString(this.getB());
        return hex.toUpperCase();
    }
         public void VerificarCor(RGB cor2){
    
        if(this.red == cor2.getR() && this.blue == cor2.getB() && this.green == cor2.getG() ){
        System.out.println("A COR SAO IGUAIS");
        }
    }
}

