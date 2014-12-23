package next.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import next.dao.AnswerDao;
import next.dao.QuestionDao;
import next.model.Answer;
import next.model.Question;
import core.mvc.AbstractController;
import core.mvc.ModelAndView;
import core.utils.ServletRequestUtils;

public class AnswerController extends AbstractController {
	AnswerDao answerDao = new AnswerDao();
	QuestionDao questionDao = new QuestionDao();

	@Override
	public ModelAndView execute(HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		
		String writer = ServletRequestUtils.getRequiredStringParameter(request, "writer");
		String contents = ServletRequestUtils.getRequiredStringParameter(request, "contents");
		long questionId = ServletRequestUtils.getRequiredLongParameter(request, "questionId");
		
		answerDao.insert(new Answer(writer, contents, questionId));
		questionDao.update(questionId);
		ModelAndView mav = jsonView();

		return mav;
	}
}
