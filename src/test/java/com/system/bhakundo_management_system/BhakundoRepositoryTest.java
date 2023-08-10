package com.system.bhakundo_management_system;

import com.system.bhakundo_management_system.Repo.BhakundoRepo;
import com.system.bhakundo_management_system.entity.Bhakundo;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.core.annotation.Order;

@DataJpaTest
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class BhakundoRepositoryTest {
    @Autowired
    private BhakundoRepo bhakundoRepo;


    @Test
    @Order(1)
    public void savebhakundoTest() {

        Bhakundo bhakundo = Bhakundo.builder()
                .bhakundoname("rak")
                .bhakundocontact("123454")
                .bhakundoprice("98888888")
                .build();


        bhakundoRepo.save(bhakundo);

        Assertions.assertThat(bhakundo.getBhakundo_Id()).isGreaterThan(0);
    }

    @Test
    @Order(4)
    public void updatebhakundoTest(){

        Bhakundo bhakundo = Bhakundo.builder()
                .bhakundoname("rak")
                .bhakundocontact("123454")
                .bhakundoprice("98888888")
                .build();


        bhakundoRepo.save(bhakundo);

        Bhakundo bhakundo1 = bhakundoRepo.findById(bhakundo.getBhakundo_Id()).get();

        bhakundo1.setBhakundocontact("13265");

        Bhakundo bhakundoupdated  = bhakundoRepo.save(bhakundo);

        Assertions.assertThat(bhakundoupdated.getBhakundocontact()).isEqualTo("85207410");

    }
}