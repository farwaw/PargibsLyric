/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import dao.LyricDAO;
import java.util.List;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;
import pojo.TblLyric;
import pojo.Category;

/**
 *
 * @author Diffa Dhania Arf
 */
public class LyricTest {
    
    public LyricTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() {
    }
    
    @After
    public void tearDown() {
    }
    @Test
    public void TestambildatalyricbyID (){
        LyricDAO obj = new LyricDAO();
        List<TblLyric> list = obj.ambildatalyricbyID(19);
        
        String expected = "Victim";
        String actual = list.get(0).getSongTitle();
        
        assertEquals (expected, actual);
        
    }
    
    @Test
    public void TestretrieveTblLyricID (){
        LyricDAO obj = new LyricDAO();
        List<TblLyric> list = obj.retrieveTblLyricID();
        
        assertNotNull(list);
    }
    
    @Test
    public void TestretrieveTblLyric (){
         LyricDAO obj = new LyricDAO();
        List<TblLyric> list = obj.retrieveTblLyric();
        
        assertNotNull(list);
    }
    @Test
    public void TestgetbyID (){
        LyricDAO obj = new LyricDAO();
        List<TblLyric> list = obj.getbyID(27);
        
        String expected = "Bang Jono";
        String actual = list.get(0).getSongTitle();
        
        assertEquals (expected, actual);
        
    }
    
    @Test
    public void TestaddTblLyric(){
       int id = 81;
       String songTitle = "Jangan";
       String singer = "Marion Jola";
       String lyric = "Blalalalalalalala";
       String category = "Pop" ;
       
       TblLyric lyc = new TblLyric();
       lyc.setIdLyric(id);
       lyc.setSongTitle(songTitle);
       lyc.setSinger(singer);
       lyc.setLyric(lyric);
       lyc.setCategory(category);
       
       LyricDAO dao = new LyricDAO();
       dao.addTblLyric(lyc);
//       
//       List<TblLyric> list = dao.getbyID(id);
//       
//       String expectedSongTitle = list.get(0).getSongTitle();
//       String expectedSinger = list.get(0).getSinger();
//       String expectedLyric = list.get(0).getLyric();
//       int expectedCategory = list.get(0).getIdCategory();
//       
//       assertEquals (expectedSongTitle, songTitle);
//       assertEquals (expectedSinger, singer);
//       assertEquals (expectedLyric, lyric);
//       assertEquals (expectedCategory, category);
//       
//       dao.destroyTblLyric(lyc);
    }
}   

