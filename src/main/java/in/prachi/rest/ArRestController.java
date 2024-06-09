package in.prachi.rest;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import in.prachi.entity.CitizenApp;
import in.prachi.service.CitizenAppService;

@RestController
public class ArRestController {

	@Autowired
	private CitizenAppService service;
	@PostMapping("/app")
	public ResponseEntity<String>createApp(@RequestBody CitizenApp app){
		boolean status = service.createApplication(app);
		if(status) {
			return new ResponseEntity<>("App Created", HttpStatus.CREATED);
		}else {
			return new ResponseEntity<String>("Application Failed to create,Invalid SSN",HttpStatus.BAD_REQUEST);
		}
	}
	@GetMapping("/apps")
	public ResponseEntity<List<CitizenApp>>getAllApps(){
		List<CitizenApp> apps = service.getApps();
		return new ResponseEntity<>(apps,HttpStatus.OK);
	}
	@GetMapping("/app/{appNum}")
	public ResponseEntity<CitizenApp>getApp(@PathVariable("appNum") Integer appNum){
	 CitizenApp app = service.getApp(appNum);
	 return new ResponseEntity<>(app,HttpStatus.OK);
	}
	@GetMapping("/citizen-app/{citizenId}")
	public ResponseEntity<CitizenApp>getAppWithCitizenId(@PathVariable("citizenId") Integer citizenId){
	 
	CitizenApp app = service.getAppByCitizenId(citizenId);
	 return new ResponseEntity<>(app,HttpStatus.OK);
}
}
