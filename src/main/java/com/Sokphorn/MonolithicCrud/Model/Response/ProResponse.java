package com.Sokphorn.MonolithicCrud.Model.Response;

import com.Sokphorn.MonolithicCrud.Model.Entity.Products;
import lombok.Data;

import java.io.Serializable;

@Data
public class ProResponse  implements Serializable {

    private Long id;
    private String proName;
    private String proCountry;
    private String quality;

    public ProResponse(Long id, String proName, String proCountry, String quality) {
        this.id = id;
        this.proName = proName;
        this.proCountry = proCountry;
        this.quality = quality;
    }

    public static ProResponse responseListProduct(Products pro){
        return new ProResponse(
                pro.getId(),
                pro.getProName(),
                pro.getProCountry(),
                pro.getQuality()
        );
    }

}
