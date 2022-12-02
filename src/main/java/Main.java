import javax.swing.*;

public class Main {
    //trying out stuff for modifying Event
    private JButton modifyEventButton;

    public static void main(String[] args) {
        JFrame frame = new JFrame("UPLANIT");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(300,300);

        //adds uplanit
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

    // testing stuff for modifying event
    public void modifyEventInput(){
        modifyEventButton = new JButton("edit event");

    }
    //modifyEventButton.addActionListener(new ActionListener()) {

    }
    //public void actionPerformed(ActionEvent e) {}
        //your actions


