package com.project.agroplus.AGROPLUS.ProductRepository;

import com.project.agroplus.AGROPLUS.ProductModel.HistoryOnPlantModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface HistoryOnPlantRepo extends JpaRepository<HistoryOnPlantModel,Long> {
}
