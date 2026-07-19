import java.util.*;

public class MusicPlaylistRecommendationEngine {

    static class RecentlyPlayed {
        LinkedList<String> history;
        int limit = 10;

        RecentlyPlayed() {
            history = new LinkedList<>();
        }

        void play(String song) {
            history.addFirst(song);
            if (history.size() > limit) history.removeLast();
        }

        boolean containsSong(String song) {
            return history.contains(song);
        }

        void displayHistory() {
            System.out.println("Recently Played:");
            for (String s : history) System.out.println(s);
        }
    }

    public static void main(String[] args) {
        RecentlyPlayed rp = new RecentlyPlayed();
        rp.play("Song1");
        rp.play("Song2");
        rp.play("Song3");
        rp.play("Song4");
        rp.play("Song5");

        System.out.println("Contains Song3? " + rp.containsSong("Song3"));
        rp.displayHistory();
    }
}

