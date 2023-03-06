import java.awt.Color;

import javax.swing.JFrame;

public class MainWindow extends JFrame{
    private AxisPanel coordinateAxis = new AxisPanel();
    private figuresConfigPanel figuresConfig = new figuresConfigPanel(coordinateAxis);
    MainWindow(){
        add(coordinateAxis);
        add(figuresConfig);
        setTitle("Первая лаба");
        setLayout(null);
        setSize(1000, 700);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBackground(Color.GRAY);
        setVisible(true);
    }
}