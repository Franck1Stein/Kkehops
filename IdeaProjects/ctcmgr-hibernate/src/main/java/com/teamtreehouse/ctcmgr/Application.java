package com.teamtreehouse.ctcmgr;

import com.teamtreehouse.ctcmgr.model.Contact;
import org.hibernate.SessionFactory;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.mapping.MetadataSource;

import javax.imageio.spi.ServiceRegistry;

public class Application {

    //Hold a reusable reference to a SessionFactory
    private static final SessionFactory sessionFactory = buildSessionFactory ();

    private static SessionFactory buildSessionFactory (){

        //Create StandardServiceRegistry
        final StandardServiceRegistry registry = new StandardServiceRegistryBuilder().configure().build();

        return new MetadataSources(registry).buildMetadata().buildSessionFactory();
    }

    public static void main(String[] args) {
        Contact contact = new ContactBuilder("Kehops", "Komla")
                .withEmail("kehops@gmail.com")
                .withPhone(2447054606L)
                .build();
    }
}
