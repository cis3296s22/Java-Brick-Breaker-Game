import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import javax.swing.*;

public class HighScoreBoard extends JPanel{
    JButton rtnMenuButton = new JButton("Return");

    public HighScoreBoard() throws FileNotFoundException {
        initBoard();
    }

    private void initBoard() {
        setFocusable(true);
        setPreferredSize(new Dimension(Configurations.WIDTH, Configurations.HEIGHT));

        setLayout(null);
        rtnMenuButton.setBounds(10, 10, 75, 20);
        add(rtnMenuButton);
        returnHandler rtnHandler = new returnHandler();
        rtnMenuButton.addActionListener(rtnHandler);
    }

    //Click Listener for High score button
    private class returnHandler implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
            setLayout(new BorderLayout());
            revalidate();
            repaint();
            MenuScreen menu = new MenuScreen();
            add(menu);
            menu.requestFocusInWindow();
            remove(rtnMenuButton);

        }
    }

    @Override
    public void paintComponent(Graphics g){
        super.paintComponent(g);

        var g2d = (Graphics2D) g;

        try {
            drawScores(g2d);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void drawScores(Graphics2D g2d) throws IOException {
        FileReader in = new FileReader("ScoreList.txt");
        BufferedReader br = new BufferedReader(in);

        var font = new Font("Verdana", Font.BOLD, 18);
        FontMetrics fontMetrics = this.getFontMetrics(font);

        g2d.setColor(Color.RED);
        g2d.setFont(font);
        g2d.drawString("Top 5 scores",
                (Configurations.WIDTH - fontMetrics.stringWidth("Top 5 scores")) / 2,
                50);

        ArrayList<Integer> scores = new ArrayList<>();
        String line = br.readLine();
        int y = 100;

        if(line == null){
            var font3 = new Font("Verdana", Font.BOLD, 15);
            g2d.setColor(Color.BLACK);
            g2d.setFont(font3);
            g2d.drawString("No Scores yet!", 40, y);
        }
        else {
            int nScores = 0;
            while (line != null) {
                scores.add(Integer.parseInt(line));
                nScores++;
                line = br.readLine();
            }
            // If there is less than 5 scores in the score list
            if(nScores == 1){
                scores.add(0);
                scores.add(0);
                scores.add(0);
                scores.add(0);
            }
            else if(nScores == 2){
                scores.add(0);
                scores.add(0);
                scores.add(0);
            }
            else if(nScores == 3){
                scores.add(0);
                scores.add(0);
            }
            else if(nScores == 4){
                scores.add(0);;
            }
            scores.sort(Collections.reverseOrder());
            var font2 = new Font("Verdana", Font.BOLD, 15);
            g2d.setColor(Color.BLACK);
            g2d.setFont(font2);
            for (int i = 0; i < 5; i++) {
                g2d.drawString("#" + (i + 1) + ": " + scores.get(i), 40, y);
                y += 30;
            }
            br.close();
            in.close();
        }
    }
}
