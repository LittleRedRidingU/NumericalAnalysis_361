import javax.swing.*;
import java.awt.*;
import java.awt.geom.Line2D;
class display {
    static int upBound = 5;
    static double[] AnswerSheet2 = new double[upBound];

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

        private display.MyFrame frame;

        public MyPanel(display.MyFrame frame) {
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
            double max = 0.0;
            for (double v : AnswerSheet2) {
                if (v > max)
                    max = v;
            }
            double scale = 450 / max;
            g2d.draw(new Line2D.Double(0, 450, 1000, 450));
            float freq = (float) 1000 / (upBound + 1);
            float position = 30;
            for (int i = 0; i < upBound; i++) {
                g2d.draw(new Line2D.Double(position, 450, position, 500 - AnswerSheet2[i] * scale));
                position = position + freq;
            }

            float[] dash = new float[]{5, 10};
            BasicStroke bs2 = new BasicStroke(
                    1,
                    BasicStroke.CAP_SQUARE,
                    BasicStroke.JOIN_MITER,
                    10.0f,
                    dash,
                    0.0f
            );
            g2d.setStroke(bs2);
            for (int i = 0; i < upBound; i++) {
                g2d.draw(new Line2D.Double(0, 500 - AnswerSheet2[i] * scale, 1000, 500 - AnswerSheet2[i] * scale));
            }

            g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);

            g2d.setFont(new Font(null, Font.PLAIN, 10));

            double last = 0.0;
            for (int i = 0; i < upBound; i++) {
                if((int)(last*100) == (int)(AnswerSheet2[i]*100)){
                    if(i == upBound-1){
                        g2d.drawString(String.valueOf(AnswerSheet2[i]), i*freq, (float) (500 - (float) AnswerSheet2[i] * scale));
                    }else {
                        continue;
                    }
                }
                g2d.drawString(String.valueOf(AnswerSheet2[i]), i*freq, (float) (500 - (float) AnswerSheet2[i] * scale));
                last = AnswerSheet2[i];
            }

            g2d.dispose();
        }

    }
}
