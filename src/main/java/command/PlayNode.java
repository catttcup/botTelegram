package command;

import common.User;
import java.util.ArrayList;
import org.telegram.telegrambots.meta.api.methods.send.SendMessage;

public class PlayNode implements ICommand{
    private static final String infoAboutCommand = "Игра запускаеться с помощью /game start, чтобы остановить игра введите stop";
    private final ArrayList<User> users = new ArrayList<User>();

    @Override
    public SendMessage doCommand(String text, Long id){
        int userIndex = -1;
        /*
         * проверяем есть ли пользователь в списке
         */
        for (int i = 0; i < users.size(); i++){
            if (id.equals(users.get(i).id)){
                userIndex = i;
                break;
            }
        }
        /*
         * Добавляем нового пользователя
         */
        if (userIndex == -1){
            User eUser = new User(id);
            users.add(eUser);
            userIndex = users.size()-1;
        }

        if (text.startsWith("start") == true){
           return users.get(userIndex).start();
        }else if (text.startsWith("stop") == true){
            return users.get(userIndex).stop();
        }else
            return users.get(userIndex).proccesAnswer(text);
    }
        
    
    @Override
    public String getInfo(){
        return infoAboutCommand;
    }
}