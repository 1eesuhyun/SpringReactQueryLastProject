package com.sist.web.service;
import org.springframework.stereotype.Service;
import com.sist.web.dto.CommentDTO;
import com.sist.web.entity.CommentEntity;
import com.sist.web.repository.CommentRepository;
import lombok.RequiredArgsConstructor;
import java.util.*;

@Service
@RequiredArgsConstructor
public class CommentServiceImpl implements CommentService{
	private final CommentRepository repo;

	@Override
	public List<CommentDTO> commentListData(int contentid) {
		// TODO Auto-generated method stub
		return repo.commentListData(contentid);
	}

	@Override
	public List<CommentDTO> commentInsert(CommentEntity vo) {
		// TODO Auto-generated method stub
		int no=repo.maxNo();
		vo.setNo(no);
		vo.setRegdate(new Date());
		repo.save(vo);
		return repo.commentListData(vo.getCno());
	}

	@Override
	public List<CommentDTO> commentUpdate(int no, String msg) {
		// TODO Auto-generated method stub
		CommentEntity vo=repo.findByNo(no);
		vo.setMsg(msg);
		vo.setNo(no);
		repo.save(vo);
		return repo.commentListData(vo.getCno());
	}

	@Override
	public List<CommentDTO> commentDelete(int no, int cno) {
		// TODO Auto-generated method stub
		CommentEntity vo=repo.findByNo(no);
		repo.delete(vo);
		return repo.commentListData(cno);
	}
}
