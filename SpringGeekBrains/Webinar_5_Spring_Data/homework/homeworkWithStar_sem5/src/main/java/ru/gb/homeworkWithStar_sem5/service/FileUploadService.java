package ru.gb.homeworkWithStar_sem5.service;

import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;

@Service
public class FileUploadService {

    private static final String UPLOADED_FOLDER = "uploaded-files";

    public void savePart(MultipartFile file, int partNumber) throws IOException {
        Path path = Paths.get(UPLOADED_FOLDER, String.valueOf(partNumber) + ".txt");
        Files.write(path, file.getBytes(), StandardOpenOption.WRITE);
    }

    public byte[] getFileContent(String fileName) throws IOException {
        Path path = Path.of(UPLOADED_FOLDER, fileName);
        return Files.readAllBytes(path);
    }
}