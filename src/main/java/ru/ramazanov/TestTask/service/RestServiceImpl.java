package ru.ramazanov.TestTask.service;

import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import ru.ramazanov.TestTask.domain.FileException;
import ru.ramazanov.TestTask.domain.FindResultEntity;
import ru.ramazanov.TestTask.domain.SystemCode;
import ru.ramazanov.TestTask.repository.FindResultRepository;

import java.util.List;

@AllArgsConstructor
@Controller
public class RestServiceImpl implements RestService {
    private final FindNumberServiceImpl findNumberService;
    private final FindResultRepository findResultRepository;

    @Override
    @RequestMapping(value = "/findNumber/properties/{number}", method = RequestMethod.GET)
    @ResponseBody
    public FindResultEntity findNumberProp(@PathVariable int number) {
        FindResultEntity result = new FindResultEntity();
        result.setNumber(number);
        List<String> processFiles;
        try {
            processFiles = findNumberService.findNumber(number, true);
            if (processFiles.isEmpty()) {
                result = FindResultEntity.builder()
                        .number(number)
                        .sysCode(SystemCode.NOT_FOUND)
                        .build();
            }
            if (!processFiles.isEmpty()) {
                result = FindResultEntity.builder()
                        .number(number)
                        .sysCode(SystemCode.OK)
                        .fileName(processFiles.toString())
                        .build();
            }
        } catch (FileException e) {
            result = FindResultEntity.builder()
                    .number(number)
                    .sysCode(SystemCode.ERROR)
                    .error(e.getMessage())
                    .build();
            result = findResultRepository.save(result);
            return result;
        }
        result = findResultRepository.save(result);
        return result;
    }

    @Override
    @RequestMapping(value = "/findNumber/storage/{number}", method = RequestMethod.GET)
    @ResponseBody
    public FindResultEntity findNumberStorage(@PathVariable int number) {
        FindResultEntity result = new FindResultEntity();
        result.setNumber(number);
        List<String> processFiles;
        try {
            processFiles = findNumberService.findNumber(number, false);
            if (processFiles.isEmpty()) {
                result = FindResultEntity.builder()
                        .number(number)
                        .sysCode(SystemCode.NOT_FOUND)
                        .build();
            }
            if (!processFiles.isEmpty()) {
                result = FindResultEntity.builder()
                        .number(number)
                        .sysCode(SystemCode.OK)
                        .fileName(processFiles.toString())
                        .build();
            }
        } catch (FileException e) {
            result = FindResultEntity.builder()
                    .number(number)
                    .sysCode(SystemCode.ERROR)
                    .error(e.getMessage())
                    .build();
            result = findResultRepository.save(result);
            return result;
        }
        result = findResultRepository.save(result);
        return result;
    }

    @Override
    @RequestMapping(value = "/result", method = RequestMethod.GET)
    @ResponseBody
    public List<FindResultEntity> result() {
        return findResultRepository.findAll();
    }
}
