package com.example.firebase;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.expression.spel.ast.Identifier;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Scanner;

@SpringBootApplication
public class FirebaseApplication {
    public static void main(String[] args) throws IOException {

        FileOutputStream fileOutputStream = new FileOutputStream("src/main/resources/a.text",true);
        Scanner scanner = new Scanner(System.in);
        while (true){
            String s = scanner.nextLine();
            fileOutputStream.write(s.getBytes());
            if(s.equals("exit")){
                break;
            }
        }
        fileOutputStream.close();


    }
}
