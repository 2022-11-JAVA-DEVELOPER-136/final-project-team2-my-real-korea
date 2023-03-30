package com.itwill.my_real_korea.service.tripboard;

import static org.junit.jupiter.api.Assertions.*;

import java.util.List;

import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.annotation.ComponentScan;

import com.itwill.my_real_korea.dto.tripboard.TripBoard;


//@SpringBootTest
//@ComponentScan(basePackages = {"com.itwill.ej_final_project"})
class TripBoardServiceImplTest {
	
	@Autowired
	private TripBoardService tripBoardService;
	
	/*
	 * 게시글 번호로 게시글 1개 보기
	 */
	//성공
	@Disabled
	@Test
	void testSelectByTbNo() throws Exception {
		System.out.println(tripBoardService.selectByTbNo(1));
	}
	
	/*
	 * 게시글 모집상태별로 보기
	 */
	//성공
	@Disabled
	@Test
	void testSelectByTbStatusList() throws Exception {
		List<TripBoard> tripBoardList = tripBoardService.selectByTbStatusList(0);
		System.out.println(tripBoardList);
	}

	/*
	 * 게시글 지역별로 보기
	 */
	//성공
	@Disabled
	@Test
	void testSelectByCityNoList() throws Exception {
		List<TripBoard> tripBoardList = tripBoardService.selectByCityNoList(1);
		System.out.println(tripBoardList);
	}
	
	/*
	 * 게시글 해시태그별로 보기
	 */
	//성공
	@Disabled
	@Test
	void testSelectByHashtagList() throws Exception {
		List<TripBoard> tripBoardList = tripBoardService.selectByHashtagList("아무나다좋아");
		System.out.println(tripBoardList);
	}
	
	/*
	 * 게시판 리스트 정렬(게시글 작성 날짜 기준 내림차순)
	 */
	//성공
	@Disabled
	@Test
	void testSelectAllOrderByDate() throws Exception {
		List<TripBoard> tripBoardList = tripBoardService.selectAllOrderByDate();
		System.out.println(tripBoardList);
	}
	

	/*
	 * 게시판 리스트 정렬(조회수 기준 내림차순)
	 */
	//성공
	@Disabled
	@Test
	void testSelectAllOrderByReadCount() throws Exception {
		List<TripBoard> tripBoardList = tripBoardService.selectAllOrderByReadCount();
		System.out.println(tripBoardList);
	}
	
	/*
	 * 게시판 리스트
	 */
	//성공
	@Disabled
	@Test
	void testSelectAllTb() throws Exception {
		List<TripBoard> tripBoardList = tripBoardService.selectAllTb();
		System.out.println(tripBoardList);
	}
	
	/*
	 * 게시글  총 개수
	 */
	//성공
	@Disabled
	@Test
	void testSelectAllTbCount() throws Exception {
		int rowCount = tripBoardService.selectAllTbCount();
		assertEquals(rowCount, 4);
	}
	
	/*
	 * 모집상태별 게시글 개수
	 */
	//성공
	@Disabled
	@Test
	void testSelectStatusCount() throws Exception {
		int rowCount = tripBoardService.selectStatusCount(0);
		assertEquals(rowCount, 3);
	}
	
	/*
	 * 지역별 게시글 개수
	 */
	//성공
	@Disabled
	@Test
	void testSelectCityNoCount() throws Exception {
		int rowCount = tripBoardService.selectCityNoCount(1);
		assertEquals(rowCount, 2);
	}
	
	/*
	 * 해시태그별 게시글 개수
	 */
	//성공
	@Disabled
	@Test
	void testSelectHashtagCount() throws Exception {
		int rowCount = tripBoardService.selectHashtagCount("인싸만");
		assertEquals(rowCount, 1);
	}
	
	/*
	 * 게시글 조회수 1 증가
	 */
	//성공
	@Disabled
	@Test
	void testIncreaseTbReadCount() throws Exception {
		int rowCount = tripBoardService.increaseTbReadCount(1);
		assertEquals(rowCount, 1);
	}
	
	/*
	 * 키워드로 검색된 동행게시판 리스트
	 */
	//성공
	@Disabled
	@Test
	void testSelectSearchTbList() throws Exception {
		List<TripBoard> tripBoardList = tripBoardService.selectSearchTbList("");
		System.out.println(tripBoardList);
	}

	/*
	 * 검색된 게시글 총 개수
	 */
	//성공
	@Disabled
	@Test
	void testSelectTbSearchCount() throws Exception {
		int rowCount = tripBoardService.selectTbSearchCount("");
		assertEquals(rowCount, 4);
	}
	
	/*
	 * 게시글의 지역정보 조회
	 */
	//성공
	@Disabled
	@Test
	void testSelectCityInfo() throws Exception {
		TripBoard tripBoard = tripBoardService.selectCityInfo(1);
		System.out.println(tripBoard);
	}
	
}
