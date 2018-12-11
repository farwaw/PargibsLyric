package dao;

import pojo.Category;
import util.HibernateUtil;
import java.util.ArrayList;
import java.util.List;
import javax.faces.context.FacesContext;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

public class CategoryDAO {

    public void addCategory(Category categoryObj) {
        Transaction transObj = null;
        Session sessionObj = HibernateUtil.getSessionFactory().openSession();
        try {
            transObj = sessionObj.beginTransaction();
            sessionObj.save(categoryObj);
            System.out.println("Berhasil memasukkan data student..");
            FacesContext.getCurrentInstance().getExternalContext().getSessionMap().put("berhasilsimpan", categoryObj.getIdCategory());
            transObj.commit();
        } catch (Exception ex) {
            ex.printStackTrace();
            transObj.rollback();
        } finally {
            sessionObj.flush();
            sessionObj.close();
        }
    }

    public void updateCategory(Category categoryObj) {
        Transaction transObj = null;
        Session sessionObj = HibernateUtil.getSessionFactory().openSession();
        try {
            transObj = sessionObj.beginTransaction();
            sessionObj.update(categoryObj);
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

    public void destroyCategory(Category categoryObj) {
        Transaction transObj = null;
        Session sessionObj = HibernateUtil.getSessionFactory().openSession();
        try {
            transObj = sessionObj.beginTransaction();
            sessionObj.delete(categoryObj);
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

    public List<Category> retrieveCategory() {
        Transaction transObj = null;
        Session sessionObj = HibernateUtil.getSessionFactory().openSession();
        List listCategory = new ArrayList();
        try {
            transObj = sessionObj.beginTransaction();
            Query query = sessionObj.createQuery("from Category");
            listCategory = query.list();
        } catch (Exception ex) {
            ex.printStackTrace();
        } finally {
            transObj.commit();
        }
        return listCategory;
    }

    public List<Category> retrieveCategoryID() {
        Transaction transObj = null;
        Session sessionObj = HibernateUtil.getSessionFactory().openSession();
        List listTblAdmin = new ArrayList();
        try {
            transObj = sessionObj.beginTransaction();
            Query query = sessionObj.createQuery("select idCategory from Category");
            listTblAdmin = query.list();
            System.out.println("berhasil");
        } catch (Exception ex) {
            ex.printStackTrace();
            transObj.rollback();
        } finally {
            sessionObj.flush();
            sessionObj.close();
        }
        return listTblAdmin;
    }

    public List<Category> getbyID(int id) {
        Transaction transObj = null;
        Session sessionObj = HibernateUtil.getSessionFactory().openSession();
        List<Category> listCategorys = new ArrayList();
        try {
            transObj = sessionObj.beginTransaction();
            Query query = sessionObj.createQuery("from Category where idCategory = :idCategory");
            query.setInteger("idCategory", id);
            listCategorys = query.list();
        } catch (Exception ex) {
            ex.printStackTrace();
        } finally {
            transObj.commit();
        }
        return listCategorys;
    }
    
    public List<Category> retrieveDatalyrics() {
        Transaction transObj = null;
        Session sessionObj = HibernateUtil.getSessionFactory().openSession();
        List listCategory = new ArrayList();
        try {
            transObj = sessionObj.beginTransaction();
            Query query = sessionObj.createQuery("from TblLyric");
            listCategory = query.list();
            transObj.commit();
            
        } catch (Exception ex) {
            ex.printStackTrace();
            transObj.rollback();
        } finally {
            sessionObj.flush();
            sessionObj.close();
        }
        return listCategory;
    }
    
}
    