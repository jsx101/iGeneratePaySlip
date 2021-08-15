package com.jsx.backend.models.payslip.incometaxbracket;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;
import java.util.stream.Stream;

@Service
public class IncomeTaxBracketService {

    @Autowired
    private IncomeTaxBracketRepository incomeTaxBracketRepository;

    public List<IncomeTaxBracket> getAllBrackets() {
        return incomeTaxBracketRepository.findAll();
    }

    public IncomeTaxBracket getTaxBracketForSalary(Integer annualSalary) {
        Stream<IncomeTaxBracket> brackets = incomeTaxBracketRepository
                .findIncomeTaxBracketByIncomeLowerLimitLessThanEqual(annualSalary);
        return brackets.reduce((first, second) -> second).orElse(null);
    }

    public String saveBracket(IncomeTaxBracket bracket) {
        incomeTaxBracketRepository.save(bracket);
        return "Document saved";
    }

    public String insertBracket(IncomeTaxBracket bracket) {
        incomeTaxBracketRepository.insert(bracket);
        return "New document inserted";
    }

    public String deleteBracket(IncomeTaxBracket bracketWithId) {
        if(bracketWithId.getId() == null) return "Please put in the ID";
        Optional<IncomeTaxBracket> dbBracket = incomeTaxBracketRepository.findById(bracketWithId.getId());
        if(dbBracket.isPresent()){
            if (bracketWithId.isSimilarTo(dbBracket.get())) {
                incomeTaxBracketRepository.deleteById(bracketWithId.getId());
                return "Matching document found in database; Document removed;";
            }
        }

        return "No matching document found in database;";
    }
}
