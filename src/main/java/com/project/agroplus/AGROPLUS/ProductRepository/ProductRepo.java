package com.project.agroplus.AGROPLUS.ProductRepository;
import com.project.agroplus.AGROPLUS.ProductModel.ProductModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProductRepo extends JpaRepository<ProductModel, Long> {
}
