package sk.itsovy.kutka;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import sk.itsovy.kutka.entity.Course;
import sk.itsovy.kutka.entity.Instructor;
import sk.itsovy.kutka.entity.InstructorDetail;

public class CreateInstructorDemo {
    public static void main(String[] args) {

        SessionFactory factory = new Configuration()
                .configure("hibernate.cfg.xml")
                .addAnnotatedClass(Instructor.class)
                .addAnnotatedClass(InstructorDetail.class)
                .addAnnotatedClass(Course.class)
                .buildSessionFactory();

        Session session = factory.getCurrentSession();

        try {

            Instructor instructor = new Instructor("Anicka", "Dusicka", "anicka@dusicka.sk");
            InstructorDetail instructorDetail = new InstructorDetail("http://www.youtube.com", "Professional dumb person.");

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