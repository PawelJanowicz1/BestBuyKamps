package com.bestbuykamps.websiteshop.business_service;

import com.bestbuykamps.websiteshop.data_model.Cart;
import com.bestbuykamps.websiteshop.data_model.CartRepository;
import com.bestbuykamps.websiteshop.data_model.ContactDetails;
import com.bestbuykamps.websiteshop.data_model.ContactDetailsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ContactDetailsService {

    private final ContactDetailsRepository contactDetailsRepository;
    private final CartService cartService;


    @Autowired
    public ContactDetailsService(ContactDetailsRepository contactDetailsRepository, CartService cartService) {
        this.contactDetailsRepository = contactDetailsRepository;
        this.cartService = cartService;
    }

    public ContactDetails addContactDetails(ContactDetails contactDetails) {
        return contactDetailsRepository.save(contactDetails);
    }

    public ContactDetails updateContactDetails(ContactDetails contactDetails) {
        return contactDetailsRepository.save(contactDetails);
    }

    public void deleteContactDetails(Long id) {
        contactDetailsRepository.deleteById(id);
    }

    public void createContactDetails(String name,
                                              String lastName,
                                              String email,
                                              String phone,
                                              String address,
                                              String country,
                                              String city,
                                              String zip,
                                              String sessionId){
        ContactDetails newContactDetails= new ContactDetails();
        newContactDetails.setFirstName(name);
        newContactDetails.setLastName(lastName);
        newContactDetails.setCountry(country);
        newContactDetails.setCity(city);
        newContactDetails.setPostalCode(zip);
        newContactDetails.setAdress(address);
        newContactDetails.setEmail(email);
        newContactDetails.setPhoneNumber(phone);
        newContactDetails.setCart(cartService.getCart(sessionId));
        newContactDetails.setCartId(cartService.getCartId(sessionId));
        cartService.getCart(sessionId).setContactDetails(newContactDetails);

        contactDetailsRepository.save(newContactDetails);
        contactDetailsRepository.flush();
    }



}
