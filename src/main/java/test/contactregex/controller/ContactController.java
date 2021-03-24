package test.contactregex.controller;

import java.util.List;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import test.contactregex.model.Contact;
import test.contactregex.service.ContactService;

@RestController
@AllArgsConstructor
@RequestMapping("/hello")
public class ContactController {
    private final ContactService contactService;

    @GetMapping("/contacts")
    public List<Contact> getContacts(@RequestParam String nameFilter) {
        return contactService.getContactByRegex(nameFilter);
    }
}
