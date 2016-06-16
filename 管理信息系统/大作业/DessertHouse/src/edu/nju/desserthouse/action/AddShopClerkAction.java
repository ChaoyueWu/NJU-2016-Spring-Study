package edu.nju.desserthouse.action;

import java.security.MessageDigest;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import edu.nju.desserthouse.model.Shop;
import edu.nju.desserthouse.model.ShopClerk;
import edu.nju.desserthouse.model.User;
import edu.nju.desserthouse.service.ShopClerkService;
import edu.nju.desserthouse.service.ShopService;

public class AddShopClerkAction extends BaseAction{
	@Autowired
	private ShopClerkService shopClerkService;
	private ShopService shopService;
	private String scname;
	private String pwd;
	private String sid;
	
	public ShopClerkService getShopClerkService() {
		return shopClerkService;
	}

	public void setShopClerkService(ShopClerkService shopClerkService) {
		this.shopClerkService = shopClerkService;
	}
	public ShopService getShopService() {
		return shopService;
	}

	public void setShopService(ShopService shopService) {
		this.shopService = shopService;
	}
	public String getScname() {
		return scname;
	}

	public void setScname(String scname) {
		this.scname = scname;
	}

	public String getPwd() {
		return pwd;
	}

	public void setPwd(String pwd) {
		this.pwd = pwd;
	}

	public String getSid() {
		return sid;
	}

	public void setSid(String sid) {
		this.sid = sid;
	}

	@Override
	public String execute() throws Exception {
		System.out.println("scname: "+scname+" pwd:"+pwd+" sid:"+sid);
		int id = getId();
		User user = new User(id,encryption(pwd));
		ShopClerk shopClerk = new ShopClerk(id,Integer.valueOf(sid),scname);
		shopClerkService.addShopClerk(shopClerk, user);
		
		List<Shop> shopList = shopService.getAllShopList();
		request.setAttribute("shopList", shopList);
		List<ShopClerk> shopClerkList = shopClerkService.getAllShopClerkList();
		request.setAttribute("shopClerkList", shopClerkList);
		return "shopClerkManage";
	}
	
	/*
	 * 生成新的分店服务员id
	 */
	private int getId(){
		List<ShopClerk> list = shopClerkService.getAllShopClerkList();
		int num = 4000000;
		int id;
		for (ShopClerk item : list) {
			id = item.getScid();
			if (id < 5000000 && id >=4000000) {
				if (num < id) {
					num = id;
				}
			}
		}
		num++;
		return num;
	}
	
	/*
	 * 计算密码的md5值
	 */
	 private String encryption(String plainText) {
	        String re_md5 = new String();
	        try {
	            MessageDigest md = MessageDigest.getInstance("MD5");
	            md.update(plainText.getBytes());
	            byte b[] = md.digest();
	 
	            int i;
	 
	            StringBuffer buf = new StringBuffer("");
	            for (int offset = 0; offset < b.length; offset++) {
	                i = b[offset];
	                if (i < 0)
	                    i += 256;
	                if (i < 16)
	                    buf.append("0");
	                buf.append(Integer.toHexString(i));
	            }
	 
	            re_md5 = buf.toString();
	 
	        } catch (Exception e) {
	            e.printStackTrace();
	        }
	        return re_md5;
	    }
}
