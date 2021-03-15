public class RGB
{
    private float red;
    private float blue;
    private float green;
    
    public float getR(){
        return this.red;
    }
    
    public void setR(float r){
        this.red = r;
    }
    
    public float getG(){
        return this.green;
    }
    
    public void setG(float g){
        this.green= g;
    }
    
    public float getB(){
        return this.blue;
    }
    
    public void setB(float b){
        this.blue = b;
    }
    
    //int getLuminosidade(){
//double luminosidade=(this.getR()*0.3 + this.getG()*0.59 + this.getB()*0.11)/255);
    //return Math.round(luminosidade);
    //}
}

