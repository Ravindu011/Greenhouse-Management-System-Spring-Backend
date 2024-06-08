package com.project.agroplus.AGROPLUS.ProductController;

import com.project.agroplus.AGROPLUS.ProductRepository.HistoryOnPlantRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin("http://localhost:3000")
public class HistoryOnPlantController {
    @Autowired
    private HistoryOnPlantRepo historyOnPlantRepo;


}
