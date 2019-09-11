package ru.ramazanov.TestTask.service;

import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import ru.ramazanov.TestTask.domain.FileException;

import javax.validation.Valid;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

@AllArgsConstructor
@Service
public class FindNumberServiceImpl implements FindNumberService {

    private final FileServiceImpl fileService;
    @Value("${list_files}")
    private List<String> fileArray;


    public List<String> findNumber(Integer number, boolean fromProp) throws FileException {
        List<String> findFiles = new ArrayList<>();
        if (fromProp) {
            for (String s : fileArray) {
                if (fileService.fileProcessor(s, number)) {
                    findFiles.add(s);
                }
            }
        } else {
            List<String> files = fileService.findFiles();
            for (String s : files) {
                if (fileService.fileProcessor(s, number)) {
                    findFiles.add(s);
                }
            }
        }
        return findFiles;
    }
}
