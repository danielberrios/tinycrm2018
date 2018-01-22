package views;

import java.awt.event.ActionListener;
import java.util.ArrayList;

import beans.CRMBean;

public interface OpportunitiesTCRMView extends TCRMView{


	String getTextId();
	String getTextDate();
	String getTextDescription();
	String getTextCost();
	String getTextStatus();
	
	void setTextId(String textId);
	void setTextDate(String textDate);
	void setTextDescription(String textDescription);
	void setTextCost(String textCost);
	void setTextStatus(String textTelephoe);


	// TODO: Verify MVC compliance of these methods
	int getSelectedClientIndex();
	void setSelectedClientIndex(int index);
	void setSelectClientItems(ArrayList<CRMBean> list);
	void setSelectClientListener(ActionListener listener);
	
	String getErrorDate();
	String getErrorDescription();
	String getErrorCost();
	String getErrorStatus();

	
	void setErrorDate(String errorDate);
	void setErrorDescription(String errorDescription);
	void setErrorCost(String errorCost);
	void setErrorStatus(String errorStatus);
	

}