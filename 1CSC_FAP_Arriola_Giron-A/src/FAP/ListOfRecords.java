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
import java.time.LocalDate;
import java.util.*;
    
public class ListOfRecords implements ActionListener{
    
    AddRecord addRecord;
    RemoveRecord removeRecord;
    
    private JFrame frame;
    private JPanel panText, panButton, panSort, panRadioButton, panClickables;
    ButtonGroup buttgrpRadButt;
    
    private JTextArea taInfo;
    private JScrollPane scrl;
    private JButton buttAddRecord, buttRemRecord, buttExport;
    
    private JRadioButton radbuttAscend, radbuttDescend;
    JComboBox comboxSort;
    
    final String[] sortOptions = {"Name", "Birthday", "Age"};
    
    ArrayList<Person> names;
            
    
   public ListOfRecords() {
   
        frame = new JFrame("List of Records");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
        panText = new JPanel();
        panButton = new JPanel(); 
        panSort = new JPanel();
        panRadioButton = new JPanel();
        panClickables = new JPanel();
        
        
        taInfo = new JTextArea(20, 60);
	scrl = new JScrollPane(taInfo);
        
        scrl.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_ALWAYS);  
        scrl.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);  
        
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
        
        names = new ArrayList<Person>();
        
        
   } 
   
   public void launchFrame() {
        
        panText.setLayout(new GridLayout(1, 3));
        panSort.setLayout(new GridLayout(1, 2));
        panRadioButton.setLayout(new GridLayout(2, 1));
        panClickables.setLayout(new GridLayout(2, 1));
        
        panButton.add(buttAddRecord);
        panButton.add(buttRemRecord);
        panButton.add(buttExport);
        
        panRadioButton.add(radbuttAscend);
        panRadioButton.add(radbuttDescend);
        
        panSort.add(comboxSort);
        panSort.add(panRadioButton);
        
        panClickables.add(panSort);
        panClickables.add(panButton);
        
        panText.add(scrl, BorderLayout.CENTER);
        
        
        
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
        
        Object sauce = actionEvent.getSource();
        
        if (sauce == buttAddRecord) {
            addRecord = new AddRecord();
            addRecord.launchFrame();
            
            refresh();
            
        }
        
        if (sauce == buttRemRecord) {
            removeRecord = new RemoveRecord();
            removeRecord.launchFrame();
           
            ////for loop, creates a new array length-1 of names[] and copies all items not in index 0
            
            refresh();
            
        }
        
        if (sauce == buttExport) {
            
            export();
            
        }
        
    
    }
    
    protected void addRecord(String name, LocalDate birthday) {
        
        ////for loop, creates a new array length+1 of names[] and copies all items + the new person
        
    
    }
    
    protected void removeRecord(String name) {
        
        ////for loop, creates a new array length-1 of names[] and copies all items - the person removed
        
    
    }
    
    private void refresh() {
        
        ////for loop, inputs all Person name\n, birthday\n and ageCalculator() to respective JTextAreas, but first clears the text
                
    }
    
    private void export() {
    ////export to CSV
    
    
    }
    
    

}

class AddRecord implements ActionListener{

    ListOfRecords listOfRecords;
    
    private JFrame frame;
    private JPanel panName, panBirthday, panButton;
    private JLabel labName, labBirthday;
    private JTextField tfName;
    private JComboBox comboxMonth, comboxDay, comboxYear;
    private JButton buttSaveBack, buttSaveAnother, buttBack;
    
    private String name;
    
    private LocalDate birthday;
    
    final String[] mm = {"January", "February", "March", "April", "May", "June", "July", 
                   "August", "September", "October", "November", "December"};
    final String[] dd = {"1", "2", "3", "4", "5", "6", "7", "8", "9", "10", "11", "12", "13", "14", "15", "16", "17", "18", "19",
                "20", "21", "22", "23", "24", "25", "26", "27", "28", "29", "30", "31"};
    int[] yyyy;
            
    
    AddRecord() {
        
     ////For loop, sets yyyy into array of years, 1900 to current year;
    
     frame = new JFrame("Add Record");
        
     panName = new JPanel();
     panBirthday = new JPanel(); 
     panButton = new JPanel();
     
     labName = new JLabel("Name: ");
     labBirthday = new JLabel("Birthday");
     
     tfName = new JTextField(40);
     
     comboxMonth = new JComboBox();
     comboxDay = new JComboBox();
     comboxYear = new JComboBox();
     
     buttSaveBack = new JButton("Save and Go Back");
     buttSaveAnother = new JButton("Save and Add Another");
     buttBack = new JButton("Back");
       
    }
    
