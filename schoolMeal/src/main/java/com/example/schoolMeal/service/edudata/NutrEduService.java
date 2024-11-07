package com.example.schoolMeal.service.edudata;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.schoolMeal.domain.entity.edudata.NutrEdu;
import com.example.schoolMeal.domain.repository.edudata.NutrEduRepository;

@Service
public class NutrEduService {

	@Autowired
	private NutrEduRepository nutrEduRepository;
	
	// 글 작성
	public void write(NutrEdu nutrEdu) {
		nutrEduRepository.save(nutrEdu);
	}
	
	// 게시글 리스트 처리
	public List<NutrEdu> nutrEduList() {
		return nutrEduRepository.findAll();
	}
	
	// 특정 게시글 불러오기
	public NutrEdu nutrEduView(Integer id) {
		return nutrEduRepository.findById(id).get();
	}
	
	/*     미구현
	// 특정 게시글 삭제
	public void nutrEduDelete(Integer id) {
		nutrEduRepository.deleteById(id);
	}
	
	// 게시글 수정
	public void nutrEduUpdate(NutrEdu nutrEdu) {
		nutrEduRepository.updateById(nutrEdu);
	}
	 
	*/
}
