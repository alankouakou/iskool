package net.ycod3r.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import net.ycod3r.domain.Evaluation;

public interface EvaluationRepo extends JpaRepository<Evaluation, Long> {

	List<Evaluation> findAllByOrderByDateEvaluationDesc();
	


}
