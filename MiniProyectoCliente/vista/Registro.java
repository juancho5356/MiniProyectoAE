package Vista;

import java.awt.EventQueue;

import javax.swing.JFrame;

import javax.swing.JPanel;
import java.awt.Color;

import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import java.awt.SystemColor;
import java.awt.ComponentOrientation;
import java.awt.Font;
import java.awt.event.ActionListener;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.awt.event.ActionEvent;
import javax.swing.JComboBox;
import javax.swing.SwingConstants;

import com.exception.ServiciosException;
import com.servicios.Rol_BeanRemote;
import com.servicios.Usuario_BeanRemote;

import com.entities.*;

import javax.swing.JPasswordField;

public class Registro {

	JFrame frame;
	private JPanel panel_Registro;
	private JLabel lblApellido;
	private JTextField textApellido;
	private JLabel lblNombre;
	private JTextField textNombre;
	private JButton btnIngresar;
	private JLabel lblRegistro;
	private JLabel lblDocumento;
	private JTextField textDocumento;
	private JLabel lblCorreo;
	private JTextField textCorreo;
	private JLabel lblClave;
	private JLabel lblRol;
	private JComboBox<Object> comboBoxRol;
	private JLabel lblCamposObligatorios;
	private JLabel lblNewLabel_3;
	private JLabel lblNewLabel_4;
	private JLabel lblNewLabel_5;
	private JLabel lblNewLabel_7;
	private JLabel lblNewLabel_8;
	private JLabel lblNewLabel_9;
	private JButton btnIr;
	private JLabel lblVerListado;
	private JPasswordField password;
	private JLabel lbl1;
	private JLabel lbl2;
	private JLabel lbl3;
	private JLabel lbl4;
	private JLabel lbl5;
	private JLabel lbl6;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Registro window = new Registro();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public Registro() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setResizable(false);
		frame.setBackground(new Color(255, 255, 255));
		frame.getContentPane().setBackground(new Color(255, 255, 255));
		frame.getContentPane().setLayout(null);
		
		panel_Registro = new JPanel();
		panel_Registro.setLayout(null);
		panel_Registro.setBackground(new Color(250, 235, 215));
		panel_Registro.setBounds(0, 0, 688, 386);
		frame.getContentPane().add(panel_Registro);
		
		lbl1 = new JLabel("Campo requerido");
		lbl1.setForeground(Color.RED);
		lbl1.setFont(new Font("Arial", Font.BOLD | Font.ITALIC, 10));
		lbl1.setBounds(350, 78, 184, 19);
		panel_Registro.add(lbl1);
		
		lbl2 = new JLabel("Campo requerido");
		lbl2.setForeground(Color.RED);
		lbl2.setFont(new Font("Arial", Font.BOLD | Font.ITALIC, 10));
		lbl2.setBounds(350, 119, 184, 19);
		panel_Registro.add(lbl2);
		
		lbl3 = new JLabel("Campo requerido");
		lbl3.setForeground(Color.RED);
		lbl3.setFont(new Font("Arial", Font.BOLD | Font.ITALIC, 10));
		lbl3.setBounds(350, 158, 184, 19);
		panel_Registro.add(lbl3);
		
		lbl4 = new JLabel("Campo requerido");
		lbl4.setForeground(Color.RED);
		lbl4.setFont(new Font("Arial", Font.BOLD | Font.ITALIC, 10));
		lbl4.setBounds(350, 196, 184, 19);
		panel_Registro.add(lbl4);
		
		lbl5 = new JLabel("Campo requerido");
		lbl5.setForeground(Color.RED);
		lbl5.setFont(new Font("Arial", Font.BOLD | Font.ITALIC, 10));
		lbl5.setBounds(350, 232, 273, 19);
		panel_Registro.add(lbl5);
		
		lbl6 = new JLabel("Campo requerido");
		lbl6.setForeground(Color.RED);
		lbl6.setFont(new Font("Arial", Font.BOLD | Font.ITALIC, 10));
		lbl6.setBounds(350, 273, 184, 19);
		panel_Registro.add(lbl6);
		lblApellido = new JLabel("Apellido");
		lblApellido.setFont(new Font("Baskerville Old Face", Font.PLAIN, 12));
		lblApellido.setBounds(22, 159, 67, 13);
		panel_Registro.add(lblApellido);
		
