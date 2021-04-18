public class Imagem {
    private RGB imagem[][];
    private RGB pixel; 
    
    
    public Imagem(int altura, int largura) {
        this.imagem = new RGB[altura][largura];
        
        for(int i = 0; i< altura; i++) 
            for(int j=0; j<largura; j++) 
                this.imagem[i][j] = this.pixel; //preciso do estático branco de rgb
    }

    //constroi uma cópia idêntica (clone) da imagem repassada
    public Imagem(Imagem original) {
        int altura = original.imagem.lenght;
        int largura = original.imagem[0].lenght;
        this.imagem = new RGB[altura][largura];
        
        for(int i = 0; i< altura; i++)
            for(int j=0; j<largura; j++)
                this.imagem[i][j] = new RGB(original[i][j]);
    }
    
    public void modificaPixelImagem(int x, int y, RGB pixel) {
        if(verificaSeDimensoesPassadasSeEnquandramNaImagem(1, 2))
            this.imagem[x][y] = pixel;
    }
    
    public void modificaPixelImagem(int x, int y, int R, int G, int B) {
        this.pixel = new RGB(R, G, B);
        this.imagem[x][y] = this.pixel;
    }
    
    public boolean verificaIgualdadeImagens(Imagem img1, Imagem img2) {
        if(comparaDimensaoImagens(img1, img2))
            return comparaPixels(img1, img2); 
        
        return false;
    }
    
    public Imagem criaNovaImagemCinza() {
        Imagem imagemCinza = new Imagem(this);//kage bunshin no jutso!
        
        int altura = this.imagem.lenght;
        int largura = this.imagem[0].lenght;
        
        //percorre a imagem convertendo cada pixel em seu relativo na escala de cinza
        for(int i = 0; i<altura; i++) 
            for(int j=0; j<largura; j++)
                imagemCinza.imagem[i][j].turnGrey();
        
        return imagemCinza;
    }
    
    public boolean verificaSeEhFragmento(Imagem img1, Imagem img2) {
        
    }
    
    
    //nesse caso vou passar 2 img, mas poderia passar um vetor de imgs
    private boolean comparaPixels(Imagem img1, Imagem img2) {
        for(int i = 0; i< img1.imagem.length; i++) {
            for(int j = 0; j< img1.imagem[0].length; j++)
                if(img1.imagem[i][j].getHex() != img2.imagem[i][j].getHex()) //opcao do equals
                    return false;
        }
        
        return true;
    }
    
    //nesse caso vou passar 2 img, mas poderia passar um vetor de imgs
    private boolean comparaDimensaoImagens(Imagem img1, Imagem img2) {
        if(img1.imagem.length == img2.imagem.length 
            && img1.imagem[0].length == img2.imagem[0].length)
            return true;
        return false;
    }
    
    
    private boolean verificaSeDimensoesPassadasSeEnquandramNaImagem(int x, int y){
        int tamanhoHorizontal = this.imagem.length;
        int tamanhoVertical = this.imagem[0].length;
        
        if(x > tamanhoHorizontal || y > tamanhoVertical)
            return false;
        
        return true;
    }
}
