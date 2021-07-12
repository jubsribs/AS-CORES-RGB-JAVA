package model.sistemaCor;

import model.*;

public class CMYK extends Cor {
    public static final CMYK PRETO  = new CMYK("P01C","PRETO","TERRA",0,0,0,100);
    public static final CMYK BRANCO = new CMYK("B01C","BRANCO","CONSTRUCOES",0,0,0,0);
    public static final CMYK VERMELHO = new CMYK("VO1C","VERMELHO","AREA PROIBIDA",0,100,100,0);
    public static final CMYK VERMELHO_ESCURO = new CMYK("VO2C","VERMELHO ESCURO","AREA PROIBIDA",0,100,100,50);
    public static final CMYK VERDE = new CMYK("VD1C","VERDE","ARVORE",100,0,100,0);
    public static final CMYK AZUL = new CMYK("A01C","AZUL","AGUAS E CHARCOS",100,100,0,0);
    public static final CMYK AZUL_CLARO = new CMYK("A02C","AZUL CLARO","AGUAS E CHARCOS",100,30,0,0);
    public static final CMYK CYANO = new CMYK("C02C","CYANO","MAR",100,0,0,0);
    public static final CMYK AMARELO_CLARO = new CMYK("AM01C","AMARELO CALRO","SOLAR",0,0,100,0);
    private int cyan;
    private int magenta;
    private int yellow;
    private int key;

    public CMYK(String codigo, String nome, String simbolo) {
        super(codigo, nome, simbolo);
    }
    
    public CMYK(String codigo, String nome, String simbolo, int cyan, int magenta, int yellow, int key) {
        this(codigo, nome, simbolo);
        this.cyan=cyan;
        this.magenta=magenta;
        this.yellow=yellow;
        this.key=key;
    }

    public CMYK(CMYK cor) {
        this(cor.getCodigo(), cor.getNome(), cor.getSimbolo(), cor.getCyan(), cor.getMagenta(), cor.getYellow(), cor.getKey());
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

        RGB newRGB = new RGB(this.getCodigo(), this.getNome(), this.getSimbolo());
        newRGB.setRGB(r, g, b);
        return newRGB;
    }

    @Override
    public String toString() {
        String cyan = getColorDigits(this.getCyan());
        String magenta = getColorDigits(this.getMagenta());
        String yellow = getColorDigits(this.getYellow());
        String key = getColorDigits(this.getKey());

        return cyan + magenta + yellow + key;
    }

    public boolean equals(CMYK corCMYK) {
        return (this.getCyan() == corCMYK.getCyan() && this.getMagenta() == corCMYK.getMagenta())
                && (this.getYellow() == corCMYK.getYellow() && this.getKey() == corCMYK.getKey());
    }
    
    public boolean equals(RGB cor) {
    	RGB thisRGB = RGB.converter(this);
    	return thisRGB.equals(cor);
    }
    
    private String getColorDigits(int color) {
        if (color < 10)
            return "00" + color;
        else if (color < 100)
            return "0" + color;
        else return Integer.toString(color);
    }

    @Override
    public void clarear(float p) {
        if (p > 1) {
            this.setK(0);
        } else if (p > 0) {
            this.setK((int) (this.getKey() * (0 + p)));
        }
    }

    @Override
    public void escurecer(float p) {
        if (p > 1) {
            this.setK(this.getKey() * (2));
        } else if (p > 0) {
            this.setK((int) (this.getKey() * (1 + p)));
        }
    }

    @Override
    public Cor getDetalhesCor() {
        return null;
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
}

