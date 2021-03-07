package com.cestar.dao;

public class DaoRunner {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		ClientDao obj =new ClientDao();
		obj.getConnection();
		obj.displayAllRecords();
		
		
		//obj.updateRecord(updated_client, old_id);
		//obj.deleteRecord(29);
		//obj.insert(29,"435262769","Cups","14-08-2020","10-08-2020");
				
				//obj.displayAllRecords();
	}

}
