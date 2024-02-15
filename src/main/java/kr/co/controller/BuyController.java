package kr.co.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import kr.co.domain.BuyDTO;
import kr.co.domain.MemberDTO;
import kr.co.service.BuyService;
import kr.co.service.MemberService;
import kr.co.service.ProductService;
import lombok.AllArgsConstructor;
import lombok.extern.log4j.Log4j;

@Log4j
@Controller
@AllArgsConstructor
@RequestMapping("/buy/*")
public class BuyController {
	private ProductService pservice;
	private MemberService mservice;
	private BuyService bservice;
	
	@GetMapping("/approvepage")
	public String approvepage(@RequestParam("p_no") Long p_no,
			@RequestParam("m_id") String m_id, Model model,
			RedirectAttributes rttr) throws Exception{
		log.info("product approve page");
		model.addAttribute("product", pservice.get(p_no));
		model.addAttribute("member", mservice.getId(m_id));
		return "./buy/approvePage";
	}
	
	@PostMapping("/approve")
	public String approve(BuyDTO buy, MemberDTO member, RedirectAttributes rttr, Model model,
			@RequestParam("m_no") Long m_no, @RequestParam("m_point") String m_point,
			@RequestParam("p_no") Long p_no, @RequestParam("p_name") String p_name,
			@RequestParam("p_image") String p_image, @RequestParam("p_price") String p_price) throws Exception{
		log.info("product approve func...");
		int point = Integer.parseInt(m_point);
		int price = Integer.parseInt(p_price);
		int afterpoint = point - price;
		member.setM_point(Integer.toString(afterpoint));
		member.setM_no(m_no);
		
		buy.setM_no(m_no);
		buy.setP_no(p_no);
		buy.setP_image(p_image);
		buy.setP_price(p_price);
		buy.setP_name(p_name);
		log.info("order: " + buy);
		bservice.approve(buy);
		mservice.pointUpdate(member);
		
		rttr.addFlashAttribute("result", buy.getB_no());
		rttr.addFlashAttribute("m_no", m_no);
		return "redirect:/member/order";
	}
	
}
