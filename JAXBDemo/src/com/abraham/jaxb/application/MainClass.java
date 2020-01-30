package com.abraham.jaxb.application;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.math.BigInteger;
import java.util.List;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;

import com.abraham.jaxb.Contact;
import com.abraham.jaxb.Contacts;
import com.abraham.jaxb.ObjectFactory;

public class MainClass {
	public static void main(String[] args) throws FileNotFoundException, JAXBException{
		InputStream is=new FileInputStream("src/hollywood_names.xml");
		// Context is the name of package 
	    String context = "com.abraham.jaxb";
	    JAXBContext jContext=null;    
	 
	   	      // Create an instance of JAXB Context
			 jContext = JAXBContext.newInstance(context);
			  // Unmarshal the data from InputStream
			 Contacts contacts = (Contacts) jContext.createUnmarshaller().unmarshal(is);
			
	
	    //read your contacts
	    List<Contact> contact = contacts.getContact();
	    
	    // Lets see the results.
	    for (Contact c : contact) {
	       System.out.println(c.getId()+" "+c.getFirstName()+" "+c.getLastName()+" "+c.getPhoneNumber());
	    }
	    
	    Marshaller marshaller= jContext.createMarshaller();
	    
	    Contact c1=new Contact();
	    c1.setId(new BigInteger("1111"));
	    c1.setFirstName("Abraham");
	    c1.setLastName("Berhe");
	    c1.setPhoneNumber(new BigInteger("641123456"));
	    Contact c2=new Contact();
	    c2.setId(new BigInteger("2222"));
	    c2.setFirstName("Sara");
	    c2.setLastName("Belachew");
	    c2.setPhoneNumber(new BigInteger("607895456"));
	    Contact c3=new Contact();
	    c3.setId(new BigInteger("3333"));
	    c3.setFirstName("Daniel");
	    c3.setLastName("Daru");
	    c3.setPhoneNumber(new BigInteger("345678345"));
	    
	    Contacts contactsObj=new Contacts();
	    contactsObj.getContact().add(c1);
	    contactsObj.getContact().add(c2);
	    contactsObj.getContact().add(c3);
	    
	    marshaller.marshal(contactsObj, new FileOutputStream("src/names.xml"));
	    
	}

}
