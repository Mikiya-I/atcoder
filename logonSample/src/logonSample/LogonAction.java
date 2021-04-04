package logonSample;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.struts.action.Action;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;
import org.apache.struts.action.ActionMessage;
import org.apache.struts.action.ActionMessages;

public class LogonAction extends Action {
	public ActionForward execute(ActionMapping mapping,ActionForm form,HttpServletRequest request,HttpServletResponse response) {
		LogonForm logon = (LogonForm) form;
		HttpSession session = request.getSession();
		String user = logon.getUser();
		String password = logon.getPassword();
		ActionMessages errors = new ActionMessages();

		Object o = session.getAttribute("TrialCount");
		int trialCount = (o==null)?0:((Integer)o).intValue();

		if(!user.equals("user")||!password.equals("password")) {
			if(++trialCount<3) {
				session.setAttribute("TrialCount", trialCount);
				errors.add(ActionMessages.GLOBAL_MESSAGE,new ActionMessage("error.PasswordOrUserMismatch"));
			}else {
				session.removeAttribute("TrialCount");
				return mapping.findForward("failure");
			}

			if(!errors.isEmpty()) {
				saveErrors(request, errors);
				return (new ActionForward(mapping.getInput()));
			}
		}

		session.setAttribute("user", user);
		return mapping.findForward("success");
	}
}