		textApellido = new JTextField();
		textApellido.setFont(new Font("Arial", Font.PLAIN, 12));
		textApellido.setForeground(SystemColor.desktop);
		textApellido.setBackground(SystemColor.textHighlightText);
		textApellido.setColumns(10);
		textApellido.setBounds(137, 156, 203, 19);
		panel_Registro.add(textApellido);
		textApellido.addKeyListener(new KeyListener() {

			@Override
			public void keyTyped(KeyEvent e) {
				char validar = e.getKeyChar();

				if(!(isLetra(validar, e))) {
					e.consume();
					
					JOptionPane.showMessageDialog(null, "Campo 'Apellido' debe contener solo letras");
				}
				else {
					lbl3.setText("Correcto");
					lbl3.setForeground(new Color(95, 158, 160));
				}
				if(textApellido.getText().equals("")) {
					lbl3.setText("Campo requerido");
					lbl3.setForeground(Color.RED);
				}
			}

			@Override
			public void keyPressed(KeyEvent e) {
				
			}

			@Override
			public void keyReleased(KeyEvent e) {
				
			}
			
		});
		
		lblNombre = new JLabel("Nombre");
		lblNombre.setFont(new Font("Baskerville Old Face", Font.PLAIN, 12));
		lblNombre.setBounds(22, 120, 93, 13);
		panel_Registro.add(lblNombre);
		
		textNombre = new JTextField();
		textNombre.setFont(new Font("Arial", Font.PLAIN, 12));
		textNombre.setForeground(SystemColor.desktop);
		textNombre.setBackground(SystemColor.textHighlightText);
		textNombre.setColumns(10);
		textNombre.setBounds(137, 117, 203, 19);
		panel_Registro.add(textNombre);
		textNombre.addKeyListener(new KeyListener() {

			public void keyTyped(KeyEvent e) {
				char validar = e.getKeyChar();
				
				if(!(isLetra(validar, e))) { 
					e.consume();
					
					JOptionPane.showMessageDialog(null, "Campo 'Nombre' debe contener solo letras");
				}
				else {
					lbl2.setText("Correcto");
					lbl2.setForeground(new Color(95, 158, 160));
				}
				if(textNombre.getText().equals("")) {
					lbl2.setText("Campo requerido");
					lbl2.setForeground(Color.RED);
				}
			}

			public void keyPressed(KeyEvent e) {

			}

			public void keyReleased(KeyEvent e) {
	
			}
			
		});
		btnIngresar = new JButton("Ingresar");
		btnIngresar.setBackground(new Color(253, 245, 230));
		btnIngresar.setBounds(235, 329, 105, 21);
		panel_Registro.add(btnIngresar);
		btnIngresar.addActionListener(new ActionListener() {
			
			public void actionPerformed(ActionEvent e) {
				
				if(textDocumento.getText().equals("") || isCedula() == false || textNombre.getText().equals("") || 
						textApellido.getText().equals("") || textCorreo.getText().equals("") || 
						isEmail(textCorreo.getText()) == false || String.valueOf(password.getPassword()).equals("") || 
						existeUsuarioCedula(textDocumento.getText()) || existeUsuarioMail(textCorreo.getText()) ||
						comboBoxRol.getSelectedItem().equals("") || String.valueOf(password.getPassword()).length() < 8) {
					
					JOptionPane.showMessageDialog(null, "Por favor ingrese todos los campos correctamente!");
				}
				else {
					String d = textDocumento.getText();
					String n = textNombre.getText();
					String a = textApellido.getText();
					
					String m = textCorreo.getText();
					String c = String.valueOf(password.getPassword());
					
					String r = (String) comboBoxRol.getSelectedItem();
					
					Rol rol = null;
					
					try {
						String dato = "MiniproyectoEJB/Rol_Bean!com.servicios.Rol_BeanRemote";
						Rol_BeanRemote ro = (Rol_BeanRemote) InitialContext.doLookup(dato);
						
						rol = ro.findNombre(r);
						
					} catch(NamingException | ServiciosException ex) {
						ex.getMessage();
					}
					
					Usuario user = new Usuario();
					user.setDocumento(d);
					user.setNombre(n);
					user.setApellido(a);
					user.setMail(m);
					user.setClave(c);
					user.setRol(rol);
					
					try {
						String dato = "MiniproyectoEJB/Usuario_Bean!com.servicios.Usuario_BeanRemote";
						Usuario_BeanRemote us = (Usuario_BeanRemote) InitialContext.doLookup(dato);
						
						if(us.insert(user)) {
							JOptionPane.showMessageDialog(null, "Usuario insertado correctamente en el sistema");
							limpiar();
						}
						else {
							JOptionPane.showMessageDialog(null, "No es posible insertar este usuario");
						}
						
					} catch(Exception ex) {
						ex.getMessage();
					}
				}
			}
		});
		
