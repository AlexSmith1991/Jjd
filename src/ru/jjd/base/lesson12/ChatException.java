package ru.jjd.base.lesson12;
//если необходимо создать собственное необрабатываемое исключение, то класс должен наследоваться от RuntimeException
//если необходимо создать собственное обрабатываемое исключение, то класс должен наследоваться от Exception
public class ChatException extends Exception{
    //можно описать любое количество свойств и методов
    //также можно переопределять методы и свойства родителя, расширять их или использовать свою реализацию

    public ChatException(String message) {
        super(message);
    }

    @Override
    public String getMessage() {
        return super.getMessage() + "Следите за кодом!!!";
    }
}
