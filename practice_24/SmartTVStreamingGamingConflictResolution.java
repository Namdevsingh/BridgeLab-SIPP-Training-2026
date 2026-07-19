public class SmartTVStreamingGamingConflictResolution {

    interface StreamingService {
        void streamMovie();

        default void showSubscriptionDetails() {
            System.out.print("Streaming subscription active\n");
        }
    }

    interface GamingService {
        void playGame();

        default void showSubscriptionDetails() {
            System.out.print("Gaming subscription active\n");
        }
    }

    static class SmartTV implements StreamingService, GamingService {
        String[] movies;
        String[] games;

        SmartTV(String[] movies, String[] games) {
            this.movies = movies;
            this.games = games;
        }

        public void streamMovie() {
            for (String m : movies) System.out.println("Streaming: " + m);
        }

        public void playGame() {
            for (String g : games) System.out.println("Playing: " + g);
        }

        public void showSubscriptionDetails() {
            StreamingService.super.showSubscriptionDetails();
            GamingService.super.showSubscriptionDetails();
        }

        void showAllContent() {
            showSubscriptionDetails();
            streamMovie();
            playGame();
        }
    }

    public static void main(String[] args) {
        SmartTV tv = new SmartTV(new String[]{"Interstellar", "The Batman"}, new String[]{"FIFA", "PUBG"});
        tv.showAllContent();
    }
}

