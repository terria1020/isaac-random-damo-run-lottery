package graphics;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.net.URL;

public class RandomButton extends JButton {

    private enum status {
        RANDOM,
        BOSS,
        RESET
    };

    private static String resPath = "/Users/jaehan1346/IdeaProjects/iaaac_random_damo/resources/";

    private final Icon randomIcon;
    private final Icon bossIcon;
    private final Icon resetIcon;
    private final JFrame parent;

    private ActionListener actionListener;

    private status flag;

    private CardFrame randomFrame;
    private CardFrame bossFrame;

    public RandomButton(final JFrame parent) {
        this.randomIcon = new ImageIcon("random_ico.png");
        this.bossIcon = new ImageIcon("boss_ico.png");
        this.resetIcon = new ImageIcon("reset_ico.png");

        this.setIcon(randomIcon);

        this.setBackground(Color.WHITE);

        this.addActionListener(getRandomActionListener());

        this.parent = parent;

        this.flag = status.RANDOM;

        randomFrame = new CardFrame("캐릭터 추첨기", 34);
        randomFrame.addIconsStr(new String[] {
                "character/apollyon.png",
                "character/azazel.png",
                "character/bethany.png",
                "character/blue.png",
                "character/cain.png",
                "character/eden.png",
                "character/eve.png",
                "character/forgotten.png",
                "character/isaac.png",
                "character/jacob.png",
                "character/judas.png",
                "character/keeper.png",
                "character/lazarus.png",
                "character/lilith.png",
                "character/lost.png",
                "character/magdalene.png",
                "character/samson.png",
                "character/apollyon_t.png",
                "character/azazel_t.png",
                "character/bethany_t.png",
                "character/blue_t.png",
                "character/cain_t.png",
                "character/eden_t.png",
                "character/eve_t.png",
                "character/forgotten_t.png",
                "character/isaac_t.png",
                "character/jacob_t.png",
                "character/judas_t.png",
                "character/keeper_t.png",
                "character/lazarus_t.png",
                "character/lilith_t.png",
                "character/lost_t.png",
                "character/magdalene_t.png",
                "character/samson_t.png"
        });

        bossFrame = new CardFrame("보스 추첨기", 7);

        bossFrame.addIconsStr(new String[] {
                "boss/blue.png",
                "boss/del.png",
                "boss/dogma.png",
                "boss/hush.png",
                "boss/lamb.png",
                "boss/megasatan.png",
                "boss/mother.png"
        });
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
        bossFrame.setVisible(false);
        randomFrame.run();

        this.setIcon(bossIcon);
    }

    private void bossChoose() {
        flag = status.RESET;
        randomFrame.setVisible(false);
        bossFrame.run();

        this.setIcon(resetIcon);
    }

    private void reset() {
        randomFrame.setVisible(false);
        bossFrame.setVisible(false);
        flag = status.RANDOM;

        this.setIcon(randomIcon);
    }

}
