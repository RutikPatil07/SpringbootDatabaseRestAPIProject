package com.cs.demo.cntrl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.cs.demo.Entity.Rduser;
import com.cs.demo.repo.Rduserrepo;
import java.util.List;

@RestController
public class RduserCntrl {
    @Autowired
	private Rduserrepo repo;
	@GetMapping("rduser")
	public List<Rduser> pb(){
		List<Rduser> lst=repo.findAll();
		return lst;
	}
	
	@PostMapping("/save")
	public Rduser savered(@RequestBody Rduser p) {
		return repo.save(p);
	}
	
	@PostMapping("/updt")
	public Rduser up(@RequestBody Rduser p) {
		return repo.save(p);
	}
	
	@DeleteMapping("/dlt/{id}")
	public String deleteBlg(@PathVariable("id") int id) {
		repo.deleteById(id);
		return "Record Deleted Successfullyyyyy....!!";
	}
}
