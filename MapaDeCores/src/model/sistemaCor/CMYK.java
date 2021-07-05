package model.sistemaCor;

import model.Cor;

public class CMYK extends Cor {
	public class CMYK extends Cor {
	public static final CYMK PRETA  = new CYMK(0, 0, 0, 100);
    	public static final CYMK BRANCA = new CYMK(0, 0, 0, 0);
    	public static final CYMK RED = new CYMK(0, 100, 100, 0);
    	public static final CYMK GREEN = new CYMK(100, 0, 100, 0);
    	public static final CYMK BLUE = new CYMK(100, 100, 0, 0);
    private int cyan;
    private int magenta;
    private int yellow;
    private int key;
		
    public CMYK(CMYK cmyk) {
        this.cyan = cmyk.getCyan();
        this.magenta = cmyk.getMagenta();
        this.yellow = cmyk.getYellow();
        this.key = cmyk.getKey();
    }

    public CMYK() { //Construtor Cor Preta
        this.cyan = 0;
        this.magenta = 0;
        this.yellow = 0;
        this.key = 100;
    }

    public CMYK(int c, int m, int y, int k) { //Construtor CriarCor
        this.setC(c);
        this.setM(m);
        this.setY(y);
    }

    private void setC(int cyan) {
        if (cyan < 0) {
            this.cyan = 0;
        } else if (cyan > 100) {
            this.cyan = 100;
        } else {
            this.cyan = cyan;
        }
    }

    private void setM(int magenta) {
        if (magenta < 0) {
            this.magenta = 0;
        } else if (magenta > 100) {
            this.magenta = 100;
        } else {
            this.magenta = magenta;
        }
    }

    private void setY(int yellow) {
        if (yellow < 0) {
            this.yellow = 0;
        } else if (yellow > 100) {
            this.yellow = 100;
        } else {
            this.yellow = yellow;
        }
    }

    private void setK(int key) {
        if (key < 0) {
            this.key = 0;
        } else if (key > 100) {
            this.key = 100;
        } else {
            this.key = key;
        }
    }

    private void setCMYK(int c, int m, int y, int k) {
        this.setC(c);
        this.setM(m);
        this.setY(y);
        this.setK(k);
    }

    public int getLuminosidade() {
        double luminosidade = (this.getKey() * 255) / 100.0;
        return (int) Math.round(luminosidade);
    }

    public RGB getRGB() {
        int r = 255 * ((1 - this.getCyan()) / 100) * ((1 - this.getKey()) / 100);
        int g = 255 * ((1 - this.getMagenta()) / 100) * ((1 - this.getKey()) / 100);
        int b = 255 * ((1 - this.getYellow()) / 100) * ((1 - this.getKey()) / 100);

        return new RGB(r, g, b);
    }

    public boolean equals(CMYK cor) {
        if ((this.getCyan() == cor.getCyan() && this.getMagenta() == cor.getMagenta())
                && (this.getYellow() == cor.getYellow() && this.getKey() == cor.getKey())) {
            return true;
        }
        return false;
    }

    @Override
    public String toString() {
        String cyan = getColorDigits(this.getCyan());
        String magenta = getColorDigits(this.getMagenta());
        String yellow = getColorDigits(this.getYellow());
        String key = getColorDigits(this.getKey());

        return cyan + magenta + yellow + key;
    }

    private String getColorDigits(int color) {
        if(color < 10)
            return "00"+color;
        else if(color < 100)
            return "0"+color;
        else return Integer.toString(color);
    }

    @Override
    public void clarear(float p) {
    	if(p>1) {
    		this.setK(0);
    	}
    	else if (p>0) {
    		this.setK((int)(this.getKey()*(0+p)));
    	}
    }

    @Override
    public void escurecer(float p) {
    	if(p>1) {
    		this.setK(this.getKey()*(2));
    	}
    	else if (p>0) {
    		this.setK((int)(this.getKey()*(1+p)));
        }
    }

    public int getCyan() {
        return cyan;
    }

    public int getMagenta() {
        return magenta;
    }

    public int getYellow() {
        return yellow;
    }

    public int getKey() {
        return key;
    }

    @Override
    public Cor converter(Cor cor) {
        if (cor instanceof CMYK) return cor;

        RGB novaCor = (RGB) cor;

        double porcentagemR = (novaCor.getR() / 255.0) * 100;
        double porcentagemG = (novaCor.getG() / 255.0) * 100;
        double porcentagemB = (novaCor.getB() / 255.0) * 100;

        double k = 100 - Math.max(Math.max(porcentagemR, porcentagemG), porcentagemB);

        if (k == 100) {
            return new CMYK(0, 0, 0, 100);
        }

        int c = (int) ((100 - porcentagemR - k) / (100 - k) * 100);
        int m = (int) ((100 - porcentagemG - k) / (100 - k) * 100);
        int y = (int) ((100 - porcentagemB - k) / (100 - k) * 100);

        return new CMYK(c, m, y, (int) k);
    }
}

