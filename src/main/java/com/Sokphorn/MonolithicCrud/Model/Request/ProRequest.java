package com.Sokphorn.MonolithicCrud.Model.Request;

import com.Sokphorn.MonolithicCrud.Model.Entity.Products;
import lombok.Data;

import java.io.Serializable;

@Data
public class ProRequest implements Serializable {

    private String proName;
    private String proCountry;
    private String quality;

    public Products createProRequest(){
        Products pro = new Products();
        pro.setProName(this.proName);
        pro.setProCountry(this.proCountry);
        pro.setQuality(this.quality);
        return pro;
    }

}
