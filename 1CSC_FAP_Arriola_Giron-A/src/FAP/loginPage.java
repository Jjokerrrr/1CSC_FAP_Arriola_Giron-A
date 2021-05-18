/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package FAP;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.io.*;
import java.util.*;
/**
 *
 * @author Andoy
 */
public class loginPage implements ActionListener{
    private JFrame loginPage;
    private JLabel username, password;
    private JTextField userIn;
    private JPasswordField passIn;
    private JButton login;
    private JPanel mainPanel, compPanel, lblPanel, txtPanel, buttonPanel;
    private boolean isAuthenticated = false;
    private HashMap <String, String> credMap = new HashMap <>();
    private int attempt = 1;
    
    public loginPage(){
        loginPage = new JFrame ("Login Screen");
        loginPage.setSize(250,120);
        loginPage.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
        mainPanel = new JPanel();
        compPanel = new JPanel();
        lblPanel = new JPanel();
        txtPanel = new JPanel();
        buttonPanel = new JPanel();
        
        username = new JLabel ("Username: ");
        password = new JLabel ("Password: ");
        
        userIn = new JTextField(13);
        passIn = new JPasswordField(13);
        
        login = new JButton("Login");
    }
     
    public void launchLogin ()
        {
            lblPanel.setLayout (new GridLayout (2,1));
            lblPanel.add(username);
            lblPanel.add(password);
            
            txtPanel.setLayout (new GridLayout (2,1));
            txtPanel.add(userIn);
            txtPanel.add(passIn);
            
            compPanel.add(lblPanel);
            compPanel.add(txtPanel);
            
            buttonPanel.add(login);
            
            mainPanel.setLayout(new BorderLayout());
            mainPanel.add(buttonPanel, BorderLayout.CENTER);
            
            loginPage.add(compPanel, BorderLayout.CENTER);
            loginPage.add(mainPanel, BorderLayout.SOUTH);
            loginPage.setLocationRelativeTo(null);
            loginPage.setVisible(true);
            login.addActionListener(this);
        }
    
    public static void main(String[] args) { 
            loginPage login = new loginPage();
            login.launchLogin();
            ListOfRecords records = new ListOfRecords();
            records.launchFrame();
    }
    
    @Override
    public void actionPerformed(ActionEvent e) 
    {
        Object source = e.getSource();
        String textUser = this.userIn.getText();
        String textPass = this.passIn.getText(); //sabi ni java outdated na daw to but we say f*** off
        boolean authentication;
        
        if (source == this.login);
        { 
            authentication = this.loginCheck(textUser, textPass);
            
            if (authentication)
            {
                isAuthenticated = true;
                JOptionPane.showMessageDialog(null, "Login Successful");
                this.loginPage.dispose();
            }
            
            else if (!authentication && attempt < 3)
            {
                JOptionPane.showMessageDialog(null, "Incorrect Username / Password");
                attempt += 1;
            }
            
            else if (!authentication && attempt == 3)
            {
                JOptionPane.showMessageDialog(null, "Sorry, you have reached the limit of 3 tries, good bye!");
                System.exit(0);
            }
        }
    }
    
    public boolean loginCheck (String inUser, String inPass)
    {
        String filePass = "";
        int index = 1;
        String user = "";
        String pass = "";
        
        try 
        {
            BufferedReader br = new BufferedReader (new FileReader("loginCredentials.txt"));
            String line = br.readLine();
            
            while (line != null)
            {
                if (index % 2 == 0)
                {
                    pass = line;
                }
                else if (index % 2 != 0)
                {   
                    user = line;
                }
                
                index++;
                credMap.put(user, pass);
                line = br.readLine();
            }
            filePass = credMap.get(inUser);
        } 
        
        catch (IOException ex) 
        {
            JOptionPane.showMessageDialog (null, "Login Credentials not found!");
            System.exit(0);
        }
        
        if (filePass != null && filePass.equals(inPass))
        {
            return true;
        }
        return false;
    }
    
    public boolean isAuthenticated()
    {
        return isAuthenticated;
    }
}


