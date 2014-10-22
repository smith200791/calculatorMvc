package ru.nvd.andr.calcmvc.web;

import java.util.Date;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
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

    @RequestMapping(value = "/index", method = RequestMethod.GET) 
    public String listCalcOperations(Map<String, Object> objectMap) {

        objectMap.put("calcOperations", new TableCalcOperations());
        objectMap.put("calcOperationsList", calcOperationsService.listTableCalcOperations());
//!!!имя jsp которое вызывается!!!
        return "calculator";
    }
    @RequestMapping(value = "/summ", method = RequestMethod.POST)
    public String addContact(@ModelAttribute("TableCalcOperations")  TableCalcOperations calcOpers, BindingResult result) {
        Integer summing = Integer.parseInt(calcOpers.getFirstarg())+Integer.parseInt(calcOpers.getSecondarg());
        TableCalcOperations calcOperations = new TableCalcOperations();
        calcOperations.setFirstarg(calcOpers.getFirstarg());
        calcOperations.setSecondarg(calcOpers.getSecondarg());
        calcOperations.setOperaion("+");
        calcOperations.setCreateDate(new Date());
        calcOperations.setResult(summing.toString());
        calcOperationsService.addTableCalcOperations(calcOperations);
        return "redirect:/index";
    }

}
