package ru.gb.homeworkWithStar_sem5.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import ru.gb.homeworkWithStar_sem5.service.FileUploadService;

import java.io.IOException;

@Controller
@RestController
@RequestMapping("/api/files")
public class FileController {
    private static final String UPLOADED_FOLDER = "uploaded-files";

    @Autowired
    private FileUploadService fileUploadService;

    @GetMapping("/upload-file")
    public String getUploadFilePage() {
        return "upload-file";
    }

    @PostMapping("/{partNumber}")
    public ResponseEntity<String> savePart(@PathVariable("partNumber") int partNumber,
                                           @RequestParam("file") MultipartFile file) throws IOException {
        fileUploadService.savePart(file, partNumber);
        return new ResponseEntity<>("File part uploaded successfully", HttpStatus.OK);
    }

    @GetMapping("/{fileName}")
    public ResponseEntity<byte[]> getFileContent(@PathVariable("fileName") String fileName) throws IOException {
        return ResponseEntity.ok(fileUploadService.getFileContent(fileName));
    }
}