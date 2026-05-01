package home_work_1;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;

public class AllTests {
    private Disc disc;

    @BeforeEach
    void addSongsToDisc (){
        disc = new Disc();
        disc.addSong(new AlternativeRockSong("Street Spirit (Fade Out)", "Radiohead", 4.13));
        disc.addSong(new AlternativeCountrySong("Far from Any Road", "The Handsome Family", 2.48));
        disc.addSong(new PopPunkSong("Helena", "My Chemical Romance", 3.24));
        disc.addSong(new AlternativeRockSong("What I've Done", "Linkin Park", 3.25));
        disc.addSong(new PopPunkSong("Famous Last Words", "My Chemical Romance", 4.59));
    }

    @Test
    void totalDuration (){
        Assertions.assertEquals(18.49, disc.getTotalDuration());
    }

    @Test
    void sortByGenre (){
        disc.sortByGenre();
        List <Song> tracklist = disc.findSongsByDuration(0,1000);
        Assertions.assertEquals("Alternative country", tracklist.get(0).getGenre());
        Assertions.assertEquals("Alternative rock", tracklist.get(1).getGenre());
        Assertions.assertEquals("Pop-punk", tracklist.get(3).getGenre());
    }

    @Test
    void findByDuration (){
        List <Song> tracklist = disc.findSongsByDuration(3.00,4.00);
        Assertions.assertEquals(3.24, tracklist.get(0).getDuration());
        Assertions.assertEquals(3.25, tracklist.get(1).getDuration());
    }

    @Test
    void cannotFindByDuration (){
        List <Song> tracklist = disc.findSongsByDuration(50.00,60.00);
        Assertions.assertTrue(tracklist.isEmpty());
    }

}