		lblRegistro = new JLabel("Alta de Usuario");
		lblRegistro.setForeground(Color.BLACK);
		lblRegistro.setFont(new Font("Bookman Old Style", Font.ITALIC, 30));
		lblRegistro.setComponentOrientation(ComponentOrientation.LEFT_TO_RIGHT);
		lblRegistro.setBounds(10, 10, 289, 47);
		panel_Registro.add(lblRegistro);
		
		lblDocumento = new JLabel("Documento");
		lblDocumento.setFont(new Font("Baskerville Old Face", Font.PLAIN, 12));
		lblDocumento.setBounds(22, 81, 67, 13);
		panel_Registro.add(lblDocumento);
		
		textDocumento = new JTextField();
		textDocumento.setFont(new Font("Arial", Font.PLAIN, 12));
		textDocumento.setForeground(SystemColor.desktop);
		textDocumento.setBackground(SystemColor.textHighlightText);
		textDocumento.setColumns(10);
		textDocumento.setBounds(137, 78, 203, 19);
		panel_Registro.add(textDocumento);
		textDocumento.addKeyListener(new KeyListener() {
			
			public void keyTyped(KeyEvent evt) {
				char validar = evt.getKeyChar();
				
				if(isNumero(validar, evt) == false) {
					evt.consume();
					
					JOptionPane.showMessageDialog(null, "Cédula debe contener solo números");
					
				}
					
				if(8 <= textDocumento.getText().length()) {
					evt.consume();
					
					if(!isCedula()) {
						JOptionPane.showMessageDialog(null, "La Cédula ingresada es incorrecta");
						lbl1.setText("Campo inválido");
						lbl1.setForeground(Color.RED);
					}
					else {
						lbl1.setText("Correcto");
						lbl1.setForeground(new Color(95, 158, 160));
					}
				}
				
				if(!(textDocumento.getText().equals(""))) {
					String ci = textDocumento.getText();
					
					if(existeUsuarioCedula(ci)) {

						JOptionPane.showMessageDialog(null, "La Cédula ingresada ya existe en el sistema!");
						textDocumento.setText("");
						
						lbl1.setText("Campo requerido");
						lbl1.setForeground(Color.RED);
					}
				}
				else {
					lbl1.setText("Campo requerido");
					lbl1.setForeground(Color.RED);
				}
				

			}

			public void keyPressed(KeyEvent e) {

			}
			public void keyReleased(KeyEvent e) {
				if(textDocumento.getText().length() == 8) {
					e.consume();

					if(!isCedula()) {
						JOptionPane.showMessageDialog(null, "La Cédula ingresada es incorrecta");
						lbl1.setText("Campo inválido");
						lbl1.setForeground(Color.RED);
					}
					else {
						lbl1.setText("Correcto");
						lbl1.setForeground(new Color(95, 158, 160));
					}
				}
				else {
					lbl1.setText("Campo requerido: 8 caracteres");
					lbl1.setForeground(Color.RED);
				}
				
				if(!(textDocumento.getText().equals(""))) {
					String ci = textDocumento.getText();
					
					if(existeUsuarioCedula(ci)) {

						JOptionPane.showMessageDialog(null, "La Cédula ingresada ya existe en el sistema!");
						textDocumento.setText("");
						
						lbl1.setText("Campo requerido");
						lbl1.setForeground(Color.RED);
					}
				}
				else {
					lbl1.setText("Campo requerido");
					lbl1.setForeground(Color.RED);
				}
			}
		});
		
