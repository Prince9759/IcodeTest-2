package com.files.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import com.files.entity.UserFile;
import com.files.repository.FileRepository;

@Service
public class FileService
{
	
	@Autowired
	private FileRepository repo;
	
	public List<UserFile> getAllFile()
	{
		return repo.findAll();
	}

}
