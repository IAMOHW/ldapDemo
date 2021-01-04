package com.ldap.demo;

import org.springframework.data.ldap.repository.LdapRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import javax.naming.Name;

@Repository
public interface ApacheDSRepository extends CrudRepository<Person, Name> {
}
