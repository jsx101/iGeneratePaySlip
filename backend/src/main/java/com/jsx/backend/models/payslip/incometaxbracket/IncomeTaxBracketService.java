package com.jsx.backend.models.payslip.incometaxbracket;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
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

    public String saveBracket(IncomeTaxBracketWithId bracketWithId) {
        String returnMessage = "";

        Optional<IncomeTaxBracket> dbBracket = incomeTaxBracketRepository.findById(bracketWithId.getId());
        if(dbBracket.isPresent()) {
            incomeTaxBracketRepository.deleteById(bracketWithId.getId());
            returnMessage += "Similar document detected in database; Document removed; ";
        }
        IncomeTaxBracket bracket = bracketWithId.convertToIncomeTaxBracket();
        bracket.setId(bracketWithId.getId());
        incomeTaxBracketRepository.insert(bracket);
        returnMessage += "New document inserted";

        return returnMessage;

    }

    public String insertBracket(IncomeTaxBracket bracket) {
        incomeTaxBracketRepository.insert(bracket);
        return "New document inserted";
    }

    public String deleteBracket(IncomeTaxBracketWithId bracketWithId) {
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