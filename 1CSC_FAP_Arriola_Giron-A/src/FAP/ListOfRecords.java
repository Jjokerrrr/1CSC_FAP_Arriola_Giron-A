/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package FAP;

import javax.swing.*;
import java.awt.event.*;
import java.awt.*;
import java.io.*;
import java.util.*;
    
public class ListOfRecords implements ActionListener{
    
    AddRecord addRecord;
    RemoveRecord removeRecord;
    
    private JFrame frame;
    private JPanel panText, panButton, panSort, panClickables;
    ButtonGroup buttgrpRadButt;
    
    private JTextArea taNames, taBirthdays, taAge;
    private JButton buttAddRecord, buttRemRecord, buttExport;
    
    private JRadioButton radbuttAscend, radbuttDescend;
    JComboBox comboxSort;
    
    String[] sortOptions = {"Name", "Birthday", "Age"};
    
    Person[] names;
            
    
   public ListOfRecords() {
   
        frame = new JFrame("List of Records");
        
        panText = new JPanel();
        panButton = new JPanel(); 
        panSort = new JPanel();
        panClickables = new JPanel();;
        
        
        taNames = new JTextArea(20, 20);
        taBirthdays = new JTextArea(20, 20);
        taAge = new JTextArea(20, 20);
        
        buttAddRecord = new JButton("Add a record");
        buttRemRecord = new JButton("Remove a record");
        buttExport = new JButton("Export to CSV file");
        
        buttgrpRadButt = new ButtonGroup();
        radbuttAscend = new JRadioButton("Ascending");
        radbuttDescend = new JRadioButton("Descending");
        
        buttgrpRadButt.add(radbuttAscend);
        buttgrpRadButt.add(radbuttDescend);
        
        comboxSort = new JComboBox(sortOptions);
        comboxSort.setSelectedIndex(0);
        
        names = new Person[0];
        
        
   } 
   
   public void launchFrame() {
        
        panText.setLayout(new GridLayout(1, 3));
        panSort.setLayout(new GridLayout(1, 3));
        panClickables.setLayout(new GridLayout(2, 1));
        
        panButton.add(buttAddRecord);
        panButton.add(buttRemRecord);
        panButton.add(buttExport);
        
        panSort.add(comboxSort, "Left");
        panSort.add(radbuttAscend);
        panSort.add(radbuttDescend);
        
        panClickables.add(panSort);
        panClickables.add(panButton);
        
        panText.add(taNames);
        panText.add(taBirthdays);
        panText.add(taAge);
        
        
       //adds the text area and button panel to the window.
        frame.add(panText, "Center");
        
        frame.add(panClickables, "South");
       
       //sizes the window correctly and makes it visible.
        frame.pack();
        frame.setVisible(true);
        
       //connects to actionPerformed to make the buttons interactable.
        buttAddRecord.addActionListener(this);
        buttRemRecord.addActionListener(this);
        buttExport.addActionListener(this);

    }
   
    @Override
    public void actionPerformed(ActionEvent actionEvent) {
        
        Object source = actionEvent.getSource();
        
        if (source == buttAddRecord) {
            addRecord = new AddRecord();
            
            //for loop, creates a new array length+1 of names[] and copies all items + the new person
            
            refresh();
            
        }
        
        if (source == buttRemRecord) {
            removeRecord = new RemoveRecord();
            
           
            //for loop, creates a new array length-1 of names[] and copies all items not in index 0
            
            refresh();
            
        }
        
        if (source == buttExport) {
            
            export();
            
        }
        
    
    }
    
    private void refresh() {
        
        //for loop, inputs all Person name\n, birthday\n and ageCalculator() to respective JTextAreas, but first clears the text
                
    }
    
    private void export() {
    //exports to CSV
    
    
    }
    
    private void ageCalculator(int birth_date, int birth_month, int birth_year) {
    
        
    
    }

}

class AddRecord implements ActionListener{

    AddRecord() {
    
    
    }
    
    void launchFrame() {
    
    }
    
    @Override
    public void actionPerformed(ActionEvent actionEvent) {
    
    }
    
}

class RemoveRecord implements ActionListener{

    RemoveRecord() {
    
    
    }
    
    void launchFrame() {
    
    }
    
    @Override
    public void actionPerformed(ActionEvent actionEvent) {
    
    }
    
}

class Person {

    Person(String name, Date birthday) {
    
    
    }
    
}
