package ejer1;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;

public class DialogoMayus extends JDialog implements ActionListener{
	private JRadioButton[] botones;
	private Ejercicio1 owner;
	
	public DialogoMayus(Ejercicio1 owner)
	{
		this.owner=owner;
		
		JPanel panBots = new JPanel();
		panBots.setLayout(new BoxLayout(panBots,BoxLayout.Y_AXIS));
		botones= new JRadioButton[3];
		botones[0] = new JRadioButton("CAMBIAR A MAYUSCULAS");
		botones[1] = new JRadioButton("Cambiar a mayusculas");
		botones[2] = new JRadioButton("Cambiar A Mayusculas");
		
		ButtonGroup bg = new ButtonGroup();
		bg.add(botones[0]);
		bg.add(botones[1]);
		bg.add(botones[2]);
		botones[0].setSelected(true);
		
		panBots.add(botones[0]);
		panBots.add(botones[1]);
		panBots.add(botones[2]);
		
		panBots.setBorder(BorderFactory.createTitledBorder("Elija tipo de alineamiento"));
		this.getContentPane().add(panBots);
		
		botones[0].addActionListener(this);
		botones[1].addActionListener(this);
		botones[2].addActionListener(this);
		
		
		setModal(true);
		pack();
		setVisible(false);
	}

	@Override
	public void actionPerformed(ActionEvent ev) {
		String texto = owner.getTxtTexto().getText();
		String textocamb="";
		if(ev.getSource()==botones[0])
		{
			textocamb=texto.toUpperCase();
		}
		else
			if(ev.getSource()==botones[1])
			{
				String[] textodiv = texto.split("\\.");
				if(textodiv.length>1)
				{
					for (int i=0;i<textodiv.length;i++)
					{
						if(!textodiv[i].trim().equals(""))
						{
							String primeraletra = textodiv[i].trim().substring(0,1);
							primeraletra=primeraletra.toUpperCase();
							String demasletras = textodiv[i].trim().substring(1);
							demasletras=demasletras.toLowerCase();
							textocamb+=primeraletra+demasletras+". ";
						}
					}
				}
				else
				{
					String primeraletra = texto.trim().substring(0,1);
					primeraletra=primeraletra.toUpperCase();
					String demasletras = texto.trim().substring(1);
					demasletras=demasletras.toLowerCase();
					textocamb+=primeraletra+demasletras;
				}
			}
			else
			{
				String[] textodiv = texto.split(" ");
				if(textodiv.length>1)
				{
					for (int i=0;i<textodiv.length;i++)
					{
						if(!textodiv[i].trim().equals(""))
						{
							String primeraletra = textodiv[i].trim().substring(0,1);
							primeraletra=primeraletra.toUpperCase();
							String demasletras = textodiv[i].trim().substring(1);
							demasletras=demasletras.toLowerCase();
							textocamb+=primeraletra+demasletras+" ";
						}
					}
				}
				else
				{
					String primeraletra = texto.trim().substring(0,1);
					primeraletra=primeraletra.toUpperCase();
					String demasletras = texto.trim().substring(1);
					demasletras=demasletras.toLowerCase();
					textocamb+=primeraletra+demasletras;
				}
			}
		owner.getTxtTexto().setText(textocamb.trim());
		setVisible(false);
		botones[0].setSelected(true);
	}
}

