package ejer1;
import javax.swing.*;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Ejercicio1 extends JFrame implements ActionListener{
	private JLabel lblTitulo;
	private JTextArea txtTexto;
	private JScrollPane scrollTexto;
	private JButton botVaciar, botMayus, botInvert;
	private DialogoMayus dialMayus;
	
	public Ejercicio1()
	{
		dialMayus =  new DialogoMayus(this);
		
		setTitle("Probando...");
		
		dibujar();
		
		tratarEventos();
		
		setResizable(false);
		pack();
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setVisible(true);
	}
	
	public void dibujar()
	{
		this.setLayout(new BoxLayout(this.getContentPane(),BoxLayout.Y_AXIS));
		
		JPanel panTop = new JPanel();
		lblTitulo = new JLabel("Escriba aqui su texto:");
		panTop.add(lblTitulo);
		
		JPanel panMid = new JPanel();
		txtTexto = new JTextArea();
		scrollTexto = new JScrollPane(txtTexto, JScrollPane.VERTICAL_SCROLLBAR_ALWAYS, JScrollPane.HORIZONTAL_SCROLLBAR_ALWAYS);
		txtTexto.setPreferredSize(new Dimension(200,100));
		panMid.add(scrollTexto);
		
		JPanel panBot = new JPanel();
		botVaciar = new JButton("VACIAR");
		botMayus = new JButton("MAYUSCULAS");
		botInvert = new JButton("INVERTIR");
		
		panBot.add(botVaciar);
		panBot.add(botMayus);
		panBot.add(botInvert);
		
		this.getContentPane().add(panTop);
		this.getContentPane().add(panMid);
		this.getContentPane().add(panBot);
	}
	
	public void tratarEventos()
	{
		botVaciar.addActionListener(new VaciarListener());
		botMayus.addActionListener(this);
		botInvert.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent ev) {
				String texto = txtTexto.getText();
				String textInvert = "";
				for (int i=texto.length()-1;i>=0;i--)
				{
					textInvert+= texto.charAt(i);
				}
				txtTexto.setText(textInvert);
			}
		});
		
	}
		
	public JTextArea getTxtTexto() {
		return txtTexto;
	}

	class VaciarListener implements ActionListener{

		@Override
		public void actionPerformed(ActionEvent ev) {
			txtTexto.setText("");
		}
		
	}
	
	public static void main(String[] args) {
		new Ejercicio1();
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		dialMayus.setVisible(true);
		
	}
}

