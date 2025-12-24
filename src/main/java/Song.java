import org.jaudiotagger.audio.AudioFile;
import org.jaudiotagger.audio.AudioFileIO;
import org.jaudiotagger.audio.exceptions.CannotReadException;
import org.jaudiotagger.audio.exceptions.InvalidAudioFrameException;
import org.jaudiotagger.audio.exceptions.ReadOnlyFileException;
import org.jaudiotagger.tag.FieldKey;
import org.jaudiotagger.tag.Tag;
import org.jaudiotagger.tag.TagException;

import java.io.File;
import java.io.IOException;

public class Song {
    private String songTitle;
    private String songArtist;
    private String songLength;
    private String filePath;


    public Song(String filePath) {
        this.filePath = filePath;

        try {
            //use jaudiotagger to make an audio file object to read mp3 files
            AudioFile audioFile = AudioFileIO.read(new File(filePath));

            //read metadate
            Tag tag = audioFile.getTag();

            if(tag != null) {
                songTitle = tag.getFirst(FieldKey.TITLE);
                songArtist = tag.getFirst(FieldKey.ARTIST);
            }
            else {
                //could not read metadata
                songTitle = "N/A";
                songArtist = "N/A";
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public String getSongTitle() {
        return songTitle;
    }

    public String getSongArtist() {
        return songArtist;
    }

    public String getSongLength() {
        return songLength;
    }

    public String getFilePath() {
        return filePath;
    }


}
