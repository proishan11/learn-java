import javax.swing.*;
import java.awt.event.*;

public class evm extends JFrame implements ActionListener{
	private JFrame frame;
	private JButton submitButton, result;
	private JRadioButton java,python,cpp;
	private JLabel headerLabel, countLabel;
	int count_java=0, count_python=0, count_cpp, temp=0;

	evm(){
		frame = new JFrame();
		headerLabel = new JLabel("",JLabel.CENTER);
		countLabel = new JLabel("",JLabel.CENTER);
		headerLabel.setSize(500,100);
		countLabel.setSize(500,600);
		headerLabel.setText("Which programming language do you like the most");
		submitButton = new JButton("Submit");
		result = new JButton("Show Result");
		java = new JRadioButton("A) Java");
		python = new JRadioButton("B) Python");
		cpp = new JRadioButton("C) C++");
		printCount();
		
		java.setBounds(50,75,100,30);
		python.setBounds(150,75,100,30);
		cpp.setBounds(250,75,100,30);
		submitButton.setBounds(50,150,100,20);
		result.setBounds(200,150,150,20);

		submitButton.addActionListener(this);
		result.addActionListener(this);
		
		frame.add(headerLabel);
		frame.add(submitButton);
		frame.add(java);
		frame.add(python);
		frame.add(cpp);
		frame.add(result);
		frame.add(countLabel);
		
		ButtonGroup group = new ButtonGroup();
		group.add(java);
		group.add(python);
		group.add(cpp);
		
		frame.setSize(700,500);
		frame.setLayout(null);
		frame.setVisible(true);
	}

	public void actionPerformed(ActionEvent e){
		if(e.getSource() == submitButton) {
			if(java.isSelected()){
				temp = JOptionPane.showConfirmDialog(this, "Confirm Your vote");
				if(temp==0)
					count_java++;
				printCount();
			}

			if(python.isSelected()){
				temp = JOptionPane.showConfirmDialog(this, "Confirm Your vote");
				if(temp==0)
					count_python++;
				printCount();
			}

			if(cpp.isSelected()){
				temp = JOptionPane.showConfirmDialog(this, "Confirm Your vote");
				if(temp==0)
					count_cpp++;
				printCount();
			}
		}

		if(e.getSource() == result){
			if(count_java>count_cpp && count_java>count_python)
				JOptionPane.showMessageDialog(this, "Java");
			if(count_python>count_java && count_python>count_cpp)
				JOptionPane.showMessageDialog(this, "Python");
			if(count_cpp>count_python && count_cpp>count_java)
				JOptionPane.showMessageDialog(this, "Cpp");
			if(count_cpp==count_java && count_cpp>count_python)
				JOptionPane.showMessageDialog(this, "Cpp and Java");
			if(count_cpp==count_python && count_cpp>count_java)
				JOptionPane.showMessageDialog(this, "Cpp and Python");
			if(count_java==count_python && count_java>count_cpp)
				JOptionPane.showMessageDialog(this, "Java and Python");
			if(count_java==count_cpp && count_java==count_python)
				JOptionPane.showMessageDialog(this, "Java, Python and Cpp");
			}
	}

	public void printCount(){
		countLabel.setText("<html> Java - " + count_java + "<br><br>Cpp -  "+count_cpp+"<br><br>Python -   "+count_python);
	}

	public static void main(String[] args){
		new evm();
	}
}
