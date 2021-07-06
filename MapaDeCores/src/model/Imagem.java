package model;

import conversor.Conversor;
import model.sistemaCor.RGB;
import model.sistemaCor.CMYK;

public class Imagem {
    private Cor imagem[][];

    public Imagem(int altura, int largura) {
        this.imagem = new Cor[altura][largura];

        for(int i = 0; i< altura; i++)
            for(int j=0; j<largura; j++)
                this.imagem[i][j] = Cor.BRANCA;
    }

    public Imagem(Imagem original) {
        int altura = original.getAltura();
        int largura = original.getLargura();

        //cria imagem com as mesmas dimensÃµes
        this.imagem = new Cor[altura][largura];

        //copia conteÃºdo da original
        for(int i = 0; i< altura; i++)
            for(int j=0; j<largura; j++)
                this.imagem[i][j] = original.getPixel(i,j);
    }

    /*public Imagem criaNovaImagemCinza() {
        Imagem imagemCinza = new Imagem(this);

        imagemCinza.greyScale();

        return imagemCinza;
    }*/

    /**
     * @param imagemOriginal -> indica a imagem que vai ser convertida
     * @param corConversao -> indica o sistema de cor para qual a imagem deve ser convertida
     * @return -> retorna uma imagem nova com os pixels do tipo passado por parametro
     */
    public Imagem converteImagemParaOutroSistema(Imagem imagemOriginal, Cor corConversao) {
        return new Conversor().converter(imagemOriginal, corConversao);
    }

    //converte cada pixel da imagem atual ao seu equivalente na escala de cinza
    /*public void greyScale() {
        for(int i = 0; i < this.getAltura(); i++)
            for(int j=0; j< this.getLargura(); j++)
                this.imagem[i][j]=this.imagem[i][j].getGrey();
    }*/
    
    //verifica se a imagem possui uma porcentagem mínima de pixels com a faixa de luminosidade indicada
    public boolean matchesPercent(Cor cor,double pctMinimo, double limiarSimilaridade) {
    	int matches = 0;
    	
    	//percorre linha
    	for(int i=0;i<this.imagem.length;i++) {
    		//percorre coluna
    		for(int j=0;j<this.imagem[0].length;j++) {
    			if (imagem[i][j].ehSimilar(cor,limiarSimilaridade))
        				matches++;
    		}
    	}
    	
    	//calcula a percentagem de matches
    	double pctMatch = matches/(imagem.length*imagem[0].length);
    	
    	//verifica se a percentagem de matches atende ao percentual mínimo
    	if (pctMatch>=pctMinimo)
    		return true;
    	else
    		return false;
    }

    public void modificaPixelImagem(int x, int y, Cor cor) {
        if(verificaSeDimensoesPassadasSeEnquandramNaImagem(1, 2))
            this.imagem[x][y] = cor;
    }

    /*public void modificaPixelImagem(int x, int y, int R, int G, int B) {
        this.pixel = new Pixel(R, G, B);
        this.imagem[x][y] = this.pixel;
    }*/

    public boolean verificaIgualdadeImagens(Imagem img1, Imagem img2) {
        if(comparaDimensaoImagens(img1, img2))
            return comparaImagens(img1, img2);

        return false;
    }

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
                        if(img.imagem[i][j].toString().equals(fragmento.imagem[0][0].toString())) {
                            ehFragmento = true;
                            //comeÃ§a comparaÃ§ao dos pixels
                            if((i + larguraFragmento) <= larguraImagem ) {
                                for(int a = i; a < (larguraFragmento + i); a++) {
                                    for(int b = a; b < alturaFragmento; b++) {
                                        if(!img.imagem[a][b].toString().equals(fragmento.imagem[a][b].toString())){
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
            //girar novamente atÃ© retornar Ã  posiÃ§Ã£o inicial
            while(girar<4){
                girar90Graus();
                girar++;
            }
        }
        return ehFragmento;
    }

    private boolean comparaImagens(Imagem img1, Imagem img2) {
        for(int i = 0; i< img1.getAltura(); i++) {
            for(int j = 0; j< img1.getLargura(); j++)
                if(!img1.imagem[i][j].toString().equals(img2.imagem[i][j].toString()))
                    return false;
        }

        return true;
    }

    private boolean comparaDimensaoImagens(Imagem img1, Imagem img2) {
        return img1.getAltura() == img2.getAltura()
                && img1.getLargura() == img2.getLargura();
    }

    private boolean verificaSeDimensoesPassadasSeEnquandramNaImagem(int x, int y){
        int tamanhoHorizontal = this.getAltura();
        int tamanhoVertical = this.getLargura();

        return x <= tamanhoHorizontal && y <= tamanhoVertical;
    }

    private void girar90Graus() {
        Imagem imagemClone = new Imagem(this);

        int altura = this.getAltura();
        int largura = this.getLargura();
        int k = 0;
        int l = largura-1;

        for(int i = 0; i< altura; i++) {
            for(int j=0; j< largura; j++){
                this.imagem[i][j] = imagemClone.getPixel(k,l);
                k++;
            }
            l--;
            k = 0;
        }
    }

    public int getAltura() {
        return this.imagem.length;
    }

    public int getLargura() {
        return this.imagem[0].length;
    }

    public Cor getPixel(int x, int y){
        return this.imagem[x][y];
    }

    public void setPixel(int posY, int posX, Cor novaCor) {
        this.imagem[posY][posX] = novaCor;
    }
}
