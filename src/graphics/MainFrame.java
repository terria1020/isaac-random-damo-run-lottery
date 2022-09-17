package graphics;

import javax.swing.*;
import java.awt.*;

public class MainFrame extends JFrame implements IFrame {

    private final JPanel mainPanel;

    public MainFrame() throws HeadlessException {
        super("랜덤추첨기");

        this.setBounds(100, 100, 400, 400);
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
