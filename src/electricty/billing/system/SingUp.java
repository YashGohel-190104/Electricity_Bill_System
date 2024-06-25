package electricty.billing.system;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.ResultSet;

public class SingUp extends JFrame implements ActionListener {

    TextField metertext,employertxt,usernametxt,nametxt,passwordtxt;
    Choice loginAsCho;
    JButton create,back;
    SingUp(){
        super("SingUp Page");
        getContentPane().setBackground(new Color(168,203,255));

        JLabel createAs = new JLabel("Create Account As");
        createAs.setBounds(30,50,125,20);
        add(createAs);

        loginAsCho = new Choice();
        // loginAsCho.add("Select");
        loginAsCho.add("Admin");
        loginAsCho.add("Customer");
        loginAsCho.setBounds(170,50,120,20);
        add(loginAsCho);

        JLabel meterNo = new JLabel("Meter Number");
        meterNo.setBounds(30,100,125,20);
        meterNo.setVisible(false);
        add(meterNo);

        metertext = new TextField();
        metertext.setBounds(170,100,125,20);
        metertext.setVisible(false);
        add(metertext);

        JLabel Employer = new JLabel("Employee ID");
        Employer.setBounds(30,100,125,20);
        Employer.setVisible(true);
        add(Employer);

        employertxt = new TextField();
        employertxt.setBounds(170,100,125,20);
        employertxt.setVisible(true);
        add(employertxt);

        JLabel username = new JLabel("UserName");
        username.setBounds(30,140,125,20);
        add(username);

        usernametxt = new TextField();
        usernametxt.setBounds(170,140,125,20);
        add(usernametxt);

        JLabel name = new JLabel("Name");
        name.setBounds(30,180,125,20);
        add(name);

        nametxt = new TextField("");
        nametxt.setBounds(170,180,125,20);
        add(nametxt);

        metertext.addFocusListener(new FocusListener() {
            @Override
            public void focusGained(FocusEvent e) {

            }

            @Override
            public void focusLost(FocusEvent e) {
                try{
                    DataBase c = new DataBase();
                    ResultSet resultSet = c.statement.executeQuery("select * from singup where meter_no = '"+metertext.getText()+"'");
                    if (resultSet.next()){
                        nametxt.setText(resultSet.getString("name"));
                    }
                }catch (Exception E){
                    E.printStackTrace();
                }
            }
        });

        JLabel password =new JLabel("Password");
        password.setBounds(30,220,125,20);
        add(password);

        passwordtxt = new TextField();
        passwordtxt.setBounds(170,220,125,20);
        add(passwordtxt);

        loginAsCho.addItemListener(new ItemListener() {
            @Override
            public void itemStateChanged(ItemEvent e) {
                String user = loginAsCho.getSelectedItem();
                if (user.equals("Customer")){
                    Employer.setVisible(false);
                    nametxt.setEditable(false);
                    employertxt.setVisible(false);
                    meterNo.setVisible(true);
                    metertext.setVisible(true);
                }
                else {
                    Employer.setVisible(true);
                    employertxt.setVisible(true);
                    meterNo.setVisible(false);
                    metertext.setVisible(false);
                }
            }
        });

        create = new JButton("Create");
//        create.setBackground(Color.GREEN);
        create.setBackground(new Color(66, 127, 219));
        create.setForeground(Color.BLACK); // Change the font Colours
        create.setBounds(40,285,100,20);
        create.addActionListener(this);
        add(create);

        back = new JButton("Back");
        back.setBackground(new Color(66,127,219));
        back.setForeground(Color.BLACK);
        back.setBounds(180,285,100,20);
        back.addActionListener(this);
        add(back);

        ImageIcon boyIcon = new ImageIcon(ClassLoader.getSystemResource("Icon/icon/boy.png"));
        Image boyImg = boyIcon.getImage().getScaledInstance(250,250,Image.SCALE_DEFAULT);
        ImageIcon boyIcon2 = new ImageIcon(boyImg);
        JLabel boyLable = new JLabel(boyIcon2);
        boyLable.setBounds(320,30,250,250);
        add(boyLable);


        setSize(600,365);
        setLocation(500,200);
        setLayout(null);
        setVisible(true);
    }


    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource()==create){
            String sloginAs = loginAsCho.getSelectedItem();
            String username = usernametxt.getText();
            String sname = nametxt.getText();
            String spassword = passwordtxt.getText();
            String smeter = metertext.getText();
            try{
                DataBase c = new DataBase();
                String query = null;
                if(loginAsCho.equals("Admin")) {
                    query = "insert into singup value('" + smeter + "', '" + username + "', '" + sname + "', '" + spassword + "','" + sloginAs + "')";
                }
                else {
                    query = "update singup set username = '"+username+"',password = '"+spassword+"',usertype = '"+sloginAs+"' where meter_no = '"+smeter+"'";
                }
                c.statement.executeUpdate(query);

                JOptionPane.showMessageDialog(null,"Account Created");
                setVisible(false);
                new Login();
            }
            catch (Exception e1){
                e1.printStackTrace();
            }
        }
        else if (e.getSource()==back) {
            setVisible(false);
            new Login();
        }
    }

    public static void main(String[] args){
        new SingUp();
    }
}
