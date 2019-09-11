package ru.ramazanov.TestTask.domain;

/**
 * Перечисление с вариантами системных сообщений
 */
public enum SystemCode {


    OK ("00","Result.OK"),
    NOT_FOUND ("01","Result.NotFound"),
    ERROR ("02", "Result.Error");

    /**
     * @param code - код сообщения
     * @param message - сообщение при коде
     */
    private String code;
    private String message;

    SystemCode(String code,String message){
        this.code = code;
        this.message = message;
    }

    public String getMessage(){
        return message;
    }

    public String getCode(){
        return code;
    }

    @Override
    public String toString() {
        return code + "."+ message;
    }

}
