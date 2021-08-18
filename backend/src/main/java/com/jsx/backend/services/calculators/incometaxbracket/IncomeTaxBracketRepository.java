package com.jsx.backend.services.calculators.incometaxbracket;

import com.jsx.backend.models.IncomeTaxBracket;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.stream.Stream;

@Repository
public interface IncomeTaxBracketRepository extends MongoRepository<IncomeTaxBracket, String> {
    Stream<IncomeTaxBracket> findIncomeTaxBracketByIncomeLowerLimitLessThanEqual(Integer annualSalary);
}
