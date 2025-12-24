import javazoom.jl.player.advanced.AdvancedPlayer;

import java.io.BufferedInputStream;
import java.io.FileInputStream;

public class MusicPlayer {
    //need a way to store song details, so we make a song class

    private Song currentSong;

    //JLayer library to create an AdvancedPlayer obj which will handle playing the music
    private AdvancedPlayer advancedPlayer;

    public MusicPlayer() {

    }

    public void loadSong(Song song) {
        currentSong = song;

        if(currentSong != null) {
            playCurrentSong();
        }
    }


    public void playCurrentSong() {
        try {
            //read mp3 audio file
            FileInputStream fileInputStream = new FileInputStream(currentSong.getFilePath());
            BufferedInputStream bufferedInputStream = new BufferedInputStream(fileInputStream);

            //create new advanced player
            advancedPlayer = new AdvancedPlayer(bufferedInputStream);

            startMusicThread();
        }
        catch (Exception e) {
            e.printStackTrace();
        }
    }



    private void startMusicThread() {
        new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    advancedPlayer.play();
                }
                catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }).start();
    }

}
