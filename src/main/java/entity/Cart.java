package entity;

import java.util.List;

public class Cart {
	private long id;
	private int userid;
	private List<Product> pList;
	
	public void add(Product prod) {
		pList.add(prod);
	}
	
	public void del(long prodid) {
		int count =0;
		for(Product p : pList) {
			if((p.getId()==prodid) && count==0) {
				pList.remove(p);
				count=1;
			}
		}
	}
	
	public long getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public long getUserid() {
		return userid;
	}
	public void setUserid(int userid) {
		this.userid = userid;
	}
	public List<Product> getpList() {
		return pList;
	}
	public void setpList(List<Product> pList) {
		this.pList = pList;
	}
	
}
