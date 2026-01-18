package com.cs.demo.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.cs.demo.Entity.Rdpassbook;
import com.cs.demo.pdto.UserPassbookDTO;

import java.util.List;

public interface Passbookrepo extends JpaRepository<Rdpassbook, Integer> {
 @Query(value = "SELECT SUM(rdamt) FROM rdpassbook", nativeQuery = true)
		 Long getTotalAmt();
 
 
 @Query(value = "SELECT * FROM rdpassbook WHERE rid = :rid ", nativeQuery = true)
 List<Rdpassbook> getAllByRid(@Param("rid") int rid);
 
 @Query(value ="select name,acno,rdpassbook.rdamt,rdpassbook.rddate from rduser inner join rdpassbook on rduser.rid =\r\n"
 		+ "rdpassbook.rid", nativeQuery = true)
 List<Object[]> getUserPassbookDetails();
 
 @Query(value ="select name,acno,rdpassbook.rdamt,rdpassbook.rddate from rduser inner join rdpassbook on rduser.rid =\r\n"
	 		+ "rdpassbook.rid", nativeQuery = true)
	 List<UserPassbookDTO> getUserPassbookDetail();

	@Query(value = "select name,acno,rdpassbook.rdamt,rdpassbook.rddate from rduser inner join rdpassbook on rduser.rid =\r\n"
		 + "rdpassbook.rid WHERE rdpassbook.rid = :rid", nativeQuery = true)
 List<UserPassbookDTO> getUserPassbookDetailById(@Param("rid") int rid);
 
 @Query(value = "select name,acno,rdpassbook.rdamt,rdpassbook.rddate from rduser inner join rdpassbook on rduser.rid =\r\n"
		 + "rdpassbook.rid WHERE rdpassbook.rid = :rid", nativeQuery = true)
 List<UserPassbookDTO> getUserPassbookDetailBId(@Param("rid") int rid);
	}



