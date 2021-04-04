package logonSample;

import javax.servlet.http.HttpServletRequest;

import org.apache.struts.action.ActionErrors;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionMapping;
import org.apache.struts.action.ActionMessage;
import org.apache.struts.upload.FormFile;

public class FileUploadForm extends ActionForm {
	protected FormFile thefile;
	private String comment;


	public FormFile getThefile() {
		return thefile;
	}
	public void setThefile(FormFile thefile) {
		this.thefile = thefile;
	}
	public String getComment() {
		return comment;
	}
	public void setComment(String comment) {
		this.comment = comment;
	}

	@Override
	public ActionErrors validate(ActionMapping mapping, HttpServletRequest request) {
		int fileSize =0;
		fileSize=thefile.getFileSize();
		ActionErrors errors = new ActionErrors();

		if(fileSize<=1000000) {
			errors.add("fileSize",new ActionMessage("error.tooLargeFileSize"));
		}
		return errors;

	}
}
