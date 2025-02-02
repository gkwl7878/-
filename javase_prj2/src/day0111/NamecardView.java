package day0111;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.border.TitledBorder;
import javax.swing.table.DefaultTableModel;

@SuppressWarnings("serial")
public class NamecardView extends JFrame {
	
	private JButton jbtImg, jbtAdd;
	private DefaultTableModel dtmNamecard;
	private JLabel jlpreview;
	private JTextField jtfName,jtfAddr;
	
	
	public NamecardView() {
		super("명함관리");
		JLabel jlName= new JLabel("이름");
		JLabel jlAddr= new JLabel("주소");
		JLabel jlImg= new JLabel("이미지");
		
		jbtImg = new JButton("이미지선택");
		jbtAdd = new JButton("명함 추가");
		
		String[] columnName = {"번호","이미지","성명","주소"};
		Object[][] data = new Object[1][4];
		data[0][0]="";
		data[0][1]="";
		data[0][2]="";
		data[0][3]="";
		dtmNamecard = new DefaultTableModel(data,columnName) {
			@Override
			public boolean isCellEditable(int row, int column) {
				return false;
			}
		};
		
		jlpreview = new JLabel(new ImageIcon("C:/dev/workspace/javase_prj2/src/day0111/upload/no_image.png"));
		jtfName = new JTextField();
		jtfAddr = new JTextField();
		
		JTable jtaNamecardList = new JTable(dtmNamecard) {
			@Override
			public Class<?> getColumnClass(int column){
				return getValueAt(0,column).getClass();
			}
		};
		
		JScrollPane jsp = new JScrollPane(jtaNamecardList);
		jsp.setBorder(new TitledBorder("명함리스트"));
		jtaNamecardList.getColumnModel().getColumn(0).setPreferredWidth(40);
		jtaNamecardList.getColumnModel().getColumn(1).setPreferredWidth(170);
		jtaNamecardList.getColumnModel().getColumn(2).setPreferredWidth(120);
		jtaNamecardList.getColumnModel().getColumn(3).setPreferredWidth(260);
		jtaNamecardList.setRowHeight(200);
		
		jtaNamecardList.getTableHeader().setReorderingAllowed(false);
		
		setLayout(null);//수동배치
		
		jlName.setBounds(10,20,80,25);
		jtfName.setBounds(80,20,80,25);
		jlAddr.setBounds(10,50,80,25);
		jtfAddr.setBounds(80,50,120,25);
		jlImg.setBounds(10,80,80,25);
		jlpreview.setBounds(80, 80, 167, 199);
		
		jbtImg.setBounds(115,285,100,25);
		jbtAdd.setBounds(115,320,100,25);
		jsp.setBounds(260,20,600,300);
		
		add(jlAddr);
		add(jtfAddr);
		add(jlName);
		add(jtfName);
		add(jlImg);
		add(jlpreview);
		add(jbtImg);
		add(jbtAdd);
		add(jsp);
		
		//이벤트 등록
		NamecardViewController nvc = new NamecardViewController(this);
		addWindowListener(nvc);
		jbtAdd.addActionListener(nvc);
		jbtImg.addActionListener(nvc);
		
		
		setBounds(100,100,900,400);
		setVisible(true);
		setResizable(false);
		
	}//NamecardView
	
	
	public JButton getJbtImg() {
		return jbtImg;
	}


	public JButton getJbtAdd() {
		return jbtAdd;
	}


	public DefaultTableModel getDtmNamecard() {
		return dtmNamecard;
	}


	public JLabel getJlpreview() {
		return jlpreview;
	}


	public JTextField getJtfName() {
		return jtfName;
	}


	public JTextField getJtfAddr() {
		return jtfAddr;
	}


	public static void main(String[] args) {
		new NamecardView();
	}//main
	
}//class
