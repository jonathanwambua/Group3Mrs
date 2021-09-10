package MainFrame;

import javax.swing.JFrame;
import javax.swing.JOptionPane;

public class errorbox {
	static JFrame f;
	
	public static void error(){
		f = new JFrame();
		JOptionPane.showMessageDialog(f, "  WARD CAPACITY IS FULL \n  Would you like to continue");
	}
	
	public static void main(String[] args) {
		errorbox.error();
	}

}