    void launchFrame() {
        
        frame.setLayout(new GridLayout(3,1));
        
        panName.setLayout(new GridLayout(1, 2));
        panBirthday.setLayout(new GridLayout(1, 4));
        panButton.setLayout(new GridLayout(1,3));
        
        panName.add(labName);
        panName.add(tfName);
        
        panBirthday.add(labBirthday);
        panBirthday.add(comboxMonth);
        panBirthday.add(comboxDay);
        panBirthday.add(comboxYear);
        
        panButton.add(buttSaveBack);
        panButton.add(buttSaveAnother);
        panButton.add(buttBack);
        
        frame.add(panName);
        frame.add(panBirthday);
        frame.add(panButton);
        
        frame.pack();
        frame.setVisible(true);
        
        buttSaveBack.addActionListener(this);
        buttSaveAnother.addActionListener(this);
        buttBack.addActionListener(this);
        
    }
    
    @Override
    public void actionPerformed(ActionEvent actionEvent) {
        Object sauce = actionEvent.getSource();
        
        if (sauce == buttSaveBack) {
        
            listOfRecords.addRecord(name, birthday);
            
            ////close
        
        }
        
        if (sauce == buttSaveAnother) {
            
            listOfRecords.addRecord(name, birthday);
            
        }
        
        if (sauce == buttBack) {
            
            ////close
        
        }
    
    }
    
}

class RemoveRecord implements ActionListener{

    ListOfRecords listOfRecords;
    
    private JFrame frame;
    private JPanel panName, panButton;
    private JLabel labName;
    private JTextField tfName;
    private JButton buttRemoveBack, buttRemoveAnother, buttBack;
    
    private String name;
            
    RemoveRecord() {
        
     ////For loop, sets yyyy into array of years, 1900 to current year;
    
     frame = new JFrame("Remove Record");
        
     panName = new JPanel();

     panButton = new JPanel();
     
     labName = new JLabel("Name: ");
     
     tfName = new JTextField(40);
     
     buttRemoveBack = new JButton("Remove and Go Back");
     buttRemoveAnother = new JButton("Save and Remove");
     buttBack = new JButton("Back");
       
    }
    
    void launchFrame() {
        
        frame.setLayout(new GridLayout(2,1));
        
        panName.setLayout(new GridLayout(1, 2));
        panButton.setLayout(new GridLayout(1,3));
        
        panName.add(labName);
        panName.add(tfName);
        
        panButton.add(buttRemoveBack);
        panButton.add(buttRemoveAnother);
        panButton.add(buttBack);
        
        frame.add(panName);
        frame.add(panButton);
        
        frame.pack();
        frame.setVisible(true);
        
        buttRemoveBack.addActionListener(this);
        buttRemoveAnother.addActionListener(this);
        buttBack.addActionListener(this);
        
    }
    
    @Override
    public void actionPerformed(ActionEvent actionEvent) {
        Object sauce = actionEvent.getSource();
        
        if (sauce == buttRemoveBack) {
        
            listOfRecords.removeRecord(name);
            
            ////close
        
        }
        
        if (sauce == buttRemoveAnother) {
            
            listOfRecords.removeRecord(name);
            
        }
        
        if (sauce == buttBack) {
            
            ////close
        
        }
    
    }
    
    
}

class Person {
    private String name;
    private LocalDate birthday;
    private int age;
    Person(String name, LocalDate birthday) {
        setName(name);
        setBirthday(birthday);
    }
    
    public void setName(String name) {
        this.name = name;
    }
    
    public String getName() {
        return(name);
    }
    
    
    public void setBirthday(LocalDate birthday) {
        this.birthday = birthday;
        
        //put here instead of constructor so that it runs every time the birthday is changed.
        ageCalculator(birthday);
    }
    
    public LocalDate getBirthday() {
    
        return(birthday);
    }
    
    private void ageCalculator(LocalDate birthday) {
        ////calculator code
        this.age = 0; //replace when code is done
    }
    
    
    
}
