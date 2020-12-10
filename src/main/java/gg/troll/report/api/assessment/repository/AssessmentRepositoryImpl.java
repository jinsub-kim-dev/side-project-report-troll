package gg.troll.report.api.assessment.repository;

import com.querydsl.jpa.impl.JPAQueryFactory;
import gg.troll.report.api.assessment.enums.AssessmentType;
import gg.troll.report.api.assessment.model.entity.Assessment;
import gg.troll.report.api.assessment.model.entity.QAssessment;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

@RequiredArgsConstructor
public class AssessmentRepositoryImpl implements AssessmentRepositoryCustom {

    @Autowired
    JPAQueryFactory queryFactory;

    @Override
    public List<Assessment> findByAccountId(String accountId, long fromAssessmentId, int size) {
        QAssessment assessment = QAssessment.assessment;

        return queryFactory.selectFrom(assessment)
                .where(assessment.accountId.eq(accountId)
                        .and(assessment.deleted.isFalse())
                        .and(assessment.assessmentId.lt(fromAssessmentId)))
                .orderBy(assessment.assessmentId.desc())
                .limit(size)
                .fetch();
    }

    @Override
    public List<Assessment> findByGameIdAndAccountId(long gameId, String accountId, long fromAssessmentId, int size) {
        QAssessment assessment = QAssessment.assessment;

        return queryFactory.selectFrom(assessment)
                .where(assessment.gameId.eq(gameId)
                        .and(assessment.accountId.eq(accountId))
                        .and(assessment.deleted.isFalse())
                        .and(assessment.assessmentId.lt(fromAssessmentId)))
                .orderBy(assessment.assessmentId.desc())
                .limit(size)
                .fetch();
    }

    @Override
    public long countNotDeletedAssessments(String accountId, AssessmentType assessmentType) {
        QAssessment assessment = QAssessment.assessment;

        return queryFactory.selectFrom(assessment)
                .where(assessment.accountId.eq(accountId)
                        .and(assessment.assessmentType.eq(assessmentType))
                        .and(assessment.deleted.isFalse()))
                .fetchCount();
    }
}
