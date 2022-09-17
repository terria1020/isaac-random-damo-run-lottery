package graphics;

import javax.sound.sampled.*;
import javax.swing.*;
import java.awt.*;
import java.io.IOException;
import java.net.URL;
import java.util.Arrays;
import java.io.File;
import java.util.Random;

public class CardFrame extends JFrame implements IFrame {

    private Icon[] icons;
    private int index;
    private int size;

    private JPanel mainPanel;

    private CardLayout layout;

    private JLabel[] labels;

    private String[] descs;

    public CardFrame(String title, int size, String[] descs) throws HeadlessException {
        super(title);
        icons = new Icon[size];
        labels = new JLabel[size];
        index = 0;
        this.size = size;

        this.descs = descs;

        this.setBounds(200, 200, 400, 400);
        this.setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
        this.setResizable(false);

        layout = new CardLayout();
        mainPanel = new JPanel(layout);

        this.setContentPane(mainPanel);

    }

    public void addIcon(URL path) {
        this.icons[index] = new ImageIcon(path);
        this.labels[index] = new JLabel(icons[index]);

        mainPanel.add(labels[index]);
        index++;
    }

    public void addIcons(URL[] path) {
        Arrays.stream(path).forEach(p -> {
            addIcon(p);
        });
    }

    public void addIconsStr(String[] path) {
        Arrays.stream(path).forEach(p -> {
            this.icons[index] = new ImageIcon(p);
            this.labels[index] = new JLabel(icons[index]);

            mainPanel.add(labels[index]);
            index++;
        });
    }

    public void addIconsStr2(String[] path) {
        Arrays.stream(path).forEach(p -> {
            this.icons[index] = new ImageIcon(p);
            this.labels[index] = new JLabel();
            this.labels[index].setIcon(icons[index]);
            this.labels[index].setText(descs[index]);
            this.labels[index].setHorizontalTextPosition(JLabel.CENTER);
            this.labels[index].setVerticalTextPosition(JLabel.BOTTOM);
            this.labels[index].setVerticalAlignment(JLabel.CENTER);
            this.labels[index].setHorizontalAlignment(JLabel.CENTER);

            mainPanel.add(labels[index]);
            index++;
        });
    }

    @Override
    public void run() {
        this.setVisible(true);



        for (int i = 0; i < 10; i++) {
            try {
                Thread.sleep(90);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            playSound();
        }



        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

        Random rand = new Random();

        for (int i = 0; i < rand.nextInt(100); i++) {
            layout.next(this.getContentPane());
        }
    }

    private void playSound() {
        File bgm;

        AudioInputStream stream;
        AudioFormat format;
        DataLine.Info info;

        bgm = new File("select.wav");

        Clip clip;

        try {
            stream = AudioSystem.getAudioInputStream(bgm);
            format = stream.getFormat();

            info = new DataLine.Info(Clip.class, format);
            clip = (Clip) AudioSystem.getLine(info);

            clip.open(stream);
            clip.start();
            clip.start();
            clip.start();
        } catch (UnsupportedAudioFileException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        } catch (LineUnavailableException e) {
            throw new RuntimeException(e);
        }
    }
}
