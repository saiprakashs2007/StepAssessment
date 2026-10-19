
public class TrafficSignalAnalyzer {

    static void findLongestStreak(String signalLog) {
        if (signalLog.length() == 0) {
            System.out.println("Signal log is empty");
            return;
        }

        char currentColor = signalLog.charAt(0);
        char longestColor = currentColor;

        int currentCount = 1;
        int longestCount = 1;

        for (int i = 1; i < signalLog.length(); i++) {
            char ch = signalLog.charAt(i);

            if (ch == currentColor) {
                currentCount++;
            } else {
                currentColor = ch;
                currentCount = 1;
            }

            if (currentCount > longestCount) {
                longestCount = currentCount;
                longestColor = currentColor;
            }
        }

        System.out.println("Longest Streak: '"
                + longestColor + "' repeated "
                + longestCount + " times");
    }

    public static void main(String[] args) {
        String signalLog = "RRGGGYRR";

        findLongestStreak(signalLog);
    }
}
