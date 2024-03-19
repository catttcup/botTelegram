package common;
import org.telegram.telegrambots.meta.api.methods.send.SendMessage;

public class User {
    public Long id;
    public int score;
    public int LastAnswer;
    public boolean Isgame;

    public User(Long id){
        this.id = id;
        score = 0;
        Isgame = false;
    }

    private boolean isDig(String text){
        char[] numbers = text.toCharArray();
        for (char number : numbers){
            if ((number < '0' || number > '9' )&& number != '-'){
                return false;
            }
        }
        return true;
    }

    public String generatEx(){
        Answer correctAnswer = new Answer();
        LastAnswer = correctAnswer.sum;
        return correctAnswer.strAnsw;
    }

    public SendMessage start(){
        SendMessage msg = new SendMessage();
        if (Isgame == true){
            msg.setText("игра уже идет");
            return msg;
        }
        Isgame = true;
        String startStr = "Ваш пример:\n" + generatEx();
        msg.setText(startStr);
        return msg;
    }

    public SendMessage stop(){
        SendMessage msg = new SendMessage();
        if (Isgame == false){
            msg.setText("игра еще не началась");
            return msg;
        }
        Isgame = false;
        msg.setText("игра окончена\n Вы ответили правильно: " +  score);
        return msg;
    }

    public SendMessage proccesAnswer(String text){
        SendMessage msg = new SendMessage();
        if (Isgame == false){
            return msg;
        }
        if (isDig(text) != true){
            msg.setText("Пожалуста вводите в ответ цифры");
            return msg;
        } else {
            int ans = Integer.parseInt(text);
            String response;
            if (ans == LastAnswer){
                response ="Правильно";
                score += 1;
            }
            else{
                response = "Неправильно! Правильный ответ: " + LastAnswer;
                if (score != 0){
                    score -= 1;
                }
            }
            response += "\n Ваш следующий пример:" + generatEx();
            msg.setText(response);
        }
        return msg;
    }
}
