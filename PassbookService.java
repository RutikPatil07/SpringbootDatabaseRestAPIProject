package com.cs.demo.service;

import com.cs.demo.pdto.UserPassbookDTO;
import com.cs.demo.repo.Passbookrepo;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PassbookService {
	@Autowired
   private Passbookrepo pprepo;
   
   public List<UserPassbookDTO> getDetail(){
	   return pprepo.getUserPassbookDetail();
	   
	   
   }
}
