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

import com.entities.Funcionalidad;
import com.servicios.FuncionalidadBeanRemote;
import javax.swing.JTextField;
import javax.swing.JCheckBox;

public class ListadoFuncionalidades implements MouseListener{

	private JFrame frame;
	private JTextField textFuncionalidad;
	private JTextField textDescripcion;

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
		frame.setBounds(100, 100, 1002, 550);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JLabel lblListadoFuncionalidades = new JLabel("Listado de Funcionalidades");
		lblListadoFuncionalidades.setFont(new Font("Baskerville Old Face", Font.ITALIC, 27));
		lblListadoFuncionalidades.setBounds(10, 20, 373, 31);
		frame.getContentPane().add(lblListadoFuncionalidades);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(26, 71, 577, 419);
		frame.getContentPane().add(scrollPane);
		
		JTable table = new JTable();
		table.setSurrendersFocusOnKeystroke(true);
		table.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		scrollPane.setViewportView(table);
		
		DefaultTableModel model = new DefaultTableModel();
		
		Object[] columns = {"Nombre", "Descripcion"};
		
		model.setColumnIdentifiers(columns);
		
		Object [] fila = new Object[columns.length];
		table.setModel(model);
		
		JLabel lblFuncionalidad = new JLabel("Funcionalidad");
		lblFuncionalidad.setFont(new Font("Baskerville Old Face", Font.PLAIN, 16));
		lblFuncionalidad.setBounds(613, 103, 170, 25);
		frame.getContentPane().add(lblFuncionalidad);
		
		textFuncionalidad = new JTextField();
		textFuncionalidad.setColumns(10);
		textFuncionalidad.setBounds(613, 133, 352, 25);
		frame.getContentPane().add(textFuncionalidad);
		
		JLabel lblDescripcin = new JLabel("Descripci\u00F3n");
		lblDescripcin.setFont(new Font("Baskerville Old Face", Font.PLAIN, 16));
		lblDescripcin.setBounds(613, 168, 170, 25);
		frame.getContentPane().add(lblDescripcin);
		
		textDescripcion = new JTextField();
		textDescripcion.setColumns(10);
		textDescripcion.setBounds(613, 200, 352, 25);
		frame.getContentPane().add(textDescripcion);
		
		JCheckBox CheckAcceso = new JCheckBox("\u00BFTengo acceso?");
		CheckAcceso.setFont(new Font("Baskerville Old Face", Font.PLAIN, 16));
		CheckAcceso.setBounds(716, 264, 146, 31);
		frame.getContentPane().add(CheckAcceso);
		
		List<Funcionalidad> funcionalidades = new LinkedList<>();

		try {
			FuncionalidadBeanRemote funcionalidadBean = (FuncionalidadBeanRemote)
					InitialContext.doLookup("MiniproyectoEJB/FuncionalidadBean!com.servicios.FuncionalidadBeanRemote");
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