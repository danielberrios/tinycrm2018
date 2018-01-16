package controllers;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Map;

import exceptions.InvalidFormFieldData;
import main.CRMMain;
import models.CRMModel;
import models.ClientModel;
import models.OpportunitiesModel;
import swingViews.OpportunitiesSwingView;
import swingViews.SwingView;
import views.OpportunitiesTCRMView;

public class OpportunitiesController extends CRMController{

	public OpportunitiesController(SwingView opportunitiesView, CRMModel opportunitiesModel, CRMModel clientModel) {
		super(opportunitiesView, opportunitiesModel);
		
		OpportunitiesSwingView cv = (OpportunitiesSwingView) opportunitiesView;
		//ContactModel cm = (ContactModel) contactModel;
		OpportunitiesModel OpportunitiesModel2 = (OpportunitiesModel) opportunitiesModel;

		cv.setSelectOpportunitiesListener(OpportunitiesModel2.getAllBeans());
		cv.clearFieldErrors();
		cv.setSelectOpportunitiesListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				System.out.println("Opportunities Combo Box Selected");
			}
		});
	}

	public void doInit() {
		super.doInit();
		refreshDropdowns();
	}
	
	public void doLeft() {
		System.out.println("OpportunitiesController.doLeft()");
		super.doLeft();
	}

	public void doRight() {
		System.out.println("OpportunitiesController.doRight()");
		super.doRight();
	}

	public void doEdit() {
		System.out.println("OpportunitiesController.doRight()");
		refreshDropdowns();
		super.doEdit();
	}

	public void doAdd() {
		System.out.println("OpportunitiesController.doAdd()");
		refreshDropdowns();
		super.doAdd();
	}

	public void doDelete() {
		System.out.println("OpportunitiesController.doDelete()");
		super.doDelete();
	}

	public void doSave() {
		System.out.println("OpportunitiesController.doSave()");
		super.doSave();
	}

	public void doSelectClient() {
		this.refreshView();
	}

	public void refreshDropdowns() {
	}

	protected void refreshView() {
		super.refreshView();
		String errorString;
		OpportunitiesSwingView cv = (OpportunitiesSwingView) getView();
		cv.clearFieldErrors();
		Map<String, String> validationErrors = getValidationErrors();
		if (validationErrors.size() > 0) {
			errorString = "Fields in red are invalid";
			if (validationErrors.containsKey("FirstName")) { cv.setErrorFirstName(validationErrors.get("FirstName")); }
			if (validationErrors.containsKey("LastName")) { cv.setErrorLastName(validationErrors.get("LastName")); }
			if (validationErrors.containsKey("Company")) { cv.setErrorCompany(validationErrors.get("Company")); }
			if (validationErrors.containsKey("Telephone")) { cv.setErrorTelephone(validationErrors.get("Telephone")); }
			if (validationErrors.containsKey("Email")) { cv.setErrorEmail(validationErrors.get("Email")); }
			if (validationErrors.containsKey("Facebook")) { cv.setErrorFacebook(validationErrors.get("Facebook")); }
			cv.setMessagesText(errorString);
		}
	}

	@Override
	public void validateForm() throws InvalidFormFieldData {
		// TODO Auto-generated method stub
		
	}

}
