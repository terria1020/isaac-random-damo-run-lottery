package graphics;

import javax.swing.*;
import java.awt.*;

public class MainFrame extends JFrame implements IFrame {

    private final JPanel mainPanel;

    public MainFrame() throws HeadlessException {
        super("랜덤추첨기");

        Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();

        this.setSize(350, 300);

        int xpos = (int)(dim.getWidth()/2 - dim.getWidth()/2);

        int ypos = (int)(dim.getWidth()/2 - dim.getWidth()/2);

        //출처: https://khjins7.tistory.com/55 [:티스토리]

        this.setLocation(xpos,ypos);

        //this.setBounds(100, 100, 400, 400);
        this.setResizable(false);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        mainPanel = new JPanel();
        mainPanel.setLayout(new BorderLayout());

        mainPanel.add(new RandomButton(this), BorderLayout.CENTER);

        this.setContentPane(mainPanel);
    }

    @Override
    public void run() {
        this.setVisible(true);
    }
}
