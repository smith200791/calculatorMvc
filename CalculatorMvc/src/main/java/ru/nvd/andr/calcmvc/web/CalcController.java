package ru.nvd.andr.calcmvc.web;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import ru.nvd.andr.calcmvc.domain.TableCalcOperations;
import ru.nvd.andr.calcmvc.operations.OperationFactory;
import ru.nvd.andr.calcmvc.service.CalcOperationsService;
import ru.nvd.andr.calcmvc.validation.TableCalcOperation;

@Controller
public class CalcController {

    @Autowired
    private CalcOperationsService calcOperationsService;
    @Autowired
    private OperationFactory operationFactory;

    @RequestMapping("/")
    public String home() {
        return "redirect:/index";
    }

    @RequestMapping(value = "/index", method = RequestMethod.GET)
    public String listCalcOperations(Map<String, Object> objectMap) {
        objectMap.put("calcOperations", new TableCalcOperations());
        objectMap.put("calcOperationsList", calcOperationsService.listTableCalcOperations());
        return "calculator";
    }

    @RequestMapping(params = "summ", method = RequestMethod.POST)
    public String summ(@Valid @TableCalcOperation @ModelAttribute("TableCalcOperations") TableCalcOperations calcOpers, BindingResult result, Map<String, Object> objectMap) throws MethodArgumentNotValidException {
        calcOpers.setOperation("+");
        calcOpers.setCreateDate(new Date());

        if (result.hasErrors()) {
            objectMap.put("errors", buildMessage(result.getAllErrors()));
            return "validationex";
        }

        calcOpers.setResult(executeOper(calcOpers).toString());
        calcOperationsService.addTableCalcOperations(calcOpers);
        return "redirect:/index";
    }
    
    
    private Long executeOper(@TableCalcOperation TableCalcOperations calcOperations) {
        return operationFactory.createOperation(calcOperations.getOperation()).excecute(Long.parseLong(calcOperations.getFirstarg()), Long.parseLong(calcOperations.getSecondarg()));
    }

    @RequestMapping(params = "multiply", method = RequestMethod.POST)
    public String multiply(@Valid @TableCalcOperation @ModelAttribute("TableCalcOperations") TableCalcOperations calcOpers, BindingResult result, Map<String, Object> objectMap) {
        calcOpers.setOperation("*");
        calcOpers.setCreateDate(new Date());
        if (result.hasErrors()) {
            objectMap.put("errors", buildMessage(result.getAllErrors()));
            return "validationex";
        }

        calcOpers.setResult(executeOper(calcOpers).toString());
        calcOperationsService.addTableCalcOperations(calcOpers);
        return "redirect:/index";
    }

    @RequestMapping(params = "division", method = RequestMethod.POST)
    public String division(@Valid @TableCalcOperation @ModelAttribute("TableCalcOperations") TableCalcOperations calcOpers, BindingResult result, Map<String, Object> objectMap) {
        calcOpers.setOperation("/");
        calcOpers.setCreateDate(new Date());
        if (result.hasErrors()) {
            objectMap.put("errors", buildMessage(result.getAllErrors()));
            return "validationex";
        }
        calcOpers.setResult(executeOper(calcOpers).toString());
        calcOperationsService.addTableCalcOperations(calcOpers);
        return "redirect:/index";

    }

    @RequestMapping(params = "subtraction", method = RequestMethod.POST)
    public String subtraction(@Valid @TableCalcOperation @ModelAttribute("TableCalcOperations") TableCalcOperations calcOpers, BindingResult result, Map<String, Object> objectMap) {
        calcOpers.setOperation("-");
        calcOpers.setCreateDate(new Date());
        if (result.hasErrors()) {
            objectMap.put("errors", buildMessage(result.getAllErrors()));
            return "validationex";
        }

        calcOpers.setResult(executeOper(calcOpers).toString());
        calcOperationsService.addTableCalcOperations(calcOpers);
        return "redirect:/index";

    }

    @RequestMapping("/delete/{objid}")
    public String deleteContact(@PathVariable("objid") Long objid) {
        calcOperationsService.removeTableCalcOperations(objid);
        return "redirect:/index";
    }

    @RequestMapping("/error403")
    public String error403() {
        return "error403";
    }

    @RequestMapping("/validationex")
    public String validationex() {
        return "validationex";
    }

    @RequestMapping("/login")
    public String login() {
        return "login";
    }

    @RequestMapping("/logout")
    public String logout() {
        return "logout";
    }

    private ArrayList<String> buildMessage(List<ObjectError> objectErrors) {
        ArrayList<String> messages = new ArrayList<String>();
        for (ObjectError objectError : objectErrors) {
            if (objectError instanceof FieldError) {
                messages.add(((FieldError) objectError).getField() + ": " + objectError.getDefaultMessage());
            } else {
                messages.add(objectError.getDefaultMessage());
            }

        }
        return messages;
    }
}
