package ase.ie.an3.tw.load;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import ase.ie.an3.tw.entity.Address;
import ase.ie.an3.tw.entity.Person;
import ase.ie.an3.tw.repository.PersonRepository;

@Component
public class DatabaseLoader implements CommandLineRunner {
	private final PersonRepository personRepository;
	
	@Autowired
	public DatabaseLoader(PersonRepository personRepository) {
		this.personRepository = personRepository;
	}

	@Override
	public void run(String... strings) throws Exception {
		Address a1 = new Address("Domiciliu", "Bucuresti", "Nerva Traian", "M64, ap. 105");
		Address a2 = new Address("Domiciliu", "Bucuresti", "Stefan cel Mare", "A1, ap. 12");
		Address a3 = new Address("Resedinta", "Craiova", "Henri Coanda", "M1, ap. 15");
		
		Person p1 = new Person("Florentina", "Burada", Arrays.asList(a1));
		Person p2 = new Person("Florentina", "Diaconescu", Arrays.asList(a2, a3));
		
		this.personRepository.save(p1);
		this.personRepository.save(p2);
	}
}
