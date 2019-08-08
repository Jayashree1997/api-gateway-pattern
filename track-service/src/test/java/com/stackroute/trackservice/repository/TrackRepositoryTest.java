//package com.stackroute.trackservice.repository;
//
//
//import com.stackroute.trackservice.domain.Track;
//import org.junit.After;
//import org.junit.Before;
//import org.junit.Test;
//import org.junit.runner.RunWith;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
//import org.springframework.test.context.junit4.SpringRunner;
//
//import static org.junit.Assert.assertEquals;
//import static org.junit.Assert.assertNotSame;
//
//@RunWith(SpringRunner.class)
//@DataJpaTest
//public class TrackRepositoryTest {
//    @Autowired
//    TrackRepository trackRepository;
//    Track track;
//
//    @Before
//    public void setUp() {
//        track = new Track();
//        track.setId(1);
//        track.setName("xyz");
//        track.setComments("avbchx");
//
//    }
//
//    @After
//    public void tearDown() {
//
//        trackRepository.deleteAll();
//    }
//
//    @Test
//    public void SaveTrack() {
//
//        Track testTrack = trackRepository.findById(track.getId()).get();
//        assertEquals(track, testTrack);
//    }
//
//    @Test
//    public void SaveTrackFailure() {
//
//        Track track1 = new Track(36, "jklm", "bhuhh");
//        trackRepository.save(track1);
//        assertNotSame(track, track1);
//    }
//    @Test
//    public void GetTrackById() {
//        Track t = new Track();
//        Track t1 = new Track(1, "ghj", "ghjkf");
//        Track t3 = new Track(2, "klm", "acbv");
//        trackRepository.save(t);
//        trackRepository.save(t3);
//        t1.setId(3);
//        Track t4 = trackRepository.findById(t1.getId()).get();
//
//        assertEquals(t3, t4);
//
//    }
//}
