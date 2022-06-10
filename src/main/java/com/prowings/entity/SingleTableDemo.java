package com.prowings.entity;

import com.prowings.entity.singletable.ContractEmployee;
import com.prowings.entity.singletable.PermanentEmployee;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import java.time.LocalDate;

public class SingleTableDemo {
    public static void main(String[] args) {

        PermanentEmployee permanentEmployee = PermanentEmployee.builder()
                .employeeId("EMP-001")
                .firstName("John")
                .lastName("West")
                .email("john@john.com")
                .costCenter("AAA-111")
                .totalLeaves(12.50F)
                .startingDate(LocalDate.parse("2018-03-10"))
                .build();

        ContractEmployee contractEmployee = ContractEmployee.builder()
                .employeeId("EMP-002")
                .firstName("Richard")
                .lastName("Smith")
                .email("richard@richard.com")
                .agencyName("CONTRACT AGENCY")
                .contractStartDate(LocalDate.parse("2018-07-12"))
                .contractStartDate(LocalDate.parse("2019-02-22"))
                .build();

        SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
        Session session = sessionFactory.openSession();
        Transaction trans = session.beginTransaction();
        session.save(permanentEmployee);
        session.save(contractEmployee);
        trans.commit();
        session.close();
    }
}
