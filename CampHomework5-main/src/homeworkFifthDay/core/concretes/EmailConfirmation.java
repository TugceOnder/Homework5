package homeworkFifthDay.core.concretes;

import homeworkFifthDay.core.abstracts.ConfirmationService;

public class EmailConfirmation implements ConfirmationService{

	@Override
	public void confirm() {
		System.out.println("Please click the link to confirm your registration.");
		
	}

	
}
