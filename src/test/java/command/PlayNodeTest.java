package command;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class PlayNodeTest {
    private final PlayNode playNode = new PlayNode();
    private final Long user_id = 123L;

    /*
     * тест на проверку идет ли игра
     */
    @Test
    void TestTestForNotGame() {

        String result = playNode.doCommand("stop", user_id).getText();
        String equalsResult = "игра еще не началась";
        Assertions.assertEquals(equalsResult, result);

    }

    /*
     * тест на проверку команды start для начала игры
     */
    @Test
    void testStartForGameReady() {
        String result = playNode.doCommand("start", user_id).getText();
        Assertions.assertTrue(result.startsWith("Ваш пример:\n"));
    }

    /*
    * тест на проверку команды stop во время игры
    */
    @Test
    void testStopForGameReady() {
        playNode.doCommand("start", user_id).getText();
        String result2 = playNode.doCommand("stop", user_id).getText();
        String equString = "игра окончена\n Вы ответили правильно: 0";
        Assertions.assertEquals(equString, result2);
    }

    /*
    * тест на проверку start
    */
    @Test
    void testCorrectStart() {
        String result = playNode.doCommand("start", user_id).getText();
        String primer = result.split("\n")[1];
        int num1 = Integer.parseInt(primer.split(" ")[0]);
        int num2 = Integer.parseInt(primer.split(" ")[2]);
        int sum=0;
        String opers = primer.split(" ")[1];
        if (opers.equals("+")){
            sum = num1 + num2;
        }else if (opers.equals("-")){
            sum = num1 - num2;
        }else if (opers.equals("*")){
            sum = num1 * num2;
        }else {
            Assertions.assertTrue(false);
        }
        String result01 = playNode.doCommand(Integer.toString(sum), user_id).getText();
        String primer01 = "Правильно\n Ваш следующий пример:";
        Assertions.assertTrue(result01.startsWith(primer01));
    }
}
