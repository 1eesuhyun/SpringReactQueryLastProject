package com.sist.web.controller;
import org.springframework.http.*;
import org.springframework.web.bind.annotation.*;
import lombok.RequiredArgsConstructor;
import java.util.*;
import com.sist.web.service.*;
import com.sist.web.repository.*;
import com.sist.web.dto.*;

@RestController
@RequiredArgsConstructor
@CrossOrigin(origins = "*")
public class JejuRestController {
	private final TravelService service;
	private final CommentService cservice;
	
	@GetMapping("/jeju/attraction_react/{page}")
	public ResponseEntity<Map> jeju_attraction(@PathVariable("page")int page)
	{
		Map map=new HashMap();
		try
		{
			List<AttractionDTO> list=service.jejuAttractionDAta((page-1)*12);
			int totalpage=service.jejuTotalPage(12);
			
			final int BLOCK=10;
			int startPage=((page-1)/BLOCK*BLOCK)+1;
			int endPage=((page-1)/BLOCK*BLOCK)+BLOCK;
			if(endPage>totalpage)
				endPage=totalpage;
			
			map.put("list", list);
			map.put("totalpage", totalpage);
			map.put("startPage", startPage);
			map.put("endPage", endPage);
			map.put("curpage", page);
		}catch(Exception ex)
		{
			ex.printStackTrace();
			return new ResponseEntity<>(null,HttpStatus.INTERNAL_SERVER_ERROR);
		}
		return new ResponseEntity<>(map,HttpStatus.OK);
	}
	
	@GetMapping("/jeju/detail_react/{contentid}")
	public ResponseEntity<Map> jeju_detail(@PathVariable("contentid") int contentid)
	{
		Map map=new HashMap();
		try
		{
			AttractionDTO dto=service.jejuAttractionDetail(contentid);
			
			List<CommentDTO> list=cservice.commentListData(contentid);
			
			map.put("dto", dto);
			map.put("comments", list);
		}catch(Exception ex)
		{
			ex.printStackTrace();
			return new ResponseEntity<>(null,HttpStatus.INTERNAL_SERVER_ERROR);
		}
		return new ResponseEntity<>(map,HttpStatus.OK);
	}
}
