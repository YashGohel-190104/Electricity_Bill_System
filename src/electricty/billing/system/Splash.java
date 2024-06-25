package electricty.billing.system;

import javax.swing.*;
import java.awt.*;

public class Splash extends JFrame {

    Splash(){

        ImageIcon imageIcon = new ImageIcon(ClassLoader.getSystemResource("Icon/splash/Splash.jpg"));
        Image imageOne = imageIcon.getImage().getScaledInstance(600,400,Image.SCALE_DEFAULT);
        ImageIcon imageIcon2 = new ImageIcon(imageOne);
        JLabel imageLable = new JLabel(imageIcon2);
        add(imageLable);

        setSize(400,400);
        setLocation(200,100);
        setVisible(true);

        try{
            Thread.sleep(3000);
            setVisible(false);


            new Login();

        }catch (Exception e){
            e.printStackTrace();
        }

    }

    public static void main(String[] args){
         new Splash();
    }
}
