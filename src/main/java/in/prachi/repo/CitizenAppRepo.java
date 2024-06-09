package in.prachi.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import in.prachi.entity.CitizenApp;

public interface CitizenAppRepo extends JpaRepository<CitizenApp, Integer>{

	public CitizenApp findByCitizenId(Integer citizenId) ;
		
	
}
