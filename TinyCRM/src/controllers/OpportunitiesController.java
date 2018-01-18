package controllers;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Map;

import exceptions.InvalidFormFieldData;
import main.CRMMain;
import models.CRMModel;
import models.ClientModel;
import swingViews.ContactSwingView;
import swingViews.OpportunitiesSwingView;
import swingViews.SwingView;
import views.ContactTCRMView;
import views.OpportunitiesTCRMView;
import views.TCRMView;

public class OpportunitiesController extends CRMController {

	public OpportunitiesController(SwingView opportunitiesView, CRMModel opportunitiesModel, CRMModel clientModel) {
		super(opportunitiesView, opportunitiesModel);

		OpportunitiesSwingView ov = (OpportunitiesSwingView) opportunitiesView;
		//ContactModel cm = (ContactModel) contactModel;
		ClientModel clientModel2 = (ClientModel) clientModel;

		ov.setSelectClientItems(clientModel2.getAllBeans());
		ov.clearFieldErrors();
		ov.setSelectClientListener(new ActionListener() {
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
		super.doSave();
	}

	public void doSave() {
		System.out.println("OpportunitiesController.doSave()");
		super.doSave();
	}

	public void doSelectClient() {
		this.refreshView();
	}

	//*cuidado con esto*//
	public void validateForm() throws InvalidFormFieldData {
		getValidationErrors().clear();
		validateDate();
		validateSaleDescription();
		validateDollarQuantity();
		validateSaleStatus();
		if (getValidationErrors().size() > 0)
			throw new InvalidFormFieldData ("Invalid Form");
	}

	public void validateDate() throws InvalidFormFieldData {
		OpportunitiesTCRMView view = (OpportunitiesTCRMView) getView();
		if (view.getTextDate().trim().length() == 0) {
			addValidationError("Date", "Empty Date. Required Field.");
		}
	}
	public void validateSaleDescription() throws InvalidFormFieldData {
		OpportunitiesTCRMView view = (OpportunitiesTCRMView) getView();
		if (view.getTextSaleDescription().trim().length() == 0) {
			addValidationError("SaleDescription", "Empty Sale Description. Required Field.");
		}
	}	
	public void validateDollarQuantity() throws InvalidFormFieldData {
		OpportunitiesTCRMView view = (OpportunitiesTCRMView) getView();
		if (view.getTextDollarQuantity().trim().length() == 0) {
			addValidationError("DollarQuantity", "Empty Dollar Quantity. Required Field.");
		}
	}	
	public void validateSaleStatus() throws InvalidFormFieldData {
		OpportunitiesTCRMView view = (OpportunitiesTCRMView) getView();
		if (view.getTextSaleStatus().trim().length() == 0) {
			addValidationError("SaleStatus", "Empty Sale Status. Required Field.");
		}
	}

	public void refreshDropdowns() {
		OpportunitiesTCRMView ov = (OpportunitiesTCRMView) getView();
		ov.setSelectClientItems(CRMMain.clientModel.getAllBeans());
	}

	protected void refreshView() {
		super.refreshView();
		String errorString;
		OpportunitiesSwingView ov = (OpportunitiesSwingView) getView();
		ov.clearFieldErrors();
		Map<String, String> validationErrors = getValidationErrors();
		if (validationErrors.size() > 0) {
			errorString = "Fields in red are invalid";
			if (validationErrors.containsKey("Date")) { ov.setErrorDate(validationErrors.get("Date")); }
			if (validationErrors.containsKey("SaleDescription")) { ov.setErrorSaleDescription(validationErrors.get("SaleDescription")); }
			if (validationErrors.containsKey("DollarQuantity")) { ov.setErrorDollarQuantity(validationErrors.get("DollarQuantity")); }
			if (validationErrors.containsKey("SaleStatus")) { ov.setErrorSaleStatus(validationErrors.get("SaleStatus")); }
			ov.setMessagesText(errorString);
		}
	}
}
