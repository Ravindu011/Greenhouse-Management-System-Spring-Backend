package com.project.agroplus.AGROPLUS.PlantService;

import com.project.agroplus.AGROPLUS.ProductModel.OnPlantModel;
import com.project.agroplus.AGROPLUS.ProductModel.ProductModel;
import com.project.agroplus.AGROPLUS.ProductRepository.OnPlantRepo;
import com.project.agroplus.AGROPLUS.ProductRepository.ProductRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class PlantService {

    @Autowired
    private ProductRepo productRepo;

    @Autowired
    private OnPlantRepo onPlantRepo;

    public List<ProductModel> findAllPlants (){
        return productRepo.findAll();
    }

    public List<OnPlantModel> findOnPlants (){
        return onPlantRepo.findAll();
    }

    public ProductModel updatePlant(Long id, ProductModel updatedPlant) {
        updatedPlant.setPID(id);
        return productRepo.save(updatedPlant);
    }






}
