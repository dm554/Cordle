import net.dv8tion.jda.api.JDA;
import net.dv8tion.jda.api.JDABuilder;
import net.dv8tion.jda.api.requests.GatewayIntent;


public class CordleBot {

    public static void main(String[] args) throws Exception{
        String api_key = System.getenv("CORDLE_API_KEY");
        JDA jda = JDABuilder.createDefault(api_key, GatewayIntent.GUILD_MESSAGES, GatewayIntent.MESSAGE_CONTENT)
                        .addEventListeners(new TextEventHandler())
                        .build();
    }
}
