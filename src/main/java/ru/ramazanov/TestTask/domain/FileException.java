package ru.ramazanov.TestTask.domain;

import lombok.Getter;

/**
 * Кастомное исключение для обработки ошибок
 */
@Getter
public class FileException extends RuntimeException {
    public FileException(String message){
        super(message);
    }
}
