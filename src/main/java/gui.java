import javax.swing.*;

public class gui {
    public static void main(String[] args) {
        JFrame frame = new JFrame("UPLANIT");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(300,300);

        //adds uplannit
        JLabel label = new JLabel("UPLANNIT");
        label.setBounds(90, 120, 90, 180);

        //adds button
        JButton button = new JButton("LETS GOOOOOOOOOOOOOOOO");

        //creates a panel to show button and label
        JPanel pnl = new JPanel();
        pnl.add(label);
        pnl.add(button);
        pnl.setBorder(BorderFactory.createEmptyBorder(90,10,10,10));

        frame.add(pnl);
        frame.setVisible(true);
    }
}