		lblCorreo = new JLabel("Correo electrónico");
		lblCorreo.setFont(new Font("Baskerville Old Face", Font.PLAIN, 12));
		lblCorreo.setBounds(22, 197, 111, 13);
		panel_Registro.add(lblCorreo);
		
		textCorreo = new JTextField();
		textCorreo.setFont(new Font("Arial", Font.PLAIN, 12));
		textCorreo.setForeground(SystemColor.desktop);
		textCorreo.setBackground(SystemColor.textHighlightText);
		textCorreo.setColumns(10);
		textCorreo.setBounds(137, 194, 203, 19);
		panel_Registro.add(textCorreo);
		textCorreo.addFocusListener(new FocusListener() {

			public void focusGained(FocusEvent e) {				
			}
			public void focusLost(FocusEvent e) {
				if(!isEmail(textCorreo.getText())) {
					JOptionPane.showMessageDialog(null, "Campo 'Correo' debe contener formato: example@example.com");
					
					lbl4.setText("Campo inválido");
					lbl4.setForeground(Color.RED);
				}
				else {
					lbl4.setText("Correcto");
					lbl4.setForeground(new Color(95, 158, 160));
				}
			}
			
		});
		textCorreo.addKeyListener(new KeyListener() {

			@Override
			public void keyTyped(KeyEvent e) {
				if(!isEmail(textCorreo.getText())) {
					
					lbl4.setText("Campo inválido");
					lbl4.setForeground(Color.RED);
				}
				else {
					lbl4.setText("Correcto");
					lbl4.setForeground(new Color(95, 158, 160));
				}
			}

			@Override
			public void keyPressed(KeyEvent e) {
				// TODO Auto-generated method stub
				
			}

			@Override
			public void keyReleased(KeyEvent e) {
				if(!isEmail(textCorreo.getText())) {
					
					lbl4.setText("Campo inválido");
					lbl4.setForeground(Color.RED);
				}
				else {
					lbl4.setText("Correcto");
					lbl4.setForeground(new Color(95, 158, 160));
				}
				if(!(textCorreo.getText().equals(""))) {
					if(existeUsuarioMail(textCorreo.getText())) {
						JOptionPane.showMessageDialog(null, "El correo ingresado ya existe en el sistema!");
						textCorreo.setText("");
						
						lbl4.setText("Campo requerido");
						lbl4.setForeground(Color.RED);
					}
				}
				else {
					lbl4.setText("Correcto");
					lbl4.setForeground(new Color(95, 158, 160));
				}
			}
			
		});
		
		lblClave = new JLabel("Contraseña");
		lblClave.setFont(new Font("Baskerville Old Face", Font.PLAIN, 12));
		lblClave.setBounds(22, 236, 67, 13);
		panel_Registro.add(lblClave);
		
		lblRol = new JLabel("Rol");
		lblRol.setFont(new Font("Baskerville Old Face", Font.PLAIN, 12));
		lblRol.setBounds(22, 274, 67, 13);
		panel_Registro.add(lblRol);
		
		comboBoxRol = new JComboBox<Object>();
		comboBoxRol.setFont(new Font("Arial", Font.PLAIN, 12));
		comboBoxRol.setBackground(new Color(255, 255, 255));
		comboBoxRol.setBounds(137, 272, 203, 17);
		panel_Registro.add(comboBoxRol);
		comboBoxRol.addItemListener(new ItemListener() {

			@Override
			public void itemStateChanged(ItemEvent e) {
				if(comboBoxRol.getSelectedItem().equals("")) {
					lbl6.setText("Campo requerido");
					lbl6.setForeground(Color.RED);
				
				}else {
					lbl6.setText("Correcto");
					lbl6.setForeground(new Color(95, 158, 160));
				}
			}
			
		});
		comboBoxRol.addItem("");
		
