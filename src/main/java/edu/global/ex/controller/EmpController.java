package edu.global.ex.mapper.controller;


import edu.global.ex.mapper.EmpMapper;
import edu.global.ex.page.Criteria;
import edu.global.ex.service.EmpService;
import edu.global.ex.vo.EmpVO;
import edu.global.ex.vo.PageVO;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Slf4j
@Controller
public class EmpController {

    @Autowired
    private EmpService empService;

    @GetMapping("/emplist")
    public String emplist(Criteria criteria, Model model) {

        log.info("emplist() ..");

        model.addAttribute("boards", empService.getList(criteria));

        int total = empService.getTotal();
        log.info("total", total);

        model.addAttribute("pageMaker", new PageVO(criteria, total));

        return "emplist";
    }

    @GetMapping("/emp")
    public String tables(Model model) {

        log.info("tables() ..");

        model.addAttribute("empList", empService.getList());

        return "table";
    }

    @GetMapping("dept")
    public String dept(Model model) {

        log.info("dept() ..");

        model.addAttribute("deptList", empService.getEmpDeptList());

        return "table2";
    }

    @GetMapping("dept2")
    public String dept2(Model model) {

        log.info("dept2() ..");

        model.addAttribute("deptList", empService.getDeptList());

        return "table3";
    }


}
