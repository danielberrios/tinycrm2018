package controllers;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import exceptions.InvalidFormFieldData;
import main.CRMMain;
import models.CRMModel;
import models.ClientModel;
import swingViews.ContactSwingView;
import swingViews.SwingView;
import views.ContactTCRMView;

public class NewContactController extends ContactController {

	public NewContactController(SwingView contactView, CRMModel contactModel, CRMModel clientModel) {
		super(contactView, contactModel, clientModel);
	}
	
	@Override
	public void validateFirstName() throws InvalidFormFieldData {
		ContactTCRMView view = (ContactTCRMView) getView();
		String t = view.getTextFirstName().trim();
		
		Pattern p = Pattern.compile("^[ A-Za-z]+$");
		Matcher m = p.matcher(t);
		
		if (t.length() == 0) {
			addValidationError("FirstName", "Empty First Name. Required Field.");
		}
		else if(t.length() == 1) {
			addValidationError("FirstName", "Invalid First Name. Required Field.");
		}
		else if (m.matches()) {
			int i = t.indexOf(" ");
			if (i > 0) {
			   t = t.substring(0, i);
			}
			view.setTextFirstName(t.substring(0,1).toUpperCase()+t.substring(1).toLowerCase());
		}
		else {
			addValidationError("FirstName", "Invalid First Name. Required Field.");
		}
		
	}
	@Override
	public void validateLastName() throws InvalidFormFieldData {
		ContactTCRMView view = (ContactTCRMView) getView();
		String t = view.getTextLastName().trim();
		
		Pattern p = Pattern.compile("^[ A-Za-z]+$");
		Matcher m = p.matcher(t);
		
		if (t.length() == 0) {
			addValidationError("LastName", "Empty Last Name. Required Field.");
		}
		else if(t.length() == 1) {
			addValidationError("LastName", "Invalid Last Name. Required Field.");
		}
		else if (m.matches()) {
			int i = t.indexOf(" ");
			if (i > 0) {
			   t = t.substring(0, i);
			}
			view.setTextLastName(t.substring(0,1).toUpperCase()+t.substring(1).toLowerCase());
		}
		else {
			addValidationError("LastName", "Invalid Last Name. Required Field.");
		}
	}	
	
	@Override
	public void validateTelephone() throws InvalidFormFieldData {
		ContactTCRMView view = (ContactTCRMView) getView();
		
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
	public void validateEmail() throws InvalidFormFieldData {
		ContactTCRMView view = (ContactTCRMView) getView();
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
}

