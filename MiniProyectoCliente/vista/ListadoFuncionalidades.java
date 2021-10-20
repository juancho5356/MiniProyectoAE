package Vista;

import java.awt.EventQueue;

import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.swing.JFrame;
import javax.swing.JLabel;
import java.awt.Font;
import java.util.LinkedList;
import java.util.List;
import java.awt.Color;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.ListSelectionModel;
import javax.swing.table.DefaultTableModel;

import com.entities.Funcionalidad;
import com.servicios.FuncionalidadBeanRemote;

public class ListadoFuncionalidades {

	private JFrame frame;

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
		
		JLabel lblListadoDeRoles = new JLabel("Listado de Funcionalidades");
		lblListadoDeRoles.setFont(new Font("Baskerville Old Face", Font.ITALIC, 27));
		lblListadoDeRoles.setBounds(10, 20, 373, 31);
		frame.getContentPane().add(lblListadoDeRoles);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(26, 71, 765, 367);
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
		
		List<Funcionalidad> funcionalidades = new LinkedList<>();
		
		//FuncionalidadBeanRemote funcionalidadBean = null;
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
	}
}
