package sk.itsovy.kutka;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import sk.itsovy.kutka.entity.Instructor;
import sk.itsovy.kutka.entity.InstructorDetail;

public class CreateDemo {
    public static void main(String[] args) {

        SessionFactory factory = new Configuration()
                .configure("hibernate.cfg.xml")
                .addAnnotatedClass(Instructor.class)
                .addAnnotatedClass(InstructorDetail.class)
                .buildSessionFactory();

        Session session = factory.getCurrentSession();

        try {

            Instructor instructor = new Instructor("Janko", "Hrasko", "janko.hrasko.sk");
            InstructorDetail instructorDetail = new InstructorDetail("http://www.youtube.com", "Janitor");

            instructor.setInstructorDetail(instructorDetail);

            session.beginTransaction();

            System.out.println("Saving Instructor: " + instructor);
            session.save(instructor);

            session.getTransaction().commit();

            System.out.println("Done!");
        } finally {
            factory.close();
        }

    }
}