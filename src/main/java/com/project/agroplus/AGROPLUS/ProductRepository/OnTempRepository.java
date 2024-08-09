package com.project.agroplus.AGROPLUS.ProductRepository;

import com.project.agroplus.AGROPLUS.ProductModel.OnTempModel;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface OnTempRepository extends JpaRepository<OnTempModel, Long> {
    OnTempModel findByTempAndHumidity(int temp, int humidity);
    Optional<OnTempModel> findFirstByOrderByIdAsc();
}

