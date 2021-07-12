/**
 * 
 */
package ui;

import javax.swing.JButton;
//import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JTextArea;
import java.awt.BorderLayout;
import java.awt.Container;

/**
 * @author Isaac
 *
 */
public class AvaliadorMapasUI extends JFrame{
	private static final long serialVersionUID = -8323390696050397302L;
	/* Componentes devem estar no contexto da instância,
    para que possam ser acessados em todos os métodos 
    não-estáticos da classe
	 */
	private JTextArea texto = new JTextArea();
	
	//construtor
	public AvaliadorMapasUI(){
		super("Avaliador de Mapas"); //define o titulo da janela
		setSize(500,200); //define as dimensao da tela
		
		setDefaultCloseOperation(EXIT_ON_CLOSE); //encerra a aplicação quando fechar a janela
		
		Container contentPane = getContentPane();//cria o container
		contentPane.setLayout(new BorderLayout());//define o tipo de layout
		
		
		JButton botao3 = new JButton("Avaliar");//cria o botao avaliar
		contentPane.add(botao3,BorderLayout.EAST);//insere o botao no layout
		
		/*void nada(){JFileChooser file = new JFileChooser();
        file.setFileSelectionMode(JFileChooser.FILES_ONLY);
        int i= file.showSaveDialog(null);
        if (i==1){
        	JtextFieldLocal.setText("");
        }else{
        	File arquivo = file.getSelectedFile();
        	JtextFieldLocal.setText(arquivo.getPath());
        }
        
        contentPane.add(file,BorderLayout.PAGE_END);*/
		
		setVisible(true);
	}
	
	public static void main(String[] args){
	    //Cria objeto
		AvaliadorMapasUI janela = new AvaliadorMapasUI();
		
		/* TO DO:
		01. GUI - JFileChooser: selecionar o aquivo do mapa/imagem
		02. GUI - (lista dropdown): selecionar tipo de elemento a avaliar
		03. GUI - JButton: botão "Avaliar"
		04. carregar a imagem do mapa p/ um objeto ImgemRGB ou ImagemCMYK
		05. buscar na base todas as cores referentes ao elemento selecionado | converter p objeto RGB ou CMYK
		06. buscar a prevalencia (%) de cada cor na imagem {imagem.similaridade(corDoBD);}
		08. calcular a percentagem total de prevalência desse elemento na imagem (soma das prevalecnias) 
		09. GUI - : exibir a percentagem total de prevalencia na imagem do elemento selecionado
		10. GUI - tabela: exibir a percentagem de cada cor associada ao simbolo (ex.: "Vegetação - 73%")
		*/
	}
	
}
