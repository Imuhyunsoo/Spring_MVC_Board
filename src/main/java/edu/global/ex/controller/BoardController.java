package edu.global.ex.mapper.controller;


import edu.global.ex.page.Criteria;
import edu.global.ex.service.BoardService;
import edu.global.ex.vo.BoardVO;
import edu.global.ex.vo.PageVO;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Slf4j
@Controller
public class BoardController {

    @Autowired
    private BoardService boardService;

    @GetMapping("/list")
    public String list(Model model) {

        log.info("list() ..");
        model.addAttribute("boards", boardService.getList());

        return "list";
    }

    @GetMapping("/write_view")
    public String write_view() {

        log.info("write_view() ..");

        return "write";
    }

    @PostMapping("/write")
    public String write(BoardVO boardVO) {

        log.info("write() ..");

        boardService.register(boardVO);

        return "redirect:list";
    }

    /* @GetMapping("/content_view")
    public String content_view(Model model, int bid) {

        log.info("content_view() ..");

        BoardVO boardVO = boardService.content_view(bid);
        model.addAttribute("content_view", boardVO);

        return "content_view";
    } */

    @GetMapping("/content_view")
    public String content_view(BoardVO boardVO, Model model) {  // 3가지 방법이 있다. 꼭 기억하자.

        log.info("content_view() ..");

        int bid = boardVO.getBid();
        model.addAttribute("content_view", boardService.read(bid));

        return "content_view";
    }

    /* @GetMapping("/delete")
    public String delete(BoardVO boardVO) {

        log.info("delete() ..");

        int bid = boardVO.getBid();
        boardService.delete(bid);

        return "redirect:list";
    } */

    // http://localhost:8282/delete?bid=28
    @GetMapping("/delete")
    public String delete(BoardVO boardVO) {

        log.info("remove() ..");

        boardService.remove(boardVO);

        return "redirect:list";
    }

    // http://localhost:8282/reply_view?bid=?
    @GetMapping("/reply_view")
    public String reply_view(BoardVO boardVO, Model model) {

        log.info("reply_view() ..");

        model.addAttribute("reply_view", boardService.read(boardVO.getBid()));

        return "reply_view";
    }

    // http://localhost:8282/reply
    @PostMapping("/reply")
    public String reply(BoardVO boardVO) {

        log.info("reply() ..");

        boardService.registerReply(boardVO);

        return "redirect:list";
    }

    // http://localhost:8282/list2?pageNum=5&amount=10
    // http://localhost:8282/list2
    @GetMapping("/list2")
    public String list2(Criteria cri, Model model) {

        log.info("list2() Criteria " + cri);

        // cri 에 pageNum=5&amount=10 값을 받아서 넘겨준다. 그 후 SQL 실행
        model.addAttribute("boards", boardService.getList(cri));


        int total = boardService.getTotal();
        log.info("total" + total);

        model.addAttribute("pageMaker", new PageVO(cri, total));

        return "list2";
    }


    // 경로를 /board/tables 로 저장해놓으먼 상대경로 지정 해놓은 것이 있어서 CSS JS 파일을 가져 오지 못한다.
    // 상대 경로 지정한 주소들을 하나하나 찾아서 / <- 추가 하여 절대 경로로 지정해야 한다.
    @GetMapping("/board/tables")
    public String tables(Model model) {

        log.info("tables() ..");

        model.addAttribute("boards", boardService.getList());

        return "board_table";
    }

    @GetMapping("/bbs")
    public String bbs(Model model) {


        return "bbs_editor";
    }

}
