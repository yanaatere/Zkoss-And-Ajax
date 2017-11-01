package service;

import java.util.List;

import entity.MstCustomer;

public interface MstCustomerSvc {
	public void save(MstCustomer mstCustomer);
	public void update(MstCustomer mstCustomer);
	public void delete(String kodeCustomer);
	public List<MstCustomer>findAll();
	public MstCustomer findOne(String kodeCustomer);
}
