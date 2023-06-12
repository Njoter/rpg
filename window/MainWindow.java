package window;

import javax.swing.*;
import javax.swing.border.LineBorder;
import javax.swing.border.TitledBorder;

import java.awt.*;

public class MainWindow {

    private JFrame frame;
    private JPanel gamePanel;
    private static TitledBorder titledBorder;
    private final Font titleFont = new Font("Arial", Font.BOLD, 20);
    private final Font inputFont = new Font("Arial", Font.PLAIN, 14);

    public MainWindow() {
        initialize();
    }

    private void initialize() {
        frame = new JFrame();
        this.frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        this.frame.setExtendedState(JFrame.MAXIMIZED_BOTH);
        this.frame.setUndecorated(true);
        this.frame.setLayout(null);
        this.frame.getContentPane().setBackground(ColorScheme.bgDark1);
        this.frame.setVisible(true);

        String title = "Title";
        LineBorder lineBorder = new LineBorder(ColorScheme.fg1, 3);
        titledBorder = new TitledBorder(lineBorder, title, 0, 1);
        titledBorder.setTitleFont(titleFont);
        titledBorder.setTitleColor(ColorScheme.fg1);
        gamePanel = new JPanel();
        this.gamePanel.setBackground(ColorScheme.bgDark1);
        this.gamePanel.setBorder(titledBorder);
        this.gamePanel.setBounds(480, 135, 960, 540);

        JTextArea inputArea = new JTextArea();
        inputArea.setBounds(480, 675, 960, 135);
        inputArea.setFont(inputFont);

        this.frame.add(gamePanel);
        this.frame.add(inputArea);
    }

    public static void setTitle(String title) {
        titledBorder.setTitle(title);
    }
}
