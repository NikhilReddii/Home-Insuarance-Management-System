package com.cg.hims.service;

import java.util.List;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.cg.hims.entities.Quote;
import com.cg.hims.exceptions.QuoteNotFoundException;
import com.cg.hims.repository.QuoteRepository;
/**
 * 
 * @author Jaya Priyadarshini ,Jadhav
 * class for implementing quote service layer interface
 *
 */

@Service
@Transactional
public class QuoteServiceImpl implements QuoteService{

	@Autowired
	private QuoteRepository qr;
	
	@Override
	public Quote addQuote(Quote quote) throws QuoteNotFoundException {
		try {			
			return qr.save(quote);
		}catch(DataAccessException e) {
			//converting SQLException to EmployeeException
			throw new QuoteNotFoundException(e.getMessage());
		}catch(Exception e) {
			//converting SQLException to EmployeeException
			throw new QuoteNotFoundException(e.getMessage());
		}
	}

	@Override
	public Quote updateQuote(Quote quote) throws QuoteNotFoundException {
		try {			
			return qr.save(quote);
		}catch(DataAccessException e) {
			//converting SQLException to EmployeeException
			throw new QuoteNotFoundException(e.getMessage());
		}catch(Exception e) {
			//converting SQLException to EmployeeException
			throw new QuoteNotFoundException(e.getMessage());
		}
	}

	@Override
	public Quote viewQuote(int quote_id) throws QuoteNotFoundException {
		try {
			Optional<Quote> optional= qr.findById(quote_id);
			if(optional.isPresent()) {
				return optional.get();
			}else {
				throw new Exception("Invalid PolicyHolderID");
			}
		}catch(DataAccessException e) {
			//converting SQLException to EmployeeException
			throw new QuoteNotFoundException(e.getMessage());
		}catch(Exception e) {
			//converting SQLException to EmployeeException
			throw new QuoteNotFoundException(e.getMessage());
		}
	}

	@Override
	public void removeQuote(int id) throws QuoteNotFoundException {
		try {
			qr.deleteById(id);
		}catch(DataAccessException e) {
			//converting SQLException to EmployeeException
			throw new QuoteNotFoundException(e.getMessage());
		}catch(Exception e) {
			//converting SQLException to EmployeeException
			throw new QuoteNotFoundException(e.getMessage());
		}	}

	@Override
	public List<Quote> showAllQuotes() throws QuoteNotFoundException {
		try {
			return qr.findAll();
		}catch(DataAccessException e) {
			//converting SQLException to EmployeeException
			throw new QuoteNotFoundException(e.getMessage());
		}catch(Exception e) {
			//converting SQLException to EmployeeException
			throw new QuoteNotFoundException(e.getMessage());
		}
	}
}
