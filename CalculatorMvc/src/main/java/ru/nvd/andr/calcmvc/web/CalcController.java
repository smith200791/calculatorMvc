package ru.nvd.andr.calcmvc.web;

import java.util.Date;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import ru.nvd.andr.calcmvc.domain.TableCalcOperations;
import ru.nvd.andr.calcmvc.service.CalcOperationsService;

@Controller
public class CalcController {

    @Autowired
    private CalcOperationsService calcOperationsService;

    @RequestMapping("/")
    // при попадании на основную ссылку /CalcOperations,
    // мы редиректим запрос на /CalcOperations/index
    public String home() {
        return "redirect:/index";
    }

    @RequestMapping("/index")
    public String listCalcOperations(Map<String, Object> map) {

        map.put("calcOperations", new TableCalcOperations());
        map.put("calcOperationsList", calcOperationsService.listTableCalcOperations());

        return "contact";
    }
    @RequestMapping(value = "/summ", method = RequestMethod.POST)
    public String addContact(String firstarg, String secondagr, BindingResult result) {
        Integer summing = Integer.parseInt(firstarg)+Integer.parseInt(secondagr);
        TableCalcOperations calcOperations = new TableCalcOperations();
        calcOperations.setCreateDate(new Date());
        calcOperations.setResult(summing.toString());
        calcOperationsService.addTableCalcOperations(calcOperations);
        return "redirect:/index";
    }

}
