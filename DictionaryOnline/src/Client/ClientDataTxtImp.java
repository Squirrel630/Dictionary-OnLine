package Client;

import ClientService.ClientDataService;
import po.UserInfo;

public class ClientDataTxtImp extends ClientDataService{
	@Override
	public UserInfo checkuser(UserInfo user){
		return LogIn.getUser();
	};
}
