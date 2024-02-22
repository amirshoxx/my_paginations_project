package com.example.jdbs;

import com.example.jdbs.dto.StudentDto;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.sql.SQLException;
import java.util.List;

@RestController
@CrossOrigin
@RequestMapping("/student")
public class Controller {

    @GetMapping
    public ResponseEntity<?> getStudents() throws SQLException {
        return ResponseEntity.status(200).body(Db.getStudents());
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> getStudent(@PathVariable Long id) throws SQLException {
        return ResponseEntity.status(200).body(Db.getOneStudent(id));
    }

    @PostMapping
    public ResponseEntity<?> saveStudent(@RequestBody StudentDto student) throws SQLException {
        Db.saveStudent(student);
        return ResponseEntity.status(200).body("added");
    }


    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteStudent(@PathVariable Long id) throws SQLException {
        Db.deleteStudent(id);
        return ResponseEntity.status(200).body("deleted");
    }

    @PutMapping("/{id}")
    public ResponseEntity<?> updateStudent(@PathVariable Long id, @RequestBody StudentDto updatedStudent) throws SQLException {
        Db.updateStudent(id, updatedStudent);
        return ResponseEntity.status(200).body("updated");
    }

    @GetMapping("/search")
    public ResponseEntity<?> searchStudent(@RequestParam String name) throws SQLException {
        List<Student> students = Db.searchStudents(name);
        return ResponseEntity.status(200).body(students);
    }

    @PutMapping("/plus")
    public ResponseEntity<?> updateAge(@RequestParam Integer age,@RequestParam Long id) throws SQLException {
        Db.updateAgePlus(id,age);
        return ResponseEntity.status(200).body("Plus");
    }
    @PutMapping("/minus")
    public ResponseEntity<?> updateAges(@RequestParam Integer age,@RequestParam Long id) throws SQLException {
        Db.updateAgeMinus(id,age);
        return ResponseEntity.status(200).body("Minus");
    }

}
