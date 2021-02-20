package BEAN;

public class Status {
	private String statusTitle;
	private String statusContent;
	private String statusName;
	private String statusImg;
	private int statusID;

	public Status() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Status(String statusTitle, String statusContent, String statusName, String statusImg, int statusID) {
		super();
		this.statusTitle = statusTitle;
		this.statusContent = statusContent;
		this.statusName = statusName;
		this.statusImg = statusImg;
		this.statusID = statusID;
	}

	public String getStatusTitle() {
		return statusTitle;
	}

	public String getStatusContent() {
		return statusContent;
	}

	public String getStatusName() {
		return statusName;
	}

	public String getStatusImg() {
		return statusImg;
	}

	public int getStatusID() {
		return statusID;
	}

	public void setStatusTitle(String statusTitle) {
		this.statusTitle = statusTitle;
	}

	public void setStatusContent(String statusContent) {
		this.statusContent = statusContent;
	}

	public void setStatusName(String statusName) {
		this.statusName = statusName;
	}

	public void setStatusImg(String statusImg) {
		this.statusImg = statusImg;
	}

	public void setStatusID(int statusID) {
		this.statusID = statusID;
	}

	public void setID(int int1) {
		// TODO Auto-generated method stub
		
	}

}
