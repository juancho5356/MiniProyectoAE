package Vista;

import java.awt.EventQueue;

import javax.swing.JFrame;
import java.awt.Color;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.ListSelectionModel;
import javax.swing.table.DefaultTableModel;
import com.entities.*;
import com.exception.ServiciosException;
import com.servicios.FuncionalidadBeanRemote;
import com.servicios.UsuarioBeanRemote;

import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.swing.JButton;
import javax.swing.JComboBox;
import java.awt.SystemColor;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.LinkedList;
import java.util.List;

public class ListadoUsuarios {

	private JFrame frame;
	private JTextField textNombre;
	private JTextField textApellido;
	private JTextField textDocumento;
	private JTable table;

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
		frame.getContentPane().setBackground(Color.WHITE);
		frame.getContentPane().setLayout(null);
		
		JLabel lblListadoDeUsuarios = new JLabel("Listado de Usuarios");
		lblListadoDeUsuarios.setFont(new Font("Baskerville Old Face", Font.ITALIC, 27));
		lblListadoDeUsuarios.setBounds(20, 10, 373, 31);
		frame.getContentPane().add(lblListadoDeUsuarios);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(20, 72, 697, 436);
		frame.getContentPane().add(scrollPane);
		
		table = new JTable();
		table.setSurrendersFocusOnKeystroke(true);
		table.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		scrollPane.setViewportView(table);
		
		listarTodo();
		
		JLabel lblNombre = new JLabel("Nombre");
		lblNombre.setFont(new Font("Baskerville Old Face", Font.PLAIN, 16));
		lblNombre.setBounds(741, 112, 170, 25);
		frame.getContentPane().add(lblNombre);
		
		textNombre = new JTextField();
		textNombre.setColumns(10);
		textNombre.setBounds(855, 112, 204, 25);
		frame.getContentPane().add(textNombre);
		
		JLabel lblApellido = new JLabel("Apellido");
		lblApellido.setFont(new Font("Baskerville Old Face", Font.PLAIN, 16));
		lblApellido.setBounds(741, 165, 170, 25);
		frame.getContentPane().add(lblApellido);
		
		textApellido = new JTextField();
		textApellido.setColumns(10);
		textApellido.setBounds(855, 165, 204, 25);
		frame.getContentPane().add(textApellido);
		
		JLabel lblRolDeUsuario = new JLabel("Rol de Usuario");
		lblRolDeUsuario.setFont(new Font("Baskerville Old Face", Font.PLAIN, 16));
		lblRolDeUsuario.setBounds(741, 276, 170, 25);
		frame.getContentPane().add(lblRolDeUsuario);
		
		JComboBox<Object> comboBoxRol = new JComboBox<Object>();
		comboBoxRol.setFont(new Font("Baskerville Old Face", Font.PLAIN, 14));
		comboBoxRol.setBackground(SystemColor.menu);
		comboBoxRol.setBounds(855, 276, 204, 25);
		comboBoxRol.addItem("");
		comboBoxRol.addItem("Administrador");
		comboBoxRol.addItem("Investigador");
		comboBoxRol.addItem("Aficionado");
		frame.getContentPane().add(comboBoxRol);
		
		JLabel lblDocumento = new JLabel("Documento");
		lblDocumento.setFont(new Font("Baskerville Old Face", Font.PLAIN, 16));
		lblDocumento.setBounds(741, 221, 170, 25);
		frame.getContentPane().add(lblDocumento);
		
		textDocumento = new JTextField();
		textDocumento.setColumns(10);
		textDocumento.setBounds(855, 221, 204, 25);
		frame.getContentPane().add(textDocumento);
		
		JButton btnActualizarUsuario = new JButton("Actualizar Usuario");
		btnActualizarUsuario.setFont(new Font("Tahoma", Font.PLAIN, 14));
		btnActualizarUsuario.setEnabled(true);
		btnActualizarUsuario.setBackground(new Color(173, 216, 230));
		btnActualizarUsuario.setBounds(741, 392, 318, 31);
		frame.getContentPane().add(btnActualizarUsuario);
		
		JButton btnEliminarUsuario = new JButton("Eliminar Usuario");
		btnEliminarUsuario.setFont(new Font("Tahoma", Font.PLAIN, 14));
		btnEliminarUsuario.setBackground(SystemColor.menu);
		btnEliminarUsuario.setBounds(741, 435, 318, 31);
		frame.getContentPane().add(btnEliminarUsuario);
		
