package vista;

import java.awt.EventQueue;


import javax.swing.JFrame;
import javax.swing.JPanel;
import java.awt.BorderLayout;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.SwingConstants;
import javax.swing.ImageIcon;
import java.awt.Color;
import javax.swing.JButton;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.SystemColor;
import java.awt.event.MouseMotionListener;

public class Menu_Investigador extends JFrame implements MouseListener, MouseMotionListener{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	
	private JPanel panel;
	private JLabel lblBienvenida;
	private JButton btnFuncionalidades;
	private JLabel lblNewLabel;
	private JLabel lblHaIniciadoSesion;
	private JButton btnCerrar;

	public static String Menu_Investigador;
	private JPanel barra;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Menu_Investigador window = new Menu_Investigador();
					window.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	
	/**
	 * Create the frame.
	 */
	public Menu_Investigador() {
		setUndecorated(true);
		initialize();
	}

	int xMouse, yMouse;
	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		setResizable(false);
		setBounds(100, 100, 845, 504);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		panel = new JPanel();
		getContentPane().add(panel, BorderLayout.CENTER);
		panel.setLayout(null);
		
		lblBienvenida = new JLabel("Welcome!");
		lblBienvenida.setForeground(new Color(255, 255, 255));
		lblBienvenida.setBackground(new Color(0, 206, 209));
		lblBienvenida.setHorizontalAlignment(SwingConstants.CENTER);
		lblBienvenida.setFont(new Font("Baskerville Old Face", Font.BOLD, 60));
		lblBienvenida.setBounds(10, 48, 821, 152);
		panel.add(lblBienvenida);
		
		btnFuncionalidades = new JButton("Funcionalidades");
		btnFuncionalidades.setBackground(new Color(255, 255, 255));
		btnFuncionalidades.setFont(new Font("Baskerville Old Face", Font.PLAIN, 14));
		btnFuncionalidades.setBounds(290, 272, 265, 52);
		panel.add(btnFuncionalidades);
		btnFuncionalidades.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Listado_Funcionalidades window = new Listado_Funcionalidades();
				window.frame.setVisible(true);
			}
		});
		
		lblHaIniciadoSesion = new JLabel("Ha iniciado sesion como Investigador");
		lblHaIniciadoSesion.setHorizontalAlignment(SwingConstants.CENTER);
		lblHaIniciadoSesion.setFont(new Font("Baskerville Old Face", Font.PLAIN, 14));
		lblHaIniciadoSesion.setBounds(573, 10, 258, 15);
		panel.add(lblHaIniciadoSesion);
		
		btnCerrar = new JButton("Cerrar sesion");
		btnCerrar.setBackground(SystemColor.menu);
		btnCerrar.addMouseListener(this);
		btnCerrar.setFont(new Font("Baskerville Old Face", Font.PLAIN, 12));
		btnCerrar.setBounds(693, 35, 115, 21);
		panel.add(btnCerrar);
		
		
		lblNewLabel = new JLabel("");
		lblNewLabel.setIcon(new ImageIcon(Menu_Investigador.class.getResource("/image/12.jpg")));
		lblNewLabel.setBounds(0, 0, 845, 504);
		panel.add(lblNewLabel);
		
		barra = new JPanel();
		barra.addMouseMotionListener(this);
		barra.addMouseListener(this);
		barra.setBorder(null);
		barra.setBackground(SystemColor.menu);
		barra.setBounds(0, 0, 845, 31);
		panel.add(barra);
		
	
	}
	public void mouseClicked(MouseEvent e) {
		if (e.getSource() == btnCerrar) {
			mouseClickedBtnCerrar(e);
		}
	}
	public void mouseEntered(MouseEvent e) {
	}
	public void mouseExited(MouseEvent e) {
	}
	public void mousePressed(MouseEvent e) {
		if (e.getSource() == barra) {
			mousePressedBarra(e);
		}
	}
	public void mouseReleased(MouseEvent e) {
	}
	protected void mouseClickedBtnCerrar(MouseEvent e) {
		int respuesta = JOptionPane.showConfirmDialog(this, "¿ Realmente quieres cerrar sesión ?", "Confirmar", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);
		if(respuesta == JOptionPane.YES_OPTION) {
			
			Login ventana = new Login();
			ventana.setVisible(true);
			dispose(); 
		}
	}
	protected void mousePressedBarra(MouseEvent e) {
		xMouse = e.getX();
		yMouse = e.getY();	
	}
	public void mouseDragged(MouseEvent e) {
		if (e.getSource() == barra) {
			mouseDraggedBarra(e);
		}
	}
	public void mouseMoved(MouseEvent e) {
	}
	protected void mouseDraggedBarra(MouseEvent e) {
		int x = e.getXOnScreen();
		int y = e.getYOnScreen();
		this.setLocation(x - xMouse, y - yMouse);
	}
}
