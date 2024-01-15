package Dao;

import Model.Reservation;
import Model.User;
import Util.HibernateUtil;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

import java.util.ArrayList;
import java.util.List;

public class UserDao {
    public User login(String email, int password) {
        User user = null;
        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction transaction = session.beginTransaction();
        Query query = session.createQuery("from Userinfo where email=:em and password=:pass");

        query.setParameter("em", email);
        query.setParameter("pass", password);
        user = (User) query.uniqueResult();
        transaction.commit();
        return user;
    }

    public boolean addUser(User user) {
        boolean msg = false;
        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction transaction = session.beginTransaction();

        int i = (int) session.save(user);

        transaction.commit();

        if (i > 0) {
            msg = true;
        }

        return msg;
    }

    public boolean addReservationDetail(Reservation reservation) {
        boolean msg = false;
        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction transaction = session.beginTransaction();

        int i = (int) session.save(reservation);

        transaction.commit();

        if (i > 0) {
            msg = true;
        }

        return msg;
    }

    public List<Reservation> getReservation() {

        List<Reservation> reservationList = new ArrayList<>();
        Session session = HibernateUtil.getSessionFactory().openSession();

        Query nl = session.createQuery("from Reservation ");
        reservationList = nl.list();

        return reservationList;
    }

    public boolean cancelReservation(int id) {
        boolean d = false;
        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction transaction = session.beginTransaction();
        Query query = session.createQuery("delete from Reservation where pnr=:id");
        query.setParameter("id", id);
        query.executeUpdate();
        transaction.commit();
        d = true;
        return d;
    }

    public User pnr(String email, int pnrNum) {
        User user = null;
        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction transaction = session.beginTransaction();
        Query query = session.createQuery("from Userinfo where email=:em and userId=:userId");

        query.setParameter("em", email);
        query.setParameter("userId", pnrNum);
        user = (User) query.uniqueResult();
        transaction.commit();
        return user;
    }

    public boolean fPass(String email, int password) {
        boolean msg = true;
        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction transaction = session.beginTransaction();

        Query query = session.createQuery("update Userinfo set password=:pass where email=:eml");
        query.setParameter("eml", email);
        query.setParameter("pass", password);
        int i = query.executeUpdate();


        //user = (User) query.uniqueResult();
        transaction.commit();
        if (i > 0) {
            msg = true;
        }
        return msg;
    }

}
