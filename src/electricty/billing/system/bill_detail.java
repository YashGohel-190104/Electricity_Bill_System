package electricty.billing.system;

import net.proteanit.sql.DbUtils;

import javax.swing.*;
import java.awt.*;
import java.sql.ResultSet;

public class bill_detail extends JFrame {

    String meter;
    bill_detail(String meter){
        this.meter = meter;
        setSize(700,650);
        setLocation(400,150);
        setLayout(null);
        getContentPane().setBackground(Color.WHITE);

        JTable table = new JTable();
        try{
            DataBase c = new DataBase();
            String Query_bill = "select * from bill where Meter_Number = '"+meter+"'";
            ResultSet resultSet = c.statement.executeQuery(Query_bill);
            table.setModel(DbUtils.resultSetToTableModel(resultSet));
        }catch (Exception e){
            e.printStackTrace();
        }

        JScrollPane sp = new JScrollPane(table);
        sp.setBounds(0,0,700,650);
        add(sp);

        setVisible(true);
    }

    public static void main(String[] args) {
        new bill_detail("");
    }
}
