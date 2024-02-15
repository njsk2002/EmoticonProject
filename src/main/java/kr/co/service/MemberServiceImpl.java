package kr.co.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;



import kr.co.domain.MemberDTO;
import kr.co.mapper.MemberMapper;
import lombok.AllArgsConstructor;
import lombok.Setter;
import lombok.extern.log4j.Log4j;


@Log4j
@Service
@AllArgsConstructor
public class MemberServiceImpl implements MemberService {
	
	@Setter(onMethod_=@Autowired)
	private MemberMapper dao;
    

	@Override
	public void register(MemberDTO dto) throws Exception {
         dao.register(dto);
	}

	@Override
	public MemberDTO get(Long m_no) throws Exception {
		
		log.info("get....." + m_no);
		try {
			return dao.read(m_no);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public MemberDTO login(MemberDTO dto) throws Exception {
		return dao.login(dto);
	}

	@Override
	public void memberUpdate(MemberDTO dto) throws Exception {
        dao.memberUpdate(dto);
	}

	@Override
	public void memberDelete(MemberDTO dto) throws Exception {
         dao.memberDelete(dto);
	}

	@Override
	public int passChk(MemberDTO dto) throws Exception {
		 
		return dao.passChk(dto);
	}

	@Override
	public int idChk(MemberDTO dto) throws Exception {
		return dao.idChk(dto);
	}

	@Override
	public List<MemberDTO> getList() {
		log.info("get id......");
		return dao.getList();
	}

	@Override
	public MemberDTO getId(String m_id) throws Exception {
		log.info("get Id......." + m_id);
		
		try {
			return dao.readId(m_id);
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return null;
	
	}
	@Override
	public void pointUpdate(MemberDTO dto) throws Exception {
          dao.pointUpdate(dto);
	}

}
