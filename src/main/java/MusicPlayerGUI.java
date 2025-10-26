import javax.swing.*;

public class MusicPlayerGUI extends JFrame {
    public MusicPlayerGUI() {
        super("Music Player");


        //Zet breedte en hoogte van scherm
        setSize(400, 600);


        //Wanneer app sluit = end process
        setDefaultCloseOperation(EXIT_ON_CLOSE);


        //Start app in center van scherm
        setLocationRelativeTo(null);


        setResizable(false);

        setLayout(null);

        addGUIComponents();
    }

    private void addGUIComponents() {
        addToolbar();
    }

    private void addToolbar() {
        JToolBar toolBar = new JToolBar();

        toolBar.setBounds(0, 0, getWidth(), 20);
        //Prevent toolbar from being moved.
        toolBar.setFloatable(false);
        add(toolBar);
    }

}
