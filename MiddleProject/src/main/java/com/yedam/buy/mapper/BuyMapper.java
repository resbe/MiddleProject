package com.yedam.buy.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.yedam.buy.domain.BuyVO;

public interface BuyMapper {
	//즉시구매
	public int insertBuy(BuyVO vo);
	//구매입찰
	public int insertBuyBid(BuyVO vo);
	//구매내역(사용자)
	public List<BuyVO> selectBuyList(@Param("userId") String userId, @Param("page") int page);
	public int countBuy(String userId);
	//구매내역
	public List<BuyVO> BuyList(int page);
	public int getCountBuy();
	//즉시판매가
	public BuyVO selectBuyPrice(BuyVO vo);
	//구매상세
	public BuyVO selectBuy(int buyId);
	
	//체결(판매아이디넣기)
	public int setSellId(BuyVO vo);
	
	//상태변경
	public int cancelBuy(BuyVO vo);
	public int returnBuy(BuyVO vo);
	public int deliveBuy(BuyVO vo);
	public int updateDlvy(BuyVO vo);
	public int completeDlvy();
}