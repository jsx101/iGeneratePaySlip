package com.jsx.backend.models.payslip.incometaxbracket;

import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Stream;

//@AllArgsConstructor
@Service
public class IncomeTaxBracketService {

    //@Autowired
    private IncomeTaxBracketRepository incomeTaxBracketRepository;

    @Autowired
    public IncomeTaxBracketService(IncomeTaxBracketRepository incomeTaxBracketRepository){
        this.incomeTaxBracketRepository = incomeTaxBracketRepository;
    }

    public List<IncomeTaxBracket> getAllBrackets() {
        return incomeTaxBracketRepository.findAll();
    }

    public IncomeTaxBracket getTaxBracketForSalary(Integer annualSalary) {
        Stream<IncomeTaxBracket> brackets = incomeTaxBracketRepository
                .findIncomeTaxBracketByIncomeLowerLimitLessThanEqual(annualSalary);
        return brackets.reduce((first, second) -> second).orElse(null);
    }
}
