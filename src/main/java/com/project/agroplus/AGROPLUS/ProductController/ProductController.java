package com.project.agroplus.AGROPLUS.ProductController;

import com.project.agroplus.AGROPLUS.ProductModel.ProductModel;
import com.project.agroplus.AGROPLUS.ProductModel.OnPlantModel;
import com.project.agroplus.AGROPLUS.ProductRepository.HistoryOnPlantRepo;
import com.project.agroplus.AGROPLUS.ProductRepository.OnPlantRepo;
import com.project.agroplus.AGROPLUS.ProductRepository.ProductRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@CrossOrigin("http://localhost:3000")
public class ProductController {
    @Autowired
    private ProductRepo productRepo;

    @Autowired
    private OnPlantRepo onPlantRepo;

    @Autowired
    private HistoryOnPlantRepo historyOnPlantRepo;


    @PutMapping("/setOngoing/{id}")
    public ResponseEntity<ProductModel> setPlantAsOngoing(@PathVariable Long id) {
        Optional<ProductModel> plantData = productRepo.findById(id);
        if (plantData.isPresent()) {
            ProductModel plant = plantData.get();
            plant.setStatus("Ongoing");

            // Also add to the ongoing plant table
            onPlantRepo.save(new OnPlantModel(
                    plant.getPID(),
                    plant.getpName(),
                    plant.getTemp(),
                    plant.getHumidity(),
                    plant.getDaysToGrow(),
                    plant.getStatus()
            ));
            productRepo.save(plant);

            return new ResponseEntity<>(plant, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
    @PostMapping("/addNewPlant")
    ProductModel addNewPlant(@RequestBody ProductModel newPlant){
        return productRepo.save(newPlant);
    }


//    @PutMapping("/removeOn/{id}")
//    public ResponseEntity<ProductModel> removeOn(@PathVariable Long id) {
//        Optional<ProductModel> plantData = productRepo.findById(id);
//        if (plantData.isPresent()) {
//            ProductModel plant = plantData.get();
//            plant.setStatus("Ongoing");
//
//            // Also add to the ongoing plant table
//            historyOnPlantRepo.save(new HistoryOnPlantModel(
//                    plant.getPID(),
//                    plant.getpName(),
//                    plant.getTemp(),
//                    plant.getHumidity(),
//                    plant.getDaysToGrow(),
//                    plant.getStatus()
//            ));
//            productRepo.save(plant);
//
//            return new ResponseEntity<>(plant, HttpStatus.OK);
//        } else {
//            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
//        }
//    }



}
