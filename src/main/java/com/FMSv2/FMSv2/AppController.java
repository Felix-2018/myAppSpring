package com.FMSv2.FMSv2;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class AppController {
    @GetMapping("/index")
    public String home()
    {
    	return "index";
    }
    @GetMapping("/accounts")
    public String accounts()
    {
    	return "accounts/index";
    }
    @GetMapping("/fleet")
    public String fleet()
    {
    	return "fleet/index";
    }
    @GetMapping("/hr")
    public String hr()
    {
    	return "hr/index";
    }
    @GetMapping("/hr/index")
    public String hrindex()
    {
    	return "hr/index";
    }
    @GetMapping("/helpdesk")
    public String helpdesk()
    {
    	return "helpdesk/index";
    }
    @GetMapping("/parameters")
    public String parameters()
    {
    	return "parameters/index";
    }
    
    @GetMapping("/payroll")
    public String payroll()
    {
    	return "payroll/index";
    }
}