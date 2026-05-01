package home_work_1;

public class Main {
    static void main() {
        Disc disc = new Disc();

        disc.addSong(new AlternativeRockSong("Street Spirit (Fade Out)", "Radiohead", 4.13));
        disc.addSong(new AlternativeCountrySong("Far from Any Road", "The Handsome Family", 2.48));
        disc.addSong(new PopPunkSong("Helena", "My Chemical Romance", 3.24));
        disc.addSong(new AlternativeRockSong("What I've Done", "Linkin Park", 3.25));
        disc.addSong(new PopPunkSong("Famous Last Words", "My Chemical Romance", 4.59));


        int min = (int)Math.floor(disc.getTotalDuration());
        int sec = (int)Math.round((disc.getTotalDuration() - Math.floor(disc.getTotalDuration()))*100);
        System.out.println("Общая продолжительность: " + min + " минут " + sec + " секунд\n" + "-------------------------------");

        System.out.println("Список до сортировки по жанрам:");
        disc.printTracklist();
        System.out.println("-------------------------------");

        disc.sortByGenre();

        System.out.println("Список после сортировки по жанрам:");
        disc.printTracklist();
        System.out.println("-------------------------------");

        disc.findSongsByDuration(3.00, 4.00);
        System.out.println("-------------------------------");
        disc.findSongsByDuration(10.00, 11.00);

    }
}
