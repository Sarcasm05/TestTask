package ru.ramazanov.TestTask.service;

import ru.ramazanov.TestTask.domain.FileException;

import java.util.List;

/**
 * Сервис отвечающий за работу с файлами
 */
public interface FileService {

    /**
     * поиск файлов в локальном хранилище
     * @return возвращает список фалов при удовлетворени параметрам
     * @throws FileException ошибки связанные с хранилищем файлов
     */
    List<String> findFiles() throws FileException;

    /**
     * поиск в заданном файле заданного числа
     * @param name имя файла 
     * @param i число для поиска
     * @return наличие в файле данного числа
     * @throws FileException ошибки связанные с хранилищем файлов
     */
    Boolean fileProcessor(String name, Integer i) throws FileException;
}
