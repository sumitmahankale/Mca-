package com.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.Model.UserCreation;
import com.Repository.SplitwiseRepository;

@Service
public class SplitwiseServiceIMPL implements SplitwiseService{

	@Autowired
	private SplitwiseRepository repository;

	@Override
	public void SaveUser(UserCreation usercreation) {
	repository.save(usercreation);	
	}

}
