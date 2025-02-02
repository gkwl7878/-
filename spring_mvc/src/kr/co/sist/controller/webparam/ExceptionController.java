package kr.co.sist.controller.webparam;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import static org.springframework.web.bind.annotation.RequestMethod.GET;

import java.util.Calendar;
import java.util.Random;
@Controller
public class ExceptionController {
	
	@RequestMapping(value="/exception/exception.do",method=GET)
	public String exceptionForm() {
		return "exception/exception_form";
	}//exceptionForm
	
	@RequestMapping(value="/exception/number_format.do",method=GET)
	public String numberFormat(int age, Model model) {
		model.addAttribute("birth", Calendar.getInstance().get(Calendar.YEAR)-age+1);
		return "exception/view_age";
	}//exceptionForm
	
	@RequestMapping(value="/exception/class_not_found.do",method=GET)
	public String classNotFound()throws ClassNotFoundException {
		if(new Random().nextBoolean()) {
			throw new ClassNotFoundException("클래스 없는 상황");
		}
		return "exception/view_class";
	}//exceptionForm
	
	//현재 Controller 내의 method들 중 NumberFormatException이 발생하면
	//method가 달라도 아래의 예외처리 method가 호출 된다.
	@ExceptionHandler(NumberFormatException.class)
	public ModelAndView numberFormatProcess(NumberFormatException nfe) {
		ModelAndView mav= new ModelAndView();
		mav.setViewName("exception/error");
		mav.addObject("msg",nfe.getMessage());//간단한 에러 메세지
		mav.addObject("exception",nfe.toString());//예외처리 객체와 간단한 에러 메세지
		
		return mav;
	}//numberFormatProcess
	
	@ExceptionHandler(ClassNotFoundException.class)
	public ModelAndView classNotFoundProcess(ClassNotFoundException cnfe) {
		ModelAndView mav =new ModelAndView();
		
		mav.setViewName("exception/error");
		mav.addObject("msg", cnfe.getMessage());
		mav.addObject("exception", cnfe.toString());
		
		return mav;
	}//classNotFoundProcess
	
}//class
