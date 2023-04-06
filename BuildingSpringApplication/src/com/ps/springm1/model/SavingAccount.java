package com.ps.springm1.model;

import com.ps.springm1.Account;
import com.ps.springm1.Card;

public class SavingAccount implements Account{
	
	//private Card atmCard;
	/*public SavingAccount(Card card){
		atmCard = card;
	}*/
	@Override  //to inform that this is the implementation method of Account interface
	public String createAccount(){
		return "Saving Account created successfully";
	}

	/*@Override
	public String cardDetails() {
		// TODO Auto-generated method stub
		return atmCard.cardDetails();
	}*/

}
