package com.jsx.backend.businesslogic.payslip.incometaxbracket;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.stream.Stream;

@Repository
public interface IncomeTaxBracketRepository extends MongoRepository<IncomeTaxBracket, String> {
    Stream<IncomeTaxBracket> findIncomeTaxBracketByIncomeLowerLimitLessThanEqual(Integer annualSalary);
}
