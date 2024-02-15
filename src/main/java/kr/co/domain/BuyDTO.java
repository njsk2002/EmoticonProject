package kr.co.domain;

import lombok.Data;

@Data
public class BuyDTO {
	
	private Long b_no;//구매번호
	private Long m_no;//구매한 회원정보
	private Long p_no; // 구매한 상품번호
	private String p_name; // 구매한 상품명
	private String p_price;//구매한 상품가격
	private String p_image;//구매한 상품 이미지명
	private String b_regdate;//구매일자
	

}
