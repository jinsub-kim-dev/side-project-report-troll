package gg.troll.report.api.assessment.repository;

import gg.troll.report.api.assessment.model.entity.Assessment;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AssessmentRepository extends JpaRepository<Assessment, Long> {
}
