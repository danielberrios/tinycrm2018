package beans;

public class OpportunitiesBean extends CRMBean {

	private String Description;
	private String Cost;
	private String date; //maybe should be stored in numbers? or like a string but we parse it?
	private long client;
	private String Status;
	
	public OpportunitiesBean(long id) {
		super(id);
		date = "";
		Description = "";
		Cost = "";
		client = -1;
		Status = "";
	}
	
	public String getDescription() {
		return Description;
	}

	public void setDescription(String Description) {
		this.Description = Description;
	}

	public String getCost() {
		return Cost;
	}

	public void setCost(String Cost) {
		this.Cost = Cost;
	}

	public String getDate() {
		return date;
	}

	public void setDate(String date) {
		this.date = date;
	}

	public String getStatus() {
		return Status;
	}

	public void setStatus(String Status) {
		this.Status = Status;
	}

	public long getClient() {
		return client;
	}
	
	public void setClient(long id) {
		this.client = id;
	}
	
	public String toString() {
		return this.getId() + ": " + this.getDescription() + " " + this.getStatus();
	}
	
	public boolean equals(Object o) {
		if (o instanceof OpportunitiesBean) {
			OpportunitiesBean c = (OpportunitiesBean) o;
			return (c.getId() == this.getId());
		}
		return false;
	}
	
}