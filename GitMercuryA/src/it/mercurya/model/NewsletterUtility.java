package it.mercurya.model;

import java.util.ArrayList;

public interface NewsletterUtility {
	public ArrayList<Newsletter> getAllNewsletter();
	public int insertNewsletter(Newsletter newsletter);
}
