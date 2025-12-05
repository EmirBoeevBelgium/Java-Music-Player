import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;

public class MusicPlayerGUI extends JFrame {
    public static final Color FRAME_COLOR = Color.BLACK;
    public static final Color TEXT_COLOR = Color.WHITE;

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

        //change frame color
        getContentPane().setBackground(FRAME_COLOR);

        addGUIComponents();
    }

    private void addGUIComponents() {
        //add toolbar
        addToolbar();

        //load record image
        JLabel songImage = new JLabel(loadImage("src/main/java/assets/record.png"));
        songImage.setBounds(0, 50, getWidth() - 20 , 225 );
        add(songImage);

        //add song title
        JLabel songTitle = new JLabel("Song Title");
        songTitle.setBounds(0, songImage.getY() + songImage.getHeight() + 5, getWidth() - 10, 30);
        songTitle.setFont(new Font("Dialog", Font.BOLD,24));
        songTitle.setForeground(TEXT_COLOR);
        songTitle.setHorizontalAlignment(SwingConstants.CENTER);

        add(songTitle);

        //song artist
        JLabel songArtist = new JLabel("Artist");
        songArtist.setBounds(0, songTitle.getY() + songTitle.getHeight() + 5, getWidth() - 10, 30);
        songArtist.setFont(new Font("Dialog", Font.PLAIN, 24));
        songArtist.setForeground(TEXT_COLOR);
        songArtist.setHorizontalAlignment(SwingConstants.CENTER);

        add(songArtist);

        // playback slider
        JSlider playbackSlider = new JSlider(JSlider.HORIZONTAL, 0, 100, 0);
        playbackSlider.setBounds(getWidth()/2 - 300/2, songArtist.getY() + songArtist.getHeight() + 5, 300, 40);
        playbackSlider.setBackground(null);
        add(playbackSlider);
    }

    private void addToolbar() {
        JToolBar toolBar = new JToolBar();

        toolBar.setBounds(0, 0, getWidth(), 20);
        //Prevent toolbar from being moved.
        toolBar.setFloatable(false);
        //add dropdown menu
        JMenuBar menuBar = new JMenuBar();
        toolBar.add(menuBar);
        //add song menu to place loading song option
        JMenu songMenu = new JMenu("Song");
        menuBar.add(songMenu);

        JMenuItem loadSong = new JMenuItem("Load Song");
        songMenu.add(loadSong);

        JMenu playlistMenu = new JMenu("Playlist");
        menuBar.add(playlistMenu);

        JMenuItem createPlaylist = new JMenuItem("Create Playlist");
        playlistMenu.add(createPlaylist);

        JMenuItem loadPlaylist = new JMenuItem("Load Playlist");
        playlistMenu.add(loadPlaylist);


        add(toolBar);
    }

    private ImageIcon loadImage(String imagePath) {
        try {
            // read the image file from the given path
            BufferedImage image = ImageIO.read(new File(imagePath));

            //return an image icon so our component can render the image
            return new ImageIcon(image);
        }
        catch(Exception e) {
            e.printStackTrace();
        }
        return null;

    }
}
