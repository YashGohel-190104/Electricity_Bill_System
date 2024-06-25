package electricty.billing.system;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;

public class update_information extends JFrame implements ActionListener {

    JLabel nametext;
    JTextField addressText,cityText,stateText,emailText,phoneText;
    String meter;
    JButton update,cancle;
    update_information(String meter){
        this.meter=meter;
        setBounds(400,150,777,450);
        getContentPane().setBackground(new Color(229,255,227));
        setLayout(null);

        JLabel heading = new JLabel("Update Customer Information");
        heading.setBounds(50,10,400,40);
        heading.setFont(new Font("serif",Font.BOLD,20));
        add(heading);

        JLabel name = new JLabel("Name");
        name.setBounds(38,70,100,20);
        add(name);

        nametext = new JLabel("");
        nametext.setBounds(150,70,200,20);
        add(nametext);

        JLabel meterNo = new JLabel("Meter Number");
        meterNo.setBounds(30,110,100,20);
        add(meterNo);

        JLabel meterText = new JLabel("");
        meterText.setBounds(30,150,100,20);
        add(meterText);

        JLabel address = new JLabel("Address");
        address.setBounds(30,150,100,20);
        add(address);

        addressText = new JTextField();
        addressText.setBounds(150,150,200,20);
        add(addressText);

        JLabel city = new JLabel("City");
        city.setBounds(30,190,100,20);
        add(city);

        cityText = new JTextField();
        cityText.setBounds(150,190,200,20);
        add(cityText);

        JLabel state = new JLabel("State");
        state.setBounds(30,230,100,20);
        add(state);

        stateText = new JTextField();
        stateText.setBounds(150,230,200,20);
        add(stateText);

        JLabel email = new JLabel("Email");
        email.setBounds(30,270,100,20);
        add(email);

        emailText = new JTextField();;
        emailText.setBounds(150,270,200,20);
        add(emailText);

        JLabel phone = new JLabel("Phone");
        phone.setBounds(30,270,100,20);
        add(phone);

        phoneText = new JTextField();;
        phoneText.setBounds(150,270,200,20);
        add(phoneText);


        try{
            DataBase c = new DataBase();
            ResultSet resultSet = c.statement.executeQuery("select * from new_customer where Meter_Number = '"+meter+"'");
            if (resultSet.next()){
                nametext.setText(resultSet.getString("Name"));
                meterText.setText(resultSet.getString("Meter_Numbere"));
                addressText.setText(resultSet.getString("Address"));
                cityText.setText(resultSet.getString("City"));
                stateText.setText(resultSet.getString("State"));
                emailText.setText(resultSet.getString("E_mail"));
                phoneText.setText(resultSet.getString("Phone_No"));
            }
        }catch(Exception e){
            e.printStackTrace();
        }

        update = new JButton("Update");
        update.setBackground(new Color(33,106,145));
        update.setForeground(Color.WHITE);
        update.setBounds(50,360,120,25);
        update.addActionListener(this);

        cancle = new JButton("Cancle");
        cancle.setBounds(200,360,120,25);
        cancle.setBackground(new Color(33,106,145));
        cancle.setForeground(Color.WHITE);
        cancle.addActionListener(this);
        add(cancle);


        ImageIcon imageIcon = new ImageIcon(ClassLoader.getSystemResource("Icon/icon/update.png"));
        Image image = imageIcon.getImage().getScaledInstance(400,430,Image.SCALE_DEFAULT);
        ImageIcon imageIcon1 = new ImageIcon(image);
        JLabel imgLbal = new JLabel(imageIcon1);
        imgLbal.setBounds(360,0,400,410);
        add(imgLbal);

        setVisible(true);
    }

    public static void main(String[] args) {
        new update_information("");
    }
    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource()==update) {
            String saddress = addressText.getText();
            String scity = cityText.getText();
            String sstate = stateText.getText();
            String semail = emailText.getText();
            String sphone = phoneText.getText();

            try{
                DataBase c = new DataBase();
                c.statement.executeUpdate("update new_customer set Address = '"+saddress+"',City = '"+scity+"',State = '"+sstate+"',E_mail = '"+semail+"',Phone_No = '"+sphone+"'");

                JOptionPane.showMessageDialog(null,"User Information Update SuccessFully");
                setVisible(false);
            }catch(Exception E){
                E.printStackTrace();
            }
        }else {
            setVisible(false);
        }
    }
}
