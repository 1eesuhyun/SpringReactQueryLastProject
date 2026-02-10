package com.sist.web.service;
import java.util.*;
import org.springframework.stereotype.Service;

import com.sist.web.dto.AttractionDTO;
import com.sist.web.dto.CommonsDTO;
import com.sist.web.repository.BusanTravelRepository;
import com.sist.web.repository.JejuTravelRepository;
import com.sist.web.repository.SeoulTravelRepository;
import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class SeoulTravelServiceImpl implements TravelService{
	private final SeoulTravelRepository repo;
	private final BusanTravelRepository brepo;
	private final JejuTravelRepository jrepo;

	@Override
	public CommonsDTO seoulMainData() {
		// TODO Auto-generated method stub
		return repo.seoulMainData();
	}

	@Override
	public List<CommonsDTO> seoulListData4() {
		// TODO Auto-generated method stub
		return repo.seoulListData4();
	}

	@Override
	public List<CommonsDTO> jejuListData5() {
		// TODO Auto-generated method stub
		return jrepo.jejuListData5();
	}

	@Override
	public List<CommonsDTO> busanListData4() {
		// TODO Auto-generated method stub
		return brepo.busanListData4();
	}

	@Override
	public List<AttractionDTO> jejuAttractionDAta(int start) {
		// TODO Auto-generated method stub
		return jrepo.jejuAttractionDAta(start);
	}

	@Override
	public int jejuTotalPage(int contenttype) {
		// TODO Auto-generated method stub
		return jrepo.jejuTotalPage(contenttype);
	}

	@Override
	public AttractionDTO jejuAttractionDetail(int contentid) {
		// TODO Auto-generated method stub
		return jrepo.jejuAttractionDetail(contentid);
	}
}
