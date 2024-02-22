package com.example.beckend.Controller;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
@CrossOrigin
@RestController
@RequestMapping("/file")
public class FileController {
    @GetMapping("/{name}")
    public void saveFile(@PathVariable String name, HttpServletResponse response) throws IOException {
        FileInputStream fileInputStream = new FileInputStream("src/main/resources/" + name);
        fileInputStream.transferTo(response.getOutputStream());
        fileInputStream.close();
        response.getOutputStream().close();
    }
    @PostMapping
    public ResponseEntity<?> saveFile(@RequestParam MultipartFile file) throws IOException {
        String originalFilename = file.getOriginalFilename();
        FileOutputStream outputStream = new FileOutputStream("src/main/resources/" + originalFilename);
    outputStream.write(file.getBytes());
    outputStream.close();
    return ResponseEntity.ok(originalFilename);
    }


































}
