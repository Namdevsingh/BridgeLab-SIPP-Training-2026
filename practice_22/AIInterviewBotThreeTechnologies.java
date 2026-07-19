public class AIInterviewBotThreeTechnologies {
    static class InterviewBot {
        String botName;
        String technology;

        InterviewBot(String botName, String technology) {
            this.botName = botName;
            this.technology = technology;
        }

        void conductInterview() {
            System.out.print("Bot: " + botName + "\nTechnology: " + technology + "\nStarting interview...\n---\n");
        }
    }

    public static void main(String[] args) {
        InterviewBot b1 = new InterviewBot("Bot-Alpha", "Java");
        InterviewBot b2 = new InterviewBot("Bot-Beta", "Python");
        InterviewBot b3 = new InterviewBot("Bot-Gamma", "Data Structures");

        b1.conductInterview();
        b2.conductInterview();
        b3.conductInterview();
    }
}

