import java.util.Scanner;

public class RuleBasedChatbot {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String input;

        System.out.println("🤖 Hello! I'm your simple chatbot. Type 'bye' to exit.");

        while (true) {
            System.out.print("You: ");
            input = scanner.nextLine().toLowerCase();

            if (input.contains("hi") || input.contains("hello")) {
                System.out.println("Chatbot: Hello! How can I help you today?");
            } else if (input.contains("how are you")) {
                System.out.println("Chatbot: I'm just a bot, but I'm doing great! What about you?");
            } else if (input.contains("what is your name")) {
                System.out.println("Chatbot: I'm a simple rule-based chatbot built in Java.");
            } else if (input.contains("bye")) {
                System.out.println("Chatbot: Goodbye! Have a nice day. 😊");
                break;
            } else if (input.contains("thanks") || input.contains("thank you")) {
                System.out.println("Chatbot: You're welcome!");
            } else if (input.contains("help")) {
                System.out.println("Chatbot: Sure! Ask me anything about programming, weather, or just chat!");
            } else {
                System.out.println("Chatbot: Sorry, I didn't understand that. Can you rephrase?");
            }
        }

        scanner.close();
    }
}