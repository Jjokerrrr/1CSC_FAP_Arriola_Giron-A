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
    
public class ListOfRecords implements ActionListener{
    
    private JFrame frame;
    private JPanel panText, panButton, panSort, panClickables;
    ButtonGroup buttgrpRadButt;
    
    private JTextArea taNames, taBirthdays, taAge;
    private JButton buttAddRecord, buttRemRecord, buttExport;
    
    private JRadioButton radbuttAscend, radbuttDescend;
    
    
        String[] sortOptions = {"Name", "Birthday", "Age"};
        JComboBox comboxSort;
            
    
   public ListOfRecords() {
   
   frame = new JFrame("List of Records");
        
        taNames = new JTextArea(20, 69);
        taBirthdays = new JTextArea(20, 69);
        taAge = new JTextArea(20, 69);
        
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
        
        
   } 
   
   public void launchFrame() {
        
       
        panSort.setLayout(new GridLayout(1, 3));
       //puts the buttons into the button panel.
        panButton.add(buttAddRecord);
        panButton.add(buttRemRecord);
        panButton.add(buttExport);
        
        panSort.add(comboxSort, "Left");
        panSort.add(radbuttAscend);
        panSort.add(radbuttDescend);
        
        panClickables.add(panSort, panButton);
        
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
    
    }

}
