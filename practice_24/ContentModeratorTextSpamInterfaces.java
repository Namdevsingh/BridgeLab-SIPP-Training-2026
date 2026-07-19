public class ContentModeratorTextSpamInterfaces {

    interface TextModeration {
        boolean isOffensive(String post);

        default void displayModerationPolicy() {
            System.out.print("Policy: Remove offensive text\n");
        }

        static boolean containsRestrictedWords(String post) {
            if (post == null) return false;
            String p = post.toLowerCase();
            return p.contains("hate") || p.contains("abuse") || p.contains("stupid");
        }
    }

    interface SpamDetection {
        boolean isSpam(String post);

        default void displayModerationPolicy() {
            System.out.print("Policy: Block spam links/messages\n");
        }
    }

    static class ContentModerator implements TextModeration, SpamDetection {
        public boolean isOffensive(String post) {
            return TextModeration.containsRestrictedWords(post);
        }

        public boolean isSpam(String post) {
            if (post == null) return false;
            String p = post.toLowerCase();
            return p.contains("buy now") || p.contains("free") || p.contains("http");
        }

        void moderate(String post) {
            displayModerationPolicy();
            if (isSpam(post)) System.out.println("Spam post: " + post);
            else if (isOffensive(post)) System.out.println("Offensive post: " + post);
            else System.out.println("Valid post: " + post);
        }

        public void displayModerationPolicy() {
            TextModeration.super.displayModerationPolicy();
            SpamDetection.super.displayModerationPolicy();
        }
    }

    public static void main(String[] args) {
        String[] posts = {
                "This is valid content",
                "Buy now free http://spam.com",
                "You are stupid",
                "Hello everyone"
        };

        ContentModerator m = new ContentModerator();
        for (String p : posts) {
            m.moderate(p);
            System.out.println("---");
        }
    }
}

