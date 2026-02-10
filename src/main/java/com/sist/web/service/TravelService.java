package com.sist.web.service;
import java.util.*;

import org.springframework.data.repository.query.Param;

import com.sist.web.dto.AttractionDTO;
import com.sist.web.dto.CommonsDTO;

public interface TravelService {
	// 메인
	public CommonsDTO seoulMainData();
	public List<CommonsDTO> seoulListData4();
	public List<CommonsDTO> jejuListData5();
	public List<CommonsDTO> busanListData4();
	// 목록 출력
	// 제주 어트랙션
	public List<AttractionDTO> jejuAttractionDAta(int start);
	public int jejuTotalPage(int contenttype);
	public AttractionDTO jejuAttractionDetail(int contentid);
}
