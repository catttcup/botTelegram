package command;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class HandlerNodeTest {
    private final HandlerNode handlerNode = new HandlerNode();

    @Test
    void checkCommandAbout() {
        String query = "/about";
        String result = handlerNode.checkCommand(query).getText();
        String equalResult = "потом допишем";
        Assertions.assertEquals(result, equalResult);
    }

    @Test
    void checkCommandEchoWithEmptyMessage() {
        String query = "/echo";
        String result = handlerNode.checkCommand(query).getText();
        String equalResult = "Введите что-нибудь, чтобы бот вывел то же самое)";
        Assertions.assertEquals(result, equalResult);
    }

    @Test
    void checkCommandEchoWithNotEmptyMessage() {
        String query = "/echo Привет я бот";
        String result = handlerNode.checkCommand(query).getText();
        Assertions.assertEquals(result, query.split(" ", 2)[1]);
    }

    @Test
    void checkCommandHelpWithEmptyMessage() {
        String query = "/help";
        String result = handlerNode.checkCommand(query).getText();
        String equalResult = """
                Бот имеет следующие команды\s
                /about
                /start
                /echo
                Для познания работы команды нажмите на соответствующую кнопку""";
        Assertions.assertEquals(result, equalResult);
    }

    @Test
    void checkCommandHelpAbout() {
        String query = "/help about";
        String result = handlerNode.checkCommand(query).getText();
        String equalResult = "Эта команда, рассказывает о боте и его создателях.";
        Assertions.assertEquals(result, equalResult);
    }

    @Test
    void checkCommandHelpEcho() {
        String query = "/help echo";
        String result = handlerNode.checkCommand(query).getText();
        String equalResult = "Выводит то, что вы введете после echo";
        Assertions.assertEquals(result, equalResult);
    }

    @Test
    void checkCommandHelpStart() {
        String query = "/help start";
        String result = handlerNode.checkCommand(query).getText();
        String equalResult = "Действительно ли надо писать help для этой команды?)";
        Assertions.assertEquals(result, equalResult);
    }

    @Test
    void checkCommandHelpHelp() {
        String query = "/help help";
        String result = handlerNode.checkCommand(query).getText();
        String equalResult = "Показывает список команд, доступных в боте";
        Assertions.assertEquals(result, equalResult);
    }
    
}