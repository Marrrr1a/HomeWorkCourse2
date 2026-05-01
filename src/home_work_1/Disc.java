package home_work_1;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class Disc {

    private List <Song> tracklist = new ArrayList<>();

    public void addSong (Song track) {
        tracklist.add(track);
    }

    /**
     * Метод для подсчёта общей продолжительности треков
     * @return totalDuration - общая продолжительность
     */
    public double getTotalDuration () {
        int totalDurationSec = 0;
        double totalDuration = 0;
        for (Song track : tracklist){
            int min = (int) Math.floor(track.getDuration());
            double sec = (track.getDuration() - min)*100;
            double durationInSec = min*60 + sec;
            totalDurationSec += durationInSec;
            totalDuration = totalDurationSec/60 + (double) (totalDurationSec % 60) /100;
        }
        return totalDuration;
    }

    /**
     * Метод для сортировки треков по жанрам
     */
    public void sortByGenre (){
        tracklist.sort(new Comparator<Song>() {
            @Override
            public int compare(Song o1, Song o2) {
                return o1.getGenre().compareTo(o2.getGenre());
            }
        });
    }


    public void printTracklist (){
        int counter = 1;
        for (Song track : tracklist){
            System.out.println(counter + ". " + track);
            counter ++;
        }
    }

    /**
     * Метод для поиска треков по продолжительности
     * @param min - минимальная продолжительность
     * @param max - максимальная продолжительность
     */
    public List<Song> findSongsByDuration (double min, double max){
        List<Song> searchResult = new ArrayList<>();
        for (Song track : tracklist){
            if (track.getDuration() <= max && track.getDuration() >= min){
                searchResult.add(track);
                System.out.println("Найденный трек: " + track);
            }
        }

        if (searchResult.isEmpty()){
            System.out.println("Не найдено подходящих треков");
        }

        return searchResult;
    }

}
