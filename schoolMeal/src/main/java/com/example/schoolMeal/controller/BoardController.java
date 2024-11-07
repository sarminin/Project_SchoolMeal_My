package com.example.schoolMeal.controller;

import jakarta.annotation.PostConstruct;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;

@RequiredArgsConstructor
@Controller
public class BoardController {

    @PostConstruct
    private void createCategory() {
        // 카테고리 DB 체크
        boolean check = categoryService.findAll();
        if (check)
            return;
        Category category = new Category();
        category.setCategory_id(10l);
        category.setCategory_name("공지사항");
        categoryService.saveCategory(category);

        category = new Category();
        category.setCategory_id(11l);
        category.setCategory_name("자유게시판");
        categoryService.saveCategory(category);

        category = new Category();
        category.setCategory_id(12l);
        category.setCategory_name("자주하는 질문");
        categoryService.saveCategory(category);

        category = new Category();
        category.setCategory_id(13l);
        category.setCategory_name("건의사항");
        categoryService.saveCategory(category);

        category = new Category();
        category.setCategory_id(14l);
        category.setCategory_name("도서요청");
        categoryService.saveCategory(category);

        category = new Category();
        category.setCategory_id(15l);
        category.setCategory_name("작은도서관 소식");
        categoryService.saveCategory(category);

    }
    //메뉴얼 및 상담 관련 자료
    @PostConstruct
    private void
    //식생활~습관 진단 프로그램 API 활용
    //request

    //영양상담 현황

    //영양상담 이력 관리

}
