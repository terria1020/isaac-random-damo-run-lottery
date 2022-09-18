package graphics;

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
        this.randomIcon = new ImageIcon("button/random_ico.png");
        this.bossIcon = new ImageIcon("button/boss_ico.png");
        this.resetIcon = new ImageIcon("button/reset_ico.png");

        this.setIcon(randomIcon);

        this.setBackground(Color.WHITE);

        this.addActionListener(getRandomActionListener());

        this.parent = parent;

        this.flag = status.RANDOM;

        randomFrame = new CardFrame("캐릭터 추첨기", 34, new String[] {
                "아폴리온",
                "아자젤",
                "베타니",
                "???",
                "케인",
                "에덴",
                "이브",
                "포가튼",
                "아이작",
                "야곱",
                "유다",
                "키퍼",
                "라자루스",
                "릴리스",
                "로스트",
                "막달린",
                "삼손",
                "아폴리온_알트",
                "아자젤_알트",
                "베타니_알트",
                "???_알트",
                "케인_알트",
                "에덴_알트",
                "이브_알트",
                "포가튼_알트",
                "아이작_알트",
                "야곱_알트",
                "유다_알트",
                "키퍼_알트",
                "라자루스_알트",
                "릴리스_알트",
                "로스트_알트",
                "막달린_알트",
                "삼손_알트"
        });
        randomFrame.addIconsStr2(new String[] {
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

        bossFrame = new CardFrame("보스 추첨기", 7, new String[] {
                "???",
                "데릴리움",
                "도그마",
                "허쉬",
                "램",
                "메가사탄",
                "마더"
        });

        bossFrame.addIconsStr2(new String[] {
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
        randomFrame.run();

        this.setIcon(bossIcon);
    }

    private void bossChoose() {
        flag = status.RESET;
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
