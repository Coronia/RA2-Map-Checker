import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.filechooser.FileNameExtensionFilter;

import java.awt.Font;
import java.awt.datatransfer.DataFlavor;
import java.awt.datatransfer.UnsupportedFlavorException;
import java.awt.dnd.DnDConstants;
import java.awt.dnd.DropTarget;
import java.awt.dnd.DropTargetDragEvent;
import java.awt.dnd.DropTargetDropEvent;
import java.awt.dnd.DropTargetEvent;
import java.awt.dnd.DropTargetListener;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.List;
import java.util.Iterator;
import java.util.Scanner;

import javax.swing.SwingConstants;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JFileChooser;

public class MainGui extends JFrame implements ActionListener {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private MyPanal contentPane;
	private JLabel lblTitle, lblSelectMap, lblSeparate, lblHint1, lblFunction;
	private JTextField txtMapFile;
	private JButton btnChooseMap, btnCheckAll, btnCheckError, btnCheckTrigger, btnCheckTag, btnCheckWP, btnCheckTeam, btnCheckTask, btnCheckScript;
	private JButton btnRecruitable, btnRepair, btnSetAlly, btnSearchWP, btnSortIndex, btnRemoveEnable, btnStandard, btnActionCopy, btnSave;
	private JFileChooser jfc = new JFileChooser(new File("."));
	
