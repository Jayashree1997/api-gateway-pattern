package com.stackroute.trackservice.service;

import com.stackroute.trackservice.domain.Track;
import com.stackroute.trackservice.exceptions.TrackAlreadyExistsException;
import com.stackroute.trackservice.repository.TrackRepository;
import org.springframework.context.annotation.Primary;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@Profile("support")
public class TrackServiceImpl implements TrackService{
  private TrackRepository trackRepository;
  public TrackServiceImpl(TrackRepository trackRepository){
    this.trackRepository=trackRepository;
  }

  @Override
  public Track saveTrack(Track track) throws TrackAlreadyExistsException {
    if(trackRepository.existsById(track.getId())){
      throw new TrackAlreadyExistsException("User already exists");
    }
    Track savedTrack=trackRepository.save(track);
    return savedTrack;
  }

  @Override
  public Track getTrackById(int id) {
    Track retrieveTrackById=trackRepository.findById(id).get();
    return retrieveTrackById;
  }

  @Override
  public List<Track> getAllTracks() {
    List<Track> retrieveTrack=trackRepository.findAll();
    return retrieveTrack;

  }
  @Override
  public Track deleteTrackById(int id) {
    Optional<Track> optionalTrack= trackRepository.findById(id);
    trackRepository.deleteById(id);
    return optionalTrack.get();
  }
  @Override
  public Track updateTrackById(int id,Track track) {
    Optional<Track> optionalTrack = trackRepository.findById(id);
    Track updateTrack= trackRepository.save(track);
    return updateTrack;
  }
  @Override
  public List<Track> getTrackByName(String name) {
    List<Track> trackList = trackRepository.getTrackByName(name);
    return trackList;
  }




}
