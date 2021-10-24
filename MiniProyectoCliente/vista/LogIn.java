package vista;

import java.awt.EventQueue;
import java.awt.Image;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import java.awt.Color;
import javax.swing.SwingConstants;
import javax.swing.border.LineBorder;


import model.Usuario;

import com.exception.ServiciosException;
import com.servicios.Usuario_BeanRemote;

import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JPasswordField;
import java.awt.SystemColor;
import javax.swing.JSeparator;
import javax.swing.JButton;
import java.awt.Cursor;
import java.awt.event.MouseListener;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionListener;

public class Login extends JFrame implements MouseListener, MouseMotionListener {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private JPanel contentPane;
	private  JLabel lblFondo;
	private JPanel panel;
	private JLabel IniciarSesion;
	private JLabel lblUsuario;
	public static JTextField textCorreo;
	private JLabel lblContrasenia;
	public static JPasswordField password;
	private JSeparator separator;
	private JSeparator separator_1;
	private JButton btnIngresar;
	private JButton buttonX;
	private JPanel barra;
	
	
	public static String Login;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Login frame = new Login();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	int xMouse, yMouse; 
	
	public Login() {
		setLocationByPlatform(true);
		setUndecorated(true);
		setResizable(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 966, 469);
		contentPane = new JPanel();
		contentPane.setBackground(Color.WHITE);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
				
		ImageIcon image2 = new ImageIcon(getClass().getResource("/image/fondo.jpg"));
		
		panel = new JPanel();
		panel.setBackground(SystemColor.control);
		panel.setBounds(0, 0, 967, 470);
		contentPane.add(panel);
		panel.setLayout(null);
		
		buttonX = new JButton("x");
		buttonX.addMouseListener(this);
		buttonX.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		buttonX.setBackground(SystemColor.controlHighlight);
		buttonX.setFont(new Font("Arial", Font.BOLD, 14));
		buttonX.setBounds(923, 0, 44, 31);
		panel.add(buttonX);
		
		separator_1 = new JSeparator();
		separator_1.setBounds(85, 321, 404, 2);
		panel.add(separator_1);
		
		separator = new JSeparator();
		separator.setBounds(85, 223, 404, 2);
		panel.add(separator);
		
		IniciarSesion = new JLabel("INICIAR SESI\u00D3N");
		IniciarSesion.setFont(new Font("Baskerville Old Face", Font.BOLD, 30));
		IniciarSesion.setBounds(85, 45, 280, 57);
		panel.add(IniciarSesion);
		
		lblFondo = new JLabel("");
		lblFondo.setBounds(581, -12, 386, 550);
		panel.add(lblFondo);
		lblFondo.setBorder(new LineBorder(new Color(0, 0, 0)));
		lblFondo.setHorizontalAlignment(SwingConstants.CENTER);
		Icon fondo2 = new ImageIcon(image2.getImage().getScaledInstance(
				lblFondo.getWidth(),
				lblFondo.getHeight(),
				Image.SCALE_DEFAULT
		));
		lblFondo.setIcon(fondo2);
		
		lblUsuario = new JLabel("Correo electrónico");
		lblUsuario.setFont(new Font("Baskerville Old Face", Font.PLAIN, 20));
		lblUsuario.setBounds(85, 143, 229, 42);
		panel.add(lblUsuario);
		
		textCorreo = new JTextField();
		textCorreo.addMouseListener(this);
		textCorreo.setBackground(SystemColor.control);
		textCorreo.setBorder(null);
		textCorreo.setForeground(SystemColor.controlShadow);
		textCorreo.setFont(new Font("Baskerville Old Face", Font.PLAIN, 16));
		textCorreo.setText("Ingrese Correo electrónico");
		textCorreo.setBounds(85, 195, 404, 25);
		panel.add(textCorreo);
		textCorreo.setColumns(10);
		
		lblContrasenia = new JLabel("Contrase\u00F1a");
		lblContrasenia.setFont(new Font("Baskerville Old Face", Font.PLAIN, 20));
		lblContrasenia.setBounds(85, 251, 229, 42);
		panel.add(lblContrasenia);
		
		password = new JPasswordField();
		password.addMouseListener(this);
		password.setFont(new Font("Baskerville Old Face", Font.PLAIN, 16));
		password.setEchoChar('*');
		password.setBackground(SystemColor.control);
		password.setForeground(SystemColor.controlShadow);
		password.setText("********");
		password.setToolTipText("");
		password.setBorder(null);
		password.setBounds(85, 292, 404, 25);
		panel.add(password);
		
		btnIngresar = new JButton("Ingresar");
		btnIngresar.addMouseListener(this);
		btnIngresar.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btnIngresar.setFont(new Font("Baskerville Old Face", Font.PLAIN, 16));
		btnIngresar.setBackground(SystemColor.controlHighlight);
		btnIngresar.setBounds(85, 372, 130, 42);
		panel.add(btnIngresar);
		btnIngresar.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent e) {
				if(!(textCorreo.getText().isEmpty() || String.valueOf(password.getPassword()).isEmpty() || textCorreo.getText().equals("Ingrese Correo electrónico") ||String.valueOf(password.getPassword()).equals("********"))) {
					
					Usuario user = null;
					
					try {
						String dato = "Mini_ProyectoEJB/Usuario_Bean!com.servicios.Usuario_BeanRemote";
						Usuario_BeanRemote ad = (Usuario_BeanRemote) InitialContext.doLookup(dato);
						
						user = ad.findUser(textCorreo.getText(), String.valueOf(password.getPassword())); 
						
						if(user != null) {
							JOptionPane.showMessageDialog(null, "Bienvenid@ al sistema " + user.getNombre()+" "+ user.getApellido() + " !");

							if(user.getRole().getNombre().equals("Administrador")) {
								Menu_Administrador menuA = new Menu_Administrador();
								menuA.setVisible(true);
								dispose();
							}
							if(user.getRole().getNombre().equals("Investigador")) {
								Menu_Investigador menuI = new Menu_Investigador();
								menuI.setVisible(true);
								dispose();
							}
							if(user.getRole().getNombre().equals("Aficionado")) {
								Menu_Aficionado menuAf = new Menu_Aficionado();
								menuAf.setVisible(true);
								dispose();
							}
						}else {
							JOptionPane.showMessageDialog(null, "Correo y/o contraseña incorrectos: no existe el usuario en el sistema");
						}
						
					} catch(NamingException | ServiciosException ex) {
						ex.getMessage();
					}
					
				}else {
					JOptionPane.showMessageDialog(null, "Por favor, complete ambos campos para poder ingresar al sistema");
				}	
			}			
		});
		
		barra = new JPanel();
		barra.addMouseMotionListener(this);
		barra.addMouseListener(this);
		barra.setBorder(null);
		barra.setBackground(SystemColor.control);
		barra.setBounds(0, 0, 967, 31);
		panel.add(barra);
	}
	
	public void mouseClicked(MouseEvent e) {
		if (e.getSource() == buttonX) {
			mouseClickedButtonX(e);
			//salir
		}
	}
	public void mouseEntered(MouseEvent e) {
		if (e.getSource() == btnIngresar) {
			btnIngresar.setBackground(SystemColor.scrollbar);
		}
		if (e.getSource() == buttonX) {
			buttonX.setBackground(Color.red);
			buttonX.setForeground(Color.white);
		}
	}
	public void mouseExited(MouseEvent e) {
		if (e.getSource() == buttonX) {
			buttonX.setBackground(Color.white);
			buttonX.setForeground(Color.black);
		}
		if (e.getSource() == btnIngresar) {
			btnIngresar.setBackground(SystemColor.controlHighlight);
		}
	}
	
	public void mousePressed(MouseEvent e) {
		if (e.getSource() == password) {
			mousePressedPassword(e);
		}
		if (e.getSource() == textCorreo) {
			mousePressedTextUsuario(e);
		}
		if (e.getSource() == barra) {
			mousePressedBarra(e);
		}
	}
	public void mouseReleased(MouseEvent e) {
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
	protected void mouseClickedButtonX(MouseEvent e) {
		System.exit(0);
	}
	
	
	protected void mousePressedTextUsuario(MouseEvent e) {
		if(textCorreo.getText().equals("Ingrese Correo electrónico")) {
			textCorreo.setText("");
			textCorreo.setForeground(Color.black);
			
		}
		if(String.valueOf(password.getPassword()).isEmpty()) {
			password.setText("********");
			password.setForeground(SystemColor.controlShadow);
		}
		
	}
	protected void mousePressedPassword(MouseEvent e) {
		if(textCorreo.getText().isEmpty()) {
			textCorreo.setText("Ingrese Correo electrónico");
			textCorreo.setForeground(SystemColor.controlShadow);
		}
		if(String.valueOf(password.getPassword()).equals("********")) {
			password.setText("");
			password.setForeground(Color.black);
		}
		

	}
}
