package graphics;

import misc.Text;
import resourcemapper.ResourceMapper;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class RandomButton extends JButton {

    private enum status {
        RANDOM,
        BOSS,
        RESET
    };

    private final Icon randomIcon;
    private final Icon bossIcon;
    private final Icon resetIcon;

    private status flag;

    private CardFrame randomFrame;
    private CardFrame bossFrame;

    private JFrame parent;

    public RandomButton(JFrame parent) {
        this.randomIcon = new ImageIcon(ResourceMapper.getUrl(Text.btnIcoPath[0]));
        this.bossIcon = new ImageIcon(ResourceMapper.getUrl(Text.btnIcoPath[1]));
        this.resetIcon = new ImageIcon(ResourceMapper.getUrl(Text.btnIcoPath[2]));

        this.setIcon(randomIcon);

        this.setBackground(Color.WHITE);

        this.addActionListener(getRandomActionListener());

        this.parent = parent;

        this.flag = status.RANDOM;
        randomFrame = new CardFrame("캐릭터 추첨기", 34, Text.charText, parent, 1);
        randomFrame.addIcons(ResourceMapper.getAllUrl(Text.charResPath));

        bossFrame = new CardFrame("보스 추첨기", 5, Text.bossText, parent, 2);
        bossFrame.addIcons(ResourceMapper.getAllUrl(Text.bossResPath));
    }

    private ActionListener getRandomActionListener() {
        return new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.out.println("clicked!");

                switch (flag) {
                    case RANDOM:
                        characterChoose();
                        break;
                    case BOSS:
                        bossChoose();
                        break;
                    case RESET:
                        reset();
                        break;
                    default:
                        break;
                }
            }
        };
    }

    private void characterChoose() {
        flag = status.BOSS;
        randomFrame.run();

        this.setIcon(bossIcon);
    }

    private void bossChoose() {
        flag = status.RESET;
        bossFrame.run();

        this.setIcon(resetIcon);
    }

    private void reset() {
        randomFrame.hideFrame();
        bossFrame.hideFrame();
        flag = status.RANDOM;

        this.setIcon(randomIcon);
    }

}
