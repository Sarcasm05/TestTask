package ru.ramazanov.TestTask.service;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import ru.ramazanov.TestTask.domain.FileException;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.Arrays;
import java.util.List;

@Service
public class FileServiceImpl implements FileService {
    @Value("${default_path}")
    private String path;

    @Override
    public List<String> findFiles() throws FileException {
        List<String> files;
        File dir = new File(path);
        String[] matches = dir.list();
        if (matches == null) {
            throw new FileException("no file is found");
        } else if (matches.length != 20) {
            throw new FileException("number of files not equals 20");
        } else {
            files = Arrays.asList(matches);
        }
        return files;
    }

    @Override
    public Boolean fileProcessor(String name, Integer i) throws FileException {

        File file = new File(path + name);
        try {
            FileReader fileReader = new FileReader(file);
            BufferedReader bufferedReader = new BufferedReader(fileReader);

            String line;
            while ((line = bufferedReader.readLine()) != null) {
                for (String num : line.split(",")) {
                    if (i.toString().equals(num)) {
                        return true;
                    }
                }
            }

            bufferedReader.close();
            fileReader.close();
        } catch (IOException e) {
            throw new FileException("file not found");
        }
        return false;
    }

}
