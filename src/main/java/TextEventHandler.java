import net.dv8tion.jda.api.events.message.MessageReceivedEvent;
import net.dv8tion.jda.api.hooks.ListenerAdapter;
import net.fellbaum.jemoji.Emoji;
import net.fellbaum.jemoji.EmojiManager;
import net.fellbaum.jemoji.IndexedEmoji;
import org.jetbrains.annotations.NotNull;

import java.util.List;
import java.util.Set;

public class TextEventHandler extends ListenerAdapter {


    @Override
    public void onMessageReceived(@NotNull MessageReceivedEvent event){
        if (event.getAuthor().isBot()) return;

        String messageContent = event.getMessage().getContentDisplay();
        if (EmojiManager.containsAnyEmoji(messageContent)){
            System.out.println("Emoji is present");
            List<IndexedEmoji> emojis = EmojiManager.extractEmojisInOrderWithIndex(messageContent);
            for (IndexedEmoji emoji: emojis){
                System.out.println(emoji.getEmoji().getDiscordAliases());
            }


        }

        if (messageContent.equals("!test")){
            event.getChannel().
                    sendMessage("This is a test.").
                    queue();
        }

    }


}
