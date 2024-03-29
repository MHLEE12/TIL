package com.study.springboard.controller;

import com.study.springboard.entity.Board;
import com.study.springboard.service.BoardService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

@Controller
public class BoardController {

    @Autowired
    private BoardService boardService;

    @GetMapping("/board/write") // localhost:7080/board/write
    public String boardWriteForm() {

        return "boardwrite";
    }

    @PostMapping("/board/writepro")
    public String boardwritepro(Board board, Model model, MultipartFile file) throws Exception {
        boardService.write(board, file);

        model.addAttribute("message", "글 작성이 완료되었습니다.");
        model.addAttribute("searchUrl", "/board/list");

        return "message";
    }

    @GetMapping("/board/list")
    public String boardList(Model model,
                            @PageableDefault(page=0, size=10, sort = "id", direction = Sort.Direction.DESC) Pageable pageable,
                            String searchKeyword) {
        // @PageDefault에서 page: default페이지/ siez : 한 페이지 게시글 수 / sort : 정렬 기준 컬럼, direction : 정렬 순서

        Page<Board> list = null;

        if(searchKeyword == null) {
            list = boardService.boardList(pageable);
        } else {
            list = boardService.boardSearchList(searchKeyword, pageable);
        }

        int nowPage = list.getPageable().getPageNumber() + 1; // 현재 페이지를 가져옴
        int startPage = Math.max(nowPage - 4, 1); // 비교해서 둘 중 높은 값을 가져옴
        int endPage = Math.min(nowPage + 5, list.getTotalPages());

        model.addAttribute("list", list);
        model.addAttribute("nowPage", nowPage);
        model.addAttribute("startPage", startPage);
        model.addAttribute("endPage", endPage);
        return "boardList";
    }

    @GetMapping("/board/view") // localhost:7080/board/view?id=1 (get방식)
    public String boardView(Model model, Integer id) {
        model.addAttribute("board", boardService.boardView(id));

        return "boardview";
    }

    @GetMapping("/board/delete")
    public String boardDelete(Integer id) {
        boardService.boardDelete(id);
        return "redirect:/board/list";
    }

    @GetMapping("/board/modify/{id}")
    public String boardModify(@PathVariable("id") Integer id, Model model) {

        model.addAttribute("board", boardService.boardView(id));
        return "boardmodify";
    }

    @PostMapping("/board/update/{id}")
    public String boardUpdate(@PathVariable("id") Integer id, Board board, Model model, MultipartFile file) throws Exception {

        Board boardTemp = boardService.boardView(id); // 기존에 저장되어 있던 게시글 내용들
        boardTemp.setTitle(board.getTitle()); // 기존에 있던 내용들에 수정한 내용들 덮어씌움
        boardTemp.setContent(board.getContent());
        boardService.write(boardTemp, file);

        model.addAttribute("message", "글 수정이 완료되었습니다.");
        model.addAttribute("searchUrl", "/board/list");

//        return "redirect:/board/list";
        return "message";
    }

}
