import java.awt.geom.Line2D;
import java.io.*;
import javax.swing.*;
import java.awt.*;

class A1Q1a {
    static float[] fSum= new float[8];
    static double[] dSum= new double[8];
    static double[] Sum1 = new double[8];
    static float[] Sum2 = new float[8];

    static final int[] POWERS_OF_10 = {1, 10, 100, 1000, 10000, 100000, 1000000, 10000000, 100000000, 1000000000};
    static int powerOfTen(int pow) {
        return POWERS_OF_10[pow];
    }

    static float sum(int n)
    {
        float s= 0.0f;
        for (int i = 1; i <= n; i++) {
            s = s + 1.0f / (float)i;
        }
        return s;
    }

    static double sumd(int n)
    {
        double i, s = 0.0;
        for (i = 1; i <= n; i++)
            s = s + 1/i;
        return s;
    }


    public static class MyFrame extends JFrame {

        public static final String TITLE = ":)";

        public static final int WIDTH = 1000;
        public static final int HEIGHT = 500;

        public MyFrame() {
            super();
            initFrame();
        }

        private void initFrame() {
            setTitle(TITLE);
            setSize(WIDTH, HEIGHT);

            setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

            setLocationRelativeTo(null);

            MyPanel panel = new MyPanel(this);
            setContentPane(panel);
        }
    }
    public static class MyPanel extends JPanel {

        private MyFrame frame;

        public MyPanel(MyFrame frame) {
            super();
            this.frame = frame;
        }
        @Override
        protected void paintComponent(Graphics g) {
            super.paintComponent(g);
            drawLine(g);
        }
        private void drawLine(Graphics g) {
            frame.setTitle("Graph in terms of N values");
            Graphics2D g2d = (Graphics2D) g.create();

            g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
            g2d.setColor(Color.RED);

            g2d.draw(new Line2D.Double(0, 450, 1000, 450));
            double max = 0.0;
            for (double v : dSum) {
                if (v > max)
                    max = v;
            }
            double scale = 450 / max;
            float position = 30;
            float position2 = 40;
            int upB = 8;
            float freq = (float) 1000 / (upB + 1);
            for (int i = 0; i < upB; i++) {
                g2d.draw(new Line2D.Double(position, 450, position, 500 - dSum[i] * scale));
                position = position + freq;
            }
            g2d.setColor(Color.BLUE);
            for (int i = 0; i < upB; i++) {
                g2d.draw(new Line2D.Double(position2, 450, position2, 500 - fSum[i] * scale));
                position2 = position2 + freq;
            }

            float[] dash = new float[] { 5, 10 };
            BasicStroke bs2 = new BasicStroke(
                    1,
                    BasicStroke.CAP_SQUARE,
                    BasicStroke.JOIN_MITER,
                    10.0f,
                    dash,
                    0.0f
            );
            g2d.setStroke(bs2);
            g2d.setColor(Color.RED);
            for (int i = 0; i < upB; i++) {
                g2d.draw(new Line2D.Double(0, 500-dSum[i] * scale, 1000, 500-dSum[i] * scale));
                position = position + freq;
            }
            g2d.setColor(Color.BLUE);
            for (int i = 0; i < upB; i++) {
                g2d.draw(new Line2D.Double(0, 500-fSum[i] * scale, 1000, 500-fSum[i] * scale));
                position2 = position2 + freq;
            }

            g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);

            g2d.setFont(new Font(null, Font.PLAIN, 10));

            for (int i = 0; i < upB; i++) {
                g2d.drawString(String.valueOf(Sum1[i]), 20, 500-(float) dSum[i]);
            }
            for (int i = 0; i < upB; i++) {
                g2d.drawString(String.valueOf(Sum1[i]), 20, 500- fSum[i]);
            }

            g2d.drawString("Red=double", 800, 500-(float) dSum[7]);
            g2d.drawString("Blue=float", 900, 500-(float) dSum[7]);

            g2d.dispose();
        }

    }



    public static void main(String[] args)
    {

        for(int i = 1; i <= 8; i++){
            int N = powerOfTen(i);
            Sum2[i-1] = sum(N);
            System.out.println("Sum is float "+Sum2[i-1]);
            fSum[i-1] = Sum2[i-1]*25;
        }
        for(int i = 1; i <= 8; i++){
            int N = powerOfTen(i);
            Sum1[i-1] = sumd(N);
            System.out.println("Sum is double "+Sum1[i-1]);
            dSum[i-1] = Sum1[i-1]*25;
        }
        EventQueue.invokeLater(() -> {
            MyFrame frame = new MyFrame();
            frame.setVisible(true);
        });
    }

} 