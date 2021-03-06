package com.javaex.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.javaex.service.GuestSerivice;
import com.javaex.vo.GuestBookVo;

@Controller
public class GuestController {
	// 필드
	@Autowired
	private GuestSerivice guestService;
	// 생성자

	// 메소드 - gs

	// 메소드 - 일반
//  리스트
	@RequestMapping(value = "/addlist", method = { RequestMethod.GET, RequestMethod.POST })
	public String addlist(Model model) {
		System.out.println("GuestController > addlist()");

		// Dao만들기
		// GuestBookDao guestbookDao = new GuestBookDao();
		List<GuestBookVo> guestBookList = guestService.getGuestList();
		System.out.println(guestBookList);
		// ds 데이터보내기 ==> request attribute에 넣는다.
		model.addAttribute("guestBookList", guestBookList);

		return "addlist";
	}

	// 등록
	@RequestMapping(value = "/add", method = { RequestMethod.GET, RequestMethod.POST })
	public String write(@ModelAttribute GuestBookVo guestbookVo) {
		System.out.println("GuestController > add()");

		int count = guestService.guestBookInsert(guestbookVo);
		System.out.println(count);

		// 리스트로 리다이텍트 시킬 예정
		return "redirect:/addlist";
	}

	// 삭제
	@RequestMapping(value = "/delete", method = { RequestMethod.GET, RequestMethod.POST })
	public String delete(@RequestParam("no") int no) {
		System.out.println("GuestController > delete()");

		
		 guestService.guestBookDelete(no);
		

		return "redirect:/addlist";
	}

	@RequestMapping(value = "/deleteForm", method = { RequestMethod.GET, RequestMethod.POST })
	public String updateForm(Model model,@RequestParam("no") int no ) {
		System.out.println("GuestController > updateForm()");
		//GuestBookDao guestbookDao = new GuestBookDao();
		GuestBookVo guestbookVo = guestService.getGuest(no);

		// ds 데이터보내기 ==> request attribute에 넣는다.
		model.addAttribute("guestbookVo", guestbookVo);
		return "deleteForm";
	}
}
