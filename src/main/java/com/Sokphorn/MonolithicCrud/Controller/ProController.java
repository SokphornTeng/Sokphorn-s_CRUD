package com.Sokphorn.MonolithicCrud.Controller;

import com.Sokphorn.MonolithicCrud.Model.Entity.Products;
import com.Sokphorn.MonolithicCrud.Model.Request.ProRequest;
import com.Sokphorn.MonolithicCrud.Model.Response.ProResponse;
import com.Sokphorn.MonolithicCrud.Service.ProService;
import jakarta.websocket.server.PathParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@Controller
@RequestMapping("/api")
public class ProController {

    @Autowired
    private ProService proService;

    public ProController(ProService proService) {
        this.proService = proService;
    }

    @PostMapping("/product")
    public ResponseEntity<ProResponse> createPro(@RequestBody ProRequest proRequest) throws Exception {
        Products pro = proService.createPro(proRequest);
        return ResponseEntity.ok(ProResponse.responseListProduct(pro));
    }
    @GetMapping("/listing")
    public ResponseEntity<List<ProResponse>> listing(){
        return ResponseEntity.ok( this.proService.listingProd().stream().map(ProResponse::responseListProduct).toList());
    }
    @PutMapping("/update")
    public ResponseEntity<ProResponse> updatePro(@RequestBody ProRequest proRequest, @PathParam("id") Long id) throws Exception {
        Products pro = this.proService.updatePro(proRequest, id);
        return ResponseEntity.ok(ProResponse.responseListProduct(pro));
    }
    @GetMapping("/find")
    public ResponseEntity<ProResponse> findById(@PathParam("id") Long id) throws Exception {
              Products pro = this.proService.findProductById(id);
         return ResponseEntity.ok(ProResponse.responseListProduct(pro));
    }
    @DeleteMapping("delete")
    public void delete(@PathParam("id") Long id){
       this.proService.deleteProduct(id);
    }
}
