package common;

import org.telegram.telegrambots.meta.api.methods.send.SendMessage;

import command.HandlerNode;

/*
 * класс работы с сообщениями
 */
public class WorkWithMessage{
    private final HandlerNode handler = new HandlerNode();
    
    public WorkWithMessage() { }
    
    
    
    /*
     * метод обработки команд
     */
    public SendMessage handleMessage(String text, Long user_id) {
        SendMessage sendMessage = new SendMessage();

        if (text.startsWith("/")) {
            SendMessage answerAboutCommand = handler.checkCommand(text, user_id);
            if (answerAboutCommand == null) {
               sendMessage.setText("Такой команды нет, напишите /help чтобы узнать доступные команды");
               return sendMessage;
            }
            return answerAboutCommand;
        }
        else {
           return handler.correctAnswer(text, user_id);
        }
    }   

}