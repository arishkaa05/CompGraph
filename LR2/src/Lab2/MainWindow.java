package Lab2;

import javax.swing.JFrame;
import java.awt.Color;
public class MainWindow extends JFrame{
    private AxisPanel axisPanel = new AxisPanel();
    private ConfigPanel configPanel = new ConfigPanel(axisPanel);
    MainWindow(){
        add(axisPanel);
        add(configPanel);
        setTitle("Лабораторная работа № 2");
        setLayout(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(1050, 800);
        setLocationRelativeTo(null);
        setBackground(Color.GRAY);
        setVisible(true);
    }
}