package gg.troll.report.api.assessment.repository;

import gg.troll.report.api.assessment.model.entity.Assessment;

import java.util.List;

public interface AssessmentRepositoryCustom {
    List<Assessment> findByAccountId(String accountId, long fromAssessmentId, int size);
    List<Assessment> findByGameIdAndAccountId(long gameId, String accountId, long fromAssessmentId, int size);
}
