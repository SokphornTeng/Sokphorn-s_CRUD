package com.Sokphorn.MonolithicCrud.Service;

import com.Sokphorn.MonolithicCrud.Model.Entity.Products;
import com.Sokphorn.MonolithicCrud.Model.Request.ProRequest;
import com.Sokphorn.MonolithicCrud.Repository.ProRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ProService {

    @Autowired
    private final ProRepo proRepo;

    public ProService(ProRepo proRepo) {
        this.proRepo = proRepo;
    }

    public Products createPro(ProRequest proRequest) throws Exception {
        Products pro = proRequest.createProRequest();
        if(this.proRepo.existsByProName(pro.getProName())){
            throw new Exception("Product Name is already exists");
        }
        try {
            return this.proRepo.save(pro);
        } catch (Exception e){
            throw new Exception(e);
        }
    }

    public Products updatePro(ProRequest proRequest, Long id) throws Exception {
        Optional<Products> pro = this.proRepo.findById(id);
        if(pro.isPresent()) {
            Products newPro = pro.get();
            newPro.setProName(proRequest.getProName());
            newPro.setProCountry(proRequest.getProCountry());
            newPro.setQuality(proRequest.getQuality());
            return this.proRepo.save(newPro);
        } else {
            throw new Exception("Product id not found");
        }

    }

    public List<Products> listingProd(){
        return this.proRepo.findAll();
    }

    public Products findProductById(Long id) throws Exception {
          return this.proRepo.findById(id).orElseThrow(() -> new Exception("Product Id not found"));
    }

    public void deleteProduct(Long id){
         this.proRepo.deleteById(id);
         System.out.println("Product already delete");
    }
}
