package electricty.billing.system;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class MainClass extends JFrame implements ActionListener {

    String acctype;
    String meter_pass;
    MainClass(String acctype,String meter_pass){
        this.acctype = acctype;
        this.meter_pass = meter_pass;
        setExtendedState(JFrame.MAXIMIZED_BOTH);

        ImageIcon imageIcon = new ImageIcon(ClassLoader.getSystemResource("Icon/icon/ebs.png"));
        Image image = imageIcon.getImage().getScaledInstance(1530,830,Image.SCALE_DEFAULT);
        ImageIcon imageIcon2 = new ImageIcon(image);
        JLabel imageLable = new JLabel(imageIcon2);
        add(imageLable);

        JMenuBar menuBar = new JMenuBar();
        setJMenuBar(menuBar);

        JMenu menu = new JMenu("Menu");
        menu.setFont(new Font("serif",Font.PLAIN,15));


        JMenuItem newcustomer = new JMenuItem("New Customer");
        newcustomer.setFont(new Font("monospaced",Font.PLAIN,14));
        ImageIcon customerImg = new ImageIcon(ClassLoader.getSystemResource("Icon/icon/customer.png"));
        Image customerImage = customerImg.getImage().getScaledInstance(20,20,Image.SCALE_DEFAULT);
        newcustomer.addActionListener(this);
        menu.add(newcustomer); // 24 * 24 image use

        JMenuItem customerdetails = new JMenuItem("Customer Details");
        customerdetails.setFont(new Font("monospaced",Font.PLAIN,14));
        ImageIcon customerdetailsImg = new ImageIcon(ClassLoader.getSystemResource("Icon/icon/customerDetails.png"));
        Image customerdetailsImage = customerdetailsImg.getImage().getScaledInstance(20,20,Image.SCALE_DEFAULT);
        customerdetails.setIcon(new ImageIcon(customerdetailsImage));
        customerdetails.addActionListener(this);
        menu.add(customerdetails);

        JMenuItem depositdetails = new JMenuItem("Deposit Detail");
        depositdetails.setFont(new Font("monospaced",Font.PLAIN,14));
        ImageIcon depositdetailsImg = new ImageIcon(ClassLoader.getSystemResource("Icon/icon/depositDetails.png"));
        Image depositdetailsImage = depositdetailsImg.getImage().getScaledInstance(20,20,Image.SCALE_DEFAULT);
        depositdetails.setIcon(new ImageIcon(depositdetailsImage));
        depositdetails.addActionListener(this);
        menu.add(depositdetails);

        JMenuItem calculate = new JMenuItem("Calculate Bill");
        calculate.setFont(new Font("mospaced",Font.PLAIN,14));
        ImageIcon calculateImg = new ImageIcon(ClassLoader.getSystemResource("Icon/icon/calculatorbills.png"));
        Image calculatImage = calculateImg.getImage().getScaledInstance(20,20,Image.SCALE_DEFAULT);
        calculate.setIcon(new ImageIcon(calculatImage));
        calculate.addActionListener(this);
        menu.add(calculate);

        JMenu Info = new JMenu("Information");
        Info.setFont(new Font("serif",Font.PLAIN,15));

        JMenuItem update = new JMenuItem("Update Information");
        update.setFont(new Font("mospaced",Font.PLAIN,14));
        ImageIcon updateImg = new ImageIcon(ClassLoader.getSystemResource("Icon/icon/refresh.png"));
        Image updateImage = updateImg.getImage().getScaledInstance(20,20,Image.SCALE_DEFAULT);
        update.setIcon(new ImageIcon(updateImage));
        update.addActionListener(this);
        Info.add(update);

        JMenuItem viewinfo = new JMenuItem("View Information");
        viewinfo.setFont(new Font("mospaced",Font.PLAIN,14));
        ImageIcon viewinfoimg = new ImageIcon(ClassLoader.getSystemResource("Icon/icon/information.png"));
        Image viewinfoimage = viewinfoimg.getImage().getScaledInstance(20,20,Image.SCALE_DEFAULT);
        viewinfo.setIcon(new ImageIcon(viewinfoimage));
        viewinfo.addActionListener(this);
        Info.add(viewinfo);

        JMenu user = new JMenu("User");
        user.setFont(new Font("serif",Font.PLAIN,15));


        JMenuItem paybill = new JMenuItem("Pay Bill");
        paybill.setFont(new Font("mospaced",Font.PLAIN,14));
        ImageIcon paybillimg = new ImageIcon(ClassLoader.getSystemResource("Icon/icon/pay.png"));
        Image paybillimage =paybillimg.getImage().getScaledInstance(20,20,Image.SCALE_DEFAULT);
        paybill.setIcon(new ImageIcon(paybillimage));
        paybill.addActionListener(this);
        user.add(paybill);

        JMenuItem billdetail = new JMenuItem("Bill Detail");
        billdetail.setFont(new Font("mospaced",Font.PLAIN,14));
        ImageIcon billdetailimg = new ImageIcon(ClassLoader.getSystemResource("Icon/icon/detail.png"));
        Image billdetailimage = billdetailimg.getImage().getScaledInstance(20,20,Image.SCALE_DEFAULT);
        billdetail.setIcon(new ImageIcon(billdetailimage));
        billdetail.addActionListener(this);
        user.add(billdetail);

        JMenu bill = new JMenu("Bill");
        bill.setFont(new Font("serif",Font.PLAIN,15));


        JMenuItem genratebill = new JMenuItem("Generate Bill");
        genratebill.setFont(new Font("mospaced",Font.PLAIN,14));
        ImageIcon genratebillimg = new ImageIcon(ClassLoader.getSystemResource("Icon/icon/bill.png"));
        Image gerratebillimage = genratebillimg.getImage().getScaledInstance(20,20,Image.SCALE_DEFAULT);
        genratebill.setIcon(new ImageIcon(gerratebillimage));
        genratebill.addActionListener(this);
        bill.add(genratebill);

        JMenu utility = new JMenu("Utility");
        utility.setFont(new Font("serif",Font.PLAIN,15));


        JMenuItem notepad = new JMenuItem("Notepad");
        notepad.setFont(new Font("mospaced",Font.PLAIN,14));
        ImageIcon notepadimg = new ImageIcon(ClassLoader.getSystemResource("Icon/icon/notepad.png"));
        Image notepadimage = notepadimg.getImage().getScaledInstance(20,20,Image.SCALE_DEFAULT);
        notepad.setIcon(new ImageIcon(notepadimage));
        notepad.addActionListener(this);
        utility.add(notepad);

        JMenuItem calculator =new JMenuItem("Calculator");
        calculator.setFont(new Font("mospaced",Font.PLAIN,14));
        ImageIcon calculatorimg = new ImageIcon(ClassLoader.getSystemResource("Icon/icon/calculator.png"));
        Image calculatorimage = calculatorimg.getImage().getScaledInstance(20,20,Image.SCALE_DEFAULT);
        calculator.setIcon(new ImageIcon(calculatorimage));
        calculator.addActionListener(this);
//        calculator.setBackground(Color.CYAN); documantation jovu k kay rite hover thay chhe to colour change kari sakay.
        utility.add(calculator);

        JMenu Exit = new JMenu("Exit");
        Exit.setFont(new Font("serif",Font.PLAIN,15));


        JMenuItem exit = new JMenuItem("Exit");
        exit.setFont(new Font("mospaced",Font.PLAIN,14));
        ImageIcon exitimg = new ImageIcon(ClassLoader.getSystemResource("Icon/icon/exit.png"));
        Image exitimage = exitimg.getImage().getScaledInstance(20,20,Image.SCALE_DEFAULT);
        exit.setIcon(new ImageIcon(exitimage));
        exit.addActionListener(this);
        Exit.add(exit);

        if(acctype.equals("Admin")){
            menuBar.add(menu);
        }else{
            menuBar.add(bill);
            menuBar.add(user);
            menuBar.add(Info);
        }
        menuBar.add(utility);
        menuBar.add(Exit);


        setLayout(new FlowLayout());
        setVisible(true);
    }

    public static void main(String[] args){
        new MainClass("","");
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        String msg = e.getActionCommand();
        if (msg.equals("New Customer")){
            new NewCustomer();
        } else if (msg.equals("Customer Details")) {
            new Customer_Details();
        } else if (msg.equals("Deposit Detail")) {
            new Deposit_Details();
        } else if (msg.equals("Calculate Bill")) {
            new CalculateBill();
        } else if (msg.equals("View Information")) {
            new view_information(meter_pass);
        } else if (msg.equals("Update Information")) {
            new update_information(meter_pass);
        } else if (msg.equals("Bill Detail")) {
            new bill_detail(meter_pass);
        } else if (msg.equals("Calculator")) {
            try{
                Runtime.getRuntime().exec("calc.exe");
            }catch (Exception E){
                E.printStackTrace();
            }
        } else if (msg.equals("Notepad")) {
            try{
                Runtime.getRuntime().exec("notepad.exe");
            }catch (Exception E){
                E.printStackTrace();
            }
        } else if (msg.equals("Exit")) {
            setVisible(false);
            new Login();
        } else if (msg.equals("Pay Bill")) {
            new pay_bill(meter_pass);
        } else if (msg.equals("Generate Bill")) {
            new generate_bill(meter_pass);
        }
    }
}
