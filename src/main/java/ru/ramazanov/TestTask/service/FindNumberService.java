package ru.ramazanov.TestTask.service;

import ru.ramazanov.TestTask.domain.FileException;

import java.util.List;

/**
 * Сервис отвечающий за посик и работу с хранилищем
 */

public interface FindNumberService {

    /**
     * Основная функция поиска в числа
     * @param number число для поиска
     * @param fromProp выбор списка фалов для поиска
     * @return список фалов в которых найдено число
     * @throws FileException передача ошшибки для обработки
     */
    List<String> findNumber(Integer number, boolean fromProp) throws FileException;
}
