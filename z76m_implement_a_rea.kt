import java.util.*

data class Message(val text: String, val sender: String)

class ChatBotSimulator(private val botName: String) {
    private val conversationHistory = mutableListOf<Message>()

    fun sendMessage(userMessage: String) {
        val botResponse = generateBotResponse(userMessage)
        conversationHistory.add(Message(userMessage, "User"))
        conversationHistory.add(Message(botResponse, botName))
        println("User: $userMessage")
        println("$botName: $botResponse")
    }

    private fun generateBotResponse(userMessage: String): String {
        // TO DO: implement bot response generation logic here
        return "I'm not sure I understand. Can you please rephrase?"
    }

    fun printConversationHistory() {
        conversationHistory.forEach { println("${it.sender}: ${it.text}") }
    }
}

fun main() {
    val bot = ChatBotSimulator("Zeta")
    while (true) {
        print("You: ")
        val userMessage = readLine()!!
        bot.sendMessage(userMessage)
        if (userMessage.lowercase() == "quit") break
    }
    bot.printConversationHistory()
}