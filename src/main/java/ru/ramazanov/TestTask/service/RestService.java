package ru.ramazanov.TestTask.service;

import ru.ramazanov.TestTask.domain.FindResultEntity;

import java.util.List;

/**
 * Rest контролер для поиска
 */

public interface RestService {

    /**
     * поиск числа в соответствии со списком заданым в настройках приложения /findNumber/properties/{number}
     * @param number число для поиска
     * @return результат поиска после записи в бд
     *
     * @see FindResultEntity
     */
    FindResultEntity findNumberProp(int number);

    /**
     *  поиск числа в соответствии  хранилище заданым в настройках приложения /findNumber/storage/{number}
     * @param number число для поиска
     * @return результат поиска после записи в бд
     */
    FindResultEntity findNumberStorage(int number);

    /**
     * Список всех поисков сохранненых в бд /result
     * @return Список всех поисков сохранненых в бд
     */
    List<FindResultEntity> result();
}
