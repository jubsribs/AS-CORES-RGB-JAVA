public class Imagem {
    private RGB imagem[][];
    private RGB pixel;
    private int altura;
    private int largura;
    
    
    public Imagem(int altura, int largura) {
        this.imagem = new RGB[altura][largura];
        this.altura=altura;
        this.largura=largura;

        for(int i = 0; i< altura; i++) 
            for(int j=0; j<largura; j++) 
                this.imagem[i][j] = this.pixel; //preciso do estático branco de rgb
    }
    
    //kage bunshin no jutso!
    public Imagem(Imagem original) {
        int altura = original.getAltura();
        int largura = original.getLargura();
        
        //cria imagem com as mesmas dimensões
        this.altura = altura;
        this.largura = largura;
        this.imagem = new RGB[altura][largura];
        
        //copia conteúdo da original
        for(int i = 0; i< altura; i++) 
            for(int j=0; j<largura; j++)
                this.imagem[i][j] = new RGB(original.getPixel(i,j));
    }

    public int getAltura() {
        return this.altura;
    }

    public int getLargura() {
        return this.largura;
    }

    //retorna o pixel da posição indicada
    public RGB getPixel(int x, int y){
        //FALTAM VALIDAÇÕES
        return this.imagem[x][y];
    }

    //cria uma nova imagem identica e converte na escala de cinza
    public Imagem criaNovaImagemCinza() {
        Imagem imagemCinza = new Imagem(this);

        imagemCinza.greyScale();
        
        return imagemCinza;
    }

    //converte cada pixel da imagem atual ao seu equivalente na escala de cinza
    public void greyScale() {
        for(int i = 0; i< altura; i++) 
            for(int j=0; j<largura; j++)
                this.imagem[i][j].turnGrey();
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
    
    public boolean verificaSeEhFragmento(Imagem img1, Imagem img2) {
        
    }
    
    
    //nesse caso vou passar 2 img, mas poderia passar um vetor de imgs
    private boolean comparaPixels(Imagem img1, Imagem img2) {
        for(int i = 0; i< img1.getAltura(); i++) {
            for(int j = 0; j< img1.getLargura(); j++)
                if(img1.imagem[i][j].getHex() != img2.imagem[i][j].getHex()) //opcao do equals
                    return false;
        }
        
        return true;
    }
    
    //nesse caso vou passar 2 img, mas poderia passar um vetor de imgs
    private boolean comparaDimensaoImagens(Imagem img1, Imagem img2) {
        if(img1.getAltura() == img2.getAltura() 
            && img1.getLargura() == img2.getLargura())
            return true;
        return false;
    }
    
    private boolean verificaSeDimensoesPassadasSeEnquandramNaImagem(int x, int y){
        int tamanhoHorizontal = this.getAltura();
        int tamanhoVertical = this.getLargura();
        
        if(x > tamanhoHorizontal || y > tamanhoVertical)
            return false;
        
        return true;
    }

    private void girar90Graus() {//gira a imagem 90° à esquerda\anti-horário
        Imagem imagemClone = new Imagem(this);

        int altura = this.getAltura();
        int largura = this.getLargura();
        int k = 0;
        int l = largura-1;
        for(int i = 0; i< altura; i++) {
            for(int j=0; j<largura; j++){
                this.imagem[i][j]= new RGB(imagemClone.getPixel(k,l));
                k++;
            }
            l--;
        }
    }
}
