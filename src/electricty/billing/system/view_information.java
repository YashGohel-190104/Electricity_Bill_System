package electricty.billing.system;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;

public class view_information extends JFrame implements ActionListener {

    String view;
    JButton cancle;
    view_information(String view){
        this.view = view;
        setBounds(350,150,850,650);
        getContentPane().setBackground(Color.WHITE);
        setLayout(null);

        JLabel heading = new JLabel("View Information");
        heading.setBounds(250,0,500,40);
        heading.setFont(new Font("serif",Font.BOLD,20));
        add(heading);

        JLabel nameLable = new JLabel("Name");
        nameLable.setBounds(70,80,100,20);
        add(nameLable);

        JLabel nameLableText = new JLabel("");
        nameLableText.setBounds(200,80,150,20);
        add(nameLableText);

        JLabel meterno = new JLabel("Meter Number");
        meterno.setBounds(70,140,100,20);
        add(meterno);

        JLabel meternoText = new JLabel("");
        meternoText.setBounds(200,140,150,20);
        add(meternoText);

        JLabel address = new JLabel("Address");
        address.setBounds(70,200,100,20);
        add(address);

        JLabel addressText = new JLabel("");
        addressText.setBounds(200,200,150,20);
        add(addressText);


        JLabel city = new JLabel("City");
        city.setBounds(70,260,100,20);
        add(city);

        JLabel cityText = new JLabel("");
        cityText.setBounds(200,260,150,20);
        add(cityText);

        JLabel state = new JLabel("State");
        state.setBounds(500,80,100,20);
        add(state);

        JLabel stateText = new JLabel("");
        stateText.setBounds(600,80,150,20);
        add(stateText);

        JLabel email = new JLabel("Email");
        email.setBounds(500,140,100,20);
        add(email);

        JLabel emailText = new JLabel("");
        emailText.setBounds(600,140,150,20);
        add(emailText);

        JLabel phone = new JLabel("Phone");
        phone.setBounds(500,200,100,20);
        add(phone);

        JLabel phoneText = new JLabel("");
        phoneText.setBounds(600,200,150,20);
        add(phoneText);


        try{
            DataBase c = new DataBase();
            ResultSet resultSet = c.statement.executeQuery("select * from new_customer where Meter_Number = '"+view+"'");
            if (resultSet.next()){
                nameLableText.setText(resultSet.getString("Name"));
                meternoText.setText(resultSet.getString("Meter_Number"));
                addressText.setText(resultSet.getString("Address"));
                cityText.setText(resultSet.getString("City"));
                stateText.setText(resultSet.getString("State"));
                emailText.setText(resultSet.getString("E_mail"));
                phoneText.setText(resultSet.getString("Phone_No"));
            }
        }
        catch (Exception e){
            e.printStackTrace();
        }

        cancle = new JButton("Cancle");
        cancle.setBackground(new Color(24,118,242));
        cancle.setForeground(Color.WHITE);
        cancle.setBounds(220,350,120,25);
        cancle.addActionListener(this);
        add(cancle);

        ImageIcon a1 = new ImageIcon(ClassLoader.getSystemResource("Icon/icon/viewInfo.png"));
        Image a2 = a1.getImage().getScaledInstance(650,300,Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(a2);
        JLabel img = new JLabel(i3);
        img.setBounds(100,320,600,300);
        add(img);

        setVisible(true);
    }

    public static void main(String[] args) {
        new view_information("");
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == cancle){
            setVisible(false);
        }
    }
}
