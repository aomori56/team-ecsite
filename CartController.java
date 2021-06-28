package jp.co.internous.origami.controller;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.google.gson.Gson;

import jp.co.internous.origami.model.domain.TblCart;
import jp.co.internous.origami.model.domain.dto.CartDto;
import jp.co.internous.origami.model.form.CartForm;
import jp.co.internous.origami.model.mapper.TblCartMapper;
import jp.co.internous.origami.model.session.LoginSession;

@Controller
@RequestMapping("/origami/cart")
public class CartController {

	@Autowired
	private TblCartMapper tblCartMapper;

	@Autowired
	private LoginSession loginSession;

	private Gson gson = new Gson();

	@RequestMapping("/")
	public String index(Model m) {
	
		int userId = loginSession.getUserId();
			
		if(loginSession.getLogined()){
		userId = loginSession.getUserId();
		}else{
		userId = loginSession.getTmpUserId();
		}
		
		List<CartDto> cartinfo = tblCartMapper.findByUserId(userId);

		m.addAttribute("loginSession", loginSession);
		m.addAttribute("cartinfo", cartinfo);
		return "cart";
	}

	@RequestMapping("/add")
	public String addCart(CartForm f, Model m) {
		
		
		int userId = loginSession.getUserId();
			
		if(loginSession.getLogined()){
		userId = loginSession.getUserId();
		}else{
		userId = loginSession.getTmpUserId();
		}
		
		f.setUserId(userId);

		TblCart cart = new TblCart(f);
		int result = 0;
		if (tblCartMapper.findCountByUserIdAndProuductId(userId, f.getProductId()) > 0) {
			result = tblCartMapper.update(cart);
		} else {
			result = tblCartMapper.insert(cart);
		}
		if (result > 0) {
			List<CartDto> cartinfo = tblCartMapper.findByUserId(userId);
	
			m.addAttribute("loginSession", loginSession);
			m.addAttribute("cartinfo", cartinfo);
		}
		return "cart";
	}

	@SuppressWarnings("unchecked")
	@RequestMapping("/delete")
	@ResponseBody
	public boolean deleteCart(@RequestBody String checkedIdList) {
		int result = 0;

		Map<String, List<String>> map = gson.fromJson(checkedIdList, Map.class);
		List<String> checkedIds = map.get("checkedIdList");

		result = tblCartMapper.deleteById(checkedIds);
		return result > 0;
	}
}