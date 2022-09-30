package graphics;

import resourcemapper.ResourceMapper;

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

    private JFrame parent;

    private int correction;

    public CardFrame(String title, int size, String[] descs, JFrame parent, int correction) throws HeadlessException {
        super(title);
        icons = new Icon[size];
        labels = new JLabel[size];
        index = 0;
        this.size = size;

        this.descs = descs;
        this.parent = parent;
        this.correction = correction;

        int parent_x;
        int parent_y;

        parent_x = parent.getX();
        parent_y = parent.getY();

        this.setBounds(parent_x + (300 * correction), parent_y, 300, 300);
        this.setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
        this.setResizable(false);

        layout = new CardLayout();
        mainPanel = new JPanel(layout);

        this.setContentPane(mainPanel);
    }

    public void addIcon(URL path) {

        if (path.toString().contains("boss")) {
            ImageIcon icon = new ImageIcon(path);
            Image original = icon.getImage();

            Image scaled = original.getScaledInstance(100, 100, Image.SCALE_SMOOTH);
            this.icons[index] = new ImageIcon(scaled);
        }
        else {
            this.icons[index] = new ImageIcon(path);
        }

        this.labels[index] = new JLabel(icons[index]);

        this.labels[index].setText(descs[index]);
        this.labels[index].setHorizontalTextPosition(JLabel.CENTER);
        this.labels[index].setVerticalTextPosition(JLabel.BOTTOM);
        this.labels[index].setVerticalAlignment(JLabel.CENTER);
        this.labels[index].setHorizontalAlignment(JLabel.CENTER);

        this.labels[index].setSize(100, 100);

        mainPanel.add(labels[index]);
        index++;
    }

    public void addIcons(URL[] path) {
        Arrays.stream(path).forEach(p -> {
            addIcon(p);
        });
    }

    @Override
    public void run() {

        this.setLocation(parent.getX() + (300 * correction), parent.getY());

        this.setVisible(true);

        for (int i = 0; i < 16; i++) {
            try {
                Thread.sleep(10 + (i * 7));
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

        int randomNumber = rand.nextInt(size);

        System.out.println("randomNumber : " + randomNumber);

        layout.first(this.getContentPane());

        for (int i = 0; i < randomNumber; i++) {
            layout.next(this.getContentPane());
        }
    }

    private void playSound() {
        URL bgm;
        bgm = ResourceMapper.getUrl("sound/select.wav");

        AudioInputStream stream;
        AudioFormat format;
        DataLine.Info info;

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

    public void hideFrame() {
        this.setVisible(false);
    }

}
