package dao;

import pojo.TblLyric;
import util.HibernateUtil;
import java.util.ArrayList;
import java.util.List;
import javax.faces.context.FacesContext;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

public class LyricDAO {

    public void addTblLyric(TblLyric lyricObj) {
        Transaction transObj = null;
        Session sessionObj = HibernateUtil.getSessionFactory().openSession();
        try {
            transObj = sessionObj.beginTransaction();
            sessionObj.save(lyricObj);
            System.out.println("Berhasil memasukkan data student..");
            FacesContext.getCurrentInstance().getExternalContext().getSessionMap().put("berhasilsimpan", lyricObj.getIdLyric());
            transObj.commit();
        } catch (Exception ex) {
            ex.printStackTrace();
            transObj.rollback();
        } finally {
            sessionObj.close();
        }
    }

    public void updateTblLyric(TblLyric lyricObj) {
        Transaction transObj = null;
        Session sessionObj = HibernateUtil.getSessionFactory().openSession();
        try {
            transObj = sessionObj.beginTransaction();
            sessionObj.update(lyricObj);
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

    public void destroyTblLyric(TblLyric lyricObj) {
        Transaction transObj = null;
        Session sessionObj = HibernateUtil.getSessionFactory().openSession();
        try {
            transObj = sessionObj.beginTransaction();
            sessionObj.delete(lyricObj);
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

    public List<TblLyric> retrieveTblLyric() {
        Transaction transObj = null;
        Session sessionObj = HibernateUtil.getSessionFactory().openSession();
        List listTblAdmin = new ArrayList();
        try {
            transObj = sessionObj.beginTransaction();
            Query query = sessionObj.createQuery("from TblLyric");
            listTblAdmin = query.list();
        } catch (Exception ex) {
            ex.printStackTrace();
        } finally {
            transObj.commit();
        }
        return listTblAdmin;
    }

    public List<TblLyric> retrieveTblLyricID() {
        Transaction transObj = null;
        Session sessionObj = HibernateUtil.getSessionFactory().openSession();
        List listTblAdmin = new ArrayList();
        try {
            transObj = sessionObj.beginTransaction();
            Query query = sessionObj.createQuery("select idLyric from TblLyric");
            listTblAdmin = query.list();
        } catch (Exception ex) {
            ex.printStackTrace();
        } finally {
            transObj.commit();
        }
        return listTblAdmin;
    }
    
    public List<TblLyric> retrieveSongLyricsbyID(int id) {
        Transaction transObj = null;
        Session sessionObj = HibernateUtil.getSessionFactory().openSession();
        List listTblAdmin = new ArrayList();
        try {
            transObj = sessionObj.beginTransaction();
            Query query = sessionObj.createQuery("from TblLyric where ID_Category = :id");
            query.setParameter("id", id);
            listTblAdmin = query.list();
            transObj.commit();
        } catch (Exception ex) {
            ex.printStackTrace();
            transObj.rollback();
        } finally {
            sessionObj.flush();
            sessionObj.close();
        }
        return listTblAdmin;
    }
    
    public List<TblLyric> ambildatalyricbyID(int id) {
        Transaction transObj = null;
        Session sessionObj = HibernateUtil.getSessionFactory().openSession();
        List listTblAdmin = new ArrayList();
        try {
            transObj = sessionObj.beginTransaction();
            Query query = sessionObj.createQuery("from TblLyric where ID_Lyric = :id");
            query.setParameter("id", id);
            listTblAdmin = query.list();
            transObj.commit();
        } catch (Exception ex) {
            ex.printStackTrace();
            transObj.rollback();
        } finally {
            sessionObj.flush();
            sessionObj.close();
        }
        return listTblAdmin;
    }

    public List<TblLyric> getbyID(int id) {
        Transaction transObj = null;
        Session sessionObj = HibernateUtil.getSessionFactory().openSession();
        List<TblLyric> listTblLyrics = new ArrayList();
        try {
            transObj = sessionObj.beginTransaction();
            Query query = sessionObj.createQuery("from TblLyric where idLyric = :idLyric");
            query.setInteger("idLyric", id);
            listTblLyrics = query.list();
        } catch (Exception ex) {
            ex.printStackTrace();
        } finally {
            transObj.commit();
        }
        return listTblLyrics;
    }
}
