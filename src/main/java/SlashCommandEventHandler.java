import net.dv8tion.jda.api.entities.Member;
import net.dv8tion.jda.api.entities.User;
import net.dv8tion.jda.api.events.interaction.command.SlashCommandInteractionEvent;
import net.dv8tion.jda.api.hooks.ListenerAdapter;
import net.dv8tion.jda.api.interactions.commands.OptionMapping;
import org.jetbrains.annotations.NotNull;


public class SlashCommandEventHandler extends ListenerAdapter {

    @Override
    public void onSlashCommandInteraction(@NotNull SlashCommandInteractionEvent event){
        switch (event.getName()){
            case "hello":
                sayHello(event);
        }
    }

    public void sayHello(SlashCommandInteractionEvent event){
      User helloUser = event.getOption("user", OptionMapping::getAsUser);
        if (helloUser != null){
            event.getChannel().sendMessage("Hello " + helloUser.getAsMention()).queue();
        }
    }
}

