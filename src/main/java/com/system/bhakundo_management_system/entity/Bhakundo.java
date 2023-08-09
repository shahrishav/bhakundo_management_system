package com.system.bhakundo_management_system.entity;



import jakarta.persistence.*;
import lombok.*;

@Builder
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "Bhakundo")

public class Bhakundo {
    @Id
    @SequenceGenerator(name = "shb_product_seq_gen", sequenceName = "shb_product_id_seq", allocationSize = 1)
    @GeneratedValue(generator = "shb_product_seq_gen", strategy = GenerationType.SEQUENCE)
    private Integer bhakundo_Id;

    private String bhakundoname;

    private String bhakundoprice;

    private String bhakundocontact;

    private String bhakundolocation;

    private String bhakundoimage;
    private String bhakundoimage1;
    private String bhakundoimage2;
@Column(length=1000)
    private String Description;

    @Transient
    private String imageBase64;

    @Transient
    private String image1Base64;


    @Transient
    private String image2Base64;

}
