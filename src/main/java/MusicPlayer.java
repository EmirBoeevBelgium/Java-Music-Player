import javazoom.jl.player.advanced.AdvancedPlayer;
import javazoom.jl.player.advanced.PlaybackEvent;
import javazoom.jl.player.advanced.PlaybackListener;

import java.io.BufferedInputStream;
import java.io.FileInputStream;

public class MusicPlayer extends PlaybackListener  {
    //need a way to store song details, so we make a song class

    private Song currentSong;

    //JLayer library to create an AdvancedPlayer obj which will handle playing the music
    private AdvancedPlayer advancedPlayer;


    //pause boolean to indicate song is paused
    private boolean isPaused;

    public MusicPlayer() {

    }

    public void loadSong(Song song) {
        currentSong = song;

        if(currentSong != null) {
            playCurrentSong();
        }
    }

    public void pauseSong() {
        if(advancedPlayer != null) {
            isPaused = true;

            stopSong();
        }
    }

    private void stopSong() {

        advancedPlayer.stop();
        advancedPlayer.close();
        advancedPlayer = null;

    }

    private void playCurrentSong() {
        try {
            //read mp3 audio file
            FileInputStream fileInputStream = new FileInputStream(currentSong.getFilePath());
            BufferedInputStream bufferedInputStream = new BufferedInputStream(fileInputStream);

            //create new advanced player
            advancedPlayer = new AdvancedPlayer(bufferedInputStream);
            advancedPlayer.setPlayBackListener(this);


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


    @Override
    public void playbackStarted(PlaybackEvent evt) {
        //method called when song starts
        System.out.println("Playback started");
    }

    @Override
    public void playbackFinished(PlaybackEvent evt) {
        //method called when song finishes or player gets closed
        System.out.println("Playback finished");
    }
}
