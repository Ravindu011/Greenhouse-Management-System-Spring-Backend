package com.project.agroplus.AGROPLUS.ProductController;

import com.project.agroplus.AGROPLUS.ProductModel.OnTempModel;
import com.project.agroplus.AGROPLUS.ProductRepository.OnTempRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@Controller
@CrossOrigin("http://localhost:3000")
public class OnTempController {
    @Autowired
    private OnTempRepository onTempRepository;

    @DeleteMapping("/deleteFromOnTemp/{id}")
    public ResponseEntity<String> deleteFromOnTemp(@PathVariable Long id) {
        try {
            if (onTempRepository.existsById(id)) {
                onTempRepository.deleteById(id);
                return new ResponseEntity<>("Entry with id " + id + " deleted successfully.", HttpStatus.OK);
            } else {
                return new ResponseEntity<>("Entry not found", HttpStatus.NOT_FOUND);
            }
        } catch (Exception e) {
            e.printStackTrace();
            return new ResponseEntity<>("Internal Server Error: " + e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping("/firstRowTemp")
    public ResponseEntity<Integer> getFirstRowTemp() {
        try {
            Optional<OnTempModel> firstEntry = onTempRepository.findFirstByOrderByIdAsc();
            if (firstEntry.isPresent()) {
                int temp = firstEntry.get().getTemp();
                return new ResponseEntity<>(temp, HttpStatus.OK);
            } else {
                return new ResponseEntity<>(HttpStatus.NOT_FOUND);
            }
        } catch (Exception e) {
            e.printStackTrace();
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
