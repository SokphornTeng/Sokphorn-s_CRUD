package com.Sokphorn.MonolithicCrud.Repository;

import com.Sokphorn.MonolithicCrud.Model.Entity.Products;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProRepo extends JpaRepository<Products, Long> {

    Boolean existsByProName(String proName);

}
