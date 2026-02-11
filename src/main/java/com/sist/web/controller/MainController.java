package com.sist.web.controller;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import lombok.RequiredArgsConstructor;
import com.sist.web.service.*;
import com.sist.web.dto.*;
import com.sist.web.repository.JejuTravelRepository;

import java.util.*;

@RestController
@RequiredArgsConstructor
@CrossOrigin(origins = "*")
public class MainController {
	private final TravelService service;
	private final MemberService mservice;
	
	@GetMapping("/")
	public ResponseEntity<Map> main()
	{
		Map map=new HashMap();
		try
		{
			CommonsDTO mainData=service.seoulMainData();
			List<CommonsDTO> seoulData=service.seoulListData4();
			List<CommonsDTO> busanData=service.busanListData4();
			List<CommonsDTO> jejuData=service.jejuListData5();
			
			map.put("main", mainData);
			map.put("slist", seoulData);
			map.put("blist", busanData);
			map.put("jlist", jejuData);
		}catch(Exception ex)
		{
			ex.printStackTrace();
			return new ResponseEntity<>(null,HttpStatus.INTERNAL_SERVER_ERROR);
		}
		return new ResponseEntity<>(map,HttpStatus.OK);
	}
	
	@GetMapping("/member/login/{id}/{pwd}")
	public ResponseEntity<MemberDTO> member_login(@PathVariable("id")String id,@PathVariable("pwd")String pwd)
	{
		MemberDTO dto=new MemberDTO();
		try
		{
			dto=mservice.memberLogin(id, pwd);
		}catch(Exception ex)
		{
			ex.printStackTrace();
			return new ResponseEntity<>(null,HttpStatus.INTERNAL_SERVER_ERROR);
		}
		return new ResponseEntity<>(dto,HttpStatus.OK);
	}
	
}