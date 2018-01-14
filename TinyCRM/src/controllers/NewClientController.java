package controllers;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import exceptions.InvalidFormFieldData;
import models.CRMModel;
import models.ClientModel;
import swingViews.ClientSwingView;
import swingViews.ContactSwingView;
import swingViews.SwingView;
import views.ClientTCRMView;
import views.ContactTCRMView;
import views.TCRMView;

public class NewClientController extends ClientController {
	
	
	public NewClientController(SwingView view, CRMModel model) {
		super(view, model);
	}

	@Override
	public void validateTelephone() {
		ClientTCRMView view = (ClientTCRMView) getView();
		
		Pattern p1 = Pattern.compile("\\d{11}");
		Matcher m1 = p1.matcher(view.getTextTelephone().replaceAll("\\s+",""));
		
		Pattern p2 = Pattern.compile("\\(\\d\\d\\d\\)-\\d\\d\\d-\\d\\d\\d\\d");
		Matcher m2 = p2.matcher(view.getTextTelephone().replaceAll("\\s+",""));
		
		if (view.getTextTelephone().trim().length() == 0) {
			addValidationError("Telephone", "Empty Telephone. Required Field.");
		}
		else if (m1.matches()) {
			String t = view.getTextTelephone().replaceAll("\\s+","") ;
			view.setTextTelephone("("+t.substring(1,4)+")-"+t.substring(4,7)+"-"+t.substring(7));
		}
		else if (m2.matches()) {
			String t = view.getTextTelephone().replaceAll("\\s+","") ;
			view.setTextTelephone(t);
		}
		else {
			addValidationError("Telephone", "Invalid Telephone. Required Field.");
		}
	}
	
	@Override
	public void validateEmail() {
		ClientTCRMView view = (ClientTCRMView) getView();
		
		Pattern p = Pattern.compile("^[A-Z0-9._%+-]+@[A-Z0-9.-]+\\.[A-Z]{2,6}$", Pattern.CASE_INSENSITIVE);
		Matcher m = p.matcher(view.getTextEmail().trim());
		
		if (view.getTextEmail().trim().length() == 0) {
			addValidationError("Email", "Empty Email. Required Field.");
		}
		else if (m.matches()) {
			
		}
		else {
			addValidationError("Email", "Invalid Email. Required Field.");
		}
	}
	
	public void validateWebsite() {
		ClientTCRMView view = (ClientTCRMView) getView();
		if (view.getTextWebsite().trim().length() == 0) {
			addValidationError("Website", "Empty Website. Required Field.");
		}
	}
}
