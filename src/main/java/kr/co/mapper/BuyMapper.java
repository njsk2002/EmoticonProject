package kr.co.mapper;

import java.util.List;

import kr.co.domain.BuyDTO;

public interface BuyMapper {
	public abstract List<BuyDTO> getList(Long m_no);
	public abstract void insertSelectKey(BuyDTO buy);

}
