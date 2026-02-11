package com.sist.web.controller;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.sist.web.dto.CommentDTO;
import com.sist.web.entity.CommentEntity;
import com.sist.web.service.CommentService;
import lombok.RequiredArgsConstructor;
import oracle.jdbc.proxy.annotation.Post;

import java.util.*;

@RestController
@RequiredArgsConstructor
@CrossOrigin(origins = "*")
public class CommentRestController {
	private final CommentService service;
	
	@GetMapping("/comment/list/{contentid}")
	public ResponseEntity<Map> comment_list(@PathVariable("contentid") int contentid)
	{
		Map map=new HashMap();
		try
		{
			List<CommentDTO> list=service.commentListData(contentid);
			map.put("comments", list);
		}catch(Exception ex)
		{
			ex.printStackTrace();
			return new ResponseEntity<>(null,HttpStatus.INTERNAL_SERVER_ERROR);
		}
		return new ResponseEntity<>(map,HttpStatus.OK);
	}
	
	@PostMapping("/comment/insert")
	public ResponseEntity<Map> comment_insert(@RequestBody CommentEntity vo)
	{
		Map map=new HashMap();
		try
		{
			List<CommentDTO> list=service.commentInsert(vo);
			map.put("comments", list);
		}catch(Exception ex)
		{
			ex.printStackTrace();
			return new ResponseEntity<>(null,HttpStatus.INTERNAL_SERVER_ERROR);
		}
		return new ResponseEntity<>(map,HttpStatus.OK);
	}
	
	@DeleteMapping("/comment/delete/{no}/{cno}")
	public ResponseEntity<Map> comment_delete(@PathVariable("no") int no,@PathVariable("cno") int cno)
	{
		Map map=new HashMap();
		try
		{
			List<CommentDTO> list=service.commentDelete(no,cno);
			map.put("comments", list);
		}catch(Exception ex)
		{
			ex.printStackTrace();
			return new ResponseEntity<>(null,HttpStatus.INTERNAL_SERVER_ERROR);
		}
		return new ResponseEntity<>(map,HttpStatus.OK);
	}
	
	@PutMapping("/comment/update")
	public ResponseEntity<Map> comment_update(@RequestBody CommentEntity vo)
	{
		Map map=new HashMap();
		try
		{
			List<CommentDTO> list=service.commentUpdate(vo.getNo(),vo.getMsg());
			map.put("comments", list);
		}catch(Exception ex)
		{
			ex.printStackTrace();
			return new ResponseEntity<>(null,HttpStatus.INTERNAL_SERVER_ERROR);
		}
		return new ResponseEntity<>(map,HttpStatus.OK);
	}
}
