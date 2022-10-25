package com.ceiba.biblioteca.controller;

import com.ceiba.biblioteca.model.DetailLoanResponseDto;
import com.ceiba.biblioteca.model.LoanRequestDto;
import com.ceiba.biblioteca.model.LoanResponseDto;
import com.ceiba.biblioteca.service.ILoanService;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/prestamo")
public class LoanController {

    private final ILoanService prestamoService;

    public LoanController(ILoanService prestamoService) {
        this.prestamoService = prestamoService;
    }

    /**
     * This method allows to validate the loan process
     * @param requestDto object with information for validations
     * @return a ResponseEntity<LoanResponseDto> with the data found
     */
    @PostMapping(produces = {MediaType.APPLICATION_JSON_VALUE})
    @ResponseBody
    public ResponseEntity<LoanResponseDto> loan(@RequestBody LoanRequestDto requestDto){
        return ResponseEntity.ok(prestamoService.loan(requestDto));
    }

    /**
     * This method allows get the loan detail
     * @param id identifier by get loan detail
     * @return a ResponseEntity<DetailLoanResponseDto> with the data found
     */
    @GetMapping(value = {"/{id}"},produces = {MediaType.APPLICATION_JSON_VALUE})
    @ResponseBody
    public ResponseEntity<DetailLoanResponseDto> loanDetail(@PathVariable("id") int id){
        return ResponseEntity.ok(prestamoService.loanDetail(id));
    }

    @PostMapping(value = {"/test"},produces = {MediaType.APPLICATION_JSON_VALUE})
    @ResponseBody
    public ResponseEntity<LoanResponseDto> test(){
        return ResponseEntity.badRequest().body(null);
    }
}

