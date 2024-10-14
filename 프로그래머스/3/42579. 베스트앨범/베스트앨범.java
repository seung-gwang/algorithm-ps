import java.util.HashMap;
import java.util.Arrays;
import java.util.ArrayList;

class Solution {
    public static class Song implements Comparable<Song> {
        String genre;
        int songPlayCnt;
        int genrePlayCnt;
        int id;
        
        public Song(String genre, int songPlayCnt, int genrePlayCnt, int id) {
            this.genre = genre;
            this.songPlayCnt = songPlayCnt;
            this.genrePlayCnt = genrePlayCnt;
            this.id = id;
        }
        
        @Override
        public int compareTo(Song other) {
            // 장르 총 재생 수로 우선 정렬
            if (this.genrePlayCnt != other.genrePlayCnt) {
                return other.genrePlayCnt - this.genrePlayCnt;
            }
            // 노래 재생 수로 정렬
            if (this.songPlayCnt != other.songPlayCnt) {
                return other.songPlayCnt - this.songPlayCnt;
            }
            // 고유 번호로 정렬
            return this.id - other.id;
        }
    }
    
    public int[] solution(String[] genres, int[] plays) {
        // 장르별 총 재생 횟수 저장
        HashMap<String, Integer> genrePlayCnt = new HashMap<>();
        for (int i = 0; i < genres.length; i++) {
            genrePlayCnt.put(genres[i], genrePlayCnt.getOrDefault(genres[i], 0) + plays[i]);
        }
        
        // 각 곡 정보를 Song 객체로 저장
        Song[] songs = new Song[plays.length];
        for (int i = 0; i < genres.length; i++) {
            songs[i] = new Song(genres[i], plays[i], genrePlayCnt.get(genres[i]), i);
        }
        
        // Song 배열을 정렬
        Arrays.sort(songs);
        
        // 결과를 저장할 리스트와 장르별 선택된 곡 개수 관리
        ArrayList<Integer> tmp = new ArrayList<>();
        HashMap<String, Integer> genreCnt = new HashMap<>();
        
        for (Song s : songs) {
            // 장르별로 최대 2곡까지만 선택
            int count = genreCnt.getOrDefault(s.genre, 0);
            if (count < 2) {
                genreCnt.put(s.genre, count + 1);
                tmp.add(s.id);
            }
        }
        
        // 결과를 int 배열로 변환
        return tmp.stream().mapToInt(i -> i).toArray();
    }
}
