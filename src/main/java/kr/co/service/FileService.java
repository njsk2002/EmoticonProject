package kr.co.service;

import java.util.List;

import kr.co.domain.UploadDTO;

public interface FileService {
	//이미지 데이터 반환(no 필요)
	public abstract List<UploadDTO> getImageList(Long i_pno);
	//이미지 데이터 전체 반환
	public abstract List<UploadDTO> getImageList1();

}
