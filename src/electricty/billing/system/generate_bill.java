package electricty.billing.system;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;

public class generate_bill extends JFrame implements ActionListener {

    String meter;
    Choice searchMonthCho;
    JTextArea area;
    JButton bill;
    generate_bill(String meter){
        this.meter=meter;
        setSize(500,700);
        setLocation(500,30);
        setLayout(new BorderLayout());
        JPanel panel = new JPanel();

        JLabel heading = new JLabel("Generate Bill");

        JLabel meter_no = new JLabel(meter);

        searchMonthCho = new Choice();
        searchMonthCho.add("Select");
        searchMonthCho.add("January");
        searchMonthCho.add("February");
        searchMonthCho.add("March");
        searchMonthCho.add("April");
        searchMonthCho.add("May");
        searchMonthCho.add("June");
        searchMonthCho.add("July");
        searchMonthCho.add("August");
        searchMonthCho.add("September");
        searchMonthCho.add("October");
        searchMonthCho.add("November");
        searchMonthCho.add("December");

        area = new JTextArea(50,15);
        area.setText("\n\n\t..............Click On The.............\n\t..................Generate Bill");
        area.setFont(new Font("Sensrif",Font.ITALIC,15));
        JScrollPane pane = new JScrollPane(area);

        bill = new JButton("Generate Bill");
        bill.addActionListener(this);

        add(pane);

        panel.add(heading);
        panel.add(meter_no);
        panel.add(searchMonthCho);
        add(panel,"North");
        add(bill,"South");

        setVisible(true);

    }

    public static void main(String[] args) {
        new generate_bill("");
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        try{
            DataBase c = new DataBase();
            String smonth = searchMonthCho.getSelectedItem();
            area.setText("\n Power Limeter \n Electricity Bill For Month of '"+smonth+"',2023\n\n\n");
            ResultSet resultSet = c.statement.executeQuery("select * from new_customer where Meter_Number = '"+meter+"'");

            if (resultSet.next()){
                area.append("\n    Customer Name        : "+resultSet.getString("Name"));
                area.append("\n    Customer Meter Number: "+resultSet.getString("Meter_Number"));
                area.append("\n    Customer Address     : "+resultSet.getString("Address"));
                area.append("\n    Customer City        : "+resultSet.getString("City"));
                area.append("\n    Customer State       : "+resultSet.getString("State"));
                area.append("\n    Customer Email       : "+resultSet.getString("E_mail"));
                area.append("\n    Customer Phone Number       : "+resultSet.getString("Phone_No"));

            }
            resultSet = c.statement.executeQuery("select * from meter_info where Meter_No ='"+meter+"'");

            if (resultSet.next()){
                area.append("\n    Customer Meter Location        : "+resultSet.getString("Meter_Location"));
                area.append("\n    Customer Meter Type: "+resultSet.getString("Meter_Type"));
                area.append("\n    Customer Phase Code   : "+resultSet.getString("Phase_Code"));
                area.append("\n    Customer Bill Type        : "+resultSet.getString("Bill_Type"));
                area.append("\n    Customer Days      : "+resultSet.getString("Days"));


            }
            resultSet = c.statement.executeQuery("select * from tax");

            if (resultSet.next()){
                area.append("\n    Cost Per Unit        : "+resultSet.getString("Cost_Per_Unit"));
                area.append("\n   Meter Rent: "+resultSet.getString("Meter_Rent"));
                area.append("\n   Service Charge   : "+resultSet.getString("Service_Charge"));
                area.append("\n   Service Tax        : "+resultSet.getString("Service_Text"));
                area.append("\n   Swacch Bharat      : "+resultSet.getString("Swachchh_Bharat_Text"));
                area.append("\n   Fixed Tax     : "+resultSet.getString("Fixed_Text"));

            }
            resultSet = c.statement.executeQuery("select * from bill where Meter_Number = '"+meter+"' and Month = '"+searchMonthCho.getSelectedItem()+"'");

            if (resultSet.next()) {
                area.append("\n    Current Month       : " + resultSet.getString("Month"));
                area.append("\n   Units Consumed: " + resultSet.getString("Unit"));
                area.append("\n   Total Charges   : " + resultSet.getString("Total_Bill"));
                area.append("\n Total Payable: "+resultSet.getString("Total_Bill"));
            }



        }catch (Exception E){
            E.printStackTrace();
        }
    }
}
