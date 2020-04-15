package ru.jjd.base.lesson12;

public class SomeMessage {
    private String title;
    private String text;

    public SomeMessage(String title, String text) throws ChatException {
        setTitle(title);//если в методе будет выброшено исключение - объект создан не будет
        setText(text);
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) throws ChatException {
        if (title.length() < 3){
            throw new ChatException("Длина title не может быть меньше 3");
            //это не обработка входящих данных, она предназначена для празработчиков а не для пользователей
        }
        this.title = title;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }
}
