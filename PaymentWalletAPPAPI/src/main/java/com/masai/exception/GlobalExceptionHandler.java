package com.masai.exception;

import java.time.LocalDateTime;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.context.request.WebRequest;

import com.masai.model.BillPayment;

@ControllerAdvice
public class GlobalExceptionHandler {
	
	@ExceptionHandler(BeneficiaryDetailException.class)
	public ResponseEntity<MyErrorDetails> HandleBeneficiaryDetailException(BeneficiaryDetailException BeneficiaryDetail , WebRequest request){
		MyErrorDetails errorDetails = new MyErrorDetails(LocalDateTime.now(), BeneficiaryDetail.getMessage(), request.getDescription(false));
		return new ResponseEntity<MyErrorDetails>(errorDetails,HttpStatus.BAD_REQUEST);
	}
	@ExceptionHandler(LoginException.class)
	public ResponseEntity<MyErrorDetails> HandleLoginException(LoginException loginException , WebRequest request){
		MyErrorDetails errorDetails = new MyErrorDetails(LocalDateTime.now(), loginException.getMessage(), request.getDescription(false));
		return new ResponseEntity<MyErrorDetails>(errorDetails,HttpStatus.BAD_REQUEST);
	}
	
<<<<<<< HEAD
	@ExceptionHandler(InsufficientBalanceException.class)
	public ResponseEntity<MyErrorDetails> InsufficientBalanceException(InsufficientBalanceException balanceException , WebRequest request){
=======
	@ExceptionHandler(MethodArgumentNotValidException.class)
	public ResponseEntity<MyErrorDetails> JPAValidationException(MethodArgumentNotValidException methodArgumentNotValidException){
		MyErrorDetails errorDetails = new MyErrorDetails(LocalDateTime.now(), "validation Error",methodArgumentNotValidException.getBindingResult().getFieldError().getDefaultMessage());
		return new ResponseEntity<MyErrorDetails>(errorDetails,HttpStatus.BAD_REQUEST);
	}
	
	
	@ExceptionHandler(Exception.class)
	public ResponseEntity<MyErrorDetails> HandleExtraException(Exception loginException , WebRequest request){
		MyErrorDetails errorDetails = new MyErrorDetails(LocalDateTime.now(), loginException.getMessage(), request.getDescription(false));
		return new ResponseEntity<MyErrorDetails>(errorDetails,HttpStatus.BAD_REQUEST);
	}
	
	@ExceptionHandler(Exception.class)
	public ResponseEntity<MyErrorDetails> HandleExtraException(InsufficientBalanceException balanceException , WebRequest request){
>>>>>>> ed96151e1fee44610405b126c1e29b444bd006ec
		MyErrorDetails errorDetails = new MyErrorDetails(LocalDateTime.now(), balanceException.getMessage(), request.getDescription(false));
		return new ResponseEntity<MyErrorDetails>(errorDetails,HttpStatus.BAD_REQUEST);
	}
	
	
	@ExceptionHandler(BillNotExisttException.class)
	public ResponseEntity<MyErrorDetails> BillNotExtraException(BillNotExisttException billPaymentException , WebRequest request){
		MyErrorDetails errorDetails = new MyErrorDetails(LocalDateTime.now(), billPaymentException.getMessage(), request.getDescription(false));
		return new ResponseEntity<MyErrorDetails>(errorDetails,HttpStatus.BAD_REQUEST);
	}

	@ExceptionHandler(Exception.class)
	public ResponseEntity<MyErrorDetails> HandleExtraException(Exception exception , WebRequest request){
		MyErrorDetails errorDetails = new MyErrorDetails(LocalDateTime.now(), exception.getMessage(), request.getDescription(false));
		return new ResponseEntity<MyErrorDetails>(errorDetails,HttpStatus.BAD_REQUEST);
	}
	
	
	
}
