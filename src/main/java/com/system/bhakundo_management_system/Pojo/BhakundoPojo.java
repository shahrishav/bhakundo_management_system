package com.system.bhakundo_management_system.Pojo;

import com.system.bhakundo_management_system.entity.Bhakundo;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.web.multipart.MultipartFile;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor

public class
BhakundoPojo {
    private Integer fid;
    private String fname;
    private String fcontact;
    private  String fprice;
    private String flocation;
    private MultipartFile image;
    private MultipartFile image1;
    private MultipartFile image2;
    private String Description;


    public BhakundoPojo(Bhakundo bhakundo) {
        this.fid = bhakundo.getBhakundo_Id();
        this.fname = bhakundo.getBhakundoname();
        this.fcontact= bhakundo.getBhakundocontact();
        this.fprice = bhakundo.getBhakundoprice();
        this.flocation = bhakundo.getBhakundolocation();
        this.Description = bhakundo.getDescription();

    }
}