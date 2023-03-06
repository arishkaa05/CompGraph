import javax.swing.JOptionPane;
import javax.swing.JPanel;
import java.awt.*;
import java.lang.Math;

public class AxisPanel extends JPanel {
    private int circleX = 0, circleY = 0;
    private int radius = 100;
    private int firstX = 150, firstY = 200;
    private double ax, ay, bx, by;
    private final int SIZE = 700;
    Color backgraund  = new Color(230, 230, 230);
    Color theme = new Color(129, 129, 129);
    Color circle = new Color(183, 133, 224);
    Color tangent = new Color(9, 110, 124);
    AxisPanel(){
        setBackground(backgraund);
        setBounds(5, 5, SIZE, SIZE);
        calculatePoints();
        System.out.println("Points on a circle: \nax: " + ax + ", ay: " + ay + 
         "\nbx: " + bx + ", by: " + by);
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        drawAxis(g);
        drawCircle(g);
        if (!isInsideTheCircle())
            drawLine(g);
        else {
        	System.out.println("The point is inside the circle\nI can't draw a tangent");
        	JOptionPane.showMessageDialog(null, "The point is inside the circle\\nI can't draw a tangent");
        }
    }

    private void drawAxis(Graphics g){
        g.setColor(theme);
        g.drawLine(0, SIZE / 2, SIZE, SIZE / 2);
        g.drawLine(SIZE / 2, 0, SIZE / 2, SIZE);
    }

    private void drawCircle(Graphics g){
        g.setColor(circle);
        //нарисовал точку центра
        g.drawOval(SIZE / 2 + circleX, -circleY + SIZE / 2, 1, 1);

        Graphics2D gr = (Graphics2D)g;
        gr.setStroke(new BasicStroke(2));
        gr.drawOval(SIZE / 2 + circleX - radius, SIZE / 2 - radius - circleY, 2 * radius, 2 * radius);
    }

    private void drawLine(Graphics g) {
        calculatePoints(); 
        g.setColor(tangent);
        g.drawLine(SIZE / 2 + firstX, -firstY + SIZE / 2, SIZE / 2 + (int)ax, -(int)ay + SIZE / 2);
        g.drawLine(SIZE / 2 + firstX, -firstY + SIZE / 2, SIZE / 2 + (int)bx, -(int)by + SIZE / 2);

        g.setColor(Color.GREEN);
        //нарисовал начальную точку
        g.drawOval(SIZE / 2 + firstX, -firstY + SIZE / 2, 2, 2); 
    }

    public void calculatePoints(){
        double a, b, c, R;
        R = Math.sqrt((circleX - firstX)*(circleX - firstX) + (circleY - firstY)*(circleY - firstY) - radius*radius);
        a = -2*(-circleX + firstX);
        b = -2*(-circleY + firstY);
        c = (circleX - firstX)*(circleX - firstX) + (circleY - firstY)*(circleY - firstY) + radius*radius - R*R;

        double x0 = -a*c/(a*a + b*b), y0 = -b*c/(a*a + b*b);
        double d = radius*radius- c*c/(a*a + b*b);
        double mult = Math.sqrt(d / (a*a + b*b));
        ax = x0 + b * mult + circleX; //надо потом прибавить координаты центра окружности
        bx = x0 - b * mult + circleX;
        ay = y0 - a * mult + circleY;
        by = y0 + a * mult + circleY;

        
    }

	public void setCircleX(int circleX) {
		this.circleX = circleX;
	}

	public void setCircleY(int circleY) {
		this.circleY = circleY;
	}

	public void setRadius(int radius) {
		this.radius = radius;
	}

	public void setFirstX(int firstX) {
		this.firstX = firstX;
	}

	public void setFirstY(int firstY) {
		this.firstY = firstY;
	}

    public double getAX(){
        return ax;
    }

    public double getAY(){
        return ay;
    }

    public double getBX(){
        return bx;
    }

    public double getBY(){
        return by;
    }

    public boolean isInsideTheCircle(){
        return (circleX - firstX)*(circleX - firstX) + (circleY - firstY)*(circleY - firstY) - radius*radius < 0;
    }
}