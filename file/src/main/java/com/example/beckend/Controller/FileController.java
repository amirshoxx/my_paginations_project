package com.example.beckend.Controller;

import com.example.beckend.Entity.User;
import jakarta.servlet.ServletOutputStream;
import jakarta.servlet.http.HttpServletResponse;
import lombok.SneakyThrows;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.UUID;

@RestController
@CrossOrigin
@RequestMapping("/file")
public class FileController {
    @PostMapping
    public String saveFile(@RequestParam MultipartFile file) throws IOException {
        String s = UUID.randomUUID() + file.getOriginalFilename();
        FileOutputStream fileOutputStream = new FileOutputStream("src/main/resources/"+s );
        fileOutputStream.write(file.getBytes());
        fileOutputStream.close();
        return s;
    }
    @SneakyThrows
    @GetMapping("/{name}")
    public void getFile(@PathVariable String  name, HttpServletResponse response){
        FileInputStream fileInputStream = new FileInputStream("src/main/resources/" + name);
        ServletOutputStream outputStream = response.getOutputStream();
        fileInputStream.transferTo(outputStream);
        outputStream.close();
        fileInputStream.close();
    }
    @PutMapping(path = "/{id}")
    public User editFile(@PathVariable Integer id, @RequestParam MultipartFile file, @RequestBody User user) throws IOException {
        if (file != null && !file.isEmpty()) {
            String newFileName = UUID.randomUUID() + file.getOriginalFilename();
            FileOutputStream fileOutputStream = new FileOutputStream("src/main/resources/" + newFileName);
            fileOutputStream.write(file.getBytes());
            fileOutputStream.close();
            user.setImg(newFileName);
        }
        return user;
    }
    @DeleteMapping("/{name}")
    public void deleteFile(@PathVariable String name){
        File file = new File("src/main/resources/"+name);
        file.delete();
    }
}
