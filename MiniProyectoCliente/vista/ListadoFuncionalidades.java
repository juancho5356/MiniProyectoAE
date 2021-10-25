package Vista;

import java.awt.EventQueue;

import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.swing.JFrame;
import javax.swing.JLabel;

import java.awt.Font;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.LinkedList;
import java.util.List;
import java.awt.Color;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.ListSelectionModel;
import javax.swing.table.DefaultTableModel;

import com.exception.ServiciosException;
import com.servicios.Funcionalidad_BeanRemote;
import com.servicios.Rol_BeanRemote;
import com.servicios.Usuario_BeanRemote;

import com.entities.*;

import javax.swing.JTextField;
import java.awt.SystemColor;
import javax.swing.JTextArea;

public class ListadoFuncionalidades implements MouseListener{

	JFrame frame;
	private JTextField textFuncionalidad;
	private JLabel lblInformacin;
	private JScrollPane scrollPane_1;
	private JTextArea textDescripcion;
	private JTextField textRol;
	private JTextField textAcceso;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ListadoFuncionalidades window = new ListadoFuncionalidades();
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
	public ListadoFuncionalidades() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.getContentPane().setBackground(Color.WHITE);
		frame.setBounds(100, 100, 1160, 606);
		frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JLabel lblListadoFuncionalidades = new JLabel("Listado de Funcionalidades");
		lblListadoFuncionalidades.setFont(new Font("Baskerville Old Face", Font.ITALIC, 27));
		lblListadoFuncionalidades.setBounds(26, 30, 373, 31);
		frame.getContentPane().add(lblListadoFuncionalidades);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(26, 71, 634, 419);
		frame.getContentPane().add(scrollPane);
		
		JTable table = new JTable();
		table.setSurrendersFocusOnKeystroke(true);
		table.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		scrollPane.setViewportView(table);
		
		DefaultTableModel model = new DefaultTableModel(){
			/**
			 * 
			 */
			private static final long serialVersionUID = 1L;

			public boolean isCellEditable(int row, int column) {
				return false;
			}
		};
		
		Object[] columns = {"Nombre", "Descripcion"};
		
		model.setColumnIdentifiers(columns);
		
		Object [] fila = new Object[columns.length];
		table.setModel(model);
		
		JLabel lblFuncionalidad = new JLabel("Funcionalidad");
		lblFuncionalidad.setFont(new Font("Baskerville Old Face", Font.PLAIN, 16));
		lblFuncionalidad.setBounds(670, 125, 170, 25);
		frame.getContentPane().add(lblFuncionalidad);
		
		textFuncionalidad = new JTextField();
		textFuncionalidad.setEditable(false);
		textFuncionalidad.setColumns(10);
		textFuncionalidad.setBounds(670, 150, 466, 25);
		frame.getContentPane().add(textFuncionalidad);
		
		JLabel lblDescripcin = new JLabel("Descripci\u00F3n");
		lblDescripcin.setFont(new Font("Baskerville Old Face", Font.PLAIN, 16));
		lblDescripcin.setBounds(670, 196, 170, 25);
		frame.getContentPane().add(lblDescripcin);
		
		lblInformacin = new JLabel("Informaci\u00F3n");
		lblInformacin.setForeground(SystemColor.activeCaption);
		lblInformacin.setFont(new Font("Baskerville Old Face", Font.PLAIN, 27));
		lblInformacin.setBounds(670, 71, 373, 31);
		frame.getContentPane().add(lblInformacin);
		
		scrollPane_1 = new JScrollPane();
		scrollPane_1.setBounds(670, 220, 466, 104);
		frame.getContentPane().add(scrollPane_1);
		
		textDescripcion = new JTextArea();
		textDescripcion.setWrapStyleWord(true);
		textDescripcion.setLineWrap(true);
		textDescripcion.setEditable(false);
		scrollPane_1.setViewportView(textDescripcion);
		
		textRol = new JTextField();
		textRol.setForeground(new Color(70, 130, 180));
		textRol.setFont(new Font("Baskerville Old Face", Font.PLAIN, 16));
		textRol.setBackground(Color.WHITE);
		textRol.setBorder(null);
		textRol.setEditable(false);
		textRol.setColumns(10);
		textRol.setBounds(805, 430, 182, 25);
		frame.getContentPane().add(textRol);
		
				
		Usuario user = null;
		
