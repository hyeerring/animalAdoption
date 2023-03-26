package com.lec.animalAdoption.service;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.lec.animalAdoption.dao.LikeListDao;
import com.lec.animalAdoption.dto.LikeListDto;

public class LikeListAddService implements Service {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) {
		String mid = request.getParameter("mid");
		int ano = Integer.parseInt(request.getParameter("ano"));
		System.out.println("mid: " + mid + " / ano: " + ano);
		
		LikeListDao lLDao = LikeListDao.getInstance();
		LikeListDto likeList = new LikeListDto(0, mid, ano);
		int result = lLDao.addLikeList(likeList);
		
		if (result == LikeListDao.SUCCESS) {
			request.setAttribute("likeResult", "<img alt='관심동물 표시' src='${conPath }/img/heart-fill.png'>");
		} else if (result == LikeListDao.FAIL) {
			
		}
	}

}
