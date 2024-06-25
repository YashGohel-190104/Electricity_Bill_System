package electricty.billing.system;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;

public class Login extends JFrame  implements ActionListener {

    JTextField usertext,passtext,logintxt;
    Choice loginChoice;
    JButton loginbtn,canclebtn,singupbtn;

    Login(){
        super("LogIn");
        getContentPane().setBackground(Color.gray);

        JLabel username = new JLabel("UserName");
        username.setBounds(300,60,100,20);
        add(username);

        usertext = new JTextField();
        usertext.setBounds(400,60,150,20);
        add(usertext);


        JLabel password = new JLabel("PassWord");
        password.setBounds(300,100,100,20);
        add(password);

        passtext = new JTextField();
        passtext.setBounds(400,100,150,20);
        add(passtext);


        JLabel login = new JLabel("LogIn in As");
        login.setBounds(300,140,100,20);
        add(login);

        loginChoice = new Choice();
       // loginChoice.add("Select");
        loginChoice.add("Admin");
        loginChoice.add("Customer");
        loginChoice.setBounds(400,140,150,20);
        add(loginChoice);


        loginbtn = new JButton("LogIn");
        loginbtn.setBounds(330,180,100,20);
        loginbtn.addActionListener(this);
        add(loginbtn);

        canclebtn = new JButton("Cancel");
        canclebtn.setBounds(460,180,100,20);
        canclebtn.addActionListener(this);
        add(canclebtn);

        singupbtn = new JButton("SingUp");
        singupbtn.setBounds(400,220,100,20);
        singupbtn.addActionListener(this);
        add(singupbtn);


        ImageIcon profileOne = new ImageIcon(ClassLoader.getSystemResource("Icon/icon/profile.png"));
        Image profileTwo = profileOne.getImage().getScaledInstance(250,250,Image.SCALE_DEFAULT);
        ImageIcon fprofileOne = new ImageIcon(profileTwo);
        JLabel profileLable = new JLabel(fprofileOne);
        profileLable.setBounds(5,5,250,250);
        add(profileLable);

//        logintxt = new JTextField();
//        logintxt.setBounds(400,140,150,20);
//        add(logintxt);

        setSize(640,300);
        setLocation(400,200);
        setLayout(null);
        setVisible(true);
    }
    public static void main(String[] args){
        new Login();
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource()==loginbtn){
            String susername = usertext.getText();
            String spassword = passtext.getText();
            String user = loginChoice.getSelectedItem();

            try{
                DataBase c = new DataBase();
                String query  = "select * from singup where username='"+susername+"' and password='"+spassword+"' and usertype='"+user+"'";
                ResultSet resultSet = c.statement.executeQuery(query);

                if (resultSet.next()){
                    String meter = resultSet.getString("meter_no");
                    setVisible(false);
                    new MainClass( user,meter);
                }else {
                    JOptionPane.showMessageDialog(null,"Invailed LogIn");
                }

            }catch (Exception E){
                E. printStackTrace();
            }

        } else if (e.getSource()==canclebtn) {
            setVisible(false);
        } else if (e.getSource()==singupbtn) {
            setVisible(false);
            new SingUp();
        }
    }
}
