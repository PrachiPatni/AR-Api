package in.prachi.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import in.prachi.entity.CitizenApp;
import in.prachi.repo.CitizenAppRepo;

@Service
public class CitizenAppServiceImpl implements CitizenAppService {

	@Autowired
	
	private CitizenAppRepo appRepo;
	@Value("$(ssaWebApiUrl)")

	private String ssaWebApiUrl;
	@Override
	public boolean createApplication(CitizenApp app) {
		RestTemplate rt= new RestTemplate();
		ResponseEntity<String> forEntity =
		 rt.getForEntity(ssaWebApiUrl, String.class, app.getSsn());
		String body = forEntity.getBody();
		if(body.equalsIgnoreCase("Rhode Island")) {
			appRepo.save(app);
			return true;
		}		return false;
	}

	@Override
	public CitizenApp getApp(Integer appNum) {
	
		return appRepo.findById(appNum).orElseThrow();
	}

	@Override
	public List<CitizenApp> getApps() {
		
		return appRepo.findAll();
	}

	@Override
	public CitizenApp getAppByCitizenId(Integer citizenId) {
		return appRepo.findByCitizenId(citizenId);
		
	}

}
