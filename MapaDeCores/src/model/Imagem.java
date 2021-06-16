package model;

public class Imagem {
    private Pixel imagem[][];
    private Pixel pixel;
    private int altura;
    private int largura;

    public Imagem(int altura, int largura) {
        this.imagem = new Pixel[altura][largura];
        this.altura=altura;
        this.largura=largura;

        for(int i = 0; i< altura; i++)
            for(int j=0; j<largura; j++)
                this.imagem[i][j] = Pixel.BRANCA;
    }


    //kage bunshin no jutsu!
    public Imagem(Imagem original) {
        int altura = original.getAltura();
        int largura = original.getLargura();

        //cria imagem com as mesmas dimensões
        this.altura = altura;
        this.largura = largura;
        this.imagem = new Pixel[altura][largura];

        //copia conteúdo da original
        for(int i = 0; i< altura; i++)
            for(int j=0; j<largura; j++)
                this.imagem[i][j] = new Pixel(original.getPixel(i,j));
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
            for(int j=0; j< largura; j++)
                this.imagem[i][j].turnGrey();
    }

    public void modificaPixelImagem(int x, int y, Pixel pixel) {
        if(verificaSeDimensoesPassadasSeEnquandramNaImagem(1, 2))
            this.imagem[x][y] = pixel;
    }

    public void modificaPixelImagem(int x, int y, int R, int G, int B) {
        this.pixel = new Pixel(R, G, B);
        this.imagem[x][y] = this.pixel;
    }

    public boolean verificaIgualdadeImagens(Imagem img1, Imagem img2) {
        if(comparaDimensaoImagens(img1, img2))
            return comparaPixels(img1, img2);

        return false;
    }

    // TODO -> NAO USAR GETHEX PARA FAZER COMPARACAO DE COR
    public boolean verificaSeEhFragmento(Imagem img, Imagem fragmento) {
        int alturaFragmento = fragmento.getAltura();
        int larguraFragmento = fragmento.getLargura();
        int alturaImagem = img.getAltura();
        int larguraImagem = img.getLargura();
        boolean ehFragmento = false;
        int girar = 0;

        if(alturaFragmento <= alturaImagem
                && larguraFragmento <= larguraImagem) {
            //while de girar imagem
            while(girar < 3) {
                //varredura imagem
                for(int i = 0; i < larguraImagem; i++) {
                    for(int j = 0; j < alturaImagem; j++) {
                        //procura primeiro pixel igual
                        if(img.imagem[i][j].getHex().equals(fragmento.imagem[0][0].getHex())) {
                            ehFragmento = true;
                            //começa comparaçao dos pixels
                            if((i + larguraFragmento) <= larguraImagem ) {
                                for(int a = i; a < (larguraFragmento + i); a++) {
                                    for(int b = a; b < alturaFragmento; b++) {
                                        if(!img.imagem[a][b].getHex().equals(fragmento.imagem[a][b].getHex())){
                                            ehFragmento = false;
                                            break;
                                        }
                                    }
                                }
                            }
                        }
                    }
                }
                girar90Graus();
                girar++;
            }
        }

        //se houve algum giro na imagem
        if (girar>0){
            //girar novamente até retornar à posição inicial
            while(girar<4){
                girar90Graus();
                girar++;
            }
        }
        return ehFragmento;
    }

    //nesse caso vou passar 2 img, mas poderia passar um vetor de imgs
    private boolean comparaPixels(Imagem img1, Imagem img2) {
        for(int i = 0; i< img1.getAltura(); i++) {
            for(int j = 0; j< img1.getLargura(); j++)
                if(!img1.imagem[i][j].getHex().equals(img2.imagem[i][j].getHex()))
                    return false;
        }

        return true;
    }

    //nesse caso vou passar 2 img, mas poderia passar um vetor de imgs
    private boolean comparaDimensaoImagens(Imagem img1, Imagem img2) {
        return img1.getAltura() == img2.getAltura()
                && img1.getLargura() == img2.getLargura();
    }

    private boolean verificaSeDimensoesPassadasSeEnquandramNaImagem(int x, int y){
        int tamanhoHorizontal = this.getAltura();
        int tamanhoVertical = this.getLargura();

        return x <= tamanhoHorizontal && y <= tamanhoVertical;
    }

    private void girar90Graus() {//gira a imagem 90° à esquerda\anti-horário
        Imagem imagemClone = new Imagem(this);

        int altura = this.getAltura();
        int largura = this.getLargura();
        int k = 0;
        int l = largura-1;

        for(int i = 0; i< altura; i++) {
            for(int j=0; j< largura; j++){
                this.imagem[i][j] = new Pixel(imagemClone.getPixel(k,l));
                k++;
            }
            l--;
            k = 0;
        }
    }

    public int getAltura() {
        return this.altura;
    }

    public int getLargura() {
        return this.largura;
    }

    //retorna o pixel da posição indicada
    public Pixel getPixel(int x, int y){
        //FALTAM VALIDAÇÕES
        return this.imagem[x][y];
    }
}