	private MapChecker mc;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					MainGui frame = new MainGui();
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
	public MainGui() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 640, 480);
		contentPane = new MyPanal();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		lblTitle = new JLabel("RA2 Map Checker");
		lblTitle.setHorizontalAlignment(SwingConstants.CENTER);
		lblTitle.setFont(new Font("Arial", Font.BOLD, 18));
		lblTitle.setBounds(20, 20, 600, 30);		
		
		lblSelectMap = new JLabel("Select or drag map file");
		lblSelectMap.setFont(new Font("Arial", Font.PLAIN, 18));
		lblSelectMap.setBounds(20, 60, 180, 18);
		
		lblSeparate = new JLabel("Separate check");
		lblSeparate.setFont(new Font("Arial", Font.PLAIN, 18));
		lblSeparate.setBounds(20, 150, 180, 18);
		
		lblHint1 = new JLabel("NOTE: You should check team types before taskforces and scripts.");
		lblHint1.setFont(new Font("Arial", Font.PLAIN, 18));
		lblHint1.setBounds(20, 230, 600, 18);
		
		lblFunction = new JLabel("Operations");
		lblFunction.setFont(new Font("Arial", Font.PLAIN, 18));
		lblFunction.setBounds(20, 270, 180, 18);
		
		txtMapFile = new JTextField();
		txtMapFile.setBounds(20, 80, 420, 24);
		txtMapFile.setColumns(10);
		txtMapFile.setEditable(false);
		
		btnChooseMap = new JButton("Choose map");
		btnChooseMap.setFont(new Font("Arial", Font.PLAIN, 18));
		btnChooseMap.setBounds(450, 78, 150, 27);
		btnChooseMap.addActionListener(this);
		
		btnCheckAll = new JButton("Check all");
		btnCheckAll.setFont(new Font("Arial", Font.PLAIN, 18));
		btnCheckAll.setBounds(20, 108, 150, 27);
		btnCheckAll.addActionListener(this);
		
		btnCheckError = new JButton("Check error");
		btnCheckError.setFont(new Font("Arial", Font.PLAIN, 18));
		btnCheckError.setBounds(235, 108, 150, 27);
		btnCheckError.addActionListener(this);
		
		btnCheckTrigger = new JButton("Triggers");
		btnCheckTrigger.setFont(new Font("Arial", Font.PLAIN, 18));
		btnCheckTrigger.setBounds(20, 168, 150, 27);
		btnCheckTrigger.addActionListener(this);
		
		btnCheckTag = new JButton("Tags");
		btnCheckTag.setFont(new Font("Arial", Font.PLAIN, 18));
		btnCheckTag.setBounds(235, 168, 150, 27);
		btnCheckTag.addActionListener(this);
		
		btnCheckWP = new JButton("Waypoints");
		btnCheckWP.setFont(new Font("Arial", Font.PLAIN, 18));
		btnCheckWP.setBounds(450, 168, 150, 27);
		btnCheckWP.addActionListener(this);
		
		btnCheckTeam = new JButton("Teamtypes");
		btnCheckTeam.setFont(new Font("Arial", Font.PLAIN, 18));
		btnCheckTeam.setBounds(20, 198, 150, 27);
		btnCheckTeam.addActionListener(this);
		
		btnCheckTask = new JButton("Taskforces");
		btnCheckTask.setFont(new Font("Arial", Font.PLAIN, 18));
		btnCheckTask.setBounds(235, 198, 150, 27);
		btnCheckTask.addActionListener(this);
		
		btnCheckScript = new JButton("Scripts");
		btnCheckScript.setFont(new Font("Arial", Font.PLAIN, 18));
		btnCheckScript.setBounds(450, 198, 150, 27);
		btnCheckScript.addActionListener(this);
		
		btnRecruitable = new JButton("Set recruitable");
		btnRecruitable.setFont(new Font("Arial", Font.PLAIN, 18));
		btnRecruitable.setBounds(20, 288, 150, 27);
		btnRecruitable.addActionListener(this);
		
		btnRepair = new JButton("AI Repair");
		btnRepair.setFont(new Font("Arial", Font.PLAIN, 18));
		btnRepair.setBounds(235, 288, 150, 27);
		btnRepair.addActionListener(this);
		
		btnSetAlly = new JButton("Ally setting");
		btnSetAlly.setFont(new Font("Arial", Font.PLAIN, 18));
		btnSetAlly.setBounds(450, 288, 150, 27);
		btnSetAlly.addActionListener(this);
		
		btnSearchWP = new JButton("Waypoint use");
		btnSearchWP.setFont(new Font("Arial", Font.PLAIN, 18));
		btnSearchWP.setBounds(20, 318, 150, 27);
		btnSearchWP.addActionListener(this);
		
		btnSortIndex = new JButton("Sort Indices");
		btnSortIndex.setFont(new Font("Arial", Font.PLAIN, 18));
		btnSortIndex.setBounds(235, 318, 150, 27);
		btnSortIndex.addActionListener(this);
		
		btnRemoveEnable = new JButton("No AIEnable");
		btnRemoveEnable.setFont(new Font("Arial", Font.PLAIN, 18));
		btnRemoveEnable.setBounds(450, 318, 150, 27);
		btnRemoveEnable.addActionListener(this);
		
		btnStandard = new JButton("Custom house");
		btnStandard.setFont(new Font("Arial", Font.PLAIN, 18));
		btnStandard.setBounds(20, 348, 150, 27);
		btnStandard.addActionListener(this);
		
		btnActionCopy = new JButton("Create test map with trigger name");
		btnActionCopy.setFont(new Font("Arial", Font.PLAIN, 18));
		btnActionCopy.setBounds(235, 348, 365, 27);
		btnActionCopy.addActionListener(this);
		
		btnSave = new JButton("Save change");
		btnSave.setFont(new Font("Arial", Font.PLAIN, 18));
		btnSave.setBounds(20, 398, 150, 27);
		btnSave.addActionListener(this);
		
		FileNameExtensionFilter filter = new FileNameExtensionFilter("Allowed File", "map", "yrm", "mpr");
		jfc.setFileFilter(filter);
		
		contentPane.add(lblTitle);
		contentPane.add(lblSelectMap);
		contentPane.add(lblSeparate);
		contentPane.add(lblHint1);
		contentPane.add(lblFunction);
		contentPane.add(txtMapFile);
		contentPane.add(btnChooseMap);
		contentPane.add(btnCheckAll);
		contentPane.add(btnCheckError);
		contentPane.add(btnCheckTrigger);
		contentPane.add(btnCheckTag);
		contentPane.add(btnCheckWP);
		contentPane.add(btnCheckTeam);
		contentPane.add(btnCheckTask);
		contentPane.add(btnCheckScript);
		contentPane.add(btnRecruitable);
		contentPane.add(btnRepair);
		contentPane.add(btnSetAlly);
		contentPane.add(btnSearchWP);
		contentPane.add(btnSortIndex);
		contentPane.add(btnRemoveEnable);
		contentPane.add(btnStandard);
		contentPane.add(btnActionCopy);
		contentPane.add(btnSave);
	}
	
	@Override
    public void actionPerformed(ActionEvent e) {
		JButton button = (JButton) e.getSource();
		if (button == btnChooseMap) {
			int status = jfc.showOpenDialog(this);
			if (status == JFileChooser.APPROVE_OPTION) {
            	String mapCode = "";
            	try {
            		jfc.showDialog(new JLabel(), "Choose map"); 
            		File file = jfc.getSelectedFile();
            		txtMapFile.setText(file.getAbsolutePath());
                    Scanner scanner = new Scanner(file);
                    while (scanner.hasNextLine()) {
                    	mapCode += scanner.nextLine()  + "\r\n";
                    }
                    mc.setString(mapCode);
            	} catch (FileNotFoundException e1) {
            		JOptionPane.showMessageDialog(null, "No such file!", "", JOptionPane.INFORMATION_MESSAGE);
            		e1.printStackTrace();
            	}
            }
		}
		else if (button == btnCheckAll) {
			//TODO: Check all
		}
	}
	
	class MyPanal extends JPanel implements DropTargetListener {
        /**
		 * 
		 */
		private static final long serialVersionUID = 1L;

		public MyPanal() {
            new DropTarget(this, DnDConstants.ACTION_COPY_OR_MOVE, this);
        }
        
        public void dragEnter(DropTargetDragEvent dtde) {}
        public void dragOver(DropTargetDragEvent dtde) {}
        public void dropActionChanged(DropTargetDragEvent dtde) {}
        public void dragExit(DropTargetEvent dte) {}
        
        public void drop(DropTargetDropEvent dtde) {
            try {
                if (dtde.isDataFlavorSupported(DataFlavor.javaFileListFlavor)) {
                    dtde.acceptDrop(DnDConstants.ACTION_COPY_OR_MOVE);
                    List<File> list = (List<File>) (dtde.getTransferable().getTransferData(DataFlavor.javaFileListFlavor));
                    Iterator<File> iterator = list.iterator();
                    boolean mapLoaded = false;
                    while (iterator.hasNext()) {
                        File file = (File) iterator.next();
                        if (!mapLoaded && (file.getName().contains(".map") || file.getName().contains(".yrm")
                        		|| file.getName().contains(".mpr"))) {
                        	txtMapFile.setText(file.getAbsolutePath());
                            String mapCode = "";
                            Scanner scanner = new Scanner(file);
                            while (scanner.hasNextLine()) {
                            	mapCode += scanner.nextLine()  + "\r\n";
                            }
                            mc.setString(mapCode);
                            mapLoaded = true;
                        }
                    }
                    if (!mapLoaded) {
                    	JOptionPane.showMessageDialog(null, "Failed to load map file!", "", JOptionPane.INFORMATION_MESSAGE);
                    }
                    dtde.dropComplete(true);
                    this.updateUI();
                } else {
                    dtde.rejectDrop();
                }
            } catch (IOException ioe) {
                ioe.printStackTrace();
            } catch (UnsupportedFlavorException ufe) {
                ufe.printStackTrace();
            }
        }
    }
}