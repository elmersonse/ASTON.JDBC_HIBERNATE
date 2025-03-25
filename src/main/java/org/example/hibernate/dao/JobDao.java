package main.java.org.example.hibernate.dao;

import main.java.org.example.hibernate.entity.Job;
import main.java.org.example.hibernate.util.HibernateUtil;
import org.hibernate.Session;
import org.hibernate.Transaction;

import java.util.List;

public class JobDao {
    public void saveJob(Job job) {
        Transaction transaction = null;

        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            transaction = session.beginTransaction();
            session.persist(job);
            transaction.commit();
        }
        catch (Exception e) {
            if (transaction != null) {
                transaction.rollback();
            }
            e.printStackTrace();
        }
    }

    public Job getJobById(int id) {
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            return session.find(Job.class, id);
        }
        catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    public List<Job> getAllJobs() {
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            return session.createQuery("from Job", Job.class).getResultList();
        }
        catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    public Job updateJob(Job job) {
        Transaction transaction = null;
        Job res = null;
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            transaction = session.beginTransaction();
            res = session.merge(job);
            transaction.commit();
        }
        catch (Exception e) {
            if (transaction != null) {
                transaction.rollback();
            }
            e.printStackTrace();
        }
        return res;
    }

    public void deleteJob(Job job) {
        Transaction transaction = null;
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            transaction = session.beginTransaction();
            session.remove(job);
            transaction.commit();
        }
        catch (Exception e) {
            if (transaction != null) {
                transaction.rollback();
            }
            e.printStackTrace();
        }
    }
}
