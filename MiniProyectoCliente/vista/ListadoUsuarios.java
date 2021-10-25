package Vista;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.JPanel;
import java.awt.Color;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import com.exception.ServiciosException;
import com.servicios.Rol_BeanRemote;
import com.servicios.Usuario_BeanRemote;

import com.entities.*;

import java.awt.SystemColor;
import java.awt.event.ActionEvent;
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

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.swing.JButton;
import javax.swing.JComboBox;
import java.awt.ComponentOrientation;
import java.awt.Font;
import javax.swing.SwingConstants;
import javax.swing.ListSelectionModel;
import java.awt.event.MouseListener;
import java.awt.event.MouseEvent;
import javax.swing.JPasswordField;
import javax.swing.JSeparator;

public class ListadoUsuarios  {

	JFrame frame;
	private JPanel panel;
	private JScrollPane scrollPane;
	private JPanel panel_1;
	private JLabel lblModificacionDeUsuarios;
	private JButton btnAceptar;
	private JTable table;
	private JLabel lblSelect;
	private JLabel lblListadoDeUsuarios;
	private JLabel lblNewLabel_1;
	private JLabel lblNewLabel_2;
	private JLabel lblNewLabel_3;
	private JLabel lblNewLabel_4;
	private JLabel lblNewLabel_5;
	private JLabel lblNewLabel_6;
	private JLabel lblDocumento;
	private JTextField textDocumento;
	private JTextField textNombre;
	private JLabel lblNombre;
	private JLabel lblApellido;
	private JLabel lbl1;
	private JLabel lbl2;
	private JTextField textApellido;
	private JLabel lbl3;
	private JLabel lbl4;
	private JTextField textCorreo;
	private JLabel lblCorreo;
	private JPasswordField password;
	private JLabel lblRol;
	private JComboBox<Object> comboBoxRol;
	private JLabel lblClave;
	private JLabel lblCamposObligatorios;
	private JLabel lbl5;
	private JLabel lbl6;
	private JPanel panel_2;
	private JLabel lblBajaDeUsuarios;
	private JSeparator separator;
	private JSeparator separator_1;
	private JTextField textId;
	private JLabel lblNewLabel;
	private JButton btnEliminar;

	
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ListadoUsuarios window = new ListadoUsuarios();
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
	public ListadoUsuarios() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setResizable(false);
		frame.getContentPane().setBackground(new Color(175, 238, 238));
		frame.getContentPane().setLayout(null);
		
		panel = new JPanel();
		panel.setBounds(0, 0, 1431, 514);
		panel.setLayout(null);
		panel.setBackground(new Color(255, 239, 213));
		frame.getContentPane().add(panel);
		
		scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 69, 846, 424);
		panel.add(scrollPane);
		
		table = new JTable();
		table.setSurrendersFocusOnKeystroke(true);
		table.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		scrollPane.setViewportView(table);
		
		listaP();
		
		panel_1 = new JPanel();
		panel_1.setBackground(new Color(255, 204, 153));
		panel_1.setLayout(null);
		panel_1.setBounds(866, 0, 566, 353);
		panel.add(panel_1);
		
		lblModificacionDeUsuarios = new JLabel("Modificacion de usuarios");
		lblModificacionDeUsuarios.setHorizontalAlignment(SwingConstants.CENTER);
		lblModificacionDeUsuarios.setFont(new Font("Bookman Old Style", Font.BOLD | Font.ITALIC, 20));
		lblModificacionDeUsuarios.setComponentOrientation(ComponentOrientation.LEFT_TO_RIGHT);
		lblModificacionDeUsuarios.setBounds(0, 20, 556, 25);
		panel_1.add(lblModificacionDeUsuarios);

		lbl1 = new JLabel("Campo requerido");
		lbl1.setForeground(Color.RED);
		lbl1.setFont(new Font("Arial", Font.BOLD | Font.ITALIC, 10));
		lbl1.setBounds(350, 86, 184, 19);
		panel_1.add(lbl1);

		lbl2 = new JLabel("Campo requerido");
		lbl2.setForeground(Color.RED);
		lbl2.setFont(new Font("Arial", Font.BOLD | Font.ITALIC, 10));
		lbl2.setBounds(350, 127, 184, 19);
		panel_1.add(lbl2);
		
		lbl3 = new JLabel("Campo requerido");
		lbl3.setForeground(Color.RED);
		lbl3.setFont(new Font("Arial", Font.BOLD | Font.ITALIC, 10));
		lbl3.setBounds(350, 166, 184, 19);
		panel_1.add(lbl3);
		
		lbl4 = new JLabel("Campo requerido");
		lbl4.setForeground(Color.RED);
		lbl4.setFont(new Font("Arial", Font.BOLD | Font.ITALIC, 10));
		lbl4.setBounds(350, 204, 184, 19);
		panel_1.add(lbl4);
		
		lbl5 = new JLabel("Campo requerido");
		lbl5.setForeground(Color.RED);
		lbl5.setFont(new Font("Arial", Font.BOLD | Font.ITALIC, 10));
		lbl5.setBounds(350, 240, 216, 19);
		panel_1.add(lbl5);
		
		lbl6 = new JLabel("Campo requerido");
		lbl6.setForeground(Color.RED);
		lbl6.setFont(new Font("Arial", Font.BOLD | Font.ITALIC, 10));
		lbl6.setBounds(350, 281, 184, 19);
		panel_1.add(lbl6);
		
		lblNewLabel_1 = new JLabel("*");
		lblNewLabel_1.setBounds(12, 91, 15, 13);
		panel_1.add(lblNewLabel_1);
		
		lblNewLabel_2 = new JLabel("*");
		lblNewLabel_2.setBounds(12, 130, 15, 13);
		panel_1.add(lblNewLabel_2);
		
		lblNewLabel_3 = new JLabel("*");
		lblNewLabel_3.setBounds(12, 169, 15, 13);
		panel_1.add(lblNewLabel_3);
		
		lblNewLabel_4 = new JLabel("*");
		lblNewLabel_4.setBounds(12, 207, 15, 13);
		panel_1.add(lblNewLabel_4);
		
		lblNewLabel_5 = new JLabel("*");
		lblNewLabel_5.setBounds(12, 246, 15, 13);
		panel_1.add(lblNewLabel_5);
		
		lblNewLabel_6 = new JLabel("*");
		lblNewLabel_6.setBounds(12, 284, 15, 13);
		panel_1.add(lblNewLabel_6);
		
		lblDocumento = new JLabel("Documento");
		lblDocumento.setFont(new Font("Baskerville Old Face", Font.PLAIN, 12));
		lblDocumento.setBounds(22, 89, 67, 13);
		panel_1.add(lblDocumento);
		
		textDocumento = new JTextField();
		textDocumento.setHorizontalAlignment(SwingConstants.LEFT);
		textDocumento.setForeground(Color.BLACK);
		textDocumento.setFont(new Font("Arial", Font.PLAIN, 12));
		textDocumento.setColumns(10);
		textDocumento.setBackground(Color.WHITE);
		textDocumento.setBounds(137, 86, 203, 19);
		panel_1.add(textDocumento);
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
					
					if(existeUsuarioCedula(ci, Long.parseLong(textId.getText()))) {

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
					
					if(existeUsuarioCedula(ci, Long.parseLong(textId.getText()))) {

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

		textNombre = new JTextField();
		textNombre.setHorizontalAlignment(SwingConstants.LEFT);
		textNombre.setForeground(Color.BLACK);
		textNombre.setFont(new Font("Arial", Font.PLAIN, 12));
		textNombre.setColumns(10);
		textNombre.setBackground(Color.WHITE);
		textNombre.setBounds(137, 125, 203, 19);
		panel_1.add(textNombre);
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
		
		lblNombre = new JLabel("Nombre");
		lblNombre.setFont(new Font("Baskerville Old Face", Font.PLAIN, 12));
		lblNombre.setBounds(22, 128, 93, 13);
		panel_1.add(lblNombre);
		
		lblApellido = new JLabel("Apellido");
		lblApellido.setFont(new Font("Baskerville Old Face", Font.PLAIN, 12));
		lblApellido.setBounds(22, 167, 67, 13);
		panel_1.add(lblApellido);
		
		
		textApellido = new JTextField();
		textApellido.setHorizontalAlignment(SwingConstants.LEFT);
		textApellido.setForeground(Color.BLACK);
		textApellido.setFont(new Font("Arial", Font.PLAIN, 12));
		textApellido.setColumns(10);
		textApellido.setBackground(Color.WHITE);
		textApellido.setBounds(137, 164, 203, 19);
		panel_1.add(textApellido);
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
		
		textCorreo = new JTextField();
		textCorreo.setHorizontalAlignment(SwingConstants.LEFT);
		textCorreo.setForeground(Color.BLACK);
		textCorreo.setFont(new Font("Arial", Font.PLAIN, 12));
		textCorreo.setColumns(10);
		textCorreo.setBackground(Color.WHITE);
		textCorreo.setBounds(137, 202, 203, 19);
		panel_1.add(textCorreo);
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
					if(existeUsuarioMail(textCorreo.getText(), Long.parseLong(textId.getText()))) {
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
		
		lblCorreo = new JLabel("Correo electrónico");
		lblCorreo.setFont(new Font("Baskerville Old Face", Font.PLAIN, 12));
		lblCorreo.setBounds(22, 205, 111, 13);
		panel_1.add(lblCorreo);
		
		password = new JPasswordField();
		password.setHorizontalAlignment(SwingConstants.LEFT);
		password.setFont(new Font("Arial", Font.PLAIN, 12));
		password.setBounds(137, 241, 203, 19);
		panel_1.add(password);
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
		
		lblRol = new JLabel("Rol");
		lblRol.setFont(new Font("Baskerville Old Face", Font.PLAIN, 12));
		lblRol.setBounds(22, 282, 67, 13);
		panel_1.add(lblRol);
		
		comboBoxRol = new JComboBox<Object>();
		comboBoxRol.setFont(new Font("Arial", Font.PLAIN, 12));
		comboBoxRol.setBackground(Color.WHITE);
		comboBoxRol.setBounds(137, 280, 203, 17);
		panel_1.add(comboBoxRol);
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
		
		lblClave = new JLabel("Contraseña");
		lblClave.setFont(new Font("Baskerville Old Face", Font.PLAIN, 12));
		lblClave.setBounds(22, 244, 67, 13);
		panel_1.add(lblClave);
		
		lblCamposObligatorios = new JLabel("Campos obligatorios *");
		lblCamposObligatorios.setHorizontalAlignment(SwingConstants.RIGHT);
		lblCamposObligatorios.setForeground(SystemColor.windowBorder);
		lblCamposObligatorios.setFont(new Font("Baskerville Old Face", Font.PLAIN, 12));
		lblCamposObligatorios.setBounds(178, 67, 162, 19);
		panel_1.add(lblCamposObligatorios);
		
		separator = new JSeparator();
		separator.setBounds(12, 43, 544, 2);
		panel_1.add(separator);
		
		textId = new JTextField();
		textId.setEditable(false);
		textId.setForeground(new Color(255, 204, 153));
		textId.setBackground(new Color(255, 204, 153));
		textId.setBorder(null);
		textId.setBounds(19, 55, 48, 19);
		panel_1.add(textId);
		textId.setColumns(10);
		
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
		
		lblSelect = new JLabel("Seleccione un registro para realizar alguna modificación o baja");
		lblSelect.setHorizontalAlignment(SwingConstants.RIGHT);
		lblSelect.setForeground(Color.DARK_GRAY);
		lblSelect.setBounds(459, 40, 397, 19);
		panel.add(lblSelect);
		
		lblListadoDeUsuarios = new JLabel("Listado de usuarios");
		lblListadoDeUsuarios.setForeground(Color.BLACK);
		lblListadoDeUsuarios.setFont(new Font("Bookman Old Style", Font.ITALIC, 30));
		lblListadoDeUsuarios.setComponentOrientation(ComponentOrientation.LEFT_TO_RIGHT);
		lblListadoDeUsuarios.setBounds(10, 12, 477, 47);
		panel.add(lblListadoDeUsuarios);
		

		btnAceptar = new JButton("Confirmar");
		btnAceptar.setBackground(new Color(255, 239, 213));
		btnAceptar.setBounds(137, 321, 203, 21);
		panel_1.add(btnAceptar);
		btnAceptar.addActionListener(new ActionListener() {
			public void actionPerformed (ActionEvent e) {
				if(textDocumento.getText().equals("") || isCedula() == false || textNombre.getText().equals("") || 
						textApellido.getText().equals("") || textCorreo.getText().equals("") || 
						isEmail(textCorreo.getText()) == false || String.valueOf(password.getPassword()).equals("") || 
						comboBoxRol.getSelectedItem().equals("") || String.valueOf(password.getPassword()).length() < 8) {
					
					JOptionPane.showMessageDialog(null, "Por favor ingrese todos los campos correctamente!");
				}
				else {
					int respuesta = JOptionPane.showConfirmDialog(null, "¿Realmente quieres modificar a este usuario?", "Confirmar", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);
					
					if(respuesta == JOptionPane.YES_OPTION) {
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
						
						user.setIdUsuario(Long.parseLong(textId.getText()));
						
						try {
							String dato = "MiniproyectoEJB/Usuario_Bean!com.servicios.Usuario_BeanRemote";
							Usuario_BeanRemote us = (Usuario_BeanRemote) InitialContext.doLookup(dato);
							
							if(us.edit(user)) {
								JOptionPane.showMessageDialog(null, "Usuario modificado correctamente");
								limpiar();
								listaP();
								Habilitar(false);
							}
							else {
								JOptionPane.showMessageDialog(null, "No es posible modificar este usuario");
							}
							
						} catch(Exception ex) {
							ex.getMessage();
						}
					}
					
				}
			
			}
			
		});
		
		panel_2 = new JPanel();
		panel_2.setBackground(new Color(255, 228, 196));
		panel_2.setBounds(866, 363, 565, 141);
		panel.add(panel_2);
		panel_2.setLayout(null);
		
		lblBajaDeUsuarios = new JLabel("Baja de usuarios");
		lblBajaDeUsuarios.setBounds(0, 22, 565, 25);
		panel_2.add(lblBajaDeUsuarios);
		lblBajaDeUsuarios.setHorizontalAlignment(SwingConstants.CENTER);
		lblBajaDeUsuarios.setFont(new Font("Bookman Old Style", Font.BOLD | Font.ITALIC, 20));
		lblBajaDeUsuarios.setComponentOrientation(ComponentOrientation.LEFT_TO_RIGHT);
		
		
		separator_1 = new JSeparator();
		separator_1.setBounds(10, 45, 545, 2);
		panel_2.add(separator_1);
		
		lblNewLabel = new JLabel("Una vez seleccionado un registro del listado de usuarios, usted podrá realizar la baja del mismo");
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setForeground(SystemColor.windowBorder);
		lblNewLabel.setFont(new Font("Baskerville Old Face", Font.PLAIN, 12));
		lblNewLabel.setBounds(10, 57, 545, 25);
		panel_2.add(lblNewLabel);
		
		btnEliminar = new JButton("Eliminar Usuario");
		btnEliminar.setBackground(new Color(255, 239, 213));
		btnEliminar.setBounds(10, 92, 545, 25);
		panel_2.add(btnEliminar);
		btnEliminar.setEnabled(false);
		
		btnEliminar.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				try {
					int respuesta = JOptionPane.showConfirmDialog(null, "¿Realmente quieres eliminar a este usuario? Una vez hecho, no hay vuelta atrás", "Confirmar", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);
					
					if(respuesta == JOptionPane.YES_OPTION) {
						String dato = "MiniproyectoEJB/Usuario_Bean!com.servicios.Usuario_BeanRemote";
						Usuario_BeanRemote us = (Usuario_BeanRemote) InitialContext.doLookup(dato);
						
						Usuario user = us.findId(Long.parseLong(textId.getText()));
						
						user.setIdUsuario(Long.parseLong(textId.getText()));
					
						if(us.delete(user)) {
							JOptionPane.showMessageDialog(null, "Usuario eliminado correctamente");
							limpiar();
							listaP();
							Habilitar(false);
						}
						else {
							JOptionPane.showMessageDialog(null, "No es posible eliminar este usuario");
						}
					}
					
					
				} catch(Exception ex) {
					ex.getMessage();
				}
			}
			
		});
		Habilitar(false);

		frame.setBackground(Color.WHITE);
		frame.setBounds(100, 100, 1445, 542);
		frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
	
		table.addMouseListener(new MouseListener() {

			@Override
			public void mouseClicked(MouseEvent e) {
				limpiar();
				
				int filaSeleccionada;
				
				
				filaSeleccionada = table.getSelectedRow();
				if(filaSeleccionada == -1) {
					btnEliminar.setEnabled(false);
					Habilitar(false);
					
				}else {
					btnEliminar.setEnabled(true);
					Habilitar(true);
					
					textDocumento.setText(table.getValueAt(filaSeleccionada, 0 ).toString());
					textNombre.setText(table.getValueAt(filaSeleccionada, 1 ).toString());
					textApellido.setText(table.getValueAt(filaSeleccionada, 2 ).toString());
					textCorreo.setText(table.getValueAt(filaSeleccionada, 3).toString());
					password.setText(table.getValueAt(filaSeleccionada, 4).toString());
					comboBoxRol.setSelectedItem(table.getValueAt(filaSeleccionada, 5));
					
					try {
						String dato = "MiniproyectoEJB/Usuario_Bean!com.servicios.Usuario_BeanRemote";
						Usuario_BeanRemote us = (Usuario_BeanRemote) InitialContext.doLookup(dato);
						
						Usuario u = us.findUser(table.getValueAt(filaSeleccionada, 3).toString(), table.getValueAt(filaSeleccionada, 4).toString());
						
						textId.setText(String.valueOf(u.getIdUsuario())); 
						
					} catch(Exception ex) {
						ex.getMessage();
					}
				}
			}

			@Override
			public void mousePressed(MouseEvent e) {
				// TODO Auto-generated method stub
				
			}

			@Override
			public void mouseReleased(MouseEvent e) {
				// TODO Auto-generated method stub
				
			}

			@Override
			public void mouseEntered(MouseEvent e) {
				// TODO Auto-generated method stub
				
			}

			@Override
			public void mouseExited(MouseEvent e) {
				// TODO Auto-generated method stub
				
			}
			
		});
		}
	
	public void listaP() {
		DefaultTableModel model = new DefaultTableModel(){
			/**
			 * 
			 */
			private static final long serialVersionUID = 1L;

			public boolean isCellEditable(int row, int column) {
				return false;
			}
		};
		
		Object[] columns = {"Documento", "Nombre", "Apellido", "Correo Electrónico", "Contraseña", "Rol"};
		model.setColumnIdentifiers(columns);
		Object [] fila = new Object[columns.length];
		
		try {
			String dato = "MiniproyectoEJB/Usuario_Bean!com.servicios.Usuario_BeanRemote";
			Usuario_BeanRemote us = (Usuario_BeanRemote) InitialContext.doLookup(dato);
			
			List<Usuario> usuarios = us.findAll();
			
			if(usuarios.size() != 0) {
				for(Usuario u : usuarios) {
					
					
					String d = u.getDocumento();
					String n = u.getNombre();
					String a = u.getApellido();
					String m = u.getMail();
					String c = u.getClave();
					String r = u.getRol().getNombre();
					
					fila[0] = d;
					fila[1] = n;
					fila[2] = a;
					
					fila[3] = m;
					fila[4] = c;
					
					fila[5] = r;
					
					model.addRow(fila); 
				}
			}
		} catch(Exception ex) {
			ex.getMessage();
		}
		
		table.setModel(model);
		
	
	}
	public void limpiar() {
		
		textId.setText("");
		textDocumento.setText("");
		textApellido.setText("");
		textNombre.setText("");
		textCorreo.setText("");
		password.setText("");
		
		lbl1.setText(" ");
		lbl1.setForeground(Color.RED);
		
		lbl2.setText(" ");
		lbl2.setForeground(Color.RED);
		
		lbl3.setText(" ");
		lbl3.setForeground(Color.RED);
		
		lbl4.setText(" ");
		lbl4.setForeground(Color.RED);
		
		lbl5.setText(" ");
		lbl5.setForeground(Color.RED);
		
		lbl6.setText(" ");
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
	public void Habilitar(boolean t) {
		if(t == true) {
			textDocumento.setEnabled(true);
			textNombre.setEnabled(true);
			textApellido.setEnabled(true);
			textCorreo.setEnabled(true);
			password.setEnabled(true);
			comboBoxRol.setEnabled(true);
			btnAceptar.setEnabled(true);

		}else {
			textDocumento.setEnabled(false);
			textNombre.setEnabled(false);
			textApellido.setEnabled(false);
			textCorreo.setEnabled(false);
			password.setEnabled(false);
			comboBoxRol.setEnabled(false);
			btnAceptar.setEnabled(false);
			btnEliminar.setEnabled(false);

		}
	}
public boolean existeUsuarioMail(String mail, long id) {
		
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
		else if(user.getIdUsuario() == id) {
			return false;
		}
		else {
			return true;
		}
	}
	public boolean existeUsuarioCedula(String cedula, long id) {
		
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
		else if(user.getIdUsuario() == id) {
			return false;
		}
		else {
			return true;
		}
	}
}
