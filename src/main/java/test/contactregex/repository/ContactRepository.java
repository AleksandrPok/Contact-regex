package test.contactregex.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import test.contactregex.model.Contact;

@Repository
public interface ContactRepository extends JpaRepository<Contact, Long> {
}
