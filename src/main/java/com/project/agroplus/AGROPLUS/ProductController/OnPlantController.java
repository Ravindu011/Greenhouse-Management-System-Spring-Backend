package com.project.agroplus.AGROPLUS.ProductController;

import com.project.agroplus.AGROPLUS.PlantService.PlantService;
import com.project.agroplus.AGROPLUS.ProductModel.HistoryOnPlantModel;
import com.project.agroplus.AGROPLUS.ProductModel.OnPlantModel;
import com.project.agroplus.AGROPLUS.ProductModel.OnTempModel;
import com.project.agroplus.AGROPLUS.ProductModel.ProductModel;
import com.project.agroplus.AGROPLUS.ProductRepository.HistoryOnPlantRepo;
import com.project.agroplus.AGROPLUS.ProductRepository.OnPlantRepo;
import com.project.agroplus.AGROPLUS.ProductRepository.OnTempRepository;
import com.project.agroplus.AGROPLUS.ProductRepository.ProductRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;
@RestController
@CrossOrigin("http://localhost:3000")
public class OnPlantController {
    @Autowired
    private OnPlantRepo onPlantRepo;

    @Autowired
    private HistoryOnPlantRepo historyOnPlantRepo;

    @Autowired
    private PlantService plantService;


    @PutMapping("/moveToHistory/{id}")
    public ResponseEntity<OnPlantModel> moveToHistory(@PathVariable Long id) {
        Optional<OnPlantModel> plantData = onPlantRepo.findById(id);
        if (plantData.isPresent()) {
            OnPlantModel plant = plantData.get();
            plant.setStatus("Standby");

            // Add to the history table
            historyOnPlantRepo.save(new HistoryOnPlantModel(
                    plant.getPID(),
                    plant.getpName(),
                    plant.getTemp(),
                    plant.getHumidity(),
                    plant.getDaysToGrow(),
                    plant.getStatus()
            ));

            return new ResponseEntity<>(plant, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

//    @DeleteMapping("/removeFromOngoing/{id}")
//    public ResponseEntity<?> removeFromOngoing(@PathVariable Long id) {
//        try {
//            if (onPlantRepo.existsById(id)) {
//                onPlantRepo.deleteById(id);
//                return new ResponseEntity<>(id+" Was Deleted", HttpStatus.OK);
//            } else {
//                return new ResponseEntity<>("Plant not found", HttpStatus.NOT_FOUND);
//            }
//        } catch (Exception e) {
//            e.printStackTrace();
//            return new ResponseEntity<>("Internal Server Error: " + e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
//        }
//    }

    @Autowired
    private OnTempRepository onTempRepository; // Inject OnTempRepository

//    @DeleteMapping("/removeFromOngoing/{id}")
//    public ResponseEntity<?> removeFromOngoing(@PathVariable Long id) {
//        try {
//            if (onPlantRepo.existsById(id)) {
//                // First, find the corresponding OnPlantModel
//                Optional<OnPlantModel> onPlantData = onPlantRepo.findById(id);
//                if (onPlantData.isPresent()) {
//                    OnPlantModel onPlant = onPlantData.get();
//
//                    // Find and delete the corresponding OnTempModel
//                    Optional<OnTempModel> onTempData = onTempRepository.findById(onPlant.getPID());
//                    if (onTempData.isPresent()) {
//                        onPlantRepo.deleteById(onPlant.getPID());
//                    }
//
//                    // Delete the OnPlantModel entry
//                    onPlantRepo.deleteById(id);
//                    return new ResponseEntity<>(id + " Was Deleted", HttpStatus.OK);
//                } else {
//                    return new ResponseEntity<>("Ongoing plant not found", HttpStatus.NOT_FOUND);
//                }
//            } else {
//                return new ResponseEntity<>("Ongoing plant not found", HttpStatus.NOT_FOUND);
//            }
//        } catch (Exception e) {
//            e.printStackTrace();
//            return new ResponseEntity<>("Internal Server Error: " + e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
//        }
//    }


    @Autowired
    private ProductRepo productRepository; // Inject ProductRepository

    @DeleteMapping("/removeFromOngoing/{id}")
    public ResponseEntity<?> removeFromOngoing(@PathVariable Long id) {
        try {
            // Check if the OnPlantModel exists
            Optional<OnPlantModel> onPlantData = onPlantRepo.findById(id);
            if (onPlantData.isPresent()) {
                OnPlantModel onPlant = onPlantData.get();

                // 1. Delete the corresponding OnTempModel entry
                Optional<OnTempModel> onTempData = onTempRepository.findById(onPlant.getPID());
                if (onTempData.isPresent()) {
                    onTempRepository.deleteById(onPlant.getPID());
                }

                // 2. Update the status of the plant in the ProductModel to "Standby"
                Optional<ProductModel> productData = productRepository.findById(onPlant.getPID());
                if (productData.isPresent()) {
                    ProductModel product = productData.get();
                    product.setStatus("Standby");
                    productRepository.save(product);
                }

                // 3. Delete the OnPlantModel entry
                onPlantRepo.deleteById(id);

                return new ResponseEntity<>(id + " was deleted and status updated to Standby", HttpStatus.OK);
            } else {
                return new ResponseEntity<>("Ongoing plant not found", HttpStatus.NOT_FOUND);
            }
        } catch (Exception e) {
            e.printStackTrace();
            return new ResponseEntity<>("Internal Server Error: " + e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
    @GetMapping("/getAllOnProduct")
    public List<OnPlantModel> getAllOngoing(){
        return plantService.findOnPlants();
    }

}
