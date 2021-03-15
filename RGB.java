
public class RGB
{
    double luminosidade;
    float red;
    float blue;
    float green;
    
    float getR(){
        return this.red;
    }
    
    void setR(int r){
        this.red = r;
    }
    
    float getG(){
        return this.green;
    }
    
    void setG(float g){
        this.green= g;
    }
    
    float getB(){
        return this.blue;
    }
    
    void setB(int b){
        this.blue = b;
    }
    
    //int getLuminosidade(){
//double luminosidade=(this.getR()*0.3 + this.getG()*0.59 + this.getB()*0.11)/255);
    //return Math.round(luminosidade);
    //}
}
