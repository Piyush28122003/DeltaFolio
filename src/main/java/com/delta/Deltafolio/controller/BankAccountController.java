package com.delta.Deltafolio.controller;

import com.delta.Deltafolio.dto.BankAccountDTO;
import com.delta.Deltafolio.dto.BankAccountRequestDTO;
import com.delta.Deltafolio.dto.TransactionRequestDTO;
<<<<<<< HEAD
import com.delta.Deltafolio.dto.UserDTO;
=======
>>>>>>> eba600fe34aaaadb0dde11129eb7b11546e8c3e6
import com.delta.Deltafolio.service.UserService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/bank-account")
@CrossOrigin(origins = "*")
public class BankAccountController {
<<<<<<< HEAD
    
    private final UserService userService;
    
=======

    private final UserService userService;

>>>>>>> eba600fe34aaaadb0dde11129eb7b11546e8c3e6
    @Autowired
    public BankAccountController(UserService userService) {
        this.userService = userService;
    }
<<<<<<< HEAD
    
    @GetMapping("/user/{userId}")
    public ResponseEntity<UserDTO.BankAccountDTO> getBankAccount(@PathVariable Long userId) {
        UserDTO.BankAccountDTO account = userService.getBankAccountDTO(userId);
        return ResponseEntity.ok(account);
    }
    
    @PostMapping("/user/{userId}/create")
    public ResponseEntity<UserDTO.BankAccountDTO> createBankAccount(
            @PathVariable Long userId,
            @Valid @RequestBody BankAccountRequestDTO request) {
        UserDTO.BankAccountDTO account = userService.createBankAccount(userId, request);
        return new ResponseEntity<>(account, HttpStatus.CREATED);
    }
    
    @PutMapping("/user/{userId}/update")
    public ResponseEntity<UserDTO.BankAccountDTO> updateBankAccount(
            @PathVariable Long userId,
            @Valid @RequestBody BankAccountRequestDTO request) {
        UserDTO.BankAccountDTO account = userService.updateBankAccount(userId, request);
        return ResponseEntity.ok(account);
    }
    
=======

    @GetMapping("/user/{userId}")
    public ResponseEntity<BankAccountDTO> getBankAccount(@PathVariable Long userId) {
        BankAccountDTO account = userService.getBankAccountDTO(userId);
        return ResponseEntity.ok(account);
    }

    @PostMapping("/user/{userId}/create")
    public ResponseEntity<BankAccountDTO> createBankAccount(
            @PathVariable Long userId,
            @Valid @RequestBody BankAccountRequestDTO request) {
        BankAccountDTO account = userService.createBankAccount(userId, request);
        return new ResponseEntity<>(account, HttpStatus.CREATED);
    }

    @PutMapping("/user/{userId}/update")
    public ResponseEntity<BankAccountDTO> updateBankAccount(
            @PathVariable Long userId,
            @Valid @RequestBody BankAccountRequestDTO request) {
        BankAccountDTO account = userService.updateBankAccount(userId, request);
        return ResponseEntity.ok(account);
    }

>>>>>>> eba600fe34aaaadb0dde11129eb7b11546e8c3e6
    @PostMapping("/user/{userId}/deposit")
    public ResponseEntity<BankAccountDTO> deposit(
            @PathVariable Long userId,
            @Valid @RequestBody TransactionRequestDTO request) {
<<<<<<< HEAD
        UserDTO.BankAccountDTO account = userService.deposit(userId, request.getAmount(), request.getDescription());
        return ResponseEntity.ok(account);
    }
    
=======
        BankAccountDTO account = userService.deposit(userId, request.getAmount(), request.getDescription());
        return ResponseEntity.ok(account);
    }

>>>>>>> eba600fe34aaaadb0dde11129eb7b11546e8c3e6
    @PostMapping("/user/{userId}/withdraw")
    public ResponseEntity<?> withdraw(
            @PathVariable Long userId,
            @Valid @RequestBody TransactionRequestDTO request) {
        try {
            BankAccountDTO account = userService.withdraw(userId, request.getAmount(), request.getDescription());
            return ResponseEntity.ok(account);
        } catch (IllegalArgumentException e) {
            return ResponseEntity.badRequest().body(new ErrorResponse(e.getMessage()));
        }
    }
<<<<<<< HEAD
    
    // Simple error response class
    private static class ErrorResponse {
        private String message;
        
        public ErrorResponse(String message) {
            this.message = message;
        }
        
        public String getMessage() {
            return message;
        }
        
=======

    // Simple error response class
    private static class ErrorResponse {
        private String message;

        public ErrorResponse(String message) {
            this.message = message;
        }

        public String getMessage() {
            return message;
        }

>>>>>>> eba600fe34aaaadb0dde11129eb7b11546e8c3e6
        public void setMessage(String message) {
            this.message = message;
        }
    }
}

