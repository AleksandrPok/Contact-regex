package test.contactregex.service;

import java.util.List;
import java.util.stream.Collectors;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import test.contactregex.model.Contact;
import test.contactregex.repository.ContactRepository;

@Service
@AllArgsConstructor
public class ContactServiceImpl implements ContactService {
    private final ContactRepository contactRepository;

    @Override
    public List<Contact> getContactByRegex(String regex) {
        List<Contact> contactsList = contactRepository.findAll();
        return contactsList.parallelStream()
                .filter(c -> !c.getName().matches(regex))
                .collect(Collectors.toList());
    }
}
