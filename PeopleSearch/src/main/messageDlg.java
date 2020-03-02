package main;

import java.awt.Color;
import javax.swing.*;
import BreezySwing.*;

//this class allows me to have a pop up  message box that centers itself

public class messageDlg extends GBDialog {
	
	JLabel display = addLabel("",1,1,1,1);
	JButton close = addButton("CLOSE",3,1,1,1);
	
	JLabel nameLbl = addLabel("Name:",1,1,1,1);
	JTextField name = addTextField("",1,2,1,1);
	JLabel count = addLabel("",1,3,1,1);
	
	JLabel ageLbl = addLabel("Age:",2,1,1,1);
	IntegerField age = addIntegerField(0,2,2,2,1);
	
	JButton add = addButton("Update",3,2,1,1);
	JButton delete = addButton("Delete",3,3,2,1);
	
	PeopleList list;
	Person p;
	
	public messageDlg(JFrame parent,String message,int comparisons) {
		super(parent);
		nameLbl.setVisible(false);
		name.setVisible(false);
		count.setVisible(false);
		ageLbl.setVisible(false); 
		age.setVisible(false);
		add.setVisible(false);
		delete.setVisible(false);
		setTitle("ERROR");
		getContentPane().setBackground(Color.RED.brighter().brighter());
		setDlgCloseIndicator("Close");
		setSize(400, 100);
		setLocationRelativeTo(null);
		display.setText(String.format("<html><font color='white'>%s | Comparisons:%d</font></html>", message,comparisons));
	}
	
	public messageDlg(JFrame parent,String title,Person iP,PeopleList Alist) {
		super(parent);
		display.setVisible(false);
		name.setText(iP.getName());
		age.setNumber(iP.getAge());
		count.setText(String.format("Comparisons : %d", Alist.getComparisons()));
		p=iP;
		list=Alist;
		setTitle(title);
		setDlgCloseIndicator("Close");
		setSize(400, 100);
		setLocationRelativeTo(null);
	}
	
	public void buttonClicked(JButton buttonObj) {
		if(buttonObj==close) {
			dispose();
		}
		if(buttonObj==add) {
			p.setName(name.getText());
			p.setAge(age.getNumber());
			dispose();
		}
		if(buttonObj==delete) {
			list.delete(p.getLoc());
			dispose();
		}
	}
}
