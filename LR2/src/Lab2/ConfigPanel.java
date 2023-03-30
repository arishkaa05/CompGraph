package Lab2;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;
import java.util.List;
import java.awt.event.*;
public class ConfigPanel extends JPanel{
    private AxisPanel AXISPANEL;
    private List<Point> pointsList;
    private JLabel[] pointLabels = new JLabel[5];
    private JTextField[] xFields = new JTextField[5];
    private JTextField[] yFields = new JTextField[5];
    private JButton drawButton = new JButton("Построить");
    ConfigPanel(AxisPanel axisPanel){
        AXISPANEL = axisPanel;
        pointsList = AXISPANEL.getPointList();
        setLayout(null);
        setBackground(Color.LIGHT_GRAY);
        setBounds(775, 150, 240, 250);

        setPointNumber();
        setPointCoords();
        drawButton.setBounds(60, 210, 130, 25);
        add(drawButton);
        drawButton.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e) {
                List<Point> tempList = new ArrayList<>();
                for (int i = 0; i < 5; i++)
                    try{
                        tempList.add(new Point(Integer.parseInt(xFields[i].getText()), Integer.parseInt(yFields[i].getText())));
                    }
                    catch(NumberFormatException ex){
                    	if (i < 3) {
                    		JFrame jFrame = new JFrame();
                            JOptionPane.showMessageDialog(jFrame, "Enter data!");
                    	}
      
                    }
                AXISPANEL.setPointList(tempList);
                AXISPANEL.repaint();
            }
        });
    }

    private void setPointNumber() {
        JLabel pointNumberLabel = new JLabel("Ведите не менее 3 точек ");
        pointNumberLabel.setBounds(55, 0, 290, 25);
        add(pointNumberLabel);
    }
    private void setPointCoords() {
        JLabel xHint = new JLabel("x"), yHint = new JLabel("y");
        xHint.setBounds(140, 30, 30, 20);
        yHint.setBounds(200, 30, 30, 20);
        add(xHint); add(yHint);
        pointLabels[0] = new JLabel("Первая точка: ");
        pointLabels[1] = new JLabel("Вторая точка: ");
        pointLabels[2] = new JLabel("Третья точка: ");
        pointLabels[3] = new JLabel("Четвертая точка: ");
        pointLabels[4] = new JLabel("Пятая точка: ");
        for (int i = 0, j = 0; i < 5; i++, j += 30){
            pointLabels[i].setBounds(10, 50 + j, 190, 25);
            add(pointLabels[i]);
            xFields[i] = new JTextField();
            yFields[i] = new JTextField();
            xFields[i].setBounds(130, 50 + j, 30, 20);
            yFields[i].setBounds(190, 50 + j, 30, 20);
            try{
                xFields[i].setText(Integer.toString(pointsList.get(i).x));
                yFields[i].setText(Integer.toString(pointsList.get(i).y));
            }
            catch(IndexOutOfBoundsException e){ }
            add(xFields[i]);
            add(yFields[i]);
        }        
    }
}