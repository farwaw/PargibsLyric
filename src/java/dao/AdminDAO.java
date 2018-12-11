package dao;

import pojo.TblAdmin;
import util.HibernateUtil;
import java.util.ArrayList;
import java.util.List;
import javax.faces.context.FacesContext;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

public class AdminDAO {

    public void addTblAdmin(TblAdmin studentObj) {
        Transaction transObj = null;
        Session sessionObj = HibernateUtil.getSessionFactory().openSession();
        try {
            
            transObj = sessionObj.beginTransaction();
            sessionObj.save(studentObj);
            System.out.println("Berhasil memasukkan data..");
            FacesContext.getCurrentInstance().getExternalContext().getSessionMap().put("berhasilsimpan", studentObj.getIdAdmin());
            transObj.commit();
        } catch (Exception ex) {
            ex.printStackTrace();
            transObj.rollback();
        } finally {
            sessionObj.flush();
            sessionObj.close();
        }
    }

    public void updateTblAdmin(TblAdmin studentObj) {
        Transaction transObj = null;
        Session sessionObj = HibernateUtil.getSessionFactory().openSession();
        try {
            transObj = sessionObj.beginTransaction();
            sessionObj.update(studentObj);
            System.out.println("Berhasil mengubah data student..");
            transObj.commit();
        } catch (Exception ex) {
            ex.printStackTrace();
            transObj.rollback();
        } finally {
            sessionObj.flush();
            sessionObj.close();
        }
    }

    public void destroyTblAdmin(TblAdmin studentObj) {
        Transaction transObj = null;
        Session sessionObj = HibernateUtil.getSessionFactory().openSession();
        try {
            transObj = sessionObj.beginTransaction();
            sessionObj.delete(studentObj);
            System.out.println("Berhasil menghapus data student..");
            transObj.commit();
        } catch (Exception ex) {
            ex.printStackTrace();
            transObj.rollback();
        } finally {
            sessionObj.flush();
            sessionObj.close();

        }
    }

    public List<TblAdmin> retrieveTblAdmin() {
        Transaction transObj = null;
        Session sessionObj = HibernateUtil.getSessionFactory().openSession();
        List listTblAdmin = new ArrayList();
        try {
            transObj = sessionObj.beginTransaction();
            Query query = sessionObj.createQuery("from TblAdmin");
            listTblAdmin = query.list();
        } catch (Exception ex) {
            ex.printStackTrace();
        } finally {
            transObj.commit();
        }
        return listTblAdmin;
    }

    public List<TblAdmin> retrieveTblAdminID() {
        Transaction transObj = null;
        Session sessionObj = HibernateUtil.getSessionFactory().openSession();
        List listTblAdmin = new ArrayList();
        try {
            transObj = sessionObj.beginTransaction();
            Query query = sessionObj.createQuery("select idAdmin from TblAdmin");
            listTblAdmin = query.list();
        } catch (Exception ex) {
            ex.printStackTrace();
        } finally {
            transObj.commit();
        }
        return listTblAdmin;
    }

    public List<TblAdmin> getbyID(int id) {
        Transaction transObj = null;
        Session sessionObj = HibernateUtil.getSessionFactory().openSession();
        List<TblAdmin> listTblAdmin = new ArrayList();
        try {
            transObj = sessionObj.beginTransaction();
            Query query = sessionObj.createQuery("from TblAdmin where idAdmin = :idAdmin");
            query.setInteger("idAdmin", id);
            listTblAdmin = query.list();
        } catch (Exception ex) {
            ex.printStackTrace();
        } finally {
            transObj.commit();
        }
        return listTblAdmin;
    }
    
    public boolean validateLogin(TblAdmin admObj) {
           Transaction transObj = null;
           Session session = HibernateUtil.getSessionFactory().openSession();
           List<TblAdmin> list = new ArrayList<TblAdmin>();
           
        try {
            transObj = session.beginTransaction();
            Query q = session.createQuery("from TblAdmin where Username = :username and Password = :password");
           
            q.setParameter("username", admObj.getUsername());
            q.setParameter("password", admObj.getPassword());
            list = q.list();
            
            transObj.commit();
            System.out.println("Sukses");
        }
        catch (Exception e) {
            System.out.println(e);
            System.out.println("gagal");
        }finally{
            session.flush();
            session.close();
        }
            if (list.size()>0) {
                return true;
            }
            else {
                return false;
            }
        }
}
