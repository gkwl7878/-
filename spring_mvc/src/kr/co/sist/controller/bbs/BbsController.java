package kr.co.sist.controller.bbs;

import org.json.simple.JSONObject;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import kr.co.sist.domain.Diary;
import kr.co.sist.domain.DiaryDetail;
import kr.co.sist.domain.DiaryReply;
import kr.co.sist.service.DiaryService;
import kr.co.sist.vo.DiaryVO;
import kr.co.sist.vo.ReplyVO;

import static org.springframework.web.bind.annotation.RequestMethod.GET;

import java.util.List;

@Controller
public class BbsController {
	
	@RequestMapping(value="/diary/list.do", method=GET)
	public String diaryList(DiaryVO dv,  Model model) {
		
		DiaryService ds= new DiaryService();
		int totalCount=ds.totalCount(); //총 게시물의 수
		int pageScale=ds.pageScale();//한 화면에 보여줄 게시물의 수 
		int totalPage=ds.totalPage(totalCount);// 총 게시물을 보여주기 위한 총 페이지 수
		if(dv.getCurrentPage()==0) {//web parameter에 값이 없을 때
			dv.setCurrentPage(1); //1번부터 조회해야 하므로 1로 설정
		}//end if
		System.out.println(dv.getCurrentPage()+"====================");
		
		int startNum=ds.startNum(dv.getCurrentPage()); //시작번호
		int endNum=ds.endNum(startNum); //끝번호
		
		dv.setStartNum(startNum);
		dv.setEndNum(endNum);
		
		List<Diary> diaryList=ds.searchDiaryList(dv); //리스트 목록
		String indexList=ds.indexList(dv.getCurrentPage(), totalPage, "list.do");
		
		model.addAttribute("diaryList",diaryList);
		model.addAttribute("indexList",indexList);
		model.addAttribute("pageScale",pageScale);
		model.addAttribute("totalCount",totalCount);
		model.addAttribute("currentPage",dv.getCurrentPage());
		
		return "diary/list";
	}
	
	@RequestMapping(value="/diary/bbs_read.do", method=GET)
	public String bbsRead(int num,Model model) {
	
		DiaryService ds= new DiaryService();
		DiaryDetail dd= ds.searchBbs(num); //원글의 내용을 조회
		List<DiaryReply> replyList= ds.searchReplyList(num); //원글의 댓글들을 조회
		
		model.addAttribute("searchData", dd);
		model.addAttribute("replyList", replyList);
		
		return "diary/bbs_read";
	}
	
	@ResponseBody
	@RequestMapping(value="diary/add_reply.do",method=GET)
	public String writeReply(ReplyVO r_vo) {
		JSONObject json=null;
		DiaryService ds =new DiaryService();
		json=ds.writeReply(r_vo);
		return json.toJSONString();
	}//
	
	
	
	
	
	
	
}//class
