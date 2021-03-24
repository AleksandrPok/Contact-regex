package test.contactregex.service;

import java.util.List;
import test.contactregex.model.Contact;

public interface ContactService {
    List<Contact> getContactByRegex(String regex);
}
