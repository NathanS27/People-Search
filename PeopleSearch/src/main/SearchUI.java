package main;

import java.awt.Color;
import javax.swing.*;
import BreezySwing.*;

public class SearchUI extends GBFrame {

	JMenuItem popualte = addMenuItem("do","populate");
	
	JLabel nameLbl = addLabel("Name:",1,1,1,1);
	JTextField name = addTextField("",1,2,2,1);
	
	JLabel ageLbl = addLabel("Age:",2,1,1,1);
	IntegerField age = addIntegerField(0,2,2,2,1);
	
	JButton add = addButton("Add",3,1,2,1);
	
	JTextArea output = addTextArea("",1,4,2,2);
	
	JButton search = addButton("Search",3,3,1,1);
	JTextField searchInput = addTextField("",3,4,1,1);
	
	ArrayListV2 people;
	sort sort;
	
	public SearchUI() {
		output.setEditable(false);
		output.setBackground(new Color(101, 247, 160).brighter());
		people = new ArrayListV2();
		sort=new sort();
	}
	
	public void buttonClicked(JButton b) {
		if(b==add) {
			people.add(new Person(name.getName(),age.getNumber()));
		}
		if(b==search) {
			sort.sortNames(people);
			display();
		}
	}
	
	public void menuItemSelected(JMenuItem m) {
		people.add(new Person("Brad", 152));
		people.add(new Person("Alex", 12));
		people.add(new Person("Chad", 69));
		people.add(new Person("Zak", 16));
		display();
	}
	
	private void display() {
		String str="";
		str+=people.toString();
		output.setText(str);
	}
	
	public static void main(String[] args) {
		JFrame frm = new SearchUI();
		frm.setSize(500,300);
		frm.setTitle("People Search Program");
		frm.getContentPane().setBackground(new Color(101, 247, 160));
		frm.setResizable(true);
		frm.setVisible(true);
		frm.setLocationRelativeTo(null);
	}
}