		List<Rol> roles = null;
		
		try {
			String dato = "MiniproyectoEJB/Rol_Bean!com.servicios.Rol_BeanRemote";
			Rol_BeanRemote r = (Rol_BeanRemote) InitialContext.doLookup(dato);
			
			roles = r.findAll();
			
			if(roles.size() != 0) {
				for(Rol re : roles) {
					comboBoxRol.addItem(re.getNombre());
				}
			}
		} catch(Exception ex) {
			ex.getMessage();
		}
		
		lblCamposObligatorios = new JLabel("Campos obligatorios *");
		lblCamposObligatorios.setFont(new Font("Baskerville Old Face", Font.PLAIN, 12));
		lblCamposObligatorios.setForeground(SystemColor.windowBorder);
		lblCamposObligatorios.setHorizontalAlignment(SwingConstants.RIGHT);
		lblCamposObligatorios.setBounds(178, 59, 162, 19);
		panel_Registro.add(lblCamposObligatorios);
		
		lblNewLabel_3 = new JLabel("*");
		lblNewLabel_3.setBounds(10, 81, 15, 13);
		panel_Registro.add(lblNewLabel_3);
		
		lblNewLabel_4 = new JLabel("*");
		lblNewLabel_4.setBounds(10, 159, 15, 13);
		panel_Registro.add(lblNewLabel_4);
		
		lblNewLabel_5 = new JLabel("*");
		lblNewLabel_5.setBounds(10, 120, 15, 13);
		panel_Registro.add(lblNewLabel_5);
		
		lblNewLabel_7 = new JLabel("*");
		lblNewLabel_7.setBounds(10, 197, 15, 13);
		panel_Registro.add(lblNewLabel_7);
		
		lblNewLabel_8 = new JLabel("*");
		lblNewLabel_8.setBounds(10, 236, 15, 13);
		panel_Registro.add(lblNewLabel_8);
		
		lblNewLabel_9 = new JLabel("*");
		lblNewLabel_9.setBounds(10, 274, 15, 13);
		panel_Registro.add(lblNewLabel_9);
		
