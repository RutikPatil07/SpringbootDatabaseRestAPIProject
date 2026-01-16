package com.cs.demo.cntrl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.cs.demo.Entity.Rdpassbook;
import com.cs.demo.pdto.UserPassbookDTO;
import com.cs.demo.repo.Passbookrepo;
import com.cs.demo.service.PassbookService;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
public class Passbookcntrl {
   @Autowired
	private Passbookrepo prepo;
   
   @Autowired
   private PassbookService service;
   @GetMapping("/detail")
   public List<UserPassbookDTO> getDetail1() {
	   return service.getDetail();
   }
   
   @GetMapping("/ttl")
   public Map<String, Object> getSummary() {
	   Long total = prepo.getTotalAmt();
	   Map<String, Object> result = new HashMap<>();
			   result.put("total", total);
			   return result;
   }
   
   @GetMapping("/passbookById/{id}")
   public List<Rdpassbook> getPassbookByRid(@PathVariable("id") int id){
	   List<Rdpassbook> lst = prepo.getAllByRid(id);
	   return lst;
   }
   
   @GetMapping("/details")
   public List<Object[]> getDetails() {
	   return prepo.getUserPassbookDetails();
   }
   
   @GetMapping("/rdpassbook")
   public List<Rdpassbook> pb(){
	   List<Rdpassbook> lst=prepo.findAll();
	   return lst;
   }
   
   @PostMapping("/psave")
	public Rdpassbook saverd(@RequestBody Rdpassbook p) {
		return prepo.save(p);
}
   
   @PostMapping("/pupdt")
	public Rdpassbook updtrd(@RequestBody Rdpassbook p) {
		return prepo.save(p);
  }
   @DeleteMapping("/pdlt/{id}")
	public String deleteBlg(@PathVariable("id") int id) {
		prepo.deleteById(id);
	return "Record Deleted Successfully...!!!";	
}
}
