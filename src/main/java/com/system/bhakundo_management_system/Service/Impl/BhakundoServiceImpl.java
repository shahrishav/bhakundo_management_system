package com.system.bhakundo_management_system.Service.Impl;


import com.system.bhakundo_management_system.Pojo.BhakundoPojo;
import com.system.bhakundo_management_system.Repo.BhakundoRepo;
import com.system.bhakundo_management_system.Service.BhakundoService;
import com.system.bhakundo_management_system.entity.Bhakundo;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Base64;
import java.util.List;

@Service
@RequiredArgsConstructor
public class BhakundoServiceImpl implements BhakundoService {

    private final BhakundoRepo bhakundoRepo;

    public static String UPLOAD_DIRECTORY = System.getProperty("user.dir") + "/images/";


    @Override
    public BhakundoPojo savebhakundo(BhakundoPojo bhakundoPojo) throws IOException {
        Bhakundo bhakundo = new Bhakundo();
        if (bhakundoPojo.getFid()!= null){
            bhakundo.setBhakundo_Id(bhakundoPojo.getFid());
        }
        bhakundo.setBhakundoname(bhakundoPojo.getFname());
        bhakundo.setBhakundoprice(bhakundoPojo.getFprice());
        bhakundo.setBhakundocontact(bhakundoPojo.getFcontact());
        bhakundo.setBhakundolocation(bhakundoPojo.getFlocation());
        bhakundo.setDescription(bhakundoPojo.getDescription());



        if(bhakundoPojo.getImage1()!=null){
//            System.out.println(UPLOAD_DIRECTORY);
            StringBuilder fileNames = new StringBuilder();
            Path fileNameAndPath = Paths.get(UPLOAD_DIRECTORY, bhakundoPojo.getImage1().getOriginalFilename());
            fileNames.append(bhakundoPojo.getImage1().getOriginalFilename());
            Files.write(fileNameAndPath, bhakundoPojo.getImage1().getBytes());

            bhakundo.setBhakundoimage1(bhakundoPojo.getImage1().getOriginalFilename());
        }
        if(bhakundoPojo.getImage2()!=null){
//            System.out.println(UPLOAD_DIRECTORY);
            StringBuilder fileNames = new StringBuilder();
            Path fileNameAndPath = Paths.get(UPLOAD_DIRECTORY, bhakundoPojo.getImage2().getOriginalFilename());
            fileNames.append(bhakundoPojo.getImage2().getOriginalFilename());
            Files.write(fileNameAndPath, bhakundoPojo.getImage2().getBytes());

            bhakundo.setBhakundoimage2(bhakundoPojo.getImage2().getOriginalFilename());
        }
        if(bhakundoPojo.getImage()!=null){
//            System.out.println(UPLOAD_DIRECTORY);
            StringBuilder fileNames = new StringBuilder();
            Path fileNameAndPath = Paths.get(UPLOAD_DIRECTORY, bhakundoPojo.getImage().getOriginalFilename());
            fileNames.append(bhakundoPojo.getImage().getOriginalFilename());
            Files.write(fileNameAndPath, bhakundoPojo.getImage().getBytes());

            bhakundo.setBhakundoimage(bhakundoPojo.getImage().getOriginalFilename());
        }
        bhakundoRepo.save(bhakundo);
        return new BhakundoPojo(bhakundo);
    }

    @Override
    public Bhakundo fetchById(Integer id) {
        Bhakundo bhakundo = bhakundoRepo.findById(id).orElseThrow(()-> new RuntimeException("Couldnot find"));
        bhakundo = Bhakundo.builder()
                .bhakundo_Id(bhakundo.getBhakundo_Id())
                .imageBase64(getImageBase64(bhakundo.getBhakundoimage()))
                .image1Base64(getImageBase64(bhakundo.getBhakundoimage1()))
                .image2Base64(getImageBase64(bhakundo.getBhakundoimage2()))
                .bhakundoname(bhakundo.getBhakundoname())
                .bhakundocontact(bhakundo.getBhakundocontact())
                .bhakundoprice(bhakundo.getBhakundoprice())
                . bhakundolocation(bhakundo.getBhakundolocation())
                .Description(bhakundo.getDescription())
                .build();
        return bhakundo;
    }

    public String getImageBase64(String fileName) {
        String filePath = System.getProperty("user.dir") + "/images/";
        File file = new File(filePath + fileName);
        byte[] bytes;
        try {
            bytes = Files.readAllBytes(file.toPath());
        } catch (IOException e) {
            e.printStackTrace();
            return null;
        }
        return Base64.getEncoder().encodeToString(bytes);
    }

    @Override
    public List<Bhakundo> fetchAll() {
        return bhakundoRepo.findAll();
    }

    @Override
    public void deleteById(Integer id) {
        bhakundoRepo.deleteById(id);
    }

}
