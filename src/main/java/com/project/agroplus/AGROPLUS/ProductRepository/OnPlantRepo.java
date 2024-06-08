package com.project.agroplus.AGROPLUS.ProductRepository;

import com.project.agroplus.AGROPLUS.ProductModel.OnPlantModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface OnPlantRepo extends JpaRepository <OnPlantModel, Long> {
}
