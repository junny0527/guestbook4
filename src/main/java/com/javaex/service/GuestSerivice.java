package com.javaex.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.javaex.dao.GuestBookDao;
import com.javaex.vo.GuestBookVo;

@Service
public class GuestSerivice {
	@Autowired
	private GuestBookDao guestbookDao;

	public List<GuestBookVo> getGuestList() {
		List<GuestBookVo> guestList = guestbookDao.guestBookList();
		return guestList;
	}

	public int guestBookInsert(GuestBookVo guestbookVo) {

		return guestbookDao.guestBookInsert(guestbookVo);

	}
	public int guestBookDelete(int no) {
		
		return guestbookDao.guestBookDelete(no);
		
	}
	public GuestBookVo getGuest(int no) {
		GuestBookVo guestbookVo = guestbookDao.getGuestBookList(no);
		return guestbookVo;
	}
}
