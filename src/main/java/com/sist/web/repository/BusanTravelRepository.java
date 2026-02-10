package com.sist.web.repository;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import com.sist.web.entity.BusanTravel;
import com.sist.web.dto.*;
import java.util.*;

public interface BusanTravelRepository extends JpaRepository<BusanTravel, Integer>{
	
	// busan => 4개
	@Query(value = "SELECT contentid,title,address,image1,hit,contenttype "
			+ "FROM busantravel "
			+ "ORDER BY contentid ASC "
			+ "OFFSET 0 ROWS FETCH NEXT 4 ROWS ONLY",nativeQuery = true)
	public List<CommonsDTO> busanListData4();
}
