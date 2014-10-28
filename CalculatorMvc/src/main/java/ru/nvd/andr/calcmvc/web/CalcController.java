package ru.nvd.andr.calcmvc.web;

import java.util.Date;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import ru.nvd.andr.calcmvc.domain.TableCalcOperations;
import ru.nvd.andr.calcmvc.operations.Operation;
import ru.nvd.andr.calcmvc.operations.OperationFactory;
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
        // !!!имя jsp которое вызывается!!!
        return "calculator";
    }

    @RequestMapping(params = "summ", method = RequestMethod.POST)
    public String summ(@ModelAttribute("TableCalcOperations") TableCalcOperations calcOpers, BindingResult result) {
        calcOpers.setOperation("+");
        calcOpers.setCreateDate(new Date());
        calcOpers.setResult(executeOper(calcOpers.getFirstarg(), calcOpers.getSecondarg(), "+").toString());
        calcOperationsService.addTableCalcOperations(calcOpers);
        return "redirect:/index";
    }

    private Long executeOper(String firstArg, String secondArg, String oper) {
        OperationFactory operationFactory = new OperationFactory();
        Operation operation = operationFactory.createOperation(oper);
        return operation.excecute(Long.parseLong(firstArg), Long.parseLong(secondArg));

    }

    @RequestMapping(params = "multiply", method = RequestMethod.POST)
    public String multiply(@ModelAttribute("TableCalcOperations") TableCalcOperations calcOpers, BindingResult result) {
        calcOpers.setOperation("*");
        calcOpers.setCreateDate(new Date());
        calcOpers.setResult(executeOper(calcOpers.getFirstarg(), calcOpers.getSecondarg(), "*").toString());
        calcOperationsService.addTableCalcOperations(calcOpers);
        return "redirect:/index";
    }

    @RequestMapping(params = "division", method = RequestMethod.POST)
    public String division(@ModelAttribute("TableCalcOperations") TableCalcOperations calcOpers, BindingResult result) {
        calcOpers.setOperation("/");
        calcOpers.setCreateDate(new Date());
        calcOpers.setResult(executeOper(calcOpers.getFirstarg(), calcOpers.getSecondarg(), "/").toString());
        calcOperationsService.addTableCalcOperations(calcOpers);
        return "redirect:/index";
    }

    @RequestMapping(params = "subtraction", method = RequestMethod.POST)
    public String subtraction(@ModelAttribute("TableCalcOperations") TableCalcOperations calcOpers, BindingResult result) {
        calcOpers.setOperation("-");
        calcOpers.setCreateDate(new Date());
        calcOpers.setResult(executeOper(calcOpers.getFirstarg(), calcOpers.getSecondarg(), "-").toString());
        calcOperationsService.addTableCalcOperations(calcOpers);
        return "redirect:/index";
    }

    @RequestMapping("/delete/{objid}")
    public String deleteContact(@PathVariable("objid") Long objid) {
        calcOperationsService.removeTableCalcOperations(objid);
        return "redirect:/index";
    }

    @RequestMapping("/logout")
    public String logout() {
        return "logout";
    }
}
