package com.ems.sb;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("v1/emp")
@Tag(name="Employee Controller", description = "Rest API for Employee Management")
public class EmpController {

    @Autowired
    private EmpService empService;

    @Autowired
    private EmailService emailService;

    @Operation(
            summary = "Add Employee",
            description = "This endpoint is used to add new Employee",
            responses = {
                    @ApiResponse(responseCode = "200", description = "Emp successfully inserted."),
                    @ApiResponse(responseCode = "500", description = "Something went wrong")
            }
    )
    @PostMapping
    public ResponseEntity<EmpBean> addEmp(@RequestBody EmpBean empBean){
        EmpBean dbEmpBean = empService.addEmp(empBean);
        return ResponseEntity.ok().body(dbEmpBean);
    }

    @Operation(
            summary = "List Employees",
            description = "This endpoint is used to get list of all Employees"
    )
    @GetMapping
    public ResponseEntity<List<EmpBean>> getAllEmp(){
        List<EmpBean> lstEmpBean = empService.getAllEmp();
        return ResponseEntity.ok().body(lstEmpBean);
    }

    @PostMapping("/sendmail")
    public ResponseEntity<String> sendMail(@RequestBody Map<String, String> payload){
        emailService.sendMail(payload.get("to"), payload.get("subject"), payload.get("message"));
        return ResponseEntity.ok().body("Email Sent");
    }

    @Operation(
            summary = "About Us",
            description = "This endpoint is used to get company information"
    )
    @GetMapping("/aboutus")
    public ResponseEntity<String> aboutUs(){
        String info = """
                Company Name: HPG Infotech,
                uTube: CodeWithSatnam
                """;
        return ResponseEntity.ok().body(info);
    }

}