		try {
			String dato = "MiniproyectoEJB/Usuario_Bean!com.servicios.Usuario_BeanRemote";
			Usuario_BeanRemote ad = (Usuario_BeanRemote) InitialContext.doLookup(dato);
			
			user = ad.findUser(LogIn.textCorreo.getText(), String.valueOf(LogIn.password.getPassword())); 
			
			if(user != null) {
				textRol.setText(user.getRol().getNombre());
			}
			
		} catch(NamingException | ServiciosException ex) {
			ex.getMessage();
		}
		
		JLabel lblUstedPoseeEl = new JLabel("Usted posee el rol:");
		lblUstedPoseeEl.setFont(new Font("Baskerville Old Face", Font.PLAIN, 16));
		lblUstedPoseeEl.setBounds(670, 430, 170, 25);
		frame.getContentPane().add(lblUstedPoseeEl);
		
		JLabel lblAccesoALa = new JLabel("Acceso a la funcionalidad");
		lblAccesoALa.setForeground(SystemColor.activeCaption);
		lblAccesoALa.setFont(new Font("Baskerville Old Face", Font.PLAIN, 25));
		lblAccesoALa.setBounds(670, 372, 373, 31);
		frame.getContentPane().add(lblAccesoALa);
		
		JLabel lblAccesoALa_1 = new JLabel("Acceso a la funcionalidad seleccionada :");
		lblAccesoALa_1.setFont(new Font("Baskerville Old Face", Font.PLAIN, 16));
		lblAccesoALa_1.setBounds(670, 465, 260, 25);
		frame.getContentPane().add(lblAccesoALa_1);
		
		textAcceso = new JTextField();
		textAcceso.setFont(new Font("Baskerville Old Face", Font.PLAIN, 16));
		textAcceso.setEditable(false);
		textAcceso.setColumns(10);
		textAcceso.setBorder(null);
		textAcceso.setBackground(Color.WHITE);
		textAcceso.setBounds(940, 465, 182, 25);
		frame.getContentPane().add(textAcceso);
		
		List<Funcionalidad> funcionalidades = new LinkedList<>();

		try {
			Funcionalidad_BeanRemote funcionalidadBean = (Funcionalidad_BeanRemote)
					InitialContext.doLookup("MiniproyectoEJB/Funcionalidad_Bean!com.servicios.Funcionalidad_BeanRemote");
			
			funcionalidades = funcionalidadBean.mostrarTodos();

		} catch (NamingException e3) {
			e3.printStackTrace();
		}
		
		for(Funcionalidad f: funcionalidades) {
			fila[0] = f.getNombre();
			fila[1] = f.getDescripcion();
			model.addRow(fila);
		}
		
		table.addMouseListener(new MouseListener() {
			public void mouseClicked(MouseEvent e) {
				int filaSeleccionada;
				
				filaSeleccionada = table.getSelectedRow();
				
				if(filaSeleccionada == -1) {
					limpiar();
				}else {
					textFuncionalidad.setText(table.getValueAt(filaSeleccionada, 0).toString());
					textDescripcion.setText(table.getValueAt(filaSeleccionada, 1).toString());
					
					String rol = textRol.getText();
					String funcion = table.getValueAt(filaSeleccionada, 0).toString();
					
					Rol r = null;
					
					try {
						String dato = "MiniproyectoEJB/Rol_Bean!com.servicios.Rol_BeanRemote";
						Rol_BeanRemote ro = (Rol_BeanRemote) InitialContext.doLookup(dato);
							
						r = ro.findAcceso(rol, funcion);
						
						
						if(r != null) {
							textAcceso.setText("Verdadero");
							textAcceso.setForeground(new Color(95, 158, 160));
							
						}else {
							textAcceso.setText("Falso");
							textAcceso.setForeground(Color.RED);
						}
						
						
					}catch(NamingException | ServiciosException ex) {
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
		
		public void limpiar() {
			textFuncionalidad.setText("");
			textDescripcion.setText("");
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


	@Override
	public void mouseClicked(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}
}