		JLabel lblModificaciDeUsuarios = new JLabel("Modificaci\u00F3n de Usuarios");
		lblModificaciDeUsuarios.setFont(new Font("Baskerville Old Face", Font.ITALIC, 27));
		lblModificaciDeUsuarios.setBounds(754, 10, 373, 31);
		frame.getContentPane().add(lblModificaciDeUsuarios);
		frame.setBounds(100, 100, 1083, 555);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		table.addMouseListener(new MouseListener() {
			public void mouseClicked(MouseEvent e) {
				int filaSeleccionada;
				
				filaSeleccionada = table.getSelectedRow();
				
				if(filaSeleccionada == -1) {
					limpiar();
				}else {
					textNombre.setText(table.getValueAt(filaSeleccionada, 0).toString());
					textApellido.setText(table.getValueAt(filaSeleccionada, 1).toString());
					textDocumento.setText(table.getValueAt(filaSeleccionada, 3).toString());
					
					String tipoUsuario = table.getValueAt(filaSeleccionada, 4).toString();

					if(tipoUsuario.equals("ADMINISTRADOR")) {
						comboBoxRol.setSelectedItem("Administrador");
					}
					if(tipoUsuario.equals("INVESTIGADOR")) {
						comboBoxRol.setSelectedItem("Investigador");
					}
					if(tipoUsuario.equals("AFICIONADO")) {
						comboBoxRol.setSelectedItem("Aficionado");
					}
				}
			}

			@Override
			public void mousePressed(MouseEvent e) {
			}

			@Override
			public void mouseReleased(MouseEvent e) {
			}

			@Override
			public void mouseEntered(MouseEvent e) {
			}

			@Override
			public void mouseExited(MouseEvent e) {
			}
	});
		
		btnActualizarUsuario.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				Usuario u = new Usuario();
				u.setNombre(textNombre.getText());
				u.setApellido(textApellido.getText());
				u.setDocumento(textDocumento.getText());
				
				Rol r = new Rol();
				r.setNombre(comboBoxRol.getSelectedItem().toString());
				
				u.setRol(r);
				
				
				try {
					UsuarioBeanRemote usuarioBean = (UsuarioBeanRemote)
							InitialContext.doLookup("MiniproyectoEJB/UsuarioBean!com.servicios.UsuarioBeanRemote");

						usuarioBean.actualizar(u);
						listarTodo();
						limpiar();
						JOptionPane.showMessageDialog(null, "Usuario modificado exitosamente");

				} catch (NamingException | ServiciosException e3) {
					JOptionPane.showMessageDialog(null, "No se ha podido modificar el usuario");;
				}
			}
			
		});
		
		btnEliminarUsuario.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				try {
					UsuarioBeanRemote usuarioBean = (UsuarioBeanRemote)
							InitialContext.doLookup("MiniproyectoEJB/UsuarioBean!com.servicios.UsuarioBeanRemote");

					String docST = textDocumento.getText();
					Long doc = Long.parseLong(docST);
					int confirmacion = JOptionPane.showConfirmDialog(null, "¿Desea eliminar definitivamente este usuario", "Confirmar", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);
					if(confirmacion == JOptionPane.YES_OPTION) {
						usuarioBean.borrar(doc);
						listarTodo();
						limpiar();
						JOptionPane.showMessageDialog(null, "Usuario eliminado exitosamente");
					}

				} catch (NamingException | ServiciosException e3) {
					JOptionPane.showMessageDialog(null, "No se ha podido eliminar el usuario");;
				}
			}
			
		});
		
	}
	
	public void limpiar() {
		textNombre.setText("");
		textApellido.setText("");
		textDocumento.setText("");
	}
	
	public void listarTodo(){
		
		DefaultTableModel model = new DefaultTableModel();
		Object[] columns = {"Nombre", "Apellido", "E-mail", "Documento", "Rol de Usuario"};
		
		model.setColumnIdentifiers(columns);
		
		Object [] fila = new Object[columns.length];
		table.setModel(model);
		
		List<Usuario> usuarios = new LinkedList<>();
		
		try {
			UsuarioBeanRemote usuarioBean = (UsuarioBeanRemote)
					InitialContext.doLookup("MiniproyectoEJB/UsuarioBean!com.servicios.UsuarioBeanRemote");
			usuarios = usuarioBean.mostrarTodos();

		} catch (NamingException e3) {
			e3.printStackTrace();
		}
		
		for (Usuario u: usuarios){
			
			String n = u.getNombre();
			String a = u.getApellido();
			String m = u.getMail();
			String d = u.getDocumento();
			String r = u.getRol().getNombre();
			
			fila[0] = n;
			fila[1] = a;
			fila[2] = m;
			fila[3] = d;
			fila[4] = r;
			model.addRow(fila); 
		}
	}
}
