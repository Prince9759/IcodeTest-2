package com.files.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;


import com.files.entity.UserFile;

@Repository
public interface FileRepository extends MongoRepository<UserFile,String>{

}
