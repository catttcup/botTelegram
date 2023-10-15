package command;

import java.util.HashMap;

import org.telegram.telegrambots.meta.api.methods.send.SendMessage;

public class HelpNode implements ICommand {
    public final String infoAboutCommands;
    public final String infoAboutCommand = "Показывает список команд, доступных в боте";
    private final HashMap<String, ICommand> commandHashMap;
    public HelpNode(HashMap<String, ICommand> map) {
        commandHashMap = map;
        StringBuilder strTemp = new StringBuilder();
        strTemp.append("Бот имеет следующие команды \n");
        for (String key : commandHashMap.keySet()) {
            strTemp.append("/").append(key).append("\n");
        }
        strTemp.append("Для познания работы команды нажмите на соответствующую кнопку");
        infoAboutCommands = strTemp.toString();
    }

    @Override
    public SendMessage doCommand(String text) {
        SendMessage msg = new SendMessage();
        if (text != null) {
            if (commandHashMap.containsKey(text)) {
                msg.setText(commandHashMap.get(text).getInfo());
                return msg;
            }
            return null;
        }
        msg.setText(infoAboutCommands);
        return msg;
    }

    @Override
    public String getInfo() {
        return infoAboutCommand;
    }
}