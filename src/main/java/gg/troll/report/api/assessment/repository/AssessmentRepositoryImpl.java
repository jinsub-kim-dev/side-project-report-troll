package gg.troll.report.api.assessment.repository;

import com.querydsl.jpa.impl.JPAQueryFactory;
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
    public List<Assessment> findByGameIdAndAccountId(long gameId, String accountId, long fromAssessmentId, int size) {
        QAssessment assessment = QAssessment.assessment;

        return queryFactory.selectFrom(assessment)
                .where(assessment.gameId.eq(gameId)
                        .and(assessment.accountId.eq(accountId))
                        .and(assessment.assessmentId.lt(fromAssessmentId)))
                .orderBy(assessment.assessmentId.desc())
                .limit(size)
                .fetch();
    }
}
