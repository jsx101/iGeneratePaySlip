package com.jsx.backend;

import com.jsx.backend.controllers.IncomeTaxBracketController;
import com.jsx.backend.models.EmployeeDetail;
import com.jsx.backend.models.PaySlip;
import com.jsx.backend.models.payslip.*;
import com.jsx.backend.models.payslip.incometaxbracket.IncomeTaxBracket;
import com.jsx.backend.models.payslip.incometaxbracket.IncomeTaxBracketRepository;
import com.jsx.backend.models.payslip.incometaxbracket.IncomeTaxBracketService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.stream.Stream;

@SpringBootApplication
@RestController
@EnableMongoRepositories
//@EnableMongoRepositories(basePackageClasses = com.jsx.backend.models.payslip.incometaxbracket.IncomeTaxBracketRepository.class)
public class BackendApplication {

	@Autowired
	private IncomeTaxBracketService incomeTaxBracketService;
	@Autowired
	private IncomeTaxBracketRepository incomeTaxBracketRepository;

	public static void main(String[] args) {
		SpringApplication.run(BackendApplication.class, args);
		/*System.out.println("Start of bean list");
		ApplicationContext appCon = new AnnotationConfigApplicationContext(BackendApplication.class);
		for(String beanName : appCon.getBeanDefinitionNames()) {
			System.out.println(beanName);
		}
		System.out.println("End of bean list");*/

		/*PaySlip paySlip = new PaySlip(new EmployeeDetail(
				"Imposter",
				"Employee",
				0,
				0.0,
				0
		));*/
	}

	@GetMapping("api/home/test")
	public Stream<IncomeTaxBracket> getIncomeTaxBracket(){
		IncomeTaxBracket i = incomeTaxBracketService.getTaxBracketForSalary(188000);
		System.out.println(i);
		return incomeTaxBracketRepository.findIncomeTaxBracketByIncomeLowerLimitLessThanEqual(188000);
	}

	/*@Bean
	CommandLineRunner runner(IncomeTaxBracketRepository repo, MongoTemplate mongoTemplate) {
		return args -> {
			usingMongoTemplateAndQuery(mongoTemplate);



		};
	}*/

	/*private void usingMongoTemplateAndQuery(MongoTemplate mongoTemplate) {
		Query query = new Query();
		query.addCriteria(Criteria.where("incomeLowerLimit").lte(60050));

		List<IncomeTaxBracket> bracket = mongoTemplate.find(query, IncomeTaxBracket.class);

		System.out.println(bracket);
		System.out.println(bracket.get(bracket.size()-1));
	}*/
}