		btnIr = new JButton("Ir");
		btnIr.setBackground(SystemColor.menu);
		btnIr.setBounds(600, 329, 67, 21);
		panel_Registro.add(btnIr);
		btnIr.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ListadoUsuarios window = new ListadoUsuarios();
				window.frame.setVisible(true);
			}
		});
		
		lblVerListado = new JLabel("Ver Listado de Registros");
		lblVerListado.setFont(new Font("Baskerville Old Face", Font.PLAIN, 12));
		lblVerListado.setBounds(444, 333, 146, 13);
		panel_Registro.add(lblVerListado);
		
		password = new JPasswordField();
		password.setFont(new Font("Arial", Font.PLAIN, 12));
		password.setBounds(137, 233, 203, 19);
		panel_Registro.add(password);
		password.addKeyListener(new KeyListener() {

			@Override
			public void keyTyped(KeyEvent e) {
				if(String.valueOf(password.getPassword()).length() < 8) {
					lbl5.setText("Campo requerido: mínimo 8 caracteres");
					lbl5.setForeground(Color.RED);
				}
				if(String.valueOf(password.getPassword()).equals("")) {
					lbl5.setText("Campo requerido");
					lbl5.setForeground(Color.RED);
				}
			}

			@Override
			public void keyPressed(KeyEvent e) {
				// TODO Auto-generated method stub
				
			}

			@Override
			public void keyReleased(KeyEvent e) {
				if(String.valueOf(password.getPassword()).length() == 8) {
					lbl5.setText("Correcto");
					lbl5.setForeground(new Color(95, 158, 160));
				}

				if(String.valueOf(password.getPassword()).equals("")) {
					lbl5.setText("Campo requerido");
					lbl5.setForeground(Color.RED);
				}
			}
			
		});
		
		
		frame.setBounds(100, 100, 702, 423);
		frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
	}
	public void limpiar() {
		textDocumento.setText("");
		textApellido.setText("");
		textNombre.setText("");
		textCorreo.setText("");
		password.setText("");
		comboBoxRol.setSelectedItem("");
		
		lbl1.setText("Campo requerido");
		lbl1.setForeground(Color.RED);
		
		lbl2.setText("Campo requerido");
		lbl2.setForeground(Color.RED);
		
		lbl3.setText("Campo requerido");
		lbl3.setForeground(Color.RED);
		
		lbl4.setText("Campo requerido");
		lbl4.setForeground(Color.RED);
		
		lbl5.setText("Campo requerido");
		lbl5.setForeground(Color.RED);
		
		lbl6.setText("Campo requerido");
		lbl6.setForeground(Color.RED);
	}
	public boolean isEmail(String correo) {
		
		Pattern pat = Pattern.compile( "^[_A-Za-z0-9-\\+]+(\\.[_A-Za-z0-9-]+)*@[A-Za-z0-9-]+(\\.[A-Za-z0-9]+)*\\.com(\\W|$)");
		
		Matcher mat = pat.matcher(correo.toLowerCase());

		if(mat.find()) {
			return true;
		}else {
			return false;
		}
	}
	public static boolean isNumero(char validar, KeyEvent evt) {
		if((validar<'0' || '9'<validar) && validar != KeyEvent.VK_BACK_SPACE) {
			evt.consume();
			
			return false;
		}
		return true;
	}
	public static boolean isLetra(char validar, KeyEvent evt) {
		if(!(Character.isAlphabetic(validar)) && validar != KeyEvent.VK_BACK_SPACE && validar != KeyEvent.VK_SPACE) {
			evt.consume();
			return false;
		}
		return true;
	}
	public boolean existeUsuarioMail(String mail) {
		
		Usuario user = null;
		
		try {
			String dato = "MiniproyectoEJB/Usuario_Bean!com.servicios.Usuario_BeanRemote";
			Usuario_BeanRemote us = (Usuario_BeanRemote) InitialContext.doLookup(dato);
			user = us.findCorreo(mail);
		
		} catch(NamingException | ServiciosException ex) {
			ex.getMessage();
		}	
		
		if(user==null) {
			return false;
		}
		else {
			return true;
		}
	}
	public boolean existeUsuarioCedula(String cedula) {
		
		Usuario user = null;
		
		try {
			String dato = "MiniproyectoEJB/Usuario_Bean!com.servicios.Usuario_BeanRemote";
			Usuario_BeanRemote us = (Usuario_BeanRemote) InitialContext.doLookup(dato);
			user = us.findDocumento(cedula);
		
		} catch(NamingException | ServiciosException ex) {
			ex.getMessage();
		}	
		
		if(user==null) {
			return false;
		}
		else {
			return true;
		}
	}
	public boolean isCedula() {
		
		int correcto=0;
		String ced=textDocumento.getText().trim();
				
		int cedula[]; // Vector donde van a estar los digitos de la cedula
		int factor[] = {8,1,2,3,4,7,6,0};// factor a multiplicar
		
		cedula = new int[8];
		
		int suma=0;
		
		
		for(int i=0;i<ced.length();i++){
			if(ced.charAt(i) == '0' || ced.charAt(i)== '1' || ced.charAt(i)=='2' 
               || ced.charAt(i)== '3' || ced.charAt(i) == '4' || ced.charAt(i)== '5' || ced.charAt(i)=='6' 
              || ced.charAt(i) == '7' || ced.charAt(i)== '8' || ced.charAt(i)=='9'){
				correcto++;
				cedula[i]=Integer.parseInt("" +ced.charAt(i));
				
				 
				suma = suma + (cedula[i]*factor[i]);
				
			}
			
		}
		
		if (correcto!=8){
			return false;
			
		} else {
			// Caso de ingreso correcto 
			
			int resto=suma%10;
			if (resto == cedula[7]) {
				return true;
			} else {
				return false;
			}
		}
	}
}
