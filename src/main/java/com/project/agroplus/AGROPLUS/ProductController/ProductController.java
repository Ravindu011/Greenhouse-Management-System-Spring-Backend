package com.project.agroplus.AGROPLUS.ProductController;

import com.project.agroplus.AGROPLUS.PlantService.PlantService;
import com.project.agroplus.AGROPLUS.ProductModel.ProductModel;
import com.project.agroplus.AGROPLUS.ProductModel.OnPlantModel;
import com.project.agroplus.AGROPLUS.ProductRepository.HistoryOnPlantRepo;
import com.project.agroplus.AGROPLUS.ProductRepository.OnPlantRepo;
import com.project.agroplus.AGROPLUS.ProductRepository.ProductRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
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

    @Autowired
    public PlantService plantService;


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

    @GetMapping("/viewProduct/{id}")
    public ResponseEntity<ProductModel> viewProduct(@PathVariable Long id) {
        Optional<ProductModel> productData = productRepo.findById(id);
        if (productData.isPresent()) {
            return new ResponseEntity<>(productData.get(), HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @GetMapping("/getAllProduct")
    public List<ProductModel> getAllProduct(){
        return plantService.findAllPlants();
    }

    @DeleteMapping("/removePlant/{id}")
    public ResponseEntity<?> removePlant(@PathVariable Long id) {
        try {
            if (productRepo.existsById(id)) {
                productRepo.deleteById(id);
                return new ResponseEntity<>(id+" Was Deleted", HttpStatus.OK);


            } else {
                return new ResponseEntity<>("Plant not found", HttpStatus.NOT_FOUND);
            }
        } catch (Exception e) {
            // Log the exception (you can use a logging framework like SLF4J)
            e.printStackTrace();
            return new ResponseEntity<>("Internal Server Error: " + e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PutMapping("/updatePlant/{id}")
    public ProductModel updateProduct(@PathVariable Long id, @RequestBody ProductModel updatedPlant) {
        return plantService.updatePlant(id, updatedPlant);
    }


}
