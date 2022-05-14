package com.example.th2.repository;

import com.example.th2.entity.ProductEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;
import java.util.List;


@Repository
@Transactional
public interface ProductRepository extends JpaRepository<ProductEntity,String> {

    @Modifying
    @Query(value="SELECT * FROM product WHERE code = :code  ", nativeQuery = true)
    List<ProductEntity> findProductEntityByID(@Param("code") String code);
    @Modifying
    @Query(value="UPDATE product  SET code = :code, description = :description  , price = :price  WHERE code = :code", nativeQuery = true)
    void updateProductEntity(@Param("code") String code, @Param("description") String description, @Param("price") double price);
}
