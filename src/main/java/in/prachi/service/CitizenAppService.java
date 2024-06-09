package in.prachi.service;

import java.util.List;

import in.prachi.entity.CitizenApp;

public interface CitizenAppService {

	public boolean createApplication(CitizenApp app);
	
	public CitizenApp getApp(Integer appNum);
	
	public List<CitizenApp>getApps();
	
	public CitizenApp getAppByCitizenId(Integer citizenId);
	
	
}
