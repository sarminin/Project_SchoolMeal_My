package com.example.schoolMeal.domain.entity.mealInfo;

import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Table(name = "mealExpert") //전문인력 테이블
@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class MealExpert {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(nullable = false, updatable = false)
	private long exp_id;
	private String exp_name;		//이름
	private String exp_department;	//소속
	private String exp_position;	//직책
	private String exp_email;		//이메일

	// 전문가의 이력(1:N 연관관계) -> 한 전문가는 여러 개의 이력을 가질 수 있다.
	@OneToMany(mappedBy = "mealExpert",
				cascade = CascadeType.ALL,
				orphanRemoval = true)
	private List<ExpertHistory> histories;

	// 전문가의 보유자격증(1:N 연관관계) -> 한 전문가는 여러 개의 자격증을 가질 수 있다.
	@OneToMany(mappedBy = "mealExpert",			// Many쪽이 연관관계의 주인, 외래키는 ExpertQualification 쪽에 생성
				cascade = CascadeType.ALL,		// 영속성 전이 설정. One쪽의 상태가 변경되면 Many쪽의 데이터에도 동일한 동작이 일어난다.
				orphanRemoval = true)			// 고아객체 제거(다른 연관관계가 없으므로 허용)
	private List<ExpertQualification> qualifications;

	public MealExpert(String exp_name, String exp_department, String exp_position, String exp_email) {
		this.exp_name = exp_name;
		this.exp_department = exp_department;
		this.exp_position = exp_position;
		this.exp_email = exp_email;

	}
}
