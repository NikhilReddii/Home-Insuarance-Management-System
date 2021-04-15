package com.cg.hims.repository;

import org.springframework.data.jpa.repository.JpaRepository;


import com.cg.hims.entities.Quote;
/**
 * 
 * @author Jaya Priyadarshini
 * @author Jadhav
 * Quote Entity repository
 *
 */

public interface QuoteRepository extends JpaRepository<Quote,Integer> {

//	public Quote addQuote(Quote quote);
//
//	public Quote updateQuote(Quote quote) throws QuoteNotFoundException;
//
//	public Quote findQuoteById(int id) throws QuoteNotFoundException;
//
//	public Quote removeQuote(int id) throws QuoteNotFoundException;
//
//	public List<Quote> showAllQuotes();

}
