import java.util.HashMap;
import java.util.PriorityQueue;
import java.util.Arrays;
import java.util.ArrayList;

class Solution {
    public class Song implements Comparable<Song> {
        String genre;
        Integer songPlayCnt;
        Integer genrePlayCnt;
        Integer id;
        
        public Song(String genre, Integer songPlayCnt, Integer genrePlayCnt, Integer id) {
            this.genre = genre;
            this.songPlayCnt = songPlayCnt;
            this.genrePlayCnt = genrePlayCnt;
            this.id = id;
        }
        
        public int compareTo(Song other) {
            if(other.genrePlayCnt != this.genrePlayCnt) {
                return other.genrePlayCnt - this.genrePlayCnt;
            }
            
            if(other.songPlayCnt != this.songPlayCnt) {
                return other.songPlayCnt - this.songPlayCnt;
            }
            
            return this.id - other.id;
        }
    }
    
    public int[] solution(String[] genres, int[] plays) {
        HashMap<String,Integer> genrePlayCnt = new HashMap<>();
        for(int i = 0; i < genres.length; ++i) {
            String g = genres[i];
            int p = plays[i];
            
            if(genrePlayCnt.containsKey(g)) {
                genrePlayCnt.put(g, genrePlayCnt.get(g) + p);
            }
            else {
                genrePlayCnt.put(g, p);
            }
        }
        
        Song[] songs = new Song[plays.length];
        for(int i = 0; i < genres.length; ++i) {
            songs[i] = new Song(genres[i], plays[i], genrePlayCnt.get(genres[i]), i);
        }
        
        Arrays.sort(songs);
        ArrayList<Integer> tmp = new ArrayList<>();
        HashMap<String, Integer> genreCnt = new HashMap<>();
        for(Song s : songs) {
            if(!genreCnt.containsKey(s.genre)) {
                genreCnt.put(s.genre, 1);
                tmp.add(s.id);
                continue;
            }
            
            if(genreCnt.get(s.genre) == 2) {
                continue;
            }
            
            genreCnt.put(s.genre, 2);
            tmp.add(s.id);
        }
        
        int[] answer = new int[tmp.size()];
        for (int i = 0; i < tmp.size(); i++) {
            answer[i] = tmp.get(i);
        }

        return answer;
    }
}