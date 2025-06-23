import net.dv8tion.jda.api.JDA;
import net.dv8tion.jda.api.JDABuilder;

import net.dv8tion.jda.api.interactions.InteractionContextType;
import net.dv8tion.jda.api.interactions.commands.OptionType;
import net.dv8tion.jda.api.interactions.commands.build.Commands;
import net.dv8tion.jda.api.interactions.commands.build.OptionData;
import net.dv8tion.jda.api.requests.GatewayIntent;
import net.dv8tion.jda.api.requests.restaction.CommandListUpdateAction;


public class CordleBot {

    public static void main(String[] args) throws Exception{
        String api_key = System.getenv("CORDLE_API_KEY");
        JDA jda = JDABuilder.createDefault(api_key, GatewayIntent.GUILD_MESSAGES, GatewayIntent.MESSAGE_CONTENT)
                        .addEventListeners(new TextEventHandler(), new SlashCommandEventHandler())
                        .build();

        //Only needs to be run when making or editing a command for the first time.
        //Commands stay even when the bot is disconnected.
        //slashCommands(jda);
    }

    public static void slashCommands(JDA jda){
        CommandListUpdateAction commands = jda.updateCommands();

        commands.addCommands(
                Commands.slash("hello", "Have the Cordle Bot say Hello to you or another user.")
                        .addOptions(new OptionData(OptionType.USER, "user", "The user to say Hello to.", false))
                        .setContexts(InteractionContextType.GUILD)
        ).queue();
    }
}