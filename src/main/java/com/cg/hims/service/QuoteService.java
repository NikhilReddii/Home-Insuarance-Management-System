package com.cg.hims.service;

import java.util.List;


import com.cg.hims.entities.Quote;
import com.cg.hims.exceptions.QuoteNotFoundException;
/**
 * 
 * @author Jaya Priyadarshini,Jadhav
 * interface of Quote in service layer
 *
 */

public interface QuoteService {

	public Quote addQuote(Quote quote) throws QuoteNotFoundException;

	public Quote updateQuote(Quote quote) throws QuoteNotFoundException;

	public Quote viewQuote(int quote_id) throws QuoteNotFoundException;

	public void removeQuote(int id) throws QuoteNotFoundException;

	public List<Quote> showAllQuotes() throws QuoteNotFoundException;

}
