package models;

import java.util.Date;

public class UserLink {

	private String username;
	private String postedlink;
	private String title;
	private Date postdate;
	private int viewcount;
	
	public UserLink() {
		// TODO Auto-generated constructor stub
	}

	public UserLink(String username, String postedlink, String title, Date postdate, int viewcount) {
		super();
		this.username = username;
		this.postedlink = postedlink;
		this.title = title;
		this.postdate = postdate;
		this.viewcount = viewcount;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPostedlink() {
		return postedlink;
	}

	public void setPostedlink(String postedlink) {
		this.postedlink = postedlink;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public Date getPostdate() {
		return postdate;
	}

	public void setPostdate(Date postdate) {
		this.postdate = postdate;
	}

	public int getViewcount() {
		return viewcount;
	}

	public void setViewcount(int viewcount) {
		this.viewcount = viewcount;
	}
				
}
