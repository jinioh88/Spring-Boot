package com.example.boot6.controller;

import com.example.boot6.domain.WebBoard;
import com.example.boot6.persistence.WebBoardRepository;
import com.example.boot6.vo.PageMaker;
import com.example.boot6.vo.PageVO;
import lombok.extern.java.Log;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
@RequestMapping("/boards")
@Log
public class WebBoardController {
    @Autowired
    private WebBoardRepository repo;

    @GetMapping("/list")
    public void list(@ModelAttribute("pageVO") PageVO vo, Model model) {
        Pageable page = vo.makePageable(0, "bno");
        Page<WebBoard> result = repo.findAll(repo.makePredicate(vo.getType(), vo.getKeyword()), page);
        log.info("" + page);
        log.info("" + result);

        log.info("Total PAGE NUMBER : " + result.getTotalPages());
        model.addAttribute("result", new PageMaker(result));
    }

    @GetMapping("/register")
    public void registerGET(@ModelAttribute("vo") WebBoard vo) { // 파라미터 안넣어도 되지만, 나중 입력값 등 문제 대비...
        log.info("register get");
    }

    @PostMapping("/register")
    public String registerPOST(@ModelAttribute("vo") WebBoard vo, RedirectAttributes rttr) {
        log.info("register post");
        log.info("" + vo);

        repo.save(vo);
        rttr.addFlashAttribute("msg", "success");

        return "redirect:/boards/list";
    }

    @GetMapping("/view")
    public void view(Long bno, @ModelAttribute("pageVO") PageVO vo, Model model) {
        log.info("BNO : " + bno);
        repo.findById(bno).ifPresent(board -> model.addAttribute("vo", board));
    }

    @GetMapping("/modify")
    public void modify(Long bno, @ModelAttribute("pageVO") PageVO vo, Model model) {
        log.info("Modify BNO: " + bno);
        repo.findById(bno).ifPresent(board -> model.addAttribute("vo", board));
    }

    @PostMapping("/delete")
    public String delete(Long bno, PageVO vo, RedirectAttributes rttr) {

        repo.deleteById(bno);
        rttr.addFlashAttribute("msg", "success");
        rttr.addAttribute("page", vo.getPage()); // addAttribute는 URL에 추가되 전송됨.
        rttr.addAttribute("size", vo.getSize());
        rttr.addAttribute("type", vo.getType());
        rttr.addAttribute("keyword", vo.getKeyword());
        log.info("delete bno : " + bno);
        return "redirect:/boards/list";
    }

    @PostMapping("/modify")
    public String modifyPost(WebBoard board, PageVO vo, RedirectAttributes rttr) {
        log.info("Modify board : " + board);
        repo.findById(board.getBno()).ifPresent(origin -> {
            origin.setTitle(board.getTitle());
            origin.setContent(board.getContent());

            repo.save(origin);
            rttr.addFlashAttribute("msg", "success");
            rttr.addAttribute("bno", origin.getBno());
        });
        rttr.addAttribute("page", vo.getPage());
        rttr.addAttribute("size", vo.getSize());
        rttr.addAttribute("type", vo.getType());
        rttr.addAttribute("keyword", vo.getKeyword());

        return "redirect:/boards/view";
    }
}
